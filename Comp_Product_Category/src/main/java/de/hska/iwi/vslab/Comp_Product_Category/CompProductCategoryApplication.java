package de.hska.iwi.vslab.Comp_Product_Category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import de.hska.iwi.vslab.Comp_Product_Category.ConsumingREST.Category;
import de.hska.iwi.vslab.Comp_Product_Category.ConsumingREST.ConsumeCoreCategory;
import de.hska.iwi.vslab.Comp_Product_Category.ConsumingREST.ConsumeCoreProduct;
import de.hska.iwi.vslab.Comp_Product_Category.ConsumingREST.Product;
import de.hska.iwi.vslab.Comp_Product_Category.Controllers.ProductCategoryController;
import de.hska.iwi.vslab.Comp_Product_Category.Services.ProductCategoryService;

@EnableEurekaClient
@SpringBootApplication
public class CompProductCategoryApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumeCoreProduct.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CompProductCategoryApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			log.info("Demo starting:");

			log.info("Adding Product Banana and getting all Products:");
			ProductCategoryService productService = new ProductCategoryService(); 
			productService.addProduct("Banana", 1.3, 1, "BANANA");

			ConsumeCoreProduct consumeProductService = new ConsumeCoreProduct(); 
			consumeProductService.getProducts();

			log.info("Getting all categories, then deleting Category Süßigkeiten, then getting all Categories and Products:");
			ConsumeCoreCategory categoryConsumeService = new ConsumeCoreCategory();
			Category[] cats = categoryConsumeService.getCategories();
			for (Category cat : cats) {
				log.info(cat.toString());
			}
			log.info("Deleting category 3");
			productService.deleteCategory(3);
			cats = categoryConsumeService.getCategories();
			for (Category cat : cats) {
				log.info(cat.toString());
			}
			log.info("Now Schokobons should be missing in products:");
			Product[] products = consumeProductService.getProducts();
			for (Product product : products) {
				log.info(product.toString());
			}
			
			log.info("Demo finishing.");
		};
	}*/

}
