package com.grupomns.GrupoMNS.repository;

import com.grupomns.GrupoMNS.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

  List<Company> findAll();

}
