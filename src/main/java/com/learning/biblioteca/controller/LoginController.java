
package com.learning.biblioteca.controller;

import com.learning.biblioteca.dtos.Login;
import com.learning.biblioteca.dtos.Sessao;
import com.learning.biblioteca.entity.Usuario;
import com.learning.biblioteca.repository.UsuarioRepository;
import com.learning.biblioteca.security.JWTCreator;
import com.learning.biblioteca.security.JWTObject;
import com.learning.biblioteca.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
@RestController
public class LoginController {
    @Autowired
    private PasswordEncoder encoder;
    
    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/login")
    public Sessao logar(@RequestBody Login login){
        Usuario user = repository.findByEmail(login.getEmail());
        if(user!=null) {
            boolean passwordOk =  encoder.matches(login.getSenha(), user.getSenha());
            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login: " + login.getEmail());
            }
            
            Sessao sessao = new Sessao();
            sessao.setLogin(user.getEmail());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
            jwtObject.setRoles(user.getRoles());
            sessao.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
            return sessao;
        } else {
            throw new RuntimeException("Erro ao tentar fazer login");
        }
    }
}