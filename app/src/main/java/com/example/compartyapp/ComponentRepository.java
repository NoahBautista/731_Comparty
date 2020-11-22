package com.example.compartyapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ComponentRepository
{
    private ComponentDao componentDao;
    private CPUDao cpuDao;
    private GPUDao gpuDao;
    private RAMDao ramDao;
    private MotherboardDao motherboardDao;
    private CasesDao casesDao;
    private PowerSupplyDao powerSupplyDao;

    private LiveData<List<Component>> allComponents;
    private LiveData<List<CPU>> allCPUs;
    private LiveData<List<GPU>> allGPUs;
    private LiveData<List<Motherboard>> allMotherboards;
    private LiveData<List<RAM>> allRAMs;
    private LiveData<List<Cases>> allCases;
    private LiveData<List<PowerSupply>> allPowerSupplies;

    public ComponentRepository(Application application)
    {
        ComponentDatabase database = ComponentDatabase.getInstance(application);
        componentDao = database.componentDao();
        allComponents = componentDao.getAllComponents();

        cpuDao = database.cpuDao();
        allCPUs = cpuDao.getAllCPUs();

        gpuDao = database.gpuDao();
        allGPUs = gpuDao.getAllGPUs();

        ramDao = database.ramDao();
        allRAMs = ramDao.getAllRAMs();

        motherboardDao = database.motherboardDao();
        allMotherboards = motherboardDao.getAllMotherboards();

        casesDao = database.casesDao();
        allCases = casesDao.getAllCases();

        powerSupplyDao = database.powerSupplyDao();
        allPowerSupplies = powerSupplyDao.getAllPowerSupplies();
    }
//Insert
    public void insertCPU (CPU cpu)
    {
        new InsertCPUAsyncTask(cpuDao).execute(cpu);
    }
    public void insertGPU (GPU gpu)
    {
        new InsertGPUAsyncTask(gpuDao).execute(gpu);
    }
    public void insertRAM (RAM ram)
    {
        new InsertRAMAsyncTask(ramDao).execute(ram);
    }
    public void insertMotherboard (Motherboard motherboard)
    {
        new InsertMotherboardAsyncTask(motherboardDao).execute(motherboard);
    }
    public void insertCases (Cases cases)
    {
        new InsertCasesAsyncTask(casesDao).execute(cases);
    }
    public void insertPowerSupply (PowerSupply powerSupply)
    {
        new InsertPowerSupplyAsyncTask(powerSupplyDao).execute(powerSupply);
    }

//Update

    public void updateCPU (CPU cpu)
    {
        new UpdateCPUAsyncTask(cpuDao).execute(cpu);
    }
    public void updateGPU (GPU gpu)
    {
        new UpdateGPUAsyncTask(gpuDao).execute(gpu);
    }
    public void updateRAM (RAM ram)
    {
        new UpdateRAMAsyncTask(ramDao).execute(ram);
    }
    public void updateMotherboard (Motherboard motherboard)
    {
        new UpdateMotherboardAsyncTask(motherboardDao).execute(motherboard);
    }
    public void updateCases (Cases cases)
    {
        new UpdateCasesAsyncTask(casesDao).execute(cases);
    }
    public void updatePowerSupply (PowerSupply powerSupply)
    {
        new UpdatePowerSupplyAsyncTask(powerSupplyDao).execute(powerSupply);
    }

//Delete

    public void deleteCPU (CPU cpu)
    {
        new DeleteCPUAsyncTask(cpuDao).execute(cpu);
    }
    public void deleteGPU (GPU gpu)
    {
        new DeleteGPUAsyncTask(gpuDao).execute(gpu);
    }
    public void deleteRAM (RAM ram)
    {
        new DeleteRAMAsyncTask(ramDao).execute(ram);
    }
    public void deleteMotherboard (Motherboard motherboard)
    {
        new DeleteMotherboardAsyncTask(motherboardDao).execute(motherboard);
    }
    public void deleteCases (Cases cases)
    {
        new DeleteCasesAsyncTask(casesDao).execute(cases);
    }
    public void deletePowerSupply (PowerSupply powerSupply)
    {
        new DeletePowerSupplyAsyncTask(powerSupplyDao).execute(powerSupply);
    }

//    public void deleteAllComponents(){
//        new DeleteAllCPUAsyncTask(cpuDao).execute();
//    }
    public void deleteAllCPUs(){
        new DeleteAllCPUAsyncTask(cpuDao).execute();
    }
    public void deleteAllGPUs(){
        new DeleteAllGPUAsyncTask(gpuDao).execute();
    }
    public void deleteAllRAMs(){
        new DeleteAllRAMAsyncTask(ramDao).execute();
    }
    public void deleteAllMotherboards(){
        new DeleteAllMotherboardAsyncTask(motherboardDao).execute();
    }
    public void deleteAllCases(){
        new DeleteAllCasesAsyncTask(casesDao).execute();
    }
    public void deleteAllPowerSupplies(){
        new DeleteAllPowerSupplyAsyncTask(powerSupplyDao).execute();
    }

    public LiveData<List<Component>> getAllComponents()
    {
        return allComponents;
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
//
//  CPU
//
    private static class InsertCPUAsyncTask extends AsyncTask<CPU, Void, Void>
    {
        private CPUDao cpuDao;

        private InsertCPUAsyncTask(CPUDao cpuDao)
        {
            this.cpuDao = cpuDao;
        }

        @Override
        protected Void doInBackground(CPU... cpus) {
            cpuDao.insertCPU(cpus[0]);
            return null;
        }
    }
    private static class UpdateCPUAsyncTask extends AsyncTask<CPU, Void, Void>
    {
        private CPUDao cpuDao;

        private UpdateCPUAsyncTask(CPUDao cpuDao)
        {
            this.cpuDao = cpuDao;
        }

        @Override
        protected Void doInBackground(CPU... cpus) {
            cpuDao.updateCPU(cpus[0]);
            return null;
        }
    }
    private static class DeleteCPUAsyncTask extends AsyncTask<CPU, Void, Void>
    {
        private CPUDao cpuDao;

        private DeleteCPUAsyncTask(CPUDao cpuDao)
        {
            this.cpuDao = cpuDao;
        }

        @Override
        protected Void doInBackground(CPU... cpus) {
            cpuDao.deleteCPU(cpus[0]);
            return null;
        }
    }
    private static class DeleteAllCPUAsyncTask extends AsyncTask<Void, Void, Void>
    {
        private CPUDao cpuDao;

        private DeleteAllCPUAsyncTask(CPUDao cpuDao)
        {
            this.cpuDao = cpuDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            cpuDao.deleteAllCPUs();
            return null;
        }
    }
//
//  GPU
//
    private static class InsertGPUAsyncTask extends AsyncTask<GPU, Void, Void>
    {
        private GPUDao gpuDao;

        private InsertGPUAsyncTask(GPUDao gpuDao)
        {
            this.gpuDao = gpuDao;
        }

        @Override
        protected Void doInBackground(GPU... gpus) {
            gpuDao.insertGPU(gpus[0]);
            return null;
        }
    }
    private static class UpdateGPUAsyncTask extends AsyncTask<GPU, Void, Void>
    {
        private GPUDao gpuDao;

        private UpdateGPUAsyncTask(GPUDao gpuDao)
        {
            this.gpuDao = gpuDao;
        }

        @Override
        protected Void doInBackground(GPU... gpus) {
            gpuDao.updateGPU(gpus[0]);
            return null;
        }
    }
    private static class DeleteGPUAsyncTask extends AsyncTask<GPU, Void, Void>
    {
        private GPUDao gpuDao;

        private DeleteGPUAsyncTask(GPUDao gpuDao)
        {
            this.gpuDao = gpuDao;
        }

        @Override
        protected Void doInBackground(GPU... gpus) {
            gpuDao.deleteGPU(gpus[0]);
            return null;
        }
    }
    private static class DeleteAllGPUAsyncTask extends AsyncTask<Void, Void, Void>
    {
        private GPUDao gpuDao;

        private DeleteAllGPUAsyncTask(GPUDao gpuDao)
        {
            this.gpuDao = gpuDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            gpuDao.deleteAllGPUs();
            return null;
        }
    }
//
//  RAM
//
    private static class InsertRAMAsyncTask extends AsyncTask<RAM, Void, Void>
    {
        private RAMDao ramDao;

        private InsertRAMAsyncTask(RAMDao ramDao)
        {
            this.ramDao = ramDao;
        }

        @Override
        protected Void doInBackground(RAM... rams) {
            ramDao.insertRAM(rams[0]);
            return null;
        }
    }
    private static class UpdateRAMAsyncTask extends AsyncTask<RAM, Void, Void>
    {
        private RAMDao ramDao;

        private UpdateRAMAsyncTask(RAMDao ramDao)
        {
            this.ramDao = ramDao;
        }

        @Override
        protected Void doInBackground(RAM... rams) {
            ramDao.updateRAM(rams[0]);
            return null;
        }
    }
    private static class DeleteRAMAsyncTask extends AsyncTask<RAM, Void, Void>
    {
        private RAMDao ramDao;

        private DeleteRAMAsyncTask(RAMDao ramDao)
        {
            this.ramDao = ramDao;
        }

        @Override
        protected Void doInBackground(RAM... rams) {
            ramDao.deleteRAM(rams[0]);
            return null;
        }
    }
    private static class DeleteAllRAMAsyncTask extends AsyncTask<Void, Void, Void>
    {
        private RAMDao ramDao;

        private DeleteAllRAMAsyncTask(RAMDao ramDao)
        {
            this.ramDao = ramDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ramDao.deleteAllRAMs();
            return null;
        }
    }
//
//  Motherboard
//
    private static class InsertMotherboardAsyncTask extends AsyncTask<Motherboard, Void, Void>
    {
        private MotherboardDao motherboardDao;

        private InsertMotherboardAsyncTask(MotherboardDao motherboardDao)
        {
            this.motherboardDao = motherboardDao;
        }

        @Override
        protected Void doInBackground(Motherboard... motherboards) {
            motherboardDao.insertMotherboard(motherboards[0]);
            return null;
        }
    }
    private static class UpdateMotherboardAsyncTask extends AsyncTask<Motherboard, Void, Void>
    {
        private MotherboardDao motherboardDao;

        private UpdateMotherboardAsyncTask(MotherboardDao motherboardDao)
        {
            this.motherboardDao = motherboardDao;
        }

        @Override
        protected Void doInBackground(Motherboard... motherboards) {
            motherboardDao.updateMotherboard(motherboards[0]);
            return null;
        }
    }
    private static class DeleteMotherboardAsyncTask extends AsyncTask<Motherboard, Void, Void>
    {
        private MotherboardDao motherboardDao;

        private DeleteMotherboardAsyncTask(MotherboardDao motherboardDao)
        {
            this.motherboardDao = motherboardDao;
        }

        @Override
        protected Void doInBackground(Motherboard... motherboards) {
            motherboardDao.deleteMotherboard(motherboards[0]);
            return null;
        }
    }
    private static class DeleteAllMotherboardAsyncTask extends AsyncTask<Void, Void, Void>
    {
        private MotherboardDao motherboardDao;

        private DeleteAllMotherboardAsyncTask(MotherboardDao motherboardDao)
        {
            this.motherboardDao = motherboardDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            motherboardDao.deleteAllMotherboards();
            return null;
        }
    }
//
//  Cases
//
    private static class InsertCasesAsyncTask extends AsyncTask<Cases, Void, Void>
    {
        private CasesDao casesDao;

        private InsertCasesAsyncTask(CasesDao casesDao)
        {
            this.casesDao = casesDao;
        }

        @Override
        protected Void doInBackground(Cases... casess) {
            casesDao.insertCases(casess[0]);
            return null;
        }
    }
    private static class UpdateCasesAsyncTask extends AsyncTask<Cases, Void, Void>
    {
        private CasesDao casesDao;

        private UpdateCasesAsyncTask(CasesDao casesDao)
        {
            this.casesDao = casesDao;
        }

        @Override
        protected Void doInBackground(Cases... casess) {
            casesDao.updateCases(casess[0]);
            return null;
        }
    }
    private static class DeleteCasesAsyncTask extends AsyncTask<Cases, Void, Void>
    {
        private CasesDao casesDao;

        private DeleteCasesAsyncTask(CasesDao casesDao)
        {
            this.casesDao = casesDao;
        }

        @Override
        protected Void doInBackground(Cases... casess) {
            casesDao.deleteCases(casess[0]);
            return null;
        }
    }
    private static class DeleteAllCasesAsyncTask extends AsyncTask<Void, Void, Void>
    {
        private CasesDao casesDao;

        private DeleteAllCasesAsyncTask(CasesDao casesDao)
        {
            this.casesDao = casesDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            casesDao.deleteAllCases();
            return null;
        }
    }
//
//  PowerSupply
//
    private static class InsertPowerSupplyAsyncTask extends AsyncTask<PowerSupply, Void, Void>
    {
        private PowerSupplyDao powerSupplyDao;

        private InsertPowerSupplyAsyncTask(PowerSupplyDao powerSupplyDao)
        {
            this.powerSupplyDao = powerSupplyDao;
        }

        @Override
        protected Void doInBackground(PowerSupply... powerSupplies) {
            powerSupplyDao.insertPowerSupply(powerSupplies[0]);
            return null;
        }
    }
    private static class UpdatePowerSupplyAsyncTask extends AsyncTask<PowerSupply, Void, Void>
    {
        private PowerSupplyDao powerSupplyDao;

        private UpdatePowerSupplyAsyncTask(PowerSupplyDao powerSupplyDao)
        {
            this.powerSupplyDao = powerSupplyDao;
        }

        @Override
        protected Void doInBackground(PowerSupply... powerSupplies) {
            powerSupplyDao.updatePowerSupply(powerSupplies[0]);
            return null;
        }
    }
    private static class DeletePowerSupplyAsyncTask extends AsyncTask<PowerSupply, Void, Void>
    {
        private PowerSupplyDao powerSupplyDao;

        private DeletePowerSupplyAsyncTask(PowerSupplyDao powerSupplyDao)
        {
            this.powerSupplyDao = powerSupplyDao;
        }

        @Override
        protected Void doInBackground(PowerSupply... powerSupplies) {
            powerSupplyDao.deletePowerSupply(powerSupplies[0]);
            return null;
        }
    }
    private static class DeleteAllPowerSupplyAsyncTask extends AsyncTask<Void, Void, Void>
    {
        private PowerSupplyDao powerSupplyDao;

        private DeleteAllPowerSupplyAsyncTask(PowerSupplyDao powerSupplyDao)
        {
            this.powerSupplyDao = powerSupplyDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            powerSupplyDao.deleteAllPowerSupplies();
            return null;
        }
    }

}

