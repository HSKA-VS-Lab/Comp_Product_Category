package de.hska.iwi.vslab.Comp_Product_Category.Controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import de.hska.iwi.vslab.Comp_Product_Category.Services.ProductCategoryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.*;
import de.hska.iwi.vslab.Comp_Product_Category.ConsumingREST.Product;

@RestController
@EnableCircuitBreaker
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    private static final Logger log = LoggerFactory.getLogger(ProductCategoryController.class);

    /**
     * Checks if categoryId actually exists, if yes then the product is added.
     */
    @PostMapping(path = "/comp_product_category/product", consumes = "application/json")
    //@HystrixCommand(fallbackMethod = "defaultFallback")
    public void addProduct(@RequestBody(required = true) Product request) {
        log.info("addProduct(name, price, categoryId, details) was called");
        productCategoryService.addProduct(request.getName(), request.getPrice(), request.getCategoryId(),
                request.getDetails());
    }

    /**
     * Delete a category and all products that were in that category.
     */
    @DeleteMapping("/comp_product_category/category/{id}")
    //@HystrixCommand(fallbackMethod = "defaultFallback")
    public void deleteCategory(@PathVariable int id) {
        log.info("deleteCategory(id) was called");
        productCategoryService.deleteCategory(id);
    }

    public void defaultFallback(Throwable throwable) {
        System.out.printf("DefaultFallback, exception=%s%n", throwable);
    }
}
