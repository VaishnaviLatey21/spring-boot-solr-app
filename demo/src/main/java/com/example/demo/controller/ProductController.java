package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {
        try {
            return productService.addProduct(product);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
    
//    @GetMapping("/get")
//    public String getProducts() {
//        try {
//            return productService.getAllProducts();
//        } catch (Exception e) {
//            return "Error: " + e.getMessage();
//        }
//    }

    @GetMapping("/")
    public String home() {
        return "Hello, World!";
    }
    
//    @GetMapping("/search")
//    public List<Product> searchProducts(@RequestParam String keyword) {
//        try {
//            return productService.searchProducts(keyword);
//        } catch (Exception e) {
//            return null;
//        }
//    }
}
