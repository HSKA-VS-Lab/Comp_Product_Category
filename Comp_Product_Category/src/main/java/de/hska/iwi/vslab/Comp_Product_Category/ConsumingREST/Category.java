package de.hska.iwi.vslab.Comp_Product_Category.ConsumingREST;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {

    private int id;
    private String name;

    @Override
    public String toString() {
        return "{ id=" + id + ", name=" + name + " }";
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

}