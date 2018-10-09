package com.grupomns.GrupoMNS.repository;

import com.grupomns.GrupoMNS.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>, EntityRepository<Project> {

}
