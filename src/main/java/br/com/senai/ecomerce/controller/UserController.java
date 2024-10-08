package br.com.senai.ecomerce.controller;

import br.com.senai.ecomerce.entity.User;
import br.com.senai.ecomerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //supora apenas dados
@RequestMapping("/user") // localhost:8080/user
public class UserController {

    // injeção de dependência, criar um objeto
    @Autowired
    private UserRepository userRepository;

    //metodo para criar um usuario
    @PostMapping
    public User createUsuario(@RequestBody User user) {
        return userRepository.save(user);
    }
}
