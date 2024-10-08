package br.com.senai.ecomerce.controller;

import br.com.senai.ecomerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //supora apenas dados
@RequestMapping("/user") // localhost:8080/user
public class UserController {
    // injeção de dependência, criar um objeto
    @Autowired
    private UserRepository userRepository;
}
