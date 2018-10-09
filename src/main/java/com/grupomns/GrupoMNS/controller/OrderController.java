package com.grupomns.GrupoMNS.controller;

import com.grupomns.GrupoMNS.entity.Order;
import com.grupomns.GrupoMNS.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
  private Order insertOrder(@RequestBody Order order) {
    orderService.insertOrder(order);

    return order;
  }

  @GetMapping("/orderList")
  private List<Order> getOrderList(@RequestHeader("codVend") int codVend) {
    return orderService.fetchOrderList(codVend);
  }

}
