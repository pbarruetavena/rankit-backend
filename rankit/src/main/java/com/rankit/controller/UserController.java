package com.rankit.controller;

import com.rankit.repository.*;
import com.rankit.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rankitapi/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Usuario> getUsers() {
        for(Usuario u : userRepository.findAll()) {
            System.out.println(u.getName());
        }
        return userRepository.findAll();
    }

    @PostMapping
    public Usuario createUser(@RequestBody Usuario user) {
        return userRepository.save(user);
    }
}
