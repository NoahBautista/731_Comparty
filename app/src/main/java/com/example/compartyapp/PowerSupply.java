package com.example.compartyapp;

import androidx.room.Entity;

@Entity(tableName = "powerSupply_table")
public class PowerSupply extends Component
{
    protected String type;
    protected String capacity;
    protected String rating;

    public PowerSupply(int image, String name, String description, String manufacturer, String link, double price, String productType, String type, String capacity, String rating) {
        super(image, name, description, manufacturer, link, price, productType);
        this.type = type;
        this.capacity = capacity;
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getRating() {
        return rating;
    }
}
