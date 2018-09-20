package com.grupomns.GrupoMNS.repository;

import com.grupomns.GrupoMNS.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

  List<Project> findAll();

}
