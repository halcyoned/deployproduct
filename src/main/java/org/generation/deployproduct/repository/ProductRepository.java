package org.generation.deployproduct.repository;

import org.generation.deployproduct.repository.Entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
