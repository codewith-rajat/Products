package com.example.products.controllers;

import com.example.products.models.ProductModel;
import com.example.products.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
public class ProductController{
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }
    // Create function API

    @GetMapping("/")
    public String hello(){
        return "hello";
    }

    @PostMapping("/addProduct")
    public ProductModel addProduct(@Valid @RequestBody ProductModel product){
        return service.addProduct(product);
    }

    @GetMapping("/products")
    public List<ProductModel> getProducts(){
        return service.getProducts();
    }

    @GetMapping("/products/{id}")
    public ProductModel getProductById(@PathVariable String id){
        return service.getProductById(id);
    }

    @PutMapping("/update/{id}")
    public ProductModel updateProduct(@Valid @PathVariable String id, @RequestBody ProductModel product){
        return service.updateProduct(id,product);
    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct(@PathVariable String id){
        service.deleteProduct(id);
    }
}
