package com.grupomns.GrupoMNS.controller;

import com.grupomns.GrupoMNS.entity.ErrorMessage;
import com.grupomns.GrupoMNS.entity.Order;
import com.grupomns.GrupoMNS.entity.ResponseMessage;
import com.grupomns.GrupoMNS.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

  private OrderService orderService;

  @Autowired
  OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping("/insert")
  private ResponseMessage insertOrder(@RequestBody Order order) throws ErrorMessage {
    Order newOrder = orderService.insertOrder(order);
    return new ResponseMessage("200", "Pedido " + newOrder.getHeader().getNuNota() + " inserido com sucesso!", newOrder);
  }

  @PutMapping("/edit")
  private ResponseMessage editOrder(@RequestBody Order order) throws ErrorMessage {
    int nuNota = order.getHeader().getNuNota();
    orderService.editOrder(order);
    return new ResponseMessage("200", "Pedido " + nuNota + " atualizado para " + order.getHeader().getNuNota(), order);
  }

  @DeleteMapping("/delete")
  private ResponseMessage deleteOrder(@RequestHeader int nuNota) throws ErrorMessage {
    orderService.removeOrder(nuNota);
    return new ResponseMessage("200", "Pedido " + nuNota + " removido com sucesso!", nuNota);
  }

  @GetMapping("/orderList")
  private List<Order> getOrderList(@RequestHeader("codVend") int codVend) {
    return orderService.fetchOrderList(codVend);
  }

}
