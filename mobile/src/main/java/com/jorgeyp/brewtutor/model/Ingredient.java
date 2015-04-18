package com.jorgeyp.brewtutor.model;

/**
 * Created by jorge on 17/4/15.
 */
public class Ingredient {
    String name;
    float quantity;
    String units;

    public Ingredient(String name, float quantity, String units) {
        this.name = name;
        this.quantity = quantity;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", units='" + units + '\'' +
                '}';
    }
}
