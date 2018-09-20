package com.grupomns.GrupoMNS.controller;

import com.grupomns.GrupoMNS.entity.Partner;
import com.grupomns.GrupoMNS.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partner")
public class PartnerController {

  private PartnerRepository partnerRepository;

  @Autowired
  PartnerController(PartnerRepository partnerRepository) {
    this.partnerRepository = partnerRepository;
  }

  @GetMapping("/")
  private List<Partner> getPartners() {
    return partnerRepository.findAll();
  }

}
