package com.rankit.controller;

import com.rankit.entity.Usuario;
import com.rankit.entity.Usuario;
import com.rankit.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/rankitapi/auth")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class AuthController {

    @Autowired
    private UserRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario, HttpSession session) {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioEncontrado.isPresent() && usuarioEncontrado.get().getSenha().equals(usuario.getSenha())) {
            session.setAttribute("usuario", usuarioEncontrado.get());
            return ResponseEntity.ok("Usuário autenticado com sucesso!");
        }
        return ResponseEntity.status(401).body("Email ou senha incorretos.");
    }

    @GetMapping("/usuario")
    public Usuario getUsuarioAutenticado(HttpSession session) {
        return (Usuario) session.getAttribute("usuario");
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "Logout realizado com sucesso!";
    }
}

