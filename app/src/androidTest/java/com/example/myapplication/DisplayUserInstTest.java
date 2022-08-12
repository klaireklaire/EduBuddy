package com.example.myapplication;

import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;


import com.example.myapplication.controller.SetupActivity;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class DisplayUserInstTest {

    @org.junit.Rule
    public ActivityScenarioRule<SetupActivity> activityRule = new ActivityScenarioRule<>(SetupActivity.class);

    @Test
    public void displayTutorProfile() {

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

        // PickModeFragment
        ViewInteraction tutorButtonVi = Espresso.onView(ViewMatchers.withId(R.id.tutorButton));
        tutorButtonVi.perform(ViewActions.click());

        // TutorInfoFragment
        ViewInteraction rateInputVi = Espresso.onView(ViewMatchers.withId(R.id.editRate));
        rateInputVi.perform(ViewActions.typeText("13.2"));

        ViewInteraction currencyInputVi = Espresso.onView(ViewMatchers.withId(R.id.editCurrency));
        currencyInputVi.perform(ViewActions.typeText("USD"));
        currencyInputVi.perform(ViewActions.closeSoftKeyboard());

        ViewInteraction numStudentsInputVi = Espresso.onView(ViewMatchers.withId(R.id.editNumStudents));
        numStudentsInputVi.perform(ViewActions.typeText("5"));
        numStudentsInputVi.perform(ViewActions.closeSoftKeyboard());

        ViewInteraction zipCodeInputVi = Espresso.onView(ViewMatchers.withId(R.id.editZipcode));
        zipCodeInputVi.perform(ViewActions.typeText("12604"));
        zipCodeInputVi.perform(ViewActions.closeSoftKeyboard());

        ViewInteraction remoteCheckBoxVi = Espresso.onView(ViewMatchers.withId(R.id.remoteCheckBox));
        remoteCheckBoxVi.perform(ViewActions.click());
        remoteCheckBoxVi.perform(ViewActions.closeSoftKeyboard());

        ViewInteraction subjectPickVi = Espresso.onView(ViewMatchers.withId(R.id.spinner));
        subjectPickVi.perform(ViewActions.click());
        Espresso.onData(Matchers.instanceOf(String.class)).atPosition(3).perform(ViewActions.click());
    //    onView(withId(spinnerId)).check(matches(withSpinnerText(containsString(selectionText))));

        ViewInteraction levelPickVi = Espresso.onView(ViewMatchers.withId(R.id.spinner2));
        levelPickVi.perform(ViewActions.click());
        Espresso.onData(Matchers.instanceOf(String.class)).atPosition(3).perform(ViewActions.click());


        ViewInteraction nextButton3Vi = Espresso.onView(ViewMatchers.withId(R.id.nextButton3));
        nextButton3Vi.perform(ViewActions.click());

        // AccountFragment
        Matcher<View> nameLabelMatcher = ViewMatchers.withId(R.id.nameLabel);
        ViewInteraction nameLabelVi = Espresso.onView(nameLabelMatcher);
        nameLabelVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("Klaire Pham")));

        Matcher<View> rateLabelMatcher = ViewMatchers.withId(R.id.rateLabel);
        ViewInteraction rateLabelVi = Espresso.onView(rateLabelMatcher);
        rateLabelVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("13.2 USD")));

        Matcher<View> zipCodeMatcher = ViewMatchers.withId(R.id.zipCodeDisplayText);
        ViewInteraction zipCodeDisplayTextVi = Espresso.onView(zipCodeMatcher);
        zipCodeDisplayTextVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("12604")));

        Matcher<View> remoteMatcher = ViewMatchers.withId(R.id.remoteDisplayText);
        ViewInteraction remoteDisplayTextVi = Espresso.onView(remoteMatcher);
        remoteDisplayTextVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("Yes")));

        Matcher<View> numStudentsMatcher = ViewMatchers.withId(R.id.numStudentsDisplayText);
        ViewInteraction numStudentsDisplayTextVi = Espresso.onView(numStudentsMatcher);
        numStudentsDisplayTextVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("5")));

        Matcher<View> teachingSubjectMatcher = ViewMatchers.withId(R.id.teachingSubjectsText);
        ViewInteraction teachingSubjectTextVi = Espresso.onView(teachingSubjectMatcher);
        teachingSubjectTextVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("Physics.")));

        ViewInteraction editProfileButtonVi = Espresso.onView(ViewMatchers.withId(R.id.editProfileButton));
        editProfileButtonVi.perform(ViewActions.click());



    }



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


    @Test
    public void editTutorProfile() {

        displayTutorProfile();

        // EditAccountFragment
        ViewInteraction rateEditVi = Espresso.onView(ViewMatchers.withId(R.id.editProfileRate));
        rateEditVi.perform(ViewActions.replaceText("200000"));

        ViewInteraction currencyEditVi = Espresso.onView(ViewMatchers.withId(R.id.editProfileCurrency));
        currencyEditVi.perform(ViewActions.replaceText("VND"));

        ViewInteraction nameEditVi = Espresso.onView(ViewMatchers.withId(R.id.editProfileName));
        nameEditVi.perform(ViewActions.replaceText("Khanh Le"));

        ViewInteraction zipCodeEditVi = Espresso.onView(ViewMatchers.withId(R.id.editProfileZipcode));
        zipCodeEditVi.perform(ViewActions.replaceText("10101"));

        ViewInteraction remoteCheckBoxVi = Espresso.onView(ViewMatchers.withId(R.id.profileRemoteCheckbox));
        remoteCheckBoxVi.perform(ViewActions.click());

        ViewInteraction numStudentsEditVi = Espresso.onView(ViewMatchers.withId(R.id.editProfileNumStudents));
        numStudentsEditVi.perform(ViewActions.replaceText("10"));

        ViewInteraction finishButtonVi = Espresso.onView(ViewMatchers.withId(R.id.finishEditButton));
        finishButtonVi.perform(ViewActions.click());

        // AccountFragment
        Matcher<View> nameLabelMatcher = ViewMatchers.withId(R.id.nameLabel);
        ViewInteraction nameLabelVi = Espresso.onView(nameLabelMatcher);
        nameLabelVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("Khanh Le")));

        Matcher<View> rateLabelMatcher = ViewMatchers.withId(R.id.rateLabel);
        ViewInteraction rateLabelVi = Espresso.onView(rateLabelMatcher);
        rateLabelVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("200000.0 VND")));

        Matcher<View> zipCodeMatcher = ViewMatchers.withId(R.id.zipCodeDisplayText);
        ViewInteraction zipCodeDisplayTextVi = Espresso.onView(zipCodeMatcher);
        zipCodeDisplayTextVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("10101")));

        Matcher<View> remoteMatcher = ViewMatchers.withId(R.id.remoteDisplayText);
        ViewInteraction remoteDisplayTextVi = Espresso.onView(remoteMatcher);
        remoteDisplayTextVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("Yes")));

        Matcher<View> numStudentsMatcher = ViewMatchers.withId(R.id.numStudentsDisplayText);
        ViewInteraction numStudentsDisplayTextVi = Espresso.onView(numStudentsMatcher);
        numStudentsDisplayTextVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("10")));


    }

    @Test
    public void studentPick() {

        // AddNameFragment
        // add name
        ViewInteraction firstNameInputVi = Espresso.onView(ViewMatchers.withId(R.id.editFirstName));
        firstNameInputVi.perform(ViewActions.typeText("Khanh"));

        ViewInteraction lastNameInputVi = Espresso.onView(ViewMatchers.withId(R.id.editLastName));
        lastNameInputVi.perform(ViewActions.typeText("Le"));

        // close the keyboard, click next button
        ViewInteraction nextButtonVi = Espresso.onView(ViewMatchers.withId(R.id.nextButton));
        nextButtonVi.perform(ViewActions.closeSoftKeyboard());
        nextButtonVi.perform(ViewActions.click());

        // AddEmailPasswordFragment
        ViewInteraction emailInputVi = Espresso.onView(ViewMatchers.withId(R.id.editEmail));
        emailInputVi.perform(ViewActions.typeText("klle@vassar.edu"));

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

        // PickModeFragment -  student button
        ViewInteraction studentButtonVi = Espresso.onView(ViewMatchers.withId(R.id.studentButton));
        studentButtonVi.perform(ViewActions.click());

        ViewInteraction subjectSpinnerVi = Espresso.onView(ViewMatchers.withId(R.id.subjectSpinner));
        subjectSpinnerVi.perform(ViewActions.click());
        Espresso.onData(Matchers.instanceOf(String.class)).atPosition(4).perform(ViewActions.click());
        ViewInteraction levelSpinnerVi = Espresso.onView(ViewMatchers.withId(R.id.levelSpinner));
        levelSpinnerVi.perform(ViewActions.click());
        Espresso.onData(Matchers.instanceOf(String.class)).atPosition(3).perform(ViewActions.click());

        // click find tutor button
        ViewInteraction findTutor = Espresso.onView(ViewMatchers.withId(R.id.findTutor));
        findTutor.perform(ViewActions.click());

        // AccountFragment
        Matcher<View> tutorList = ViewMatchers.withId(R.id.tutorList);
        ViewInteraction tutorListVi = Espresso.onView(tutorList);
        tutorListVi.perform(ViewActions.click());
        Espresso.onData(Matchers.instanceOf(String.class)).atPosition(0).perform(ViewActions.click());

        // AccountFragment
        Matcher<View> nameLabelMatcher = ViewMatchers.withId(R.id.nameLabel);
        ViewInteraction nameLabelVi = Espresso.onView(nameLabelMatcher);
        nameLabelVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("Professor")));

        Matcher<View> rateLabelMatcher = ViewMatchers.withId(R.id.rateLabel);
        ViewInteraction rateLabelVi = Espresso.onView(rateLabelMatcher);
        rateLabelVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("200.0 USD")));

        Matcher<View> zipCodeMatcher = ViewMatchers.withId(R.id.zipCodeDisplayText);
        ViewInteraction zipCodeDisplayTextVi = Espresso.onView(zipCodeMatcher);
        zipCodeDisplayTextVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("12604")));

        Matcher<View> remoteMatcher = ViewMatchers.withId(R.id.remoteDisplayText);
        ViewInteraction remoteDisplayTextVi = Espresso.onView(remoteMatcher);
        remoteDisplayTextVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("Yes")));

        Matcher<View> numStudentsMatcher = ViewMatchers.withId(R.id.numStudentsDisplayText);
        ViewInteraction numStudentsDisplayTextVi = Espresso.onView(numStudentsMatcher);
        numStudentsDisplayTextVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("20")));


    }

}