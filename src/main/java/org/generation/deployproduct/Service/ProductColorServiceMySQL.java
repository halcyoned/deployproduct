package org.generation.deployproduct.Service;


import org.generation.deployproduct.repository.Entity.Product_Color;
import org.generation.deployproduct.repository.Product_ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductColorServiceMySQL implements ProductColorService {

    private final Product_ColorRepository product_colorRepository;

    public ProductColorServiceMySQL(@Autowired Product_ColorRepository product_colorRepository) {
        this.product_colorRepository = product_colorRepository;
    }

    @Override
    public Product_Color save(Product_Color product_color)
    {
        return product_colorRepository.save(product_color);
    }

    @Override
    public void delete(int product_color_id)
    {
       product_colorRepository.deleteById(product_color_id);
    }

    @Override
    public List<Product_Color> all()
    {
        List<Product_Color> result = new ArrayList<>();
        product_colorRepository.findAll().forEach(result::add);
        return result;

    }

    @Override
    public Product_Color findById(int product_color_id)
    {
        Optional<Product_Color> product_color = product_colorRepository.findById(product_color_id);
        Product_Color product_colorResponse = product_color.get();
        return product_colorResponse;
    }
}
