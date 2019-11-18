package de.hska.iwi.vslab.Comp_Product_Category.ConsumingREST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;


public class ConsumeCoreProduct {
    
    private static final Logger log = LoggerFactory.getLogger(ConsumeCoreProduct.class);

    private String urlCoreProduct = "http://localhost:8080/product";
    
    RestTemplate restTemplate = new RestTemplate();

    public Product[] getProducts() {
        Product [] products = restTemplate.getForObject(urlCoreProduct, Product[].class);
        return products;
    }

    public void addProduct(String name, double price, int categoryId, String details) {
        Product product = new Product(name, price, categoryId, details);
        restTemplate.postForLocation(urlCoreProduct, product);
    }

    public void deleteProduct(int id) {
        restTemplate.delete(urlCoreProduct + "/" + id);
    }

}