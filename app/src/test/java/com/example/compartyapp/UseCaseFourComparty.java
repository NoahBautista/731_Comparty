package com.example.compartyapp;

import android.content.Intent;
import android.os.Build;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;

@Config(sdk = Build.VERSION_CODES.O_MR1)
@RunWith(RobolectricTestRunner.class)
public class UseCaseFourComparty
{
    CPU cpu;
    GPU gpu;
    RAM ram;
    Motherboard motherboard;
    Cases cases;
    PowerSupply powerSupply;

    @Before
    public void setUp()
    {
        cpu = new CPU(R.drawable.intelcorei79700k,"Intel Core i7 9700k","Intel Description","Intel","https://www.amazon.ca/1",455.99,"cpu",8,8,"3.60GHz","4.90GHz");
        gpu = new GPU(R.drawable.gigabytegeforcegt1030,"Gigabyte GeForce GT 1030", "SMOOTH AND CRISP VISUAL", "GIGABYTE","https://www.amazon.ca/2",119.99,"gpu",384,2,"1252MHz","1506MHz","PCIE-3.0");
        ram = new RAM(R.drawable.xpg,"XPG Z1 DDR4 3200MHz (PC4 25600) 16GB (2x8GB) 288-Pin CL-16-20-20", "Legendary XPG Z1 Memory Designed for high-performance task needs, XPG Z1 memory modules feature superior thermodynamic-efficient design that consumes 20% less power than previous version memory even when running at up to 4266 MHz speed.", "XPG", "https://www.amazon.ca/3", 79.99, "ram","3200MHz","DDR4","16",2);
        motherboard = new Motherboard(R.drawable.msiperformancegamingx470,"MSI Performance Gaming AMD X470 Ryzen 2ND and 3rd Gen AM4 DDR4 DVI HDMI Onboard Graphics CFX ATX Motherboard","Unlimited customization options and packed with exclusive gaming features, MSI performance gaming motherboards offer the best possible gaming experience.","MSI","https://www.amazon.ca/4",175.64,"motherboard","ATX","AMD Ryzen Gen 3.0","DDR4","PCIE-3.0");
        cases = new Cases(R.drawable.deepcoolmatrexx55,"DEEPCOOL MATREXX 55 V3 ADD-RGB 3F Case", "A compact ATX computer case supports motherboards up to E-ATX.", "DEEPCOOL","https://www.amazon.ca/5", 104.99,"cases","E-ATX");
        powerSupply = new PowerSupply(R.drawable.corsaircp9020,"Corsair CP-9020195-NA RM Series RM750 80 Plus Gold Fully Modular ATX Power Supply", "Corsair RM series power supplies are built with the highest quality components to deliver 80 Plus Gold efficient power to your PC.","Corsair","https://www.amazon.ca/6",154.99,"powerSupply","Fully Modular","750W","80 Plus Gold");
    }

    @Test
    public void useCaseFour()
    {
        //Click CPU Item from CPU Category from the HomePage
        CPUView activity = Robolectric.setupActivity(CPUView.class);
        activity.findViewById(R.id.cardView).performClick();
        Intent expectedIntent = new Intent(activity, ViewCPU.class);
        Intent actual = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent.getComponent(), actual.getComponent());
        //CPU cpu = new CPU(R.drawable.intelcorei79700k,"Intel Core i7 9700k","Intel Description","Intel","https://amazon.ca",455.99,"cpu",8,8,"3.60GHz","4.90GHz");
        Assert.assertEquals(R.drawable.intelcorei79700k, cpu.getImage());
        Assert.assertEquals("Intel Core i7 9700k", cpu.getName());
        Assert.assertEquals("Intel Description", cpu.getDescription());
        Assert.assertEquals("Intel", cpu.getManufacturer());
        Assert.assertEquals("https://www.amazon.ca/1", cpu.getLink());
        Assert.assertEquals(455.99, cpu.getPrice(),.00d);
        Assert.assertEquals("cpu", cpu.getProductType());
        Assert.assertEquals(8, cpu.getNumberOfCores());
        Assert.assertEquals(8, cpu.getNumberOfThreads());
        Assert.assertEquals("3.60GHz", cpu.getBaseClock());
        Assert.assertEquals("4.90GHz", cpu.getBoostClock());


        //Click GPU Item from GPU Category from the HomePage
        GPUView activity1 = Robolectric.setupActivity(GPUView.class);
        activity1.findViewById(R.id.cardView).performClick();
        Intent expectedIntent1 = new Intent(activity1, ViewGPU.class);
        Intent actual1 = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent1.getComponent(), actual1.getComponent());
        Assert.assertEquals(R.drawable.gigabytegeforcegt1030, gpu.getImage());
        Assert.assertEquals("Gigabyte GeForce GT 1030", gpu.getName());
        Assert.assertEquals("SMOOTH AND CRISP VISUAL", gpu.getDescription());
        Assert.assertEquals("GIGABYTE", gpu.getManufacturer());
        Assert.assertEquals("https://www.amazon.ca/2", gpu.getLink());
        Assert.assertEquals(119.99, gpu.getPrice(),.00d);
        Assert.assertEquals("gpu", gpu.getProductType());
        Assert.assertEquals(384, gpu.getCores());
        Assert.assertEquals(2, gpu.getVram());
        Assert.assertEquals("1252MHz", gpu.getGpuBaseClock());
        Assert.assertEquals("1506MHz", gpu.getGpuBoostClock());

        //Click RAM Item from RAM Category from the HomePage
        RamView activity2 = Robolectric.setupActivity(RamView.class);
        activity2.findViewById(R.id.cardView).performClick();
        Intent expectedIntent2 = new Intent(activity2, ViewRAM.class);
        Intent actual2 = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent2.getComponent(), actual2.getComponent());
        Assert.assertEquals(R.drawable.xpg, ram.getImage());
        Assert.assertEquals("XPG Z1 DDR4 3200MHz (PC4 25600) 16GB (2x8GB) 288-Pin CL-16-20-20", ram.getName());
        Assert.assertEquals("Legendary XPG Z1 Memory Designed for high-performance task needs, XPG Z1 memory modules feature superior thermodynamic-efficient design that consumes 20% less power than previous version memory even when running at up to 4266 MHz speed.", ram.getDescription());
        Assert.assertEquals("XPG", ram.getManufacturer());
        Assert.assertEquals("https://www.amazon.ca/3", ram.getLink());
        Assert.assertEquals(79.99, ram.getPrice(),.00d);
        Assert.assertEquals("ram", ram.getProductType());
        Assert.assertEquals("16", ram.getCapacity());
        Assert.assertEquals(2, ram.getNumberOfSticks());
        Assert.assertEquals("DDR4", ram.getMemoryType());
        Assert.assertEquals("3200MHz", ram.getFrequency());

        //Click Motherboard Item from Motherboard Category from the HomePage
        MotherboardView activity3 = Robolectric.setupActivity(MotherboardView.class);
        activity3.findViewById(R.id.cardView).performClick();
        Intent expectedIntent3 = new Intent(activity3, ViewMotherboard.class);
        Intent actual3 = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent3.getComponent(), actual3.getComponent());
        Assert.assertEquals(R.drawable.msiperformancegamingx470, motherboard.getImage());
        Assert.assertEquals("MSI Performance Gaming AMD X470 Ryzen 2ND and 3rd Gen AM4 DDR4 DVI HDMI Onboard Graphics CFX ATX Motherboard", motherboard.getName());
        Assert.assertEquals("Unlimited customization options and packed with exclusive gaming features, MSI performance gaming motherboards offer the best possible gaming experience.", motherboard.getDescription());
        Assert.assertEquals("MSI", motherboard.getManufacturer());
        Assert.assertEquals("https://www.amazon.ca/4", motherboard.getLink());
        Assert.assertEquals(175.64, motherboard.getPrice(),.00d);
        Assert.assertEquals("motherboard", motherboard.getProductType());
        Assert.assertEquals("ATX", motherboard.getSize());
        Assert.assertEquals("AMD Ryzen Gen 3.0", motherboard.getSocket());
        Assert.assertEquals("DDR4", motherboard.getRamSupport());
        Assert.assertEquals("PCIE-3.0", motherboard.getPcieSupport());

        //Click Case Item from Cases Category from the HomePage
        CasesView activity4 = Robolectric.setupActivity(CasesView.class);
        activity4.findViewById(R.id.cardView).performClick();
        Intent expectedIntent4 = new Intent(activity4, ViewCases.class);
        Intent actual4 = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent4.getComponent(), actual4.getComponent());
        Assert.assertEquals(R.drawable.deepcoolmatrexx55, cases.getImage());
        Assert.assertEquals("DEEPCOOL MATREXX 55 V3 ADD-RGB 3F Case", cases.getName());
        Assert.assertEquals("A compact ATX computer case supports motherboards up to E-ATX.", cases.getDescription());
        Assert.assertEquals("DEEPCOOL", cases.getManufacturer());
        Assert.assertEquals("https://www.amazon.ca/5", cases.getLink());
        Assert.assertEquals(104.99, cases.getPrice(),.00d);
        Assert.assertEquals("cases", cases.getProductType());
        Assert.assertEquals("E-ATX", cases.getSizeSupport());

        //Click Power Supply Item from Power Supply Category from the HomePage
        PowerSupplyView activity5 = Robolectric.setupActivity(PowerSupplyView.class);
        activity5.findViewById(R.id.cardView).performClick();
        Intent expectedIntent5 = new Intent(activity5, ViewPowerSupply.class);
        Intent actual5 = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent5.getComponent(), actual5.getComponent());
        Assert.assertEquals(R.drawable.corsaircp9020, powerSupply.getImage());
        Assert.assertEquals("Corsair CP-9020195-NA RM Series RM750 80 Plus Gold Fully Modular ATX Power Supply", powerSupply.getName());
        Assert.assertEquals("Corsair RM series power supplies are built with the highest quality components to deliver 80 Plus Gold efficient power to your PC.", powerSupply.getDescription());
        Assert.assertEquals("Corsair", powerSupply.getManufacturer());
        Assert.assertEquals("https://www.amazon.ca/6", powerSupply.getLink());
        Assert.assertEquals(154.99, powerSupply.getPrice(),.00d);
        Assert.assertEquals("powerSupply", powerSupply.getProductType());
        Assert.assertEquals("750W", powerSupply.getCapacity());
        Assert.assertEquals("80 Plus Gold", powerSupply.getRating());
        Assert.assertEquals("Fully Modular", powerSupply.getType());
    }

    @After
    public void tearDown()
    {
        cpu = null;
        gpu = null;
        ram = null;
        motherboard = null;
        cases = null;
        powerSupply = null;
    }
}
