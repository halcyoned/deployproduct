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
    public Product save(Product item) {return productRepository.save(product);}

    @Override
    public void delete(int productId) {productRepository.deleteById(productId);}

    @Override
    public List<Product> all() {
        List<Product> result = new ArrayList<>();
        productRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Product findById(int itemId) {

        Optional<Product> item = productRepository.findById(itemId);
        Product productResponse = product.get();
        return productResponse;
    }
}
