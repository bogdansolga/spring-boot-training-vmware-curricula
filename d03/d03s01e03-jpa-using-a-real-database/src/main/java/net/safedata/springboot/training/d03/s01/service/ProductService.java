package net.safedata.springboot.training.d03.s01.service;

import jakarta.annotation.PostConstruct;
import net.safedata.spring.training.jpa.model.Product;
import net.safedata.springboot.training.d03.s01.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class ProductService {

    private static final Random RANDOM = new Random(200);

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init() {
        IntStream.range(0, 10)
                 .forEach(value ->
                         productRepository.save(new Product("The product with the ID " + RANDOM.nextInt(100),
                                 RANDOM.nextDouble() * 200))
                 );
    }

    @Transactional(
            readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = {
                  IllegalArgumentException.class,
                  UnsupportedOperationException.class
            }
    )
    public void create(final Product product) {
        productRepository.save(product);
    }

    public Product get(final int id) {
        return productRepository.findById(id)
                                .orElseThrow(() -> new IllegalArgumentException("Not found"));
    }

    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    public void update(final int id, final Product product) {
        final Product existingProduct = get(id);

        existingProduct.setName(product.getName());

        productRepository.save(product);
    }

    public void delete(final int id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductsPage(int pageNumber, int pageSize) {
        return productRepository.findAll(Pageable.ofSize(pageSize)
                                                 .withPage(pageNumber))
                                .orElse(new ArrayList<>());
    }
}
