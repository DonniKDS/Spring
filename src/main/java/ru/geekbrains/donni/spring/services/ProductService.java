package ru.geekbrains.donni.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.donni.spring.model.Product;
import ru.geekbrains.donni.spring.repositories.ProductRepository;

import java.util.List;

@Component
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts () {
        return productRepository.getAllProducts();
    }

    public void save (Product product) {
        productRepository.save(product);
    }
}
