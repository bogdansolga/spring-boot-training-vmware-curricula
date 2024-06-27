package net.safedata.springboot.training.d04.s03.repository;

import net.safedata.spring.training.jpa.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
