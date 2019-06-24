package com.grupomns.GrupoMNS.repository;

import com.grupomns.GrupoMNS.entity.OperationType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationTypeRepository extends CrudRepository<OperationType, Long>, EntityRepository<OperationType> {

}
