package com.example.back_simulador_comunio.controller;

import com.example.back_simulador_comunio.entities.User;
import com.example.back_simulador_comunio.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/info")
    public User getUserDetails(){
        String userName = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return userRepo.findByUsername(userName).get();
    }
}
