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
public class TestYoutube {

    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String BASIC_SAMPLE_PACKAGE = "YouTube";
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

    @Test
    public void testSearchVideo() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("YouTube"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("YouTube"));
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().description("Search"));
        button.click();

        UiObject text = mDevice.findObject(new UiSelector().resourceId("com.google.android.youtube:id/search_edit_text"));
        text.setText("UI Automator");

        UiObject option = mDevice.findObject(new UiSelector().resourceId("com.google.android.youtube:id/text").index(1));
        option.click();

        UiObject select = mDevice.findObject(new UiSelector().className("android.view.ViewGroup").index(3));
        select.click();

    }

    @Test
    public void testPlayVideo() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("YouTube"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("YouTube"));
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().className("android.widget.Button").index(1));
        button.click();

        UiObject option = mDevice.findObject(new UiSelector().className("android.view.ViewGroup").index(0));
        option.click();

    }

    @Test
    public void testStopVideo() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("YouTube"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("YouTube"));
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().className("android.widget.Button").index(1));
        button.click();

        UiObject play = mDevice.findObject(new UiSelector().className("android.view.ViewGroup").index(0));
        play.click();

        play.waitUntilGone(20000);

        UiObject option = mDevice.findObject(new UiSelector().resourceId("com.google.android.youtube:id/player_view"));
        option.click();

        UiObject stop = mDevice.findObject(new UiSelector().resourceId("com.google.android.youtube:id/player_control_play_pause_replay_button"));
        stop.click();

    }

    @Test
    public void testChangeQuality() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("YouTube"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("YouTube"));
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().className("android.widget.Button").index(1));
        button.click();

        UiObject play = mDevice.findObject(new UiSelector().className("android.view.ViewGroup").index(0));
        play.click();

        play.waitUntilGone(20000);

        UiObject option = mDevice.findObject(new UiSelector().resourceId("com.google.android.youtube:id/player_view"));
        option.click();

        UiObject select = mDevice.findObject(new UiSelector().resourceId("com.google.android.youtube:id/player_overflow_button"));
        select.click();

        UiObject quality = mDevice.findObject(new UiSelector().className("android.widget.RelativeLayout").index(2));
        quality.click();

        UiObject level = mDevice.findObject(new UiSelector().className("android.widget.RelativeLayout").index(7));
        level.click();

    }

    @Test
    public void testChangeVelocity() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("YouTube"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("YouTube"));
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().className("android.widget.Button").index(1));
        button.click();

        UiObject play = mDevice.findObject(new UiSelector().className("android.view.ViewGroup").index(0));
        play.click();

        play.waitUntilGone(20000);

        UiObject option = mDevice.findObject(new UiSelector().resourceId("com.google.android.youtube:id/player_view"));
        option.click();

        UiObject select = mDevice.findObject(new UiSelector().resourceId("com.google.android.youtube:id/player_overflow_button"));
        select.click();

        UiObject velocity = mDevice.findObject(new UiSelector().className("android.widget.RelativeLayout").index(4));
        velocity.click();

        UiObject level = mDevice.findObject(new UiSelector().className("android.widget.RelativeLayout").index(8));
        level.click();

    }

    @Test
    public void testShareVideo() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("YouTube"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("YouTube"));
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().className("android.widget.Button").index(1));
        button.click();

        UiObject play = mDevice.findObject(new UiSelector().className("android.view.ViewGroup").index(0));
        play.click();

        play.waitUntilGone(30000);

        UiObject option = mDevice.findObject(new UiSelector().resourceId("com.google.android.youtube:id/player_view"));
        option.click();

        UiObject share = mDevice.findObject(new UiSelector().resourceId("com.google.android.youtube:id/player_share_button"));
        share.click();

        UiObject messages = mDevice.findObject(new UiSelector().text("Messages"));
        messages.click();

        UiObject contact = mDevice.findObject(new UiSelector().resourceId("com.google.android.apps.messaging:id/details_container").index(1));
        contact.click();

        UiObject enviar = mDevice.findObject(new UiSelector().resourceId("com.google.android.apps.messaging:id/send_message_button_icon"));
        enviar.click();

    }

}
