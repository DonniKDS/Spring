package ru.geekbrains.donni.spring.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.donni.spring.ProductNotFoundException;
import ru.geekbrains.donni.spring.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<Product>(Arrays.asList(
                new Product(1L, "Книга", 500L),
                new Product(2L, "Ручка", 50L),
                new Product(3L, "Журнал", 300L),
                new Product(4L, "Открытка", 30L),
                new Product(5L, "Блокнот", 60L)
        ));
    }

    public ProductRepository() {
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(productList);
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Product getProductById (long id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new ProductNotFoundException();
    }

    public void save (Product product) {
        productList.add(product);
    }
}
