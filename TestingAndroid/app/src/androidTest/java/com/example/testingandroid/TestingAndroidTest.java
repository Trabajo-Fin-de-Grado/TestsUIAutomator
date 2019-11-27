package com.example.testingandroid;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
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

import static android.support.test.InstrumentationRegistry.getContext;
import static android.support.test.InstrumentationRegistry.getInstrumentation;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class TestingAndroidTest {

    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String BASIC_SAMPLE_PACKAGE = "My First Application";
    private UiDevice mDevice;

    @Before
    public void startMainActivityFromHomeScreen() {

        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        // Wait for launcher
        final String launcherPackage = getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)), LAUNCH_TIMEOUT);
    }

    private String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        // Use PackageManager to get the launcher package name
        PackageManager pm = getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }

    @Test
    public void checkPreconditions() {
        assertThat(mDevice, notNullValue());
    }

    @Test
    public void testSearchApp() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiObject testingApp = mDevice.findObject(new UiSelector().resourceId("com.google.android.apps.nexuslauncher:id/search_box_input"));
        testingApp.click();
        testingApp.setText("Testing");
    }

    @Test
    public void testSearchOtherApp() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        mDevice.findObject(new UiSelector().description("Apps list")).click();

        UiObject testingApp = mDevice.findObject(new UiSelector().resourceId("com.google.android.apps.nexuslauncher:id/search_box_input"));
        testingApp.click();
        testingApp.setText("M");

        UiObject appItem = mDevice.findObject(new UiSelector().resourceId("com.google.android.apps.nexuslauncher:id/apps_list_view").instance(0).childSelector(new UiSelector().text("Maps")));
        appItem.click();
    }

    @Test
    public void testSearchGoogle() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.clickAndWaitForNewWindow();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("Google"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Google"));
        testingApp.clickAndWaitForNewWindow();

        UiObject text = mDevice.findObject(new UiSelector().resourceId("com.google.android.googlequicksearchbox:id/text_container"));
        text.clickAndWaitForNewWindow();

        UiObject search = mDevice.findObject(new UiSelector().resourceId("com.google.android.googlequicksearchbox:id/search_box"));
        search.setText("UI Automator");

        UiObject option = mDevice.findObject(new UiSelector().className("android.widget.RelativeLayout").index(0));
        option.click();

        UiObject select = mDevice.findObject(new UiSelector().resourceId("com.google.android.googlequicksearchbox:id/corpus_selector_name").index(1));
        select.click();

        UiObject video = mDevice.findObject(new UiSelector().textStartsWith("Video for android ui automator 3:10 Android Tools"));
        video.click();
    }

    @Test
    public void testSearchGoogleMaps() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("Maps"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Maps"));
        testingApp.clickAndWaitForNewWindow();

        UiObject search = mDevice.findObject(new UiSelector().text("Search here"));
        search.clickAndWaitForNewWindow();
        search.setText("Reina Mercedes");

        UiObject location = mDevice.findObject(new UiSelector().text("Avenida de la Reina Mercedes"));
        location.clickAndWaitForNewWindow();
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
        option.clickAndWaitForNewWindow();

        // UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        // appViews.scrollIntoView(new UiSelector().text("Android › developer › testing › ui-a... UI Automator | Android Developers"));

        UiObject video = mDevice.findObject(new UiSelector().textStartsWith("Android › developer › testing › ui"));
        video.click();
    }

    @Test
    public void testQuiz() throws UiObjectNotFoundException {
        UiDevice mDevice;
        mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("Quiz"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Quiz"));
        testingApp.clickAndWaitForNewWindow();

        UiObject option = mDevice.findObject(new UiSelector().resourceId("com.example.myquiz:id/answer3"));
        option.click();

        UiObject button = mDevice.findObject(new UiSelector().resourceId("com.example.myquiz:id/btn_check"));
        button.click();
    }

    @Test
    public void testQuizPro() throws UiObjectNotFoundException {
        UiDevice mDevice;
        mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("QuizPro"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("QuizPro"));
        testingApp.clickAndWaitForNewWindow();

        UiObject option1 = mDevice.findObject(new UiSelector().resourceId("com.example.quizpro:id/answer3"));
        option1.click();

        UiObject button1 = mDevice.findObject(new UiSelector().resourceId("com.example.quizpro:id/btn_check"));
        button1.click();

        UiObject option2 = mDevice.findObject(new UiSelector().resourceId("com.example.quizpro:id/answer2"));
        option2.click();

        UiObject button2 = mDevice.findObject(new UiSelector().resourceId("com.example.quizpro:id/btn_check"));
        button2.click();

        UiObject option3 = mDevice.findObject(new UiSelector().resourceId("com.example.quizpro:id/answer2"));
        option3.click();

        UiObject button3 = mDevice.findObject(new UiSelector().resourceId("com.example.quizpro:id/btn_check"));
        button3.click();

        UiObject button4 = mDevice.findObject(new UiSelector().resourceId("android:id/button1"));
        button4.click();
    }

}