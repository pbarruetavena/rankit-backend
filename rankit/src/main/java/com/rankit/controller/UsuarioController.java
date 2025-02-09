package com.rankit.controller;

import com.rankit.repository.*;
import com.rankit.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rankitapi")
public class UsuarioController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody Usuario usuario) {
        if (userRepository.findByEmail(usuario.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("E-mail já cadastrado!");
        }

        usuario.setSenha(usuario.getSenha());
        userRepository.save(usuario);
        return ResponseEntity.ok("Usuário cadastrado com sucesso!");
    }
}
