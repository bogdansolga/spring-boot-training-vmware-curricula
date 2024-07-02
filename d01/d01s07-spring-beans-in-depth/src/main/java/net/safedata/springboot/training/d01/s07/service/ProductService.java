package net.safedata.springboot.training.d01.s07.service;

import net.safedata.springboot.training.d01.s07.RunProfiles;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile(RunProfiles.DEV)
public class ProductService {

    public void displayAllProducts() {
        System.out.println("Displaying all the products");
    }
}
