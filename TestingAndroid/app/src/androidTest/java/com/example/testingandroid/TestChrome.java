package com.example.testingandroid;

import android.content.Context;
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class TestChrome {

    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String BASIC_SAMPLE_PACKAGE = "Chrome";
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
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = getInstrumentation().getTargetContext();

        assertEquals("com.example.chrome", appContext.getPackageName());
    }

    @Test
    public void testSearchGoogleChrome() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Chrome"));
        testingApp.clickAndWaitForNewWindow();

        UiObject search = mDevice.findObject(new UiSelector().resourceId("com.android.chrome:id/search_box_text"));
        search.click();

        UiObject text = mDevice.findObject(new UiSelector().resourceId("com.android.chrome:id/url_bar"));
        text.setText("UI Automator");

        UiObject option = mDevice.findObject(new UiSelector().text("ui automator viewer"));
        //UiObject option = mDevice.findObject(new UiSelector().text("uiautomatorviewer"));
        option.clickAndWaitForNewWindow();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
        appViews.scrollIntoView(new UiSelector().text("Android › developer › testing › ui-a..."));

        UiObject select = mDevice.findObject(new UiSelector().textStartsWith("Android › developer › testing › ui"));
        select.click();
    }

    @Test
    public void testShareImageGoogleChrome() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Chrome"));
        testingApp.clickAndWaitForNewWindow();

        UiObject search = mDevice.findObject(new UiSelector().resourceId("com.android.chrome:id/search_box_text"));
        search.click();

        UiObject text = mDevice.findObject(new UiSelector().resourceId("com.android.chrome:id/url_bar"));
        text.setText("SCRUM");

        UiObject option = mDevice.findObject(new UiSelector().text("SCRUM"));
        option.clickAndWaitForNewWindow();

        UiObject images = mDevice.findObject(new UiSelector().text("IMAGES"));
        images.clickAndWaitForNewWindow();

        UiObject image = mDevice.findObject(new UiSelector().text("Image result for SCRUM"));
        image.clickAndWaitForNewWindow();

        UiObject share = mDevice.findObject(new UiSelector().text("Share"));
        share.clickAndWaitForNewWindow();

        UiObject drive = mDevice.findObject(new UiSelector().text("Save to Drive"));
        drive.clickAndWaitForNewWindow();

        UiObject title = mDevice.findObject(new UiSelector().resourceId("com.google.android.apps.docs:id/upload_edittext_document_title"));
        title.setText("Imagen SCRUM");

        UiObject save = mDevice.findObject(new UiSelector().text("Save"));
        save.clickAndWaitForNewWindow();
    }

    @Test
    public void testClearHistoryGoogleChrome() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Chrome"));
        testingApp.clickAndWaitForNewWindow();

        UiObject options = mDevice.findObject(new UiSelector().description("More options"));
        options.click();

        UiObject history = mDevice.findObject(new UiSelector().text("History"));
        history.click();

        UiObject clear = mDevice.findObject(new UiSelector().text("Clear browsing data…"));
        clear.click();

        UiObject button = mDevice.findObject(new UiSelector().text("Clear data"));
        button.click();

        UiObject confirm = mDevice.findObject(new UiSelector().text("Clear"));
        confirm.click();
    }
}