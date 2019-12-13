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
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class TestGmail {

    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String BASIC_SAMPLE_PACKAGE = "Gmail";
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

        assertEquals("com.example.gmail", appContext.getPackageName());
    }

    @Test
    public void testSendEmail() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
        appViews.scrollIntoView(new UiSelector().text("Gmail"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Gmail"));
        testingApp.clickAndWaitForNewWindow();

        UiObject email = mDevice.findObject(new UiSelector().description("Compose"));
        email.clickAndWaitForNewWindow();

        UiObject user = mDevice.findObject(new UiSelector().resourceId("com.google.android.gm:id/to"));
        user.setText("zalo.agui3@gmail.com");

        UiObject subject = mDevice.findObject(new UiSelector().text("Subject"));
        subject.setText("UI Automator");

        UiObject body = mDevice.findObject(new UiSelector().text("Compose email"));
        body.setText("Test probando aplicación de Gmail");

        UiObject button = mDevice.findObject(new UiSelector().description("Send"));
        button.clickAndWaitForNewWindow();

        mDevice.pressHome();
    }

    @Test
    public void testEditDraft() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
        appViews.scrollIntoView(new UiSelector().text("Gmail"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Gmail"));
        testingApp.clickAndWaitForNewWindow();

        UiObject options = mDevice.findObject(new UiSelector().description("Open navigation drawer"));
        options.clickAndWaitForNewWindow();

        UiObject drafts = mDevice.findObject(new UiSelector().text("Drafts"));
        drafts.clickAndWaitForNewWindow();

        UiObject email = mDevice.findObject(new UiSelector().descriptionStartsWith(" me, UI Automator, Test probando aplicación de Gmail"));
        email.clickAndWaitForNewWindow();

        UiObject edit = mDevice.findObject(new UiSelector().description("Edit"));
        edit.clickAndWaitForNewWindow();

        UiObject text = mDevice.findObject(new UiSelector().description("Attach file"));
        text.clickAndWaitForNewWindow();

        UiObject attachment = mDevice.findObject(new UiSelector().text("Attach file"));
        attachment.clickAndWaitForNewWindow();

        UiObject file = mDevice.findObject(new UiSelector().text("Untitled document.docx"));
        file.clickAndWaitForNewWindow();

        UiObject save = mDevice.findObject(new UiSelector().description("Navigate up"));
        save.clickAndWaitForNewWindow();
    }

    @Test
    public void testDeleteEmail() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
        appViews.scrollIntoView(new UiSelector().text("Gmail"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Gmail"));
        testingApp.clickAndWaitForNewWindow();

        UiObject options = mDevice.findObject(new UiSelector().description("Open navigation drawer"));
        options.clickAndWaitForNewWindow();

        UiObject sent = mDevice.findObject(new UiSelector().text("Sent"));
        sent.clickAndWaitForNewWindow();

        UiObject body = mDevice.findObject(new UiSelector().description("Double tap to select this conversation"));
        body.longClick();

        UiObject delete = mDevice.findObject(new UiSelector().description("Delete"));
        delete.clickAndWaitForNewWindow();
    }

    @Test
    public void testEmptyTrash() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
        appViews.scrollIntoView(new UiSelector().text("Gmail"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Gmail"));
        testingApp.clickAndWaitForNewWindow();

        UiObject options = mDevice.findObject(new UiSelector().description("Open navigation drawer"));
        options.clickAndWaitForNewWindow();

        UiScrollable scroll = new UiScrollable(new UiSelector().scrollable(false));
        scroll.scrollIntoView(new UiSelector().text("Trash"));

        UiObject sent = mDevice.findObject(new UiSelector().text("Trash"));
        sent.clickAndWaitForNewWindow();

        UiObject trash = mDevice.findObject(new UiSelector().text("EMPTY TRASH NOW"));
        trash.clickAndWaitForNewWindow();

        UiObject confirm = mDevice.findObject(new UiSelector().text("EMPTY"));
        confirm.clickAndWaitForNewWindow();
    }

}
