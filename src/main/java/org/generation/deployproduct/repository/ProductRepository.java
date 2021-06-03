package org.generation.deployproduct.repository;

import org.generation.deployproduct.repository.Entity.Product;
import org.springframework.data.repository.CrudRepository;

//CrudRepository is a package that is imported in so that we can perform CRUD (Create, Read, Update, Delete) operations in the database

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
