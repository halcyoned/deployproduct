package org.generation.deployproduct.controller;

import org.generation.deployproduct.Service.ProductColorService;
import org.generation.deployproduct.controller.DTO.ProductColorDTO;
import org.generation.deployproduct.repository.Entity.Product_Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product_color")
public class ProductColorController {

    final ProductColorService productColorService;

    public ProductColorController(@Autowired ProductColorService productColorService) {
        this.productColorService = productColorService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Product_Color> getProductColors() {
        System.out.println("In getProductColors method");
        return productColorService.all();
    }

    @CrossOrigin
    @PostMapping("/add")
    public Product_Color save(@RequestBody ProductColorDTO productColorDTO) {
        System.out.println("In save method");
        return productColorService.save(new Product_Color(productColorDTO));
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Product_Color findProductColorById(@PathVariable Integer product_color_id) {
        System.out.println("In findProductColorById method");
        return productColorService.findById(product_color_id);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public Product_Color update(@PathVariable Integer id, @RequestBody ProductColorDTO productColorDTO) {
        System.out.println("In update method");
        Product_Color product_color = productColorService.findById(id);
        product_color.setProduct_Product_code(productColorDTO.getProduct_Product_code());
        product_color.setColor(productColorDTO.getColor());
        return productColorService.save(product_color);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productColorService.delete(id);
    }
}
