package de.hska.iwi.vslab.Comp_Product_Category.Controllers;

import de.hska.iwi.vslab.Comp_Product_Category.Services.ProductCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * Checks if categoryId actually exists, if yes then the product is added. 
     */
    @PostMapping("/comp_product_category/product/{id}")
    public void addProduct(@RequestBody String name, double price, String details, int categoryId) { 
        // TODO REST Schema as param?
        // TODO what if no? a return value?
        productCategoryService.addProduct(name, price, details, categoryId);
    }

    /**
     * Delete a category and all products that were in that category. 
     */
    @DeleteMapping("/comp_product_category/category/{id}")
    public long deleteCategory(@PathVariable int id){
        return productCategoryService.deleteCategory(id);
    }

}
