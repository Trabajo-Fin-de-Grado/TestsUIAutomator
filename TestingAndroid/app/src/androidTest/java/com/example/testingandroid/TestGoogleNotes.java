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
public class TestGoogleNotes {

    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String BASIC_SAMPLE_PACKAGE = "Notes";
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

    // UiObject photo    = mDevice.findObject(new UiSelector().text("Take photo"));
    // UiObject image    = mDevice.findObject(new UiSelector().text("Choose image"));
    // UiObject drawn    = mDevice.findObject(new UiSelector().text("Drawing"));
    // UiObject record   = mDevice.findObject(new UiSelector().text("Recording"));
    // UiObject checkbox = mDevice.findObject(new UiSelector().text("Checkboxes"));

    @Test
    public void testCreateNote() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("Keep Notes"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Keep Notes"));
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().description("New text note"));
        button.click();

        UiObject title = mDevice.findObject(new UiSelector().text("Title"));
        title.setText("UI Automator");

        UiObject description = mDevice.findObject(new UiSelector().text("Note"));
        description.setText("Prueba crear nota UI Automator");

        UiObject close = mDevice.findObject(new UiSelector().description("Navigate up"));
        close.click();

    }

    @Test
    public void testEditNoteAddImage() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("Keep Notes"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Keep Notes"));
        testingApp.clickAndWaitForNewWindow();

        UiObject note = mDevice.findObject(new UiSelector().text("UI Automator"));
        note.clickAndWaitForNewWindow();

        UiObject options = mDevice.findObject(new UiSelector().resourceId("com.google.android.keep:id/menu_icon"));
        options.click();

        UiObject image = mDevice.findObject(new UiSelector().text("Choose image"));
        image.click();

        UiObject menu = mDevice.findObject(new UiSelector().description("Show roots"));
        menu.click();

        UiObject option = mDevice.findObject(new UiSelector().text("zalo.agui1@gmail.com"));
        option.click();

        UiObject drive = mDevice.findObject(new UiSelector().text("My Drive"));
        drive.click();

        UiScrollable scroll = new UiScrollable(new UiSelector().scrollable(false));
        scroll.scrollIntoView(new UiSelector().text("UI Automator"));

        UiObject file = mDevice.findObject(new UiSelector().text("UI Automator"));
        file.clickAndWaitForNewWindow();

        UiObject close = mDevice.findObject(new UiSelector().description("Navigate up"));
        close.click();
    }

    @Test
    public void testEditNoteAddList() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("Keep Notes"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Keep Notes"));
        testingApp.clickAndWaitForNewWindow();

        UiObject note = mDevice.findObject(new UiSelector().text("UI Automator"));
        note.clickAndWaitForNewWindow();

        UiObject options = mDevice.findObject(new UiSelector().resourceId("com.google.android.keep:id/menu_icon"));
        options.click();

        UiObject checkbox = mDevice.findObject(new UiSelector().text("Checkboxes"));
        checkbox.click();

        UiObject check = mDevice.findObject(new UiSelector().resourceId("com.google.android.keep:id/checkbox"));
        check.click();

        UiObject item1 = mDevice.findObject(new UiSelector().resourceId("com.google.android.keep:id/description"));
        item1.setText("Prueba 2.0");

        UiObject list = mDevice.findObject(new UiSelector().text("List item"));
        list.click();
        check.click();

        UiObject item2 = mDevice.findObject(new UiSelector().resourceId("com.google.android.keep:id/description"));
        item2.setText("Prueba 3.0");

        UiObject close = mDevice.findObject(new UiSelector().description("Navigate up"));
        close.click();
    }

    // UiObject pin      = mDevice.findObject(new UiSelector().description("Pin button"));
    // UiObject reminder = mDevice.findObject(new UiSelector().description("Add reminder"));
    // UiObject color    = mDevice.findObject(new UiSelector().description("Change color"));
    // UiObject label    = mDevice.findObject(new UiSelector().description("Add label"));
    // UiObject options  = mDevice.findObject(new UiSelector().description("More options"));

    @Test
    public void testEditNoteAddReminder() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("Keep Notes"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Keep Notes"));
        testingApp.clickAndWaitForNewWindow();

        UiObject note = mDevice.findObject(new UiSelector().text("UI Automator"));
        note.longClick();

        UiObject reminder = mDevice.findObject(new UiSelector().description("Add reminder"));
        reminder.clickAndWaitForNewWindow();

        UiObject day = mDevice.findObject(new UiSelector().resourceId("com.google.android.keep:id/text"));
        day.click();

        UiObject tomorrow = mDevice.findObject(new UiSelector().text("Tomorrow"));
        tomorrow.click();

        UiObject repeat = mDevice.findObject(new UiSelector().text("Does not repeat"));
        repeat.click();

        UiObject daily = mDevice.findObject(new UiSelector().text("Daily"));
        daily.click();

        UiObject place = mDevice.findObject(new UiSelector().text("Place"));
        place.click();

        UiObject location = mDevice.findObject(new UiSelector().text("Edit location"));
        location.click();

        UiObject search = mDevice.findObject(new UiSelector().text("Search"));
        search.setText("Avenida Reina Mercedes");

        UiObject select = mDevice.findObject(new UiSelector().text("Seville, Spain"));
        select.click();

        UiObject save = mDevice.findObject(new UiSelector().text("Save"));
        save.click();

        UiObject close = mDevice.findObject(new UiSelector().text("Close"));
        close.click();
    }

    // UiObject archive = mDevice.findObject(new UiSelector().text("Archive"));
    // UiObject delete  = mDevice.findObject(new UiSelector().text("Delete"));
    // UiObject copy = mDevice.findObject(new UiSelector().text("Make a copy"));
    // UiObject send = mDevice.findObject(new UiSelector().text("Send"));
    // UiObject copy = mDevice.findObject(new UiSelector().text("Copy to Google Docs"));

    @Test
    public void testRemoveNote() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("Keep Notes"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Keep Notes"));
        testingApp.clickAndWaitForNewWindow();

        UiObject note = mDevice.findObject(new UiSelector().text("UI Automator"));
        note.longClick();

        UiObject options = mDevice.findObject(new UiSelector().description("More options"));
        options.click();

        UiObject delete = mDevice.findObject(new UiSelector().text("Delete"));
        delete.click();
    }
}