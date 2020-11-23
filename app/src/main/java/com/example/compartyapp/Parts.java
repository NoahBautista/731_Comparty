package com.example.compartyapp;

public class Parts {

    private String description;
    private String link;
    private String manufacturer;
    private String name;
    private String type;
    private double price;

    private Parts() {}

    private Parts(String description, String link, String manufacturer, String name, String type, double price) {
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

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

}
