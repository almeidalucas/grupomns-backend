package com.grupomns.GrupoMNS.service;

import com.grupomns.GrupoMNS.entity.*;
import com.grupomns.GrupoMNS.repository.OrderHeaderRepository;
import com.grupomns.GrupoMNS.repository.OrderRepository;
import com.grupomns.GrupoMNS.repository.ProductHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

  private OrderRepository orderRepository;
  private OrderHeaderRepository orderHeaderRepository;
  private ProductHeaderRepository productHeaderRepository;

  @Autowired
  OrderService(
      OrderRepository orderRepository,
      OrderHeaderRepository orderHeaderRepository,
      ProductHeaderRepository productHeaderRepository
  ) {
    this.orderRepository = orderRepository;
    this.orderHeaderRepository = orderHeaderRepository;
    this.productHeaderRepository = productHeaderRepository;
  }

  @SuppressWarnings("unchecked")
  public ResponseMessage insertOrder(Order order, boolean isEdit) throws ErrorMessage {
    if (isEdit)
      orderRepository.removeOrder(order.getHeader().getNuNota());

    Integer nuNota = orderRepository.insertOrderHeader(order.getHeader());

    order.getHeader().setNuNota(nuNota);
    ResponseMessage responseMessage = (orderRepository.insertOrderProductList(nuNota, order.getProductHeaderList()));

    orderRepository.geraRateio(nuNota);

    Order newOrder = new Order();
    newOrder.setHeader(order.getHeader());
    newOrder.setProductHeaderList((List<ProductHeader>) responseMessage.getData());

    return new ResponseMessage(responseMessage.getCode(), responseMessage.getMessage(), newOrder);
  }

  public void removeOrder(Integer nuNota) throws ErrorMessage {
    orderRepository.removeOrder(nuNota);
  }

  public List<Order> fetchOrderList(int codVend) {
    List<OrderHeader> orderHeaderList = orderHeaderRepository.findByCodVendOrderByNuNota(codVend);
    List<ProductHeader> productHeaderList = productHeaderRepository.findByCodVendOrderByCod(codVend);
    List<Order> orderList = new ArrayList<>();

    for (OrderHeader orderHeader :
        orderHeaderList) {
      List<ProductHeader> productHeaderListTemp = new ArrayList<>();

      for (ProductHeader productHeader :
          productHeaderList) {
        if (orderHeader.getNuNota() == productHeader.getNuNota()) {
          productHeaderListTemp.add(productHeader);
        }
      }

      if (productHeaderListTemp.size() > 0) {
        Order order = new Order(orderHeader, productHeaderListTemp);
        orderList.add(order);
      }
    }

    return orderList;
  }

}
