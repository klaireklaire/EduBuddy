package com.example.myapplication.model;

import android.provider.ContactsContract;

import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Serializable;
import java.util.*;

public class UserLibrary implements Serializable {

    // fields
    HashSet<User> users;
    HashSet<TutorUser> tutorUsers;
//    private EmailEnter emailEnter;
//
//    public EmailEnter getEmailEnter() { return emailEnter; }
//    public void setEmailEnter(EmailEnter emailEnter) { this.emailEnter = emailEnter; }

    // constructors
    public UserLibrary() {
        this.users = new HashSet<User>();
        initTestUsers();
    }

    public UserLibrary(HashSet<User> users) { this.users = users; }

    public UserLibrary(User u) {
        this.users = new HashSet<User>();
        this.users.add(u);
    }


    public UserLibrary addUser(User user) {
        this.users.add(user);

        return this;
    }




    public HashSet<User> filterUsers(List<IFilter> fl) {

        HashSet<User> resUsers = this.users;

        for (IFilter f : fl) {
            resUsers = f.filter(resUsers);
        }

        return resUsers;

    }


    void initTestUsers(){

       Set<Subject> testLearning = new HashSet<>();
       Set<Subject> testTeaching = new HashSet<>();
       Set<Subject> testLearning1 = new HashSet<>();
       Set<Subject> testTeaching1 = new HashSet<>();
       Set<Subject> testLearning2 = new HashSet<>();
       Set<Subject> testTeaching2 = new HashSet<>();


       Subject HIGH_SCHOOL_LITERATURE = new Subject("Literature", SubjectLevel.HIGH_SCHOOL);
       Subject HIGH_SCHOOL_MATH = new Subject("Math", SubjectLevel.HIGH_SCHOOL);
       Subject HIGH_SCHOOl_ENGLISH = new Subject("English", SubjectLevel.HIGH_SCHOOL);

       testTeaching.add(HIGH_SCHOOl_ENGLISH);
       testLearning.add(HIGH_SCHOOL_LITERATURE);
       testTeaching1.add(HIGH_SCHOOL_LITERATURE);
       testLearning1.add(HIGH_SCHOOl_ENGLISH);
       testTeaching2.add(HIGH_SCHOOl_ENGLISH);

       User user0 = new TutorUser(
               "a@gmail.com",
               "123456",
               "Khanh Le",
               2002,
               true,
               12604,
               testLearning,
               testTeaching, 15.00,
               4,
               Currency.USD);

       User user1 = new TutorUser(
               "user1@gmail.com",
               "user1password",
               "Brooklynn Pierce",
               2003,
               true,
               10101,
               testLearning1,
               testTeaching1,
               13.25,
               3,
               Currency.USD);

       User user2 = new TutorUser(
               "user2@gmail.com",
               "user2password",
               "Karli Cardenas",
               2002,
               true,
               13453,
               testLearning2,
               testTeaching2,
               15.00,
               4,
               Currency.USD);

       User user3 = new TutorUser("user3@gmail.com", "user3password", "Camden Hardin", 2000,
               true, 15672, testLearning1, testTeaching,20.00,
               3,
               Currency.USD );

       User user4 = new TutorUser("user4@gmail.com", "user4password", "Lee Blankenship", 2000,
               true, 16527, testLearning2, testTeaching, 25.00,
               7,
               Currency.USD);

       User user5 = new TutorUser("user5@gmail.com", "user5password", "Hara Lee", 1999,
               true, 16527, testLearning2, testTeaching, 15.00,
               4,
               Currency.USD);


       this.users.add(user0);
       this.users.add(user1);
       this.users.add(user2);
       this.users.add(user3);
       this.users.add(user4);
       this.users.add(user5);


   }

    @Override
    public String toString() {

        HashSet<User> thisUsers = this.users;
        String res = "Your search returns: \n";

        for (User user : thisUsers) {
            res += user.name + "\n";
        }

        return res;
    }

    public HashSet<User> getUsers() { return users; }
    public HashSet<TutorUser> getTutorUsers() { return tutorUsers;}

    //public HashSet<TutorUser> getTutorUsers() { return users; }

//    public void addUser(String email, String password) {
//        User user = new User();
//    }

//    HashSet<User> filterUsers(List<IFilter> fl) {
//
//        HashSet<User> resUsers = this.users;
//
//        for (IFilter f : fl) {
//            resUsers = f.filter(resUsers);
//        }
//
//        return resUsers;
//
//    }

 //   public static void main(String[] args) {
//        UserLibrary test = new UserLibrary();
//
//        Set<Subject> testLearning = new HashSet<>();
//        Set<Subject> testTeaching = new HashSet<>();
//        Set<Subject> testLearning1 = new HashSet<>();
//        Set<Subject> testTeaching1 = new HashSet<>();
//        Set<Subject> testLearning2 = new HashSet<>();
//        Set<Subject> testTeaching2 = new HashSet<>();
//
//
//        Subject HIGH_SCHOOL_LITERATURE = new Subject("Literature", SubjectLevel.HIGH_SCHOOL);
//        Subject HIGH_SCHOOL_MATH = new Subject("Math", SubjectLevel.HIGH_SCHOOL);
//        Subject HIGH_SCHOOl_ENGLISH = new Subject("English", SubjectLevel.HIGH_SCHOOL);
//
//        testTeaching.add(HIGH_SCHOOl_ENGLISH);
//        testLearning.add(HIGH_SCHOOL_LITERATURE);
//        testTeaching1.add(HIGH_SCHOOL_LITERATURE);
//        testLearning1.add(HIGH_SCHOOl_ENGLISH);
//        testTeaching2.add(HIGH_SCHOOl_ENGLISH);

//        User user0 = new User(
//                "a@gmail.com",
//                "123456",
//                "Khanh Le",
//                19,
//                "College",
//                "Female",
//                true,
//                "Poughkeepsie",
//                testLearning,
//                testTeaching);
//
//        User user1 = new TutorUser(
//                "user1@gmail.com",
//                "user1password",
//                "Brooklynn Pierce",
//                17,
//                "High",
//                "Female",
//                true,
//                "USA",
//                testLearning1,
//                testTeaching1,
//                13.25,
//                3);
//
//        User user2 = new TutorUser(
//                "user2@gmail.com",
//                "user2password",
//                "Karli Cardenas",
//                17, "College",
//                "Male",
//                true,
//                "USA",
//                testLearning2,
//                testTeaching2,
//                15.00,
//                4);
//
//        User user3 = new TutorUser("user3@gmail.com", "user3password", "Camden Hardin", 19, "Middle", "Male",
//                true, "USA", testLearning1, testTeaching, 5.00, 2);
//
//        User user4 = new TutorUser("user4@gmail.com", "user4password", "Lee Blankenship", 19, "Other", "Female",
//                true, "USA", testLearning2, testTeaching, 12.5, 1);
//
//        User user5 = new TutorUser("user5@gmail.com", "user5password", "Hara Lee", 20, "Other", "Female",
//                true, "Germany", testLearning2, testTeaching, 11.00, 6);
//
//
//        test.users.add(user0);
//        test.users.add(user1);
//        test.users.add(user2);
//        test.users.add(user3);
//        test.users.add(user4);
//        test.users.add(user5);


        // Set<User> result = test.filter(user -> user.age == 19 && user.teachingList.contains(HIGH_SCHOOl_ENGLISH));

        // TO DO: Test: AgeFilter
//        AgeFilter ageFilter = new AgeFilter(17);
//        List<IFilter> filters = new ArrayList<>();
//
//        filters.add(ageFilter);
//        HashSet<User> newUsers = test.filterUsers(filters);
//        UserLibrary newUserLib = new UserLibrary(newUsers);
//
//        System.out.println(newUsers.size());
//        System.out.println(newUserLib);

    }

