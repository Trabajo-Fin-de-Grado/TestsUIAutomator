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
public class TestPlayMusic {

    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String BASIC_SAMPLE_PACKAGE = "Play Music";
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
    public void playMusic() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        // UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Aplicaciones"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("Play Música"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Play Música"));
        testingApp.clickAndWaitForNewWindow();

        UiObject music = mDevice.findObject(new UiSelector().text("Music"));
        music.click();

        UiScrollable list = new UiScrollable(new UiSelector().scrollable(false));
        list.scrollIntoView(new UiSelector().text("Twenty One Pilots Forest"));

        UiObject song = mDevice.findObject(new UiSelector().text("Twenty One Pilots Forest"));
        song.click();

    }

    @Test
    public void stopMusic() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        // UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Aplicaciones"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("Play Música"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Play Música"));
        testingApp.clickAndWaitForNewWindow();

        UiObject music = mDevice.findObject(new UiSelector().text("Music"));
        music.click();

        UiScrollable list = new UiScrollable(new UiSelector().scrollable(false));
        list.scrollIntoView(new UiSelector().text("Twenty One Pilots Forest"));

        UiObject song = mDevice.findObject(new UiSelector().text("Twenty One Pilots Forest"));
        song.click();

        UiObject artist = mDevice.findObject(new UiSelector().text("Artista desconocido"));
        artist.click();

        song.waitUntilGone(4000);

        UiObject stop = mDevice.findObject(new UiSelector().description("Pausar"));
        stop.click();

        stop.waitUntilGone(1000);

        UiObject play = mDevice.findObject(new UiSelector().description("Reproducir"));
        play.click();

        stop.waitUntilGone(1000);

        stop.click();
    }

    @Test
    public void previousSong() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        // UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Aplicaciones"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("Play Música"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Play Música"));
        testingApp.clickAndWaitForNewWindow();

        UiObject music = mDevice.findObject(new UiSelector().text("Music"));
        music.click();

        UiScrollable list = new UiScrollable(new UiSelector().scrollable(false));
        list.scrollIntoView(new UiSelector().text("Twenty One Pilots Forest"));

        UiObject song = mDevice.findObject(new UiSelector().text("Twenty One Pilots Forest"));
        song.click();

        UiObject artist = mDevice.findObject(new UiSelector().text("Artista desconocido"));
        artist.click();

        song.waitUntilGone(5000);

        UiObject previous = mDevice.findObject(new UiSelector().description("Anterior"));
        previous.click();

        previous.waitUntilGone(5000);

        UiObject stop = mDevice.findObject(new UiSelector().description("Pausar"));
        stop.click();

    }

    @Test
    public void nextSong() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        // UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Aplicaciones"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("Play Música"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Play Música"));
        testingApp.clickAndWaitForNewWindow();

        UiObject music = mDevice.findObject(new UiSelector().text("Music"));
        music.click();

        UiScrollable list = new UiScrollable(new UiSelector().scrollable(false));
        list.scrollIntoView(new UiSelector().text("Twenty One Pilots Forest"));

        UiObject song = mDevice.findObject(new UiSelector().text("Twenty One Pilots Forest"));
        song.click();

        UiObject artist = mDevice.findObject(new UiSelector().text("Artista desconocido"));
        artist.click();

        song.waitUntilGone(5000);

        UiObject next = mDevice.findObject(new UiSelector().description("Siguiente"));
        next.click();

        next.waitUntilGone(5000);

        UiObject stop = mDevice.findObject(new UiSelector().description("Pausar"));
        stop.click();

    }

}
