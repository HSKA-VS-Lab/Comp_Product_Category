package de.hska.iwi.vslab.Comp_Product_Category.ConsumingREST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;


public class ConsumeCoreCategory {
    
    private static final Logger log = LoggerFactory.getLogger(ConsumeCoreCategory.class);

    private String urlCoreCategory = "http://localhost:8082/category";
    
    RestTemplate restTemplate = new RestTemplate();

    public Category[] getCategories() {
        Category [] categories = restTemplate.getForObject(urlCoreCategory, Category[].class);
        for (Category category : categories) {
            log.info(category.toString());
        }
        return categories;
    }

}