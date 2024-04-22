package br.com.example.springbootawsservicesintegrations.controller;

import br.com.example.springbootawsservicesintegrations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/user-password")
    public String getUserPassword(){
        return service.getUserPassword();
    }
}
