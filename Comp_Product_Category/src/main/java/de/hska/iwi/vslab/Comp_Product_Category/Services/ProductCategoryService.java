package de.hska.iwi.vslab.Comp_Product_Category.Services;

import org.springframework.stereotype.Service;

/** 
 * The implementation of the service.
 */
@Service
public class ProductCategoryService {

    private String urlDB = "http://localhost:8080/";

    private String urlCoreCategory = "http://localhost:8080/category";

    private String urlCoreProduct = "http://localhost:8080/product";

    public void addProduct(String name, double price, String details, int categoryId) { 
        
    }

    public long deleteCategory(int id){
        return 0;
    }
    
}
