package com.example.androidlab;

import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;

import androidx.core.widget.NestedScrollView;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void onClickButton() {

        // Библиотека постоянно кидает ошибки Error performing 'single click'
        //   Так и не смог найти решение.

        onView(withId(R.id.editTextLogin)).perform(typeText("testLogin"));
        onView(withId(R.id.editTextPassword)).perform(typeText("testPassword"));
        onView(withId(R.id.editTextFIO)).perform(typeText("testFIO"));

        onView(withId(R.id.buttonActivity)).perform(click());

        onView(withId(R.id.textViewLogin)).check(matches(withText("testLogin")));
        onView(withId(R.id.textViewPassword)).check(matches(withText("testPassword")));
        onView(withId(R.id.textViewFIO)).check(matches(withText("testFIO")));
    }
}