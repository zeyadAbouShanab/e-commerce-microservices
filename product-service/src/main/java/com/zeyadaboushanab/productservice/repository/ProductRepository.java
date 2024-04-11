package com.zeyadaboushanab.productservice.repository;

import com.zeyadaboushanab.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
