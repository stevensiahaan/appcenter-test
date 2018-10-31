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

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class OpenAnalyticsTest {

    private String username_tobe_typed="admin";
    private String correct_password ="admin123";
    private String wrong_password = "admin";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
    @Rule
    public ReportHelper reportHelper = Factory.getReportHelper();

    @Test
    public void openAnalytics()
    {
        Espresso.onView(withId(R.id.btnClickMe)).perform(click());
        Espresso.onView((withId(R.id.btnOK))).perform(click());
        Espresso.onView(withText(R.string.OK)).inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView()))) .check(matches(isDisplayed()));
    }

    @After
    public void TearDown(){
        reportHelper.label("Stopping App");
    }

}