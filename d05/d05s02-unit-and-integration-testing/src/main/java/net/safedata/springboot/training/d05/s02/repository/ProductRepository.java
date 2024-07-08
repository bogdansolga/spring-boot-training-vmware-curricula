package net.safedata.springboot.training.d05.s02.repository;

import net.safedata.spring.training.jpa.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
