package ru.geekbrains.donni.spring.comtrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.donni.spring.model.Product;
import ru.geekbrains.donni.spring.services.ProductService;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService (ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products")
    public String showProductsPage (Model model) {
        List<Product> list = productService.getAllProducts();
        model.addAttribute("products", list);
        return "products";
    }

    @GetMapping("/save_product")
    public String saveProduct(@RequestParam String title, @RequestParam long cost) {
        Product product = new Product(title, cost);
        productService.save(product);
        return "redirect:/products";
    }
}
