package br.com.fiap.biblioteca_virtual_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.biblioteca_virtual_api.model.Token;
import br.com.fiap.biblioteca_virtual_api.model.User;
import br.com.fiap.biblioteca_virtual_api.repository.UserRepository;
import br.com.fiap.biblioteca_virtual_api.service.AuthService;
import br.com.fiap.biblioteca_virtual_api.service.TokenService;

@RestController
public class AuthController {
    
    @Autowired
    private TokenService tokenService;

    @Autowired 
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody Credentials credentials){
        var user = authService.loadUserByUsername(credentials.email());
        
        return tokenService.createToken((User) user);
        // new Token("token", "Beaeer", credentials.email());
        // "token" + credentials.email(); 
    }
}
