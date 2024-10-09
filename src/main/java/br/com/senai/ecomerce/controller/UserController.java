package br.com.senai.ecomerce.controller;

import br.com.senai.ecomerce.entity.User;
import br.com.senai.ecomerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //suporta apenas dados
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

    //listar todos os usuarios do banco de dados
    @GetMapping
    public List<User> getAllUser(){
        // SELECT * FROM User
        return userRepository.findAll();
    }

    // Pegar usuario pelo seu ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElse(null);
    }

    // deleta um usuario pelo seu id
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }
}
