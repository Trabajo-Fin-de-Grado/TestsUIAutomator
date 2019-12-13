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
public class TestContacts {

    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String BASIC_SAMPLE_PACKAGE = "Contacts";
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

        assertEquals("com.example.contacts", appContext.getPackageName());
    }

    @Test
    public void testCrearContacto() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Contacts"));
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().resourceId("com.android.contacts:id/floating_action_button"));
        button.clickAndWaitForNewWindow();

        UiObject expansion = mDevice.findObject(new UiSelector().resourceId("com.android.contacts:id/expansion_view"));
        expansion.click();

        // UiObject namePrefix = mDevice.findObject(new UiSelector().text("Name prefix"));
        UiObject firstName  = mDevice.findObject(new UiSelector().text("First name"));
        UiObject middleName = mDevice.findObject(new UiSelector().text("Middle name"));
        UiObject lastName   = mDevice.findObject(new UiSelector().text("Last name"));
        // UiObject nameSuffix   = mDevice.findObject(new UiSelector().text("Name suffix"));

        firstName.setText("Gonzalo");
        middleName.setText("Aguilar");
        lastName.setText("Hermoso");

        expansion.click();

        UiObject phone = mDevice.findObject(new UiSelector().text("Phone"));
        phone.setText("654123987");

        UiObject mobile = mDevice.findObject(new UiSelector().text("Mobile"));
        mobile.click();

        UiObject home = mDevice.findObject(new UiSelector().text("Home"));
        home.click();

        UiObject phoneHome = mDevice.findObject(new UiSelector().text("Phone"));
        phoneHome.setText("924556677");

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("Email"));

        UiObject email = mDevice.findObject(new UiSelector().text("Email"));
        email.setText("automator@gmail.com");

        UiScrollable appViews2 = new UiScrollable(new UiSelector().scrollable(false));
        appViews2.scrollIntoView(new UiSelector().text("More fields"));

        UiObject moreData = mDevice.findObject(new UiSelector().text("More fields"));
        moreData.click();

        // UiObject save = mDevice.findObject(new UiSelector().resourceId("com.android.contacts:id/menu_save")); // API 25
        UiObject save = mDevice.findObject(new UiSelector().resourceId("com.android.contacts:id/editor_menu_save_button")); // API 28
        save.click();

        mDevice.pressHome();
        allAppsButton.click();
        testingApp.clickAndWaitForNewWindow();

        UiObject contact = mDevice.findObject(new UiSelector().resourceId("com.android.contacts:id/cliv_name_textview"));
        contact.exists();
    }

    @Test
    public void testCrearOtroContacto() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Contacts"));
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().resourceId("com.android.contacts:id/floating_action_button"));
        button.clickAndWaitForNewWindow();

        UiObject expansion = mDevice.findObject(new UiSelector().resourceId("com.android.contacts:id/expansion_view"));
        expansion.click();

        // UiObject namePrefix = mDevice.findObject(new UiSelector().text("Name prefix"));
        UiObject firstName  = mDevice.findObject(new UiSelector().text("First name"));
        UiObject middleName = mDevice.findObject(new UiSelector().text("Middle name"));
        UiObject lastName   = mDevice.findObject(new UiSelector().text("Last name"));
        // UiObject nameSuffix   = mDevice.findObject(new UiSelector().text("Name suffix"));

        firstName.setText("Antonio");
        middleName.setText("Macías");
        lastName.setText("Zambrano");

        expansion.click();

        UiObject phone = mDevice.findObject(new UiSelector().text("Phone"));
        phone.setText("654987123");

        UiObject mobile = mDevice.findObject(new UiSelector().text("Mobile"));
        mobile.click();

        UiObject home = mDevice.findObject(new UiSelector().text("Home"));
        home.click();

        UiObject phoneHome = mDevice.findObject(new UiSelector().text("Phone"));
        phoneHome.setText("924223344");

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("Email"));

        UiObject email = mDevice.findObject(new UiSelector().text("Email"));
        email.setText("automator@gmail.com");

        UiObject moreData = mDevice.findObject(new UiSelector().text("More fields"));
        moreData.click();

        // UiObject save = mDevice.findObject(new UiSelector().resourceId("com.android.contacts:id/menu_save")); // API 25
        UiObject save = mDevice.findObject(new UiSelector().resourceId("com.android.contacts:id/editor_menu_save_button")); // API 28
        save.click();

        mDevice.pressHome();
        allAppsButton.click();
        testingApp.clickAndWaitForNewWindow();

        UiObject contact = mDevice.findObject(new UiSelector().resourceId("com.android.contacts:id/cliv_name_textview"));
        contact.exists();
    }

    @Test
    public void testEditarContacto() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Contacts"));
        testingApp.clickAndWaitForNewWindow();

        UiObject contact = mDevice.findObject(new UiSelector().description("Gonzalo Aguilar Hermoso"));
        contact.click();

        UiObject button = mDevice.findObject(new UiSelector().resourceId("com.android.contacts:id/menu_edit"));
        button.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("More fields"));

        UiObject moreData = mDevice.findObject(new UiSelector().text("More fields"));
        moreData.click();

        UiScrollable appViews0 = new UiScrollable(new UiSelector().scrollable(true));
        appViews0.scrollIntoView(new UiSelector().text("Company"));

        UiObject company = mDevice.findObject(new UiSelector().text("Company"));
        company.setText("Escuela Técnica Superior de Ingeniería Informática");

        UiScrollable appViews1 = new UiScrollable(new UiSelector().scrollable(false));
        appViews1.scrollIntoView(new UiSelector().text("Address"));

        UiObject address = mDevice.findObject(new UiSelector().text("Address"));
        address.setText("Avenida Reina Mercedes nº 4");

        UiScrollable appViews2 = new UiScrollable(new UiSelector().scrollable(false));
        appViews2.scrollIntoView(new UiSelector().text("Website"));

        UiObject website = mDevice.findObject(new UiSelector().text("Website"));
        website.setText("https://www.informatica.us.es/");

        UiScrollable appViews3 = new UiScrollable(new UiSelector().scrollable(false));
        appViews3.scrollIntoView(new UiSelector().text("Notes"));

        UiObject notes = mDevice.findObject(new UiSelector().text("Notes"));
        notes.setText("UI Automator");

        // UiObject save = mDevice.findObject(new UiSelector().resourceId("com.android.contacts:id/menu_save")); // API 25
        UiObject save = mDevice.findObject(new UiSelector().resourceId("com.android.contacts:id/editor_menu_save_button")); // API 28
        save.click();

    }

    @Test
    public void testBorrarContacto() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Contacts"));
        testingApp.clickAndWaitForNewWindow();

        UiObject contact = mDevice.findObject(new UiSelector().description("Gonzalo Aguilar Hermoso"));
        contact.click();

        UiObject options = mDevice.findObject(new UiSelector().className("android.widget.ImageButton"));
        options.click();

        UiObject delete = mDevice.findObject(new UiSelector().text("Delete"));
        delete.click();

        UiObject button = mDevice.findObject(new UiSelector().resourceId("android:id/button1"));
        button.click();
    }

    @Test
    public void testAñadirFavoritos() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Contacts"));
        testingApp.clickAndWaitForNewWindow();

        UiObject contact = mDevice.findObject(new UiSelector().description("Gonzalo Aguilar Hermoso"));
        contact.click();

        UiObject button = mDevice.findObject(new UiSelector().resourceId("com.android.contacts:id/menu_star"));
        button.click();

        mDevice.pressHome();
        allAppsButton.click();
        testingApp.clickAndWaitForNewWindow();

        UiObject favorites = mDevice.findObject(new UiSelector().text("FAVORITES"));
        favorites.click();
    }

}
