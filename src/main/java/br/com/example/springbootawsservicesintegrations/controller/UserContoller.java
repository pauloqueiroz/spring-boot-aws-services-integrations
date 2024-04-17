package br.com.example.springbootawsservicesintegrations.controller;

import br.com.example.springbootawsservicesintegrations.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserContoller {

    UserService service;
    @GetMapping
    public String getUserPassword(){
        return service.getUserPassword();
    }
}
