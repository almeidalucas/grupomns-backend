package com.grupomns.GrupoMNS.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntityRepository<T> {

  List<T> findAll();

}
