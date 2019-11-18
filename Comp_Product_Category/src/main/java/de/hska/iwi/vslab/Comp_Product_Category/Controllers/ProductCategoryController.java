package de.hska.iwi.vslab.Comp_Product_Category.Controllers;

import de.hska.iwi.vslab.Comp_Product_Category.Services.ProductCategoryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

	private static final Logger log = LoggerFactory.getLogger(ProductCategoryController.class);

    /**
     * Checks if categoryId actually exists, if yes then the product is added. 
     */
    @PostMapping("/comp_product_category/product")
    public void addProduct(@RequestBody String name, double price, int categoryId, String details) { 
        log.info("addProduct(name, price, categoryId, details) was called");
        productCategoryService.addProduct(name, price, categoryId, details);
    }

    /**
     * Delete a category and all products that were in that category. 
     */
    @DeleteMapping("/comp_product_category/category/{id}")
    public void deleteCategory(@PathVariable int id){
        log.info("deleteCategory(id) was called");
        productCategoryService.deleteCategory(id);
    }

}
