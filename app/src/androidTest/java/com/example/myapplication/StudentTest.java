package com.example.myapplication;

import android.content.Context;
import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.*;

import com.example.myapplication.controller.SetupActivity;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class StudentTest {

    @org.junit.Rule
    public ActivityScenarioRule<SetupActivity> activityRule = new ActivityScenarioRule<>(SetupActivity.class);

    @Test
    public void studentPick() {
        // check that fields are empty at the start
//        Matcher<View> nameMatcher = ViewMatchers.withId(R.id.nameLabel);
//        ViewInteraction lineItemsVi = Espresso.onView(lineItemsMatcher);
//        lineItemsVi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.items_default)));

        // AddNameFragment
        // add name
        ViewInteraction firstNameInputVi = Espresso.onView(ViewMatchers.withId(R.id.editFirstName));
        firstNameInputVi.perform(ViewActions.typeText("Klaire"));

        ViewInteraction lastNameInputVi = Espresso.onView(ViewMatchers.withId(R.id.editLastName));
        lastNameInputVi.perform(ViewActions.typeText("Pham"));

        // close the keyboard, click next button
        ViewInteraction nextButtonVi = Espresso.onView(ViewMatchers.withId(R.id.nextButton));
        nextButtonVi.perform(ViewActions.closeSoftKeyboard());
        nextButtonVi.perform(ViewActions.click());

        // AddEmailPasswordFragment
        ViewInteraction emailInputVi = Espresso.onView(ViewMatchers.withId(R.id.editEmail));
        emailInputVi.perform(ViewActions.typeText("klairepham@vassar.edu"));

        ViewInteraction passwordInputVi = Espresso.onView(ViewMatchers.withId(R.id.editPassword));
        passwordInputVi.perform(ViewActions.typeText("12345678"));

        // close keyboard, click next button
        ViewInteraction nextButton1Vi = Espresso.onView(ViewMatchers.withId(R.id.nextButton1));
        nextButton1Vi.perform(ViewActions.closeSoftKeyboard());
        nextButton1Vi.perform(ViewActions.click());

        // AddBirthdayFragment
        ViewInteraction birthdayInputVi = Espresso.onView(ViewMatchers.withId(R.id.editBirthYear));
        birthdayInputVi.perform(ViewActions.typeText("2002"));

        ViewInteraction nextButton2Vi = Espresso.onView(ViewMatchers.withId(R.id.nextButton2));
        nextButton2Vi.perform(ViewActions.closeSoftKeyboard());
        nextButton2Vi.perform(ViewActions.click());


        // click student button
        ViewInteraction studentButtonVi = Espresso.onView(ViewMatchers.withId(R.id.studentButton));
        ViewInteraction subjectSpinnerVi = Espresso.onView(ViewMatchers.withId(R.id.subjectSpinner));
        subjectSpinnerVi.perform(ViewActions.click());
        Espresso.onData(Matchers.instanceOf(String.class)).atPosition(1);
        ViewInteraction levelSpinnerVi = Espresso.onView(ViewMatchers.withId(R.id.levelSpinner));
        subjectSpinnerVi.perform(ViewActions.click());
        Espresso.onData(Matchers.instanceOf(String.class)).atPosition(2);

        // click find tutor button
        ViewInteraction findTutor = Espresso.onView(ViewMatchers.withId(R.id.findTutor));
        findTutor.perform(ViewActions.click());

        // AccountFragment
        Matcher<View> tutorList = ViewMatchers.withId(R.id.tutorList);
        ViewInteraction tutorListVi = Espresso.onView(tutorList);
        Espresso.onData(Matchers.instanceOf(String.class)).atPosition(0).perform(ViewActions.click());

        // AccountFragment
        Matcher<View> nameLabelMatcher = ViewMatchers.withId(R.id.nameLabel);
        ViewInteraction nameLabelVi = Espresso.onView(nameLabelMatcher);
        nameLabelVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("Khanh Le")));

        Matcher<View> rateLabelMatcher = ViewMatchers.withId(R.id.rateLabel);
        ViewInteraction rateLabelVi = Espresso.onView(rateLabelMatcher);
        rateLabelVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("15.0 USD")));

        Matcher<View> zipCodeMatcher = ViewMatchers.withId(R.id.zipCodeDisplayText);
        ViewInteraction zipCodeDisplayTextVi = Espresso.onView(zipCodeMatcher);
        zipCodeDisplayTextVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("12604")));

        Matcher<View> remoteMatcher = ViewMatchers.withId(R.id.remoteDisplayText);
        ViewInteraction remoteDisplayTextVi = Espresso.onView(remoteMatcher);
        remoteDisplayTextVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("Yes")));

        Matcher<View> numStudentsMatcher = ViewMatchers.withId(R.id.numStudentsDisplayText);
        ViewInteraction numStudentsDisplayTextVi = Espresso.onView(numStudentsMatcher);
        numStudentsDisplayTextVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("4")));


//    @Test
//    public void emailpass() {
//        name();
//
//        // AddEmailPasswordFragment
//        ViewInteraction emailInputVi = Espresso.onView(ViewMatchers.withId(R.id.editEmail));
//        emailInputVi.perform(ViewActions.typeText("klairepham@vassar.edu"));
//        ViewInteraction passwordInputVi = Espresso.onView(ViewMatchers.withId(R.id.editPassword));
//        passwordInputVi.perform(ViewActions.typeText("12345678"));
//        // close keyboard, click next button
//        ViewInteraction nextButton1Vi = Espresso.onView(ViewMatchers.withId(R.id.nextButton1));
//        nextButton1Vi.perform(ViewActions.closeSoftKeyboard());
//        nextButton1Vi.perform(ViewActions.click());
//    }


    }



}