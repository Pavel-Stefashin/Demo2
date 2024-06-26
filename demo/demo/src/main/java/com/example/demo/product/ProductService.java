package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository studentRepository) {
        this.productRepository = studentRepository;
    }

    public List<Product> ShowAll(String title){
        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    //--------------------------------
    public List<Product> ShowAllNotTitle(){
        return productRepository.findAll();
    }
    //--------------------------------
    public void AddProduct(Product product){
        productRepository.save(product);
    }

    public void DeleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

}