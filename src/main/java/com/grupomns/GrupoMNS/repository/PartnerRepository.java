package com.grupomns.GrupoMNS.repository;

import com.grupomns.GrupoMNS.entity.Partner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends CrudRepository<Partner, Long>, EntityRepository<Partner> {

}
