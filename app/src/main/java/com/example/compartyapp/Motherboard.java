package com.example.compartyapp;

import androidx.room.Entity;

@Entity(tableName = "motherboard_table")
public class Motherboard extends Component
{
    protected String size;
    protected String socket;
    protected String ramSupport;
    protected String pcieSupport;

    public Motherboard(int image, String name, String description, String manufacturer, String link, double price, String productType, String size, String socket, String ramSupport, String pcieSupport) {
        super(image, name, description, manufacturer, link, price, productType);
        this.size = size;
        this.socket = socket;
        this.ramSupport = ramSupport;
        this.pcieSupport = pcieSupport;
    }

    public String getSize() {
        return size;
    }

    public String getSocket() {
        return socket;
    }

    public String getRamSupport() {
        return ramSupport;
    }

    public String getPcieSupport() {
        return pcieSupport;
    }
}
