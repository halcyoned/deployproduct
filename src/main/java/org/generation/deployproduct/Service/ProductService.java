package org.generation.deployproduct.Service;

import org.generation.deployproduct.repository.Entity.Product;
import java.util.List;

public interface ProductService {
    Product save (Product product);

    void delete (int product_code);

    List<Product> all();

    Product findById(int product_code);

}
