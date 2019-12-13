package com.example.testingandroid;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class TestPhone {

    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String BASIC_SAMPLE_PACKAGE = "Phone";
    private UiDevice mDevice;

    @Before
    public void startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        // Wait for launcher
        final String launcherPackage = mDevice.getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)), LAUNCH_TIMEOUT);
    }

    @Test
    public void checkPreconditions() {
        assertThat(mDevice, notNullValue());
    }

    // UiObject numero0 = mDevice.findObject(new UiSelector().text("0"));
    // UiObject numero1 = mDevice.findObject(new UiSelector().text("1"));
    // UiObject numero2 = mDevice.findObject(new UiSelector().text("2"));
    // UiObject numero3 = mDevice.findObject(new UiSelector().text("3"));
    // UiObject numero4 = mDevice.findObject(new UiSelector().text("4"));
    // UiObject numero5 = mDevice.findObject(new UiSelector().text("5"));
    // UiObject numero6 = mDevice.findObject(new UiSelector().text("6"));
    // UiObject numero7 = mDevice.findObject(new UiSelector().text("7"));
    // UiObject numero8 = mDevice.findObject(new UiSelector().text("8"));
    // UiObject numero9 = mDevice.findObject(new UiSelector().text("9"));

    @Test
    public void testCallPhone() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("Phone"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Phone"));
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().description("key pad"));
        button.click();


        UiObject numero2 = mDevice.findObject(new UiSelector().text("2"));
        UiObject numero3 = mDevice.findObject(new UiSelector().text("3"));
        UiObject numero5 = mDevice.findObject(new UiSelector().text("5"));
        UiObject numero6 = mDevice.findObject(new UiSelector().text("6"));
        UiObject numero9 = mDevice.findObject(new UiSelector().text("9"));

        numero6.click();
        numero9.click();
        numero2.click();

        numero5.click();
        numero2.click();

        numero5.click();
        numero3.click();

        numero5.click();
        numero5.click();

        UiObject call = mDevice.findObject(new UiSelector().description("dial"));
        call.clickAndWaitForNewWindow();

        call.waitUntilGone(2000);

        UiObject end = mDevice.findObject(new UiSelector().description("End call"));
        end.clickAndWaitForNewWindow();

    }

}