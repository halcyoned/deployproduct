package org.generation.deployproduct.Service;

import org.generation.deployproduct.repository.ItemRepository;
import org.generation.deployproduct.repository.Entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceMySQL implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceMySQL(@Autowired ProductRepository productRepository) {this.productRepository = productRepository;}

    @Override
    public Product save(Product product) {return productRepository.save(product);}

    @Override
    public void delete(int product_code) {productRepository.deleteById(product_code);}

    @Override
    public List<Product> all() {
        List<Product> result = new ArrayList<>();
        productRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Product findById(int product_code) {

        Optional<Product> item = productRepository.findById(product_code);
        Product productResponse = product.get();
        return productResponse;
    }
}
