package de.hska.iwi.vslab.Comp_Product_Category.ConsumingREST;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    private int id = 999; // this value is determined by the core service
    private String name;
    private double price;
    private String details;
    private int categoryIdFromProduct;

    // the framework needs a default constructor for whatever reason..
    private Product() {
        name = "unknown";
        price = 0.0;
        details = "";
        categoryIdFromProduct = 0;
    }

    public Product(String name, double price, int categoryIdFromProduct, String details) {
        this.name = name;
        this.price = price;
        this.details = details;
        this.categoryIdFromProduct = categoryIdFromProduct;
    }

    @Override
    public String toString() {
        return String.format("Product[name='%s', price=%e, categoryId=%d, details='%s']", name, price, categoryIdFromProduct,
        details);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }
    /**
     * @return the details
     */
    public String getDetails() {
        return details;
    }
    /**
     * @return the categoryIdFromProduct
     */
    public int getCategoryIdFromProduct() {
        return categoryIdFromProduct;
    }

}