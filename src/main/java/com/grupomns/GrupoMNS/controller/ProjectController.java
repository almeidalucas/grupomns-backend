package com.grupomns.GrupoMNS.controller;

import com.grupomns.GrupoMNS.entity.Project;
import com.grupomns.GrupoMNS.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

  private ProjectRepository projectRepository;

  @Autowired
  ProjectController(ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }

  @GetMapping("/")
  private List<Project> getProjects() {
    return projectRepository.findAll();
  }

}
