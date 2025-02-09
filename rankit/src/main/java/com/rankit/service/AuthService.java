package com.rankit.service;

import com.rankit.entity.Usuario;
import com.rankit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public boolean autenticarUsuario(String email, String senha) {
        Optional<Usuario> usuario = userRepository.findByEmail(email);
        return usuario.isPresent() && usuario.get().getSenha().equals(senha);
    }
}
