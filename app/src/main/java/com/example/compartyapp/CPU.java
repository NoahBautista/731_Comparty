package com.example.compartyapp;

import androidx.room.Entity;

@Entity(tableName = "cpu_table")
public class CPU extends Component
{
    protected int numberOfCores;
    protected int numberOfThreads;
    protected String baseClock;
    protected String boostClock;


    public CPU(int image, String name, String description, String manufacturer, String link, double price, String productType, int numberOfCores, int numberOfThreads, String baseClock, String boostClock) {
        super(image, name, description, manufacturer, link, price, productType);
        this.numberOfCores = numberOfCores;
        this.numberOfThreads = numberOfThreads;
        this.baseClock = baseClock;
        this.boostClock = boostClock;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public int getNumberOfThreads() {
        return numberOfThreads;
    }

    public String getBaseClock() {
        return baseClock;
    }

    public String getBoostClock() {
        return boostClock;
    }
}
