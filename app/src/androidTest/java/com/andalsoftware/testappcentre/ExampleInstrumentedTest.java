package com.andalsoftware.testappcentre;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.microsoft.appcenter.espresso.Factory;
import com.microsoft.appcenter.espresso.ReportHelper;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.app.PendingIntent.getActivity;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ReportHelper reportHelper = Factory.getReportHelper();
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    private String username_tobe_typed="admin";
    private String correct_password ="admin123";
    private String wrong_password = "admin";


    @Test
    public void loginPageTest()
    {
        Espresso.onView(withId(R.id.btnLogin)).perform(click());
        Espresso.onView((withId(R.id.editTextUsername))).perform(ViewActions.typeText(username_tobe_typed));
        Espresso.onView(withId(R.id.editTextPassword)).perform(ViewActions.typeText(correct_password));
        Espresso.onView(withId(R.id.btnLoginUser)).perform(ViewActions.click());
        Espresso.onView(withText(R.string.msg_login_success)).inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView()))) .check(matches(isDisplayed()));
    }

    @After
    public void TearDown(){
        reportHelper.label("Stopping App");
    }
}
