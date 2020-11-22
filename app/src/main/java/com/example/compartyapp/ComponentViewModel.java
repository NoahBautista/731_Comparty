package com.example.compartyapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ComponentViewModel extends AndroidViewModel {
    private ComponentRepository repository;
    private LiveData<List<CPU>> allCPUs;
    private LiveData<List<GPU>> allGPUs;
    private LiveData<List<RAM>> allRAMs;
    private LiveData<List<Motherboard>> allMotherboards;
    private LiveData<List<Cases>> allCases;
    private LiveData<List<PowerSupply>> allPowerSupplies;

    public ComponentViewModel(@NonNull Application application) {
        super(application);
        repository = new ComponentRepository(application);
        allCPUs = repository.getAllCPUs();
        allGPUs = repository.getAllGPUs();
        allRAMs = repository.getAllRAMs();
        allMotherboards = repository.getAllMotherboards();
        allCases = repository.getAllCases();
        allPowerSupplies = repository.getAllPowerSupplies();
    }
/*

Insert

 */
    public void insertCPU(CPU cpu)
    {
        repository.insertCPU(cpu);
    }
    public void insertGPU(GPU gpu)
    {
        repository.insertGPU(gpu);
    }
    public void insertRAM(RAM ram)
    {
        repository.insertRAM(ram);
    }
    public void insertMotherboard(Motherboard motherboard)
    {
        repository.insertMotherboard(motherboard);
    }
    public void insertCases(Cases cases)
    {
        repository.insertCases(cases);
    }
    public void insertPowerSupply(PowerSupply powerSupply)
    {
        repository.insertPowerSupply(powerSupply);
    }
/*

Update

 */
    public void updateCPU(CPU cpu)
    {
        repository.updateCPU(cpu);
    }
    public void updateGPU(GPU gpu)
    {
        repository.updateGPU(gpu);
    }
    public void updateRAM(RAM ram)
    {
        repository.updateRAM(ram);
    }
    public void updateMotherboard(Motherboard motherboard)
    {
        repository.updateMotherboard(motherboard);
    }
    public void updateCases(Cases cases)
    {
        repository.updateCases(cases);
    }
    public void updatePowerSupply(PowerSupply powerSupply)
    {
        repository.updatePowerSupply(powerSupply);
    }
    /*

    Delete

     */
    public void deleteCPU(CPU cpu)
    {
        repository.deleteCPU(cpu);
    }
    public void deleteGPU(GPU gpu)
    {
        repository.deleteGPU(gpu);
    }
    public void deleteRAM(RAM ram)
    {
        repository.deleteRAM(ram);
    }
    public void deleteMotherboard(Motherboard motherboard)
    {
        repository.deleteMotherboard(motherboard);
    }
    public void deleteCases(Cases cases)
    {
        repository.deleteCases(cases);
    }
    public void deletePowerSupply(PowerSupply powerSupply)
    {
        repository.deletePowerSupply(powerSupply);
    }
    /*

DeleteAll

 */
    public void deleteAllCPUs(CPU cpu)
    {
        repository.deleteAllCPUs();
    }
    public void deleteAllGPUs(GPU gpu)
    {
        repository.deleteAllGPUs();
    }
    public void deleteAllRAMs(RAM ram)
    {
        repository.deleteAllRAMs();
    }
    public void deleteAllMotherboards(Motherboard motherboard)
    {
        repository.deleteAllMotherboards();
    }
    public void deleteAllCases(Cases cases)
    {
        repository.deleteAllCases();
    }
    public void deleteAllPowerSupplies(PowerSupply powerSupply)
    {
        repository.deleteAllPowerSupplies();
    }

    public LiveData<List<CPU>> getAllCPUs()
    {
        return allCPUs;
    }
    public LiveData<List<GPU>> getAllGPUs()
    {
        return allGPUs;
    }

    public LiveData<List<RAM>> getAllRAMs()
    {
        return allRAMs;
    }

    public LiveData<List<Motherboard>> getAllMotherboards()
    {
        return allMotherboards;
    }

    public LiveData<List<Cases>> getAllCases()
    {
        return allCases;
    }

    public LiveData<List<PowerSupply>> getAllPowerSupplies()
    {
        return allPowerSupplies;
    }



}
