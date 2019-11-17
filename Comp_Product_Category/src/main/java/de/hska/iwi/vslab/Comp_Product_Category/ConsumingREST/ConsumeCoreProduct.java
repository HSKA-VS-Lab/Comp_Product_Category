package de.hska.iwi.vslab.Comp_Product_Category.ConsumingREST;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;


public class ConsumeCoreProduct {
    
    private static final Logger log = LoggerFactory.getLogger(ConsumeCoreProduct.class);

    private String urlCoreProduct = "http://localhost:8080/product";

    public void execute() {
        RestTemplate restTemplate = new RestTemplate();
        Product [] products = restTemplate.getForObject(urlCoreProduct, Product[].class);
        for (Product product : products) {
            log.info(product.toString());
        }
        
    }

}