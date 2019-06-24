package com.grupomns.GrupoMNS.controller;

import com.grupomns.GrupoMNS.entity.OperationType;
import com.grupomns.GrupoMNS.repository.OperationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operationType")
public class OperationTypeController {

  private OperationTypeRepository operationTypeRepository;

  @Autowired
  OperationTypeController(OperationTypeRepository operationTypeRepository) {
    this.operationTypeRepository = operationTypeRepository;
  }

  @GetMapping("/")
  private List<OperationType> getOperationTypes() {
    return operationTypeRepository.findAll();
  }

}
