package com.example.compartyapp;

public class Components {

    private String description;
    private String link;
    private String manufacturer;
    private String name;
    private String type;
    private double price;

    private Components() {}

    private Components(String description, String link, String manufacturer, String name, String type, double price) {
        this.description = description;
        this.link = link;
        this.manufacturer = manufacturer;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
