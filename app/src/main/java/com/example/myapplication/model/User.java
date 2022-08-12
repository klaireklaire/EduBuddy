package com.example.myapplication.model;

import androidx.annotation.NonNull;

import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Serializable;
import java.util.*;

/**
 * The Profile class represents all necessary information to make a new user. It stores the user's
 * login credentials and profile information. For the first iteration, fields not relevant to implementing the
 * filtered search features are omitted.
 *
 * @version 2022.04.04
 */

public class User implements Serializable {

    // fields
    /**
     * The user's email
     */
    String email;

    /**
     * The user's password
     */
    String password;

    /**
     * The user's name
     */
    String name;

    /**
     * The user's age
     */
    int birthYear;



    /**
     * True if the user can engage with the tutoring process remotely. False otherwise.
     */
    boolean isRemote;

    /**
     * The user's location
     */
    int zipCode;

    /**
     * List of subjects that the users want to teach
     */
    Set<Subject> teachingList = new HashSet<Subject>();

    /**
     * List of subjects that the users want to learn
     */
    Set<Subject> learningList = new HashSet<Subject>();

    // fields that are not relevant to this iteration yet
    // String bio;
    // String goals;
    // String awards;
    // List<EduHistory> eduList;

    /** Default constructor
     *
     */
    public User(){

    }

    // references strings for database access
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String NAME = "name";
    private static final String BIRTH_YEAR = "birthYear";
    private static final String IS_REMOTE = "isRemote";
    private static final String ZIP_CODE = "zipCode";
    private static final String TEACHING_LIST = "teachingList";
    private static final String LEARNING_LIST = "learningList";

    /**
     * Constructor for an on-set User object
     * @param name
     */
    public User(String name) {
        this.email = "";
        this.password = "";
        this.name = name;
        this.birthYear = 0;
        this.isRemote = false;
        this.zipCode = 10000;
        this.teachingList = new HashSet<Subject>();
        this.learningList = new HashSet<Subject>();
    }

    /**
     * Constructor for a User object
     * @param email User's email
     * @param password User's password
     * @param name User's full name
     * @param birthYear User's birth year
     * @param isRemote User's availability of teaching remotely
     * @param zipCode User's zip code
     * @param teachingList User's list of teaching subjects
     * @param learningList User's list of learning subjects
     */
    public User(String email, String password, String name, int birthYear, boolean isRemote,
                int zipCode, Set<Subject> teachingList, Set<Subject> learningList) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.birthYear = birthYear;
        this.isRemote = isRemote;
        this.zipCode = zipCode;
        this.teachingList = teachingList;
        this.learningList = learningList;
    }

    @NonNull
    public Map<String,Object> toMap() {
        Map<String,Object> map = new HashMap<>();
        map.put(EMAIL, email);
        map.put(PASSWORD, password);
        map.put(NAME, name);
        map.put(BIRTH_YEAR, birthYear);
        map.put(IS_REMOTE, isRemote);
        map.put(ZIP_CODE, zipCode);

        List<Map<String, Object>> tlArray = new LinkedList<>();
        int i = 0;
        for (Subject s : this.teachingList) tlArray.add(s.toMap());

        List<Map<String, Object>> llArray = new LinkedList<>();
        int j = 0;
        for (Subject s : this.learningList) llArray.add(s.toMap());

        map.put(TEACHING_LIST, tlArray);
        map.put(LEARNING_LIST, llArray);

        return map;
    }

    public static User fromMap(@NonNull Map<String, Object> map) {
        String email = (String) map.get(EMAIL);
        String password = (String) map.get(PASSWORD);
        String name = (String) map.get(NAME);
        long birthYear = (long) map.get(BIRTH_YEAR);
        int birthYearInt = Math.toIntExact(birthYear);
        boolean isRemote = (boolean) map.get(IS_REMOTE);
        long zipCode = (long) map.get(ZIP_CODE);
        int zipCodeInt = Math.toIntExact(zipCode);
        Set<Subject> teachingList = new HashSet<>();
        Set<Subject> learningList = new HashSet<>();

//        Map<String,Object>[] tlArray = (Map<String,Object>[]) map.get(TEACHING_LIST);
        ArrayList<Map<String, Object>> tlArray = (ArrayList<Map<String, Object>>) map.get(TEACHING_LIST);
        for (Map<String, Object> s : tlArray)
            teachingList.add(Subject.fromMap(s));

        ArrayList<Map<String, Object>> llArray = (ArrayList<Map<String, Object>>) map.get(LEARNING_LIST);
        for (Map<String, Object> s : llArray)
            learningList.add(Subject.fromMap(s));

        return new User(email, password, name, birthYearInt, isRemote, zipCodeInt, teachingList, learningList);
    }

//    public List<Subject> toList(Set<Subject> set) {
//        List<Subject> retlist = new ArrayList<>(set);
//        for (Subject s : set) {
//            retlist.add(s);
//        }
//
//        return retlist;
//    }
//
//    public static Set<Subject> toSet(Object list) {
//        Set<Subject> retset = new HashSet<>();
//        if (list instanceof ArrayList)  {
//            retset = new HashSet<Subject>((List<Subject>) list);
//        }
//        return retset;
//    }

    @Override
    public String toString() {

        String result = "";

        result += "Name: " + this.name;
        result += "\nBirth year: " + this.birthYear;

        result += "\nRemote tutoring available: ";
        if (this.isRemote) {
            result += "Yes";
        } else result += "No";

        result += "\nZipcode: " + this.zipCode;

        result += "\nTeaching subjects: ";
        for (Subject s : teachingList) {
            result += s.toString() + "; ";
        }

        result += "\nLearning subjects: ";
        for (Subject s : teachingList) {
            result += s.toString() + "; ";
        }

        return result;

    }

    public String makeIsRemoteString() {
        String isRemoteString = "";
        if (this.isRemote()) {
            isRemoteString = "Yes";
        } else {
            isRemoteString = "No";
        }

        return isRemoteString;
    }

    public String makeTeachingSubjectListString() {
        String teachingListString = "";
        int i = 0;
        for (Subject subject : this.teachingList) {
            if (i == this.teachingList.size() - 1) {
                teachingListString += subject.getSubjectName() + ".";
            } else {
                teachingListString += subject.getSubjectName() + ", ";
                i++;
            }
        }
        return teachingListString;
    }

    public String makeLearningSubjectListString() {
        String learningListString = "";
        int i = 0;
        for (Subject subject : this.learningList) {
            if (i == this.learningList.size() - 1) {
                learningListString += subject.getSubjectName() + ".";
            } else {
                learningListString += subject.getSubjectName() + ", ";
                i++;
            }
        }
        return learningListString;
    }

    /*
    Setter and Getter methods
     */

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }


    public boolean isRemote() {
        return isRemote;
    }

    public void setRemote(boolean remote) {
        isRemote = remote;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public Set<Subject> getTeachingList() {
        return teachingList;
    }

    public void setTeachingList(Set<Subject> teachingList) {
        this.teachingList = teachingList;
    }

    public Set<Subject> getLearningList() {
        return learningList;
    }

    public void setLearningList(Set<Subject> learningList) {
        this.learningList = learningList;
    }
}