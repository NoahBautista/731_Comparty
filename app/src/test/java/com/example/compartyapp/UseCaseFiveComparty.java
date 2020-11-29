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
public class UseCaseFiveComparty
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
    public void useCaseFive()
    {
        //Click “View Link of CPU” button from the View More Information page
        ViewCPU activity = Robolectric.setupActivity(ViewCPU.class);
        activity.findViewById(R.id.cpuWebview).performClick();
        Intent expectedIntent = new Intent(activity, CPUWebView.class);
        Intent actual = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent.getComponent(), actual.getComponent());
        Assert.assertEquals("https://www.amazon.ca/1", cpu.getLink());

        //Click “View Link of GPU” button from the View More Information page
        ViewGPU activity1 = Robolectric.setupActivity(ViewGPU.class);
        activity1.findViewById(R.id.gpuWebview).performClick();
        Intent expectedIntent1 = new Intent(activity1, GPUWebView.class);
        Intent actual1 = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent1.getComponent(), actual1.getComponent());
        Assert.assertEquals("https://www.amazon.ca/2", gpu.getLink());

        //Click “View Link of RAM” button from the View More Information page
        ViewRAM activity2 = Robolectric.setupActivity(ViewRAM.class);
        activity2.findViewById(R.id.ramWebview).performClick();
        Intent expectedIntent2 = new Intent(activity2, RAMWebView.class);
        Intent actual2 = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent2.getComponent(), actual2.getComponent());
        Assert.assertEquals("https://www.amazon.ca/3", ram.getLink());

        //Click “View Link of Motherboard” button from the View More Information page
        ViewMotherboard activity3 = Robolectric.setupActivity(ViewMotherboard.class);
        activity3.findViewById(R.id.motherboardWebview).performClick();
        Intent expectedIntent3 = new Intent(activity3, MotherboardWebView.class);
        Intent actual3 = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent3.getComponent(), actual3.getComponent());
        Assert.assertEquals("https://www.amazon.ca/4", motherboard.getLink());

        //Click “View Link of Case” button from the View More Information page
        ViewCases activity4 = Robolectric.setupActivity(ViewCases.class);
        activity4.findViewById(R.id.casesWebview).performClick();
        Intent expectedIntent4 = new Intent(activity4, CasesWebView.class);
        Intent actual4 = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent4.getComponent(), actual4.getComponent());
        Assert.assertEquals("https://www.amazon.ca/5", cases.getLink());

        //Click “View Link of Power Supply” button from the View More Information page
        ViewPowerSupply activity5 = Robolectric.setupActivity(ViewPowerSupply.class);
        activity5.findViewById(R.id.powerSupplyWebview).performClick();
        Intent expectedIntent5 = new Intent(activity5, PowerSupplyWebView.class);
        Intent actual5 = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent5.getComponent(), actual5.getComponent());
        Assert.assertEquals("https://www.amazon.ca/6", powerSupply.getLink());
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
