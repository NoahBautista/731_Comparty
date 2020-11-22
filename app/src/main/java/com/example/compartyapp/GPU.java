package com.example.compartyapp;

import androidx.room.Entity;

@Entity(tableName = "gpu_table")
public class GPU extends Component
{
    protected int cores;
    protected int vram;
    protected String gpuBaseClock;
    protected String gpuBoostClock;
    protected String pcieVersion;

    public GPU(int image, String name, String description, String manufacturer, String link, double price, String productType, int cores, int vram, String gpuBaseClock, String gpuBoostClock, String pcieVersion) {
        super(image, name, description, manufacturer, link, price, productType);
        this.cores = cores;
        this.vram = vram;
        this.gpuBaseClock = gpuBaseClock;
        this.gpuBoostClock = gpuBoostClock;
        this.pcieVersion = pcieVersion;
    }

    public int getCores() {
        return cores;
    }

    public int getVram() {
        return vram;
    }

    public String getGpuBaseClock() {
        return gpuBaseClock;
    }

    public String getGpuBoostClock() {
        return gpuBoostClock;
    }

    public String getPcieVersion() {
        return pcieVersion;
    }
}
