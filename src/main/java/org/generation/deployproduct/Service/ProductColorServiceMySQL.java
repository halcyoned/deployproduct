package org.generation.deployproduct.Service;

import org.generation.deployproduct.repository.Entity.Product_Color;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductColorServiceMySQL implements ProductColorService {

    public ProductColorServiceMySQL() {}

    @Override
    public Product_Color save(Product_Color product_color)
    {
        return null;
    }

    @Override
    public void delete(int product_product_code)
    {

    }

    @Override
    public List<Product_Color> all()
    {
        return null;
    }

    @Override
    public Product_Color findById(int product_product_code)
    {
        return null;
    }
}
