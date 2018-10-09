package com.grupomns.GrupoMNS.repository;

import com.grupomns.GrupoMNS.entity.ProductHeader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductHeaderRepository extends CrudRepository<ProductHeader, Long> {

  List<ProductHeader> findAllByCodVend(int codVend);

  List<ProductHeader> findByCodVendOrderByCod(int codVend);

}
