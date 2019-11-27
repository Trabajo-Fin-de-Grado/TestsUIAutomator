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
public class TestClock {

    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String BASIC_SAMPLE_PACKAGE = "Clock";
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

    // UiObject sunday = mDevice.findObject(new UiSelector().description("Sunday"));

    // UiObject monday = mDevice.findObject(new UiSelector().description("Monday"));

    // UiObject tuesday = mDevice.findObject(new UiSelector().description("Tuesday"));

    // UiObject wednesday = mDevice.findObject(new UiSelector().description("Wednesday"));

    // UiObject thursday = mDevice.findObject(new UiSelector().description("Thursday"));

    // UiObject friday = mDevice.findObject(new UiSelector().description("Friday"));

    // UiObject saturday = mDevice.findObject(new UiSelector().description("Saturday"));

    @Test
    public void testAlarm() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Clock"));
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().description("Alarm"));
        button.clickAndWaitForNewWindow();

        UiObject expansion = mDevice.findObject(new UiSelector().resourceId("com.google.android.deskclock:id/arrow"));
        expansion.click();

        UiObject ringtone = mDevice.findObject(new UiSelector().resourceId("com.google.android.deskclock:id/choose_ringtone"));
        ringtone.click();

        UiScrollable ringtoneViews = new UiScrollable(new UiSelector().scrollable(true));
        ringtoneViews.scrollIntoView(new UiSelector().text("Krypton"));

        UiObject tone = mDevice.findObject(new UiSelector().text("Krypton"));
        tone.clickAndWaitForNewWindow();

        UiObject select = mDevice.findObject(new UiSelector().resourceId("android:id/button1"));
        select.clickAndWaitForNewWindow();

        UiObject label = mDevice.findObject(new UiSelector().resourceId("com.google.android.deskclock:id/edit_label"));
        label.clickAndWaitForNewWindow();

        UiObject text = mDevice.findObject(new UiSelector().className("android.widget.EditText"));
        text.setText("UI Automator");
        select.clickAndWaitForNewWindow();

        UiObject checkBox = mDevice.findObject(new UiSelector().resourceId("com.google.android.deskclock:id/repeat_onoff"));
        if(!checkBox.isSelected()) checkBox.click();

    }

    @Test
    public void testOtherAlarm() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Clock"));
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().description("Alarm"));
        button.clickAndWaitForNewWindow();

        UiObject expansion = mDevice.findObject(new UiSelector().resourceId("com.google.android.deskclock:id/arrow"));
        expansion.click();

        UiObject sunday = mDevice.findObject(new UiSelector().description("Sunday"));
        sunday.click();

        UiObject monday = mDevice.findObject(new UiSelector().description("Monday"));
        monday.click();

        UiObject tuesday = mDevice.findObject(new UiSelector().description("Tuesday"));
        tuesday.click();

        UiObject wednesday = mDevice.findObject(new UiSelector().description("Wednesday"));
        wednesday.click();

        UiObject thursday = mDevice.findObject(new UiSelector().description("Thursday"));
        thursday.click();

        UiObject friday = mDevice.findObject(new UiSelector().description("Friday"));
        friday.click();

        UiObject saturday = mDevice.findObject(new UiSelector().description("Saturday"));
        saturday.click();

        expansion.click();

        UiObject checkBox = mDevice.findObject(new UiSelector().resourceId("com.google.android.deskclock:id/onoff"));
        if(!checkBox.isSelected()) checkBox.click();
    }


    @Test
    public void testTimer() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Clock"));
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().description("Timer"));
        button.clickAndWaitForNewWindow();

        UiObject number0 = mDevice.findObject(new UiSelector().text("0"));
        UiObject number1 = mDevice.findObject(new UiSelector().text("1"));
        UiObject number2 = mDevice.findObject(new UiSelector().text("2"));
        UiObject number3 = mDevice.findObject(new UiSelector().text("3"));
        UiObject number4 = mDevice.findObject(new UiSelector().text("4"));
        UiObject number5 = mDevice.findObject(new UiSelector().text("5"));
        UiObject number6 = mDevice.findObject(new UiSelector().text("6"));
        UiObject number7 = mDevice.findObject(new UiSelector().text("7"));
        UiObject number8 = mDevice.findObject(new UiSelector().text("8"));
        UiObject number9 = mDevice.findObject(new UiSelector().text("9"));

        number3.click();
        number7.click();

        number2.click();
        number8.click();

        number6.click();
        number1.click();

        UiObject play = mDevice.findObject(new UiSelector().resourceId("com.google.android.deskclock:id/fab"));
        play.click();
        play.waitUntilGone(20000);
        play.click();

        UiObject stop = mDevice.findObject(new UiSelector().resourceId("com.google.android.deskclock:id/left_button"));
        stop.click();

    }

    @Test
    public void testStopwatch() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Clock"));
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().description("Stopwatch"));
        button.clickAndWaitForNewWindow();

        UiObject play = mDevice.findObject(new UiSelector().resourceId("com.google.android.deskclock:id/fab"));
        play.click();

        play.waitUntilGone(20000);

        play.click();

        UiObject stop = mDevice.findObject(new UiSelector().resourceId("com.google.android.deskclock:id/left_button"));
        stop.click();
    }

}