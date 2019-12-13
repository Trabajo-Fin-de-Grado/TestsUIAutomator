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
public class TestMessage {

    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String BASIC_SAMPLE_PACKAGE = "Messages";
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
    public void testSendMessage() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        // appViews.scrollIntoView(new UiSelector().text("Messenger")); // API 25
        appViews.scrollIntoView(new UiSelector().text("Messages"));     // API 28

        // UiObject testingApp = mDevice.findObject(new UiSelector().text("Messenger")); // API 25
        UiObject testingApp = mDevice.findObject(new UiSelector().text("Messages"));     // API 28
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().resourceId("com.google.android.apps.messaging:id/start_new_conversation_button"));
        button.click();

        UiObject number = mDevice.findObject(new UiSelector().text("654123987"));
        number.click();

        UiObject message = mDevice.findObject(new UiSelector().resourceId("com.google.android.apps.messaging:id/compose_message_text"));
        message.setText("UI Automator");

        UiObject enviar = mDevice.findObject(new UiSelector().resourceId("com.google.android.apps.messaging:id/self_send_icon"));
        enviar.clickAndWaitForNewWindow();

    }

    @Test
    public void testSendIcon() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        // appViews.scrollIntoView(new UiSelector().text("Messenger")); // API 25
        appViews.scrollIntoView(new UiSelector().text("Messages"));     // API 28

        // UiObject testingApp = mDevice.findObject(new UiSelector().text("Messenger")); // API 25
        UiObject testingApp = mDevice.findObject(new UiSelector().text("Messages"));     // API 28
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().resourceId("com.google.android.apps.messaging:id/start_new_conversation_button"));
        button.click();

        UiObject number = mDevice.findObject(new UiSelector().text("654123987"));
        number.click();

        UiObject icon = mDevice.findObject(new UiSelector().resourceId("com.google.android.apps.messaging:id/emoji_keyboard_button"));
        icon.click();

        UiObject emoji = mDevice.findObject(new UiSelector().className("android.widget.ImageView").index(12));
        emoji.click();

        UiObject enviar = mDevice.findObject(new UiSelector().resourceId("com.google.android.apps.messaging:id/self_send_icon"));
        enviar.clickAndWaitForNewWindow();

    }

    @Test
    public void testDeleteMessage() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        // appViews.scrollIntoView(new UiSelector().text("Messenger")); // API 25
        appViews.scrollIntoView(new UiSelector().text("Messages"));     // API 28

        // UiObject testingApp = mDevice.findObject(new UiSelector().text("Messenger")); // API 25
        UiObject testingApp = mDevice.findObject(new UiSelector().text("Messages"));     // API 28
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().text("Gonzalo Aguilar Hermoso"));
        button.click();

        UiObject options = mDevice.findObject(new UiSelector().description("More options"));
        options.click();

        UiObject delete = mDevice.findObject(new UiSelector().text("Delete"));
        delete.click();

        UiObject send = mDevice.findObject(new UiSelector().resourceId("android:id/button1"));
        send.clickAndWaitForNewWindow();
    }

}
