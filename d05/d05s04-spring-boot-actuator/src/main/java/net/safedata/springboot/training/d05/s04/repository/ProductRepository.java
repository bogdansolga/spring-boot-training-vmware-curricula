package net.safedata.springboot.training.d05.s04.repository;

import net.safedata.springboot.training.d05.s04.model.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * A simple Spring Data {@link CrudRepository} for the {@link Product} entity
 *
 * @author bogdan.solga
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
