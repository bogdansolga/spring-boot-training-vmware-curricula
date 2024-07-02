package net.safedata.springboot.training.d05.s03.controller;

import net.safedata.springboot.training.d05.s03.model.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        path = "/product",
        method = RequestMethod.GET
)
public class ProductController {

    @RequestMapping(
            path = "/{id}"
    )
    public Product getProduct(@PathVariable final int id) {
        return new Product(10, "Tablet");
    }
}
