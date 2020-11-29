package com.example.compartyapp;

import android.content.Intent;
import android.os.Build;
import org.junit.Assert;
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
    @Test
    public void useCaseFour()
    {
        //Click CPU Item from CPU Category from the HomePage
        CPUView activity = Robolectric.setupActivity(CPUView.class);
        activity.findViewById(R.id.cardView).performClick();
        Intent expectedIntent = new Intent(activity, ViewCPU.class);
        Intent actual = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent.getComponent(), actual.getComponent());

        //Click GPU Item from GPU Category from the HomePage
        GPUView activity1 = Robolectric.setupActivity(GPUView.class);
        activity1.findViewById(R.id.cardView).performClick();
        Intent expectedIntent1 = new Intent(activity1, ViewGPU.class);
        Intent actual1 = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent1.getComponent(), actual1.getComponent());

        //Click RAM Item from RAM Category from the HomePage
        RamView activity2 = Robolectric.setupActivity(RamView.class);
        activity2.findViewById(R.id.cardView).performClick();
        Intent expectedIntent2 = new Intent(activity2, ViewRAM.class);
        Intent actual2 = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent2.getComponent(), actual2.getComponent());

        //Click Motherboard Item from Motherboard Category from the HomePage
        MotherboardView activity3 = Robolectric.setupActivity(MotherboardView.class);
        activity3.findViewById(R.id.cardView).performClick();
        Intent expectedIntent3 = new Intent(activity3, ViewMotherboard.class);
        Intent actual3 = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent3.getComponent(), actual3.getComponent());

        //Click Case Item from Cases Category from the HomePage
        CasesView activity4 = Robolectric.setupActivity(CasesView.class);
        activity4.findViewById(R.id.cardView).performClick();
        Intent expectedIntent4 = new Intent(activity4, ViewCases.class);
        Intent actual4 = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent4.getComponent(), actual4.getComponent());

        //Click Power Supply Item from Power Supply Category from the HomePage
        PowerSupplyView activity5 = Robolectric.setupActivity(PowerSupplyView.class);
        activity5.findViewById(R.id.cardView).performClick();
        Intent expectedIntent5 = new Intent(activity5, ViewPowerSupply.class);
        Intent actual5 = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent5.getComponent(), actual5.getComponent());
    }

//    @Test
//    public void clickingGPUItem()
//    {
//        GPUView activity = Robolectric.setupActivity(GPUView.class);
//        activity.findViewById(R.id.cardView).performClick();
//
//        Intent expectedIntent = new Intent(activity, ViewGPU.class);
//        Intent actual = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
//        Assert.assertEquals(expectedIntent.getComponent(), actual.getComponent());
//    }
//
//    @Test
//    public void clickingRAMItem()
//    {
//        RamView activity = Robolectric.setupActivity(RamView.class);
//        activity.findViewById(R.id.cardView).performClick();
//
//        Intent expectedIntent = new Intent(activity, ViewRAM.class);
//        Intent actual = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
//        Assert.assertEquals(expectedIntent.getComponent(), actual.getComponent());
//    }
//
//    @Test
//    public void clickingMotherboardItem()
//    {
//        MotherboardView activity = Robolectric.setupActivity(MotherboardView.class);
//        activity.findViewById(R.id.cardView).performClick();
//
//        Intent expectedIntent = new Intent(activity, ViewMotherboard.class);
//        Intent actual = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
//        Assert.assertEquals(expectedIntent.getComponent(), actual.getComponent());
//    }
//
//    @Test
//    public void clickingCasesItem()
//    {
//        CasesView activity = Robolectric.setupActivity(CasesView.class);
//        activity.findViewById(R.id.cardView).performClick();
//
//        Intent expectedIntent = new Intent(activity, ViewCases.class);
//        Intent actual = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
//        Assert.assertEquals(expectedIntent.getComponent(), actual.getComponent());
//    }
//
//    @Test
//    public void clickingPowerSupplyItem()
//    {
//        PowerSupplyView activity = Robolectric.setupActivity(PowerSupplyView.class);
//        activity.findViewById(R.id.cardView).performClick();
//
//        Intent expectedIntent = new Intent(activity, ViewPowerSupply.class);
//        Intent actual = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
//        Assert.assertEquals(expectedIntent.getComponent(), actual.getComponent());
//    }
}
