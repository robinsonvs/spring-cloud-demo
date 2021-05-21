package com.severo.cloud.productcatalog.repository;

import com.severo.cloud.productcatalog.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
