package de.hska.iwi.vslab.Comp_Product_Category;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.hska.iwi.vslab.Comp_Product_Category.ConsumingREST.ConsumeCoreProduct;
import de.hska.iwi.vslab.Comp_Product_Category.Controllers.ProductCategoryController;
import de.hska.iwi.vslab.Comp_Product_Category.Services.ProductCategoryService;

@SpringBootApplication
public class CompProductCategoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompProductCategoryApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			ProductCategoryController controller = new ProductCategoryController();

			ConsumeCoreProduct productService = new ConsumeCoreProduct(); 
			productService.execute();
			//controller.addProduct(name, price, details, "Obst");
			// add a product and delete a category
		};
	}

}
