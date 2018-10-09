package com.grupomns.GrupoMNS.repository;

import com.grupomns.GrupoMNS.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>, EntityRepository<Product> {

}
