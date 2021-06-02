package org.generation.deployproduct.controller;

import org.generation.deployproduct.repository.Entity.Product;
import org.generation.deployproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {



    //Test - IMPROPER WAY
    /*final ProductRepository productRepository;

    public ProductController(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public Iterable<Product> getProduct() {
        return productRepository.findAll();
    }
     */

}
