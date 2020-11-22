package com.example.compartyapp;

import androidx.room.Entity;

@Entity(tableName = "cases_table")
public class Cases extends Component
{
    protected String sizeSupport;

    public Cases(int image, String name, String description, String manufacturer, String link, double price, String productType, String sizeSupport) {
        super(image, name, description, manufacturer, link, price, productType);
        this.sizeSupport = sizeSupport;
    }

    public String getSizeSupport() {
        return sizeSupport;
    }
}
