package com.grupomns.GrupoMNS.controller;

import com.grupomns.GrupoMNS.entity.User;
import com.grupomns.GrupoMNS.exception.EntityNotFoundException;
import com.grupomns.GrupoMNS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  private UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/getUser")
  private User getUser(@RequestHeader("username") String username, @RequestHeader("password") String password) throws EntityNotFoundException {
    return userRepository.findByUsernameAndPassword(username, password).orElseThrow(
        () -> new EntityNotFoundException("Usuário ou senha invalidos.")
    );
  }

}
