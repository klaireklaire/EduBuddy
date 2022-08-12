package com.example.myapplication.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.myapplication.persistence.FirestoreFacade;
import com.example.myapplication.persistence.IPersistenceFacade;
import com.example.myapplication.view.IProfileView;
import com.example.myapplication.view.ISendRequestView;
import com.example.myapplication.view.ProfileFragment;
import com.example.myapplication.view.SendRequestFragment;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

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

import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Controller class that handles all logic
 */
public class SetupActivity extends AppCompatActivity implements IAddNameView.Listener, IAddEmailPasswordView.Listener,
        IAddBirthdayView.Listener, IPickModeView.Listener, ITutorInfoView.Listener, IAccountView.Listener,
        ISearchSubjectView.Listener, IFilteredTutorsView.Listener, IEditAccountView.Listener,
        IProfileView.Listener, ISendRequestView.Listener {

    private static final String IN_PROGRESS = "IN_PROGRESS";
    private static final String USER = "USER";
    private static final String USER_LIBRARY = "USER_LIBRARY";
    private static final String TUTOR_USER = "TUTOR_USER";
    private static final String NAME = "name";
    private static final String RATE = "rateString";
    private static final String IS_REMOTE = "isRemoteString";
    private static final String REMOTE = "isRemote";
    private static final String TEACHING_LIST = "teachingListString";
    private static final String LEARNING_LIST = "learningListString";
    private static final String ZIP_CODE = "zipCode";
    private static final String NUM_STUDENTS = "numStudents";
    private static final String CURRENCY = "CURRENCY";
    private static final String RATE_PER_HOUR = "RATE_PER_HOUR";
    private static final String IS_TUTOR = "IS_TUTOR";

    private static int SPLASH_TIME_OUT = 4000;

    // fields
    IMainView mainView;
    UserLibrary ul;
    User user;
    TutorUser tutorUser;

    // fields for User object
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
    boolean isTutor = false;

   // java.util.Map<String, Object> userMapData = new java.util.HashMap<>();

    // connect to database
    //FirebaseFirestore db = FirebaseFirestore.getInstance();
    private IPersistenceFacade persistenceFacade = new FirestoreFacade();


    protected void onCreate(Bundle savedInstanceState) {
        // set custom fragment factory
        // must do this before call to super.onCreate() because that's where fragments are recreated
        getSupportFragmentManager().setFragmentFactory(new EduBuddyFragFractory(this));

        super.onCreate(savedInstanceState);

        // do we have state to recover, or are we starting out fresh?
        if (savedInstanceState == null) {
            this.ul = new UserLibrary();
        } else {
            this.ul = (UserLibrary) savedInstanceState.getSerializable(USER_LIBRARY);
            this.tutorUser = (TutorUser) savedInstanceState.getSerializable(TUTOR_USER);
            this.user = (User) savedInstanceState.getSerializable(USER);
            this.name = savedInstanceState.getString(NAME);
            this.rateString = savedInstanceState.getString(RATE);
            this.ratePerHour = savedInstanceState.getDouble(RATE_PER_HOUR);
            this.currency = (Currency) savedInstanceState.getSerializable(CURRENCY);
            this.isRemote = savedInstanceState.getBoolean(REMOTE);
            this.zipCode = savedInstanceState.getInt(ZIP_CODE);
            this.numStudents = savedInstanceState.getInt(NUM_STUDENTS);
            this.isRemoteString = savedInstanceState.getString(IS_REMOTE);
            this.teachingListString = savedInstanceState.getString(TEACHING_LIST);
            this.learningListString = savedInstanceState.getString(LEARNING_LIST);

        }

        // retrieve user library
        this.persistenceFacade.retrieveUserLibrary(new IPersistenceFacade.DataListener<UserLibrary>() {
            @Override
            public void onDataReceived(@NonNull UserLibrary ul) {
                SetupActivity.this.ul = ul;

            }
            @Override
            public void onNoDataFound() { }
        });

        mainView = new MainView(this);
        setContentView(mainView.getRootView());

        // display the first fragment
        if (savedInstanceState == null || !savedInstanceState.getBoolean(IN_PROGRESS))
            // display the add name fragment
            this.mainView.displayFragment(AddNameFragment.class, null,false);



//        Map<String, Object> tmap = new HashMap<>();
//        tmap.put("testkey", "testbslr");
//        // put the user document in the database
//        CollectionReference cref = db.collection("test-collection");
//        DocumentReference dref = cref.document();
//        Log.i("EduBuddy", dref.getId());
//        dref.set(tmap, SetOptions.merge());

    }

    @Override
    public void onAddedUser(String fullName) {
        user = new User(fullName);
        ul.addUser(user);

        // swap fragment
        this.mainView.displayFragment(new AddEmailPasswordFragment(this), true);

        // put in database
      //  userMapData.put("name", user.getName());
    }

    @Override
    public void onEditedEmail(String email, String password) {

        user.setEmail(email);
        user.setPassword(password);

        // swap fragment
        this.mainView.displayFragment(new AddBirthdayFragment(this), true);

        // put in database
     //   userMapData.put("email", user.getEmail());
     ///   userMapData.put("password", user.getPassword());
    }

    @Override
    public void onEditedBirthday(int birthYear) {
        user.setBirthYear(birthYear);

        // swap fragment
        this.mainView.displayFragment(new PickModeFragment(this), true);

        // put in database
      ///  userMapData.put("birthYear", user.getBirthYear());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(IN_PROGRESS, true);
        outState.putSerializable(USER_LIBRARY, this.ul);
        // save current user
        outState.putSerializable(USER, this.user);
        outState.putSerializable(TUTOR_USER, this.tutorUser);
        // user info
        outState.putString(NAME, this.name);
        outState.putString(RATE, this.rateString);
        outState.putDouble(RATE_PER_HOUR, this.ratePerHour);
        outState.putString(IS_REMOTE, this.isRemoteString);
        outState.putBoolean(REMOTE, this.isRemote);
        outState.putSerializable(CURRENCY, this.currency);
        outState.putString(TEACHING_LIST, this.teachingListString);
        outState.putString(LEARNING_LIST, this.learningListString);
        outState.putBoolean(IS_TUTOR, this.isTutor);


    }

    @Override
    public void onPickedStudent() {
        this.ul.addUser(user);
        this.persistenceFacade.saveUser(user);
        this.mainView.displayFragment(new SearchSubjectFragment(this), true);
    }


    @Override
    public void onPickedTutor() {
        // TODO: swap fragment
        isTutor = true;
        this.mainView.displayFragment(new TutorInfoFragment(this), true);
    }

    @Override
    public void onAddedTutorInfo(double ratePerHour, int numStudents, Currency currency,
                                 int zipCode, boolean isRemote, Subject teachingSubject) {
        tutorUser = new TutorUser(user, ratePerHour, numStudents, currency, zipCode, isRemote);

        // process info
        name = tutorUser.getName();
        this.ratePerHour = ratePerHour;
        this.currency = currency;
        rateString = tutorUser.makeRateString();
        isRemoteString = tutorUser.makeIsRemoteString();
        tutorUser.getTeachingList().add(teachingSubject);
        teachingListString = tutorUser.makeTeachingSubjectListString();
        learningListString = tutorUser.makeLearningSubjectListString();

        //Display information edited
      Bundle fragArgs = AccountFragment.makeArgsBundle(name, rateString, isRemoteString, teachingListString, learningListString, zipCode, numStudents);
        Fragment fragment = new AccountFragment(this);
        fragment.setArguments(fragArgs);

        // swap fragment
        this.mainView.displayFragment(AccountFragment.class, fragArgs, true);

        this.ul.addUser(tutorUser);
        this.persistenceFacade.saveTutorUser(tutorUser);

//        // put in database
//        java.util.Map<String, Object> userMapData = tutorUser.toMap();
//
//        // put the user document in the database
//        CollectionReference cref = db.collection("users");
//        DocumentReference dref = cref.document();
//        Log.i("EduBuddy", dref.getId());
//        dref.set(userMapData, SetOptions.merge());
    }

    @Override
    public void onEditAccount() {
        // TODO: swap fragment
        //, this.name, this.ratePerHour,
        //        this.currency, this.isRemote, this.teachingListString, this.learningListString,
        //        tutorUser.getZipCode(), tutorUser.getNumStudents()
        Bundle fragArgs = EditAccountFragment.makeArgsBundle(this.name, this.ratePerHour, this.currency, this.isRemote,this.teachingListString, this.learningListString,tutorUser.getZipCode(), tutorUser.getNumStudents());

        this.mainView.displayFragment(EditAccountFragment.class, fragArgs, true);
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

        // Display information edit
        Bundle fragArgs = AccountFragment.makeArgsBundle(name, rateString, isRemoteString, teachingListString, learningListString, zipCode, numStudents);
       Fragment fragment = new AccountFragment(this);
       fragment.setArguments(fragArgs);

        // Display information edited
        this.mainView.displayFragment(AccountFragment.class, fragArgs, true);
    }

    public void onShowProfile(String userName) {
        for (User u : ul.getUsers()){
            if (u.getName().equals(userName)){
                TutorUser tutorUser = (TutorUser) u;
                this.mainView.displayFragment(new ProfileFragment(this, tutorUser.getName(), tutorUser.makeRateString(), tutorUser.makeIsRemoteString(), tutorUser.makeTeachingSubjectListString(), tutorUser.makeLearningSubjectListString(), tutorUser.getZipCode(), tutorUser.getNumStudents()), true);
            }
        }
    }

    @Override
    public void onSendRequest() {

        // display SendRequestFragment
        this.mainView.displayFragment(new SendRequestFragment(this), true);
        // query for the user
        // update the request
    }
}