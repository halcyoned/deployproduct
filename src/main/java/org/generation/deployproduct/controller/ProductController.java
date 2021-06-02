package org.generation.deployproduct.controller;

import org.generation.deployproduct.Service.ProductService;
import org.generation.deployproduct.controller.DTO.ProductDTO;
import org.generation.deployproduct.repository.Entity.Product;
import org.generation.deployproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    final ProductService productService;


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

    public ProductController(@Autowired ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping("/all")
    public Iterable<Product> getProducts()
    {
        return productService.all();
    }

    @CrossOrigin
    @PostMapping("/add")
    public Product save(@RequestBody ProductDTO productDto)
    {
        System.out.println("In Save");
        return productService.save(new Product(productDto));
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Integer id)
    {
        return productService.findById(id);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public Product update( @PathVariable Integer id, @RequestBody ProductDTO productDto)
    //public Product update(@PathVariable Integer id
    {
        System.out.println("Hello");
        Product product = productService.findById(id);
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setImage_url(productDto.getImage_url());
        product.setPrice(productDto.getPrice());
        return productService.save(product);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id) {
        productService.delete(id);
    }

}
