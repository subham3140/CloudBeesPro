package com.cloudbees.ecommerce.app.repository;

import com.cloudbees.ecommerce.app.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository Interface For The Product API Operations
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>, ProductCustomRepository {
}
