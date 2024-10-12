package br.com.senai.ecomerce.controller;

import br.com.senai.ecomerce.entity.Product;
import br.com.senai.ecomerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //suporta apenas dados
@RequestMapping("/product") // localhost:8080/user
public class ProductController {
    // injeção de dependência, criar um objeto
    @Autowired
    private ProductRepository productRepository;

    //metodo para criar um produto
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    //listar todos os produtos do banco de dados
    @GetMapping
    public List<Product> getAllProduct() {
        // SELECT * FROM User
        return productRepository.findAll();
    }

    // Pegar produto pelo seu ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productRepository.findById(id).orElse(null);
    }

    // deleta um produto pelo seu id
    @DeleteMapping
    public void deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
    }

    //atualizar info do produto pelo id
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        if (product != null){
            product.setName(product.getName());
            product.setBrand(product.getBrand());
            product.setColor(product.getColor());
            product.setPrice(product.getPrice());
        }
        return null;
    }
}
