package de.hska.iwi.vslab.Comp_Product_Category.ConsumingREST;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    int id;
    String name;
    double price;
    String details;
    int categoryIdFromProduct;

    @Override
    public String toString() {
        return "Product{ ID=" + id + ", name=" + name + ", details=" + details + ", categoryIdFromProduct=" + categoryIdFromProduct + "}";
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