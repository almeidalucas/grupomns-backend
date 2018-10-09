package com.grupomns.GrupoMNS.repository;

import java.util.List;

public interface EntityRepository<T> {

  List<T> findAll();

}
