package com.example.compartyapp;

import androidx.room.Entity;

@Entity(tableName = "ram_table")
public class RAM extends Component
{
    protected String frequency;
    protected String memoryType;
    protected String capacity;
    protected int numberOfSticks;

    public RAM(int image, String name, String description, String manufacturer, String link, double price, String productType, String frequency, String memoryType, String capacity, int numberOfSticks) {
        super(image, name, description, manufacturer, link, price, productType);
        this.frequency = frequency;
        this.memoryType = memoryType;
        this.capacity = capacity;
        this.numberOfSticks = numberOfSticks;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public String getCapacity() {
        return capacity;
    }

    public int getNumberOfSticks() {
        return numberOfSticks;
    }
}
