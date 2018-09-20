package com.grupomns.GrupoMNS.controller;

import com.grupomns.GrupoMNS.entity.Company;
import com.grupomns.GrupoMNS.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

  private CompanyRepository companyRepository;

  @Autowired
  CompanyController(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  @GetMapping("/")
  private List<Company> getCompanies() {
    return companyRepository.findAll();
  }

}
