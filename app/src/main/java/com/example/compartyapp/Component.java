package com.example.compartyapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "component_table")
public class Component
{
    @PrimaryKey(autoGenerate = true)
    protected int componentID;
    protected int image;
    protected String name;
    protected String description;
    protected String manufacturer;
    protected String link;
    protected double price;
    protected String productType;

    public Component(int image, String name, String description, String manufacturer, String link, double price, String productType) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.link = link;
        this.price = price;
        this.productType = productType;
    }

    public void setComponentID(int componentID) {
        this.componentID = componentID;
    }

    public int getComponentID() {
        return componentID;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getLink() {
        return link;
    }

    public double getPrice() {
        return price;
    }

    public String getProductType() {
        return productType;
    }
}
