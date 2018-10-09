package com.grupomns.GrupoMNS.entity;

import java.util.List;

public class Order {

  public Order() {

  }

  public Order(OrderHeader header, List<ProductHeader> productHeaderList) {
    this.header = header;
    this.productHeaderList = productHeaderList;
  }

  private OrderHeader header;

  private List<ProductHeader> productHeaderList;

  public OrderHeader getHeader() {
    return header;
  }

  public void setHeader(OrderHeader header) {
    this.header = header;
  }

  public List<ProductHeader> getProductHeaderList() {
    return productHeaderList;
  }

  public void setProductHeaderList(List<ProductHeader> productHeaderList) {
    this.productHeaderList = productHeaderList;
  }
}
