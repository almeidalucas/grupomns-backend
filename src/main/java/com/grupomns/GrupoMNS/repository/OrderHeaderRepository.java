package com.grupomns.GrupoMNS.repository;

import com.grupomns.GrupoMNS.entity.OrderHeader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderHeaderRepository extends CrudRepository<OrderHeader, Long> {

  List<OrderHeader> findByCodVendOrderByNuNota(int codVend);

}
