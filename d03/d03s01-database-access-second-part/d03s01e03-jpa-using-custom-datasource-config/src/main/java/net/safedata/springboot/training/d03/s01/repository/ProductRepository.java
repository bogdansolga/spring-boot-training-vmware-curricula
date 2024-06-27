package net.safedata.springboot.training.d03.s01.repository;

import net.safedata.spring.training.jpa.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}