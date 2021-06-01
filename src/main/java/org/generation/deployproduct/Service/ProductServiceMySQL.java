package org.generation.deployproduct.Service;

import org.generation.deployproduct.repository.Entity.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceMySQL implements ProductService{

    public ProductServiceMySQL() {}

    @Override
    public Product save(Product product)
    {
        return null;
    }

    @Override
    public void delete(int product_code)
    {

    }

    @Override
    public List<Product> all()
    {
        return null;
    }

    @Override
    public Product findById(int product_code)
    {
        return null;
    }
}
