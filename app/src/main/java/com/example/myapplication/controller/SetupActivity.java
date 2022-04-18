package com.example.myapplication.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.model.Currency;
import com.example.myapplication.model.IFilter;
import com.example.myapplication.model.Subject;
import com.example.myapplication.model.SubjectFilter;
import com.example.myapplication.model.SubjectLevel;
import com.example.myapplication.model.User;
import com.example.myapplication.model.TutorUser;
import com.example.myapplication.model.UserLibrary;
import com.example.myapplication.view.AccountFragment;
import com.example.myapplication.view.AddBirthdayFragment;
import com.example.myapplication.view.AddEmailPasswordFragment;
import com.example.myapplication.view.AddNameFragment;
import com.example.myapplication.view.EditAccountFragment;
import com.example.myapplication.view.FilteredTutorsFragment;
import com.example.myapplication.view.IAccountView;
import com.example.myapplication.view.IAddBirthdayView;
import com.example.myapplication.view.IAddEmailPasswordView;
import com.example.myapplication.view.IAddNameView;
import com.example.myapplication.view.IEditAccountView;
import com.example.myapplication.view.IFilteredTutorsView;
import com.example.myapplication.view.IMainView;
import com.example.myapplication.view.IPickModeView;
import com.example.myapplication.view.ISearchSubjectView;
import com.example.myapplication.view.ITutorInfoView;
import com.example.myapplication.view.MainView;
import com.example.myapplication.view.PickModeFragment;
import com.example.myapplication.view.SearchSubjectFragment;
import com.example.myapplication.view.TutorInfoFragment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Controller class that handles all logic
 */
public class SetupActivity extends AppCompatActivity implements IAddNameView.Listener, IAddEmailPasswordView.Listener,
        IAddBirthdayView.Listener, IPickModeView.Listener, ITutorInfoView.Listener, IAccountView.Listener,
        ISearchSubjectView.Listener, IFilteredTutorsView.Listener, IEditAccountView.Listener {

    IMainView mainView;
    UserLibrary ul = new UserLibrary();
    User user;
    TutorUser tutorUser;

    String name;
    String rateString;
    double ratePerHour;
    Currency currency;
    boolean isRemote;
    String isRemoteString;
    String teachingListString;
    String learningListString;
    int zipCode;
    int numStudents;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainView = new MainView(this);
        setContentView(mainView.getRootView());

        // display the add name fragment
        this.mainView.displayFragment(new AddNameFragment(this), false);
    }

    @Override
    public void onAddedUser(String fullName) {
        user = new User(fullName);
        ul.addUser(user);

        // swap fragment
        this.mainView.displayFragment(new AddEmailPasswordFragment(this), true);
    }

    @Override
    public void onEditedEmail(String email, String password) {

        user.setEmail(email);
        user.setPassword(password);

        // swap fragment
        this.mainView.displayFragment(new AddBirthdayFragment(this), true);
    }

    @Override
    public void onEditedBirthday(int birthYear) {
        user.setBirthYear(birthYear);

        // swap fragment
        this.mainView.displayFragment(new PickModeFragment(this), true);

    }

    @Override
    public void onPickedStudent() {
        this.mainView.displayFragment(new SearchSubjectFragment(this), true);
    }


    @Override
    public void onPickedTutor() {
        // TODO: swap fragment
        this.mainView.displayFragment(new TutorInfoFragment(this), true);
    }

    @Override
    public void onAddedTutorInfo(double ratePerHour, int numStudents, Currency currency,
                                 int zipCode, boolean isRemote) {
        tutorUser = new TutorUser(user, ratePerHour, numStudents, currency, zipCode, isRemote);

        // process info
        name = tutorUser.getName();
        this.ratePerHour = ratePerHour;
        this.currency = currency;
        rateString = tutorUser.makeRateString();
        isRemoteString = tutorUser.makeIsRemoteString();
        teachingListString = tutorUser.makeTeachingSubjectListString();
        learningListString = tutorUser.makeLearningSubjectListString();

        // swap fragment
        this.mainView.displayFragment(new AccountFragment(this, name, rateString,
                isRemoteString, teachingListString, learningListString, zipCode, numStudents), true);
    }

    @Override
    public void onEditAccount() {
        // TODO: swap fragment
        this.mainView.displayFragment(new EditAccountFragment(this, this.name, this.ratePerHour,
                this.currency, this.isRemote, this.teachingListString, this.learningListString,
                tutorUser.getZipCode(), tutorUser.getNumStudents()), true);
    }

    @Override
    public void onSubjectFilter(String subject, SubjectLevel subjectLevel){
        SubjectFilter subjectFilter = new SubjectFilter(subjectLevel, subject);
        List<IFilter> filters= new ArrayList<>();
        filters.add(subjectFilter);
        HashSet<User> resUsers = ul.filterUsers(filters);
        UserLibrary newUserLib = new UserLibrary(resUsers);

        this.mainView.displayFragment(new FilteredTutorsFragment(this, newUserLib), true);
    }

    @Override
    public void onFinishedEditingAccount(double ratePerHour, int numStudents, Currency currency,
                                         int zipCode, boolean isRemote, String name) {
        // edit fields
        tutorUser.setRatePerHour(ratePerHour);
        tutorUser.setCurrency(currency);
        rateString = tutorUser.makeRateString();
        tutorUser.setNumStudents(numStudents);
        tutorUser.setZipCode(zipCode);
        tutorUser.setRemote(isRemote);
        isRemoteString = tutorUser.makeIsRemoteString();
        tutorUser.setName(name);

        // Display information edited
        this.mainView.displayFragment(new AccountFragment(this, name, rateString,
                isRemoteString, teachingListString, learningListString, zipCode, numStudents), true);
    }

    public void onShowProfile(String userName) {
        for (User u : ul.getUsers()){
            if (u.getName().equals(userName)){
                TutorUser tutorUser = (TutorUser) u;
                this.mainView.displayFragment(new AccountFragment(this, tutorUser.getName(), tutorUser.makeRateString(), tutorUser.makeIsRemoteString(), tutorUser.makeTeachingSubjectListString(), tutorUser.makeLearningSubjectListString(), tutorUser.getZipCode(), tutorUser.getNumStudents()), true);
            }
        }
    }

}