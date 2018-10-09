package com.grupomns.GrupoMNS.controller;

import com.grupomns.GrupoMNS.entity.Product;
import com.grupomns.GrupoMNS.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

  private ProductRepository productRepository;

  @Autowired
  ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @GetMapping("/")
  private List<Product> getProducts() {
    return productRepository.findAll();
  }

}
