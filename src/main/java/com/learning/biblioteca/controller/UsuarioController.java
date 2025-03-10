package com.learning.biblioteca.controller;

import com.learning.biblioteca.entity.Usuario;
import com.learning.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping
    public void postUsuario(@RequestBody Usuario usuario){
        usuarioService.criarUsuario(usuario);
    }
    
    
}
