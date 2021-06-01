package org.generation.deployproduct.Service;

import org.generation.deployproduct.repository.Entity.Item;
import java.util.List;

@Service
public interface ProductService {
    Product save (Product product);

    void delete (int productId);

    List<Product> all();

    Product findById(int productId);

}
