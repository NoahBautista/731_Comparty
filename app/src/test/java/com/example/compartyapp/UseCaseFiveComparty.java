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
public class UseCaseFiveComparty
{
    @Test
    public void useCaseFive()
    {
        //Click “View Link of CPU” button from the View More Information page
        ViewCPU activity = Robolectric.setupActivity(ViewCPU.class);
        activity.findViewById(R.id.cpuWebview).performClick();
        Intent expectedIntent = new Intent(activity, CPUWebView.class);
        Intent actual = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent.getComponent(), actual.getComponent());

        //Click “View Link of GPU” button from the View More Information page
        ViewGPU activity1 = Robolectric.setupActivity(ViewGPU.class);
        activity1.findViewById(R.id.gpuWebview).performClick();
        Intent expectedIntent1 = new Intent(activity1, GPUWebView.class);
        Intent actual1 = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent1.getComponent(), actual1.getComponent());

        //Click “View Link of RAM” button from the View More Information page
        ViewRAM activity2 = Robolectric.setupActivity(ViewRAM.class);
        activity2.findViewById(R.id.ramWebview).performClick();
        Intent expectedIntent2 = new Intent(activity2, RAMWebView.class);
        Intent actual2 = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent2.getComponent(), actual2.getComponent());

        //Click “View Link of Motherboard” button from the View More Information page
        ViewMotherboard activity3 = Robolectric.setupActivity(ViewMotherboard.class);
        activity3.findViewById(R.id.motherboardWebview).performClick();
        Intent expectedIntent3 = new Intent(activity3, MotherboardWebView.class);
        Intent actual3 = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent3.getComponent(), actual3.getComponent());

        //Click “View Link of Case” button from the View More Information page
        ViewCases activity4 = Robolectric.setupActivity(ViewCases.class);
        activity4.findViewById(R.id.casesWebview).performClick();
        Intent expectedIntent4 = new Intent(activity4, CasesWebView.class);
        Intent actual4 = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent4.getComponent(), actual4.getComponent());

        //Click “View Link of Power Supply” button from the View More Information page
        ViewPowerSupply activity5 = Robolectric.setupActivity(ViewPowerSupply.class);
        activity5.findViewById(R.id.powerSupplyWebview).performClick();
        Intent expectedIntent5 = new Intent(activity5, PowerSupplyWebView.class);
        Intent actual5 = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        Assert.assertEquals(expectedIntent5.getComponent(), actual5.getComponent());
    }
}
