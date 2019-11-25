package de.hska.iwi.vslab.Comp_Product_Category.Services;

import org.springframework.stereotype.Service;

import de.hska.iwi.vslab.Comp_Product_Category.ConsumingREST.Category;
import de.hska.iwi.vslab.Comp_Product_Category.ConsumingREST.ConsumeCoreCategory;
import de.hska.iwi.vslab.Comp_Product_Category.ConsumingREST.ConsumeCoreProduct;
import de.hska.iwi.vslab.Comp_Product_Category.ConsumingREST.Product;

/**
 * The implementation of the service.
 */
@Service
public class ProductCategoryService {

    public void addProduct(String name, Double price, Integer categoryId, String details) {
        ConsumeCoreCategory coreCategory = new ConsumeCoreCategory();
        Category[] categories = coreCategory.getCategories();

        loop: for (Category cat : categories) {
            if (cat.getId() == categoryId) {
                ConsumeCoreProduct coreProduct = new ConsumeCoreProduct();
                coreProduct.addProduct(name, price, categoryId, details);
                break loop;
            }
        }
    }

    public long deleteCategory(int id) {
        ConsumeCoreCategory coreCategory = new ConsumeCoreCategory();
        coreCategory.deleteCategory(id);

        ConsumeCoreProduct coreProduct = new ConsumeCoreProduct();
        Product[] products = coreProduct.getProducts();
        for (Product product : products) {
            if (product.getCategoryId() == id) {
                coreProduct.deleteProduct(id);
            }
        }
        return 0;
    }

}
