package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    private final ProductService productService;

    @Autowired
    public ProductConfig(ProductService studentService) {
        this.productService = studentService;
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository){
        return args -> {
            //"Электро-товары","маршрутизаторы",
            Product pr1 = new Product("jrogg","nnnnnn",
                    "1111","123456789",12345,1123456);
            Product pr2 = new Product("kkkkk","uuuuu",
                    "22222","9840374312",55000,68900);

            repository.saveAll(
                    List.of(pr1,pr2)
            );
        };
    }

}
