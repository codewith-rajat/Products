package com.example.products.services;

import com.example.products.models.ProductModel;
import com.example.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {this.repository = repository; }

    public ProductModel addProduct(ProductModel product) {return repository.save(product); }

    public List<ProductModel> getProducts() {return repository.findAll(); }

    public ProductModel getProductById(String id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public ProductModel updateProduct(String id, ProductModel product){
        ProductModel existingProduct = repository.findById((id))
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        existingProduct.setName(product.getName());
        existingProduct.setCost((product.getCost()));
        return repository.save(existingProduct);
    }

    public void deleteProduct(String id) {
        repository.deleteById(id);
    }

}
