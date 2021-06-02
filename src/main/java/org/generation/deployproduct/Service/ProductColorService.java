package org.generation.deployproduct.Service;

import org.generation.deployproduct.repository.Entity.Product_Color;

import java.util.List;

public interface ProductColorService {

    Product_Color save(Product_Color product_color);

    void delete(int product_color_id);

    List<Product_Color> all();

    Product_Color findById(int product_color_id);

}
