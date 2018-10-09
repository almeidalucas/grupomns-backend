package com.grupomns.GrupoMNS.controller;

import com.grupomns.GrupoMNS.ErrorResponse;
import com.grupomns.GrupoMNS.entity.User;
import com.grupomns.GrupoMNS.exception.EntityNotFoundException;
import com.grupomns.GrupoMNS.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(
    value = "UserController receives requests for user data",
    description = "This controller implements REST endpoints to get user data"
)
@RestController
@RequestMapping("/user")
public class UserController {

  private UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @ApiOperation(
      value = "Get user by username and password",
      response = User.class
  )
  @ApiResponses(
      value = {
          @ApiResponse(code = 200, message = "OK", response = User.class),
          @ApiResponse(code = 404, message = "User not found", response = EntityNotFoundException.class),
          @ApiResponse(code = 500, message = "Error processing request", response = ErrorResponse.class)
      }
  )
  @GetMapping("/getUser")
  private User getUser(
      @ApiParam(value = "Username", required = true, name = "name")
      @RequestHeader("name") String name,
      @ApiParam(value = "Password", required = true, name = "password")
      @RequestHeader("password") String password) throws EntityNotFoundException {

    return userRepository.findByNameAndPassword(name, password).orElseThrow(
        () -> new EntityNotFoundException("Usuário ou senha invalidos.")
    );

  }

}
