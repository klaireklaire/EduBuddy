package com.example.myapplication.model;

import java.util.*;

/**
 * The Profile class represents all necessary information to make a new user. It stores the user's
 * login credentials and profile information. For the first iteration, fields not relevant to implementing the
 * filtered search features are omitted.
 *
 * @version 2022.04.04
 */

public class User {

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
     * The user's gender: Male, Female, and Other
     */
    Gender gender;

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

    /**
     * Constructor for an on-set User object
     * @param name
     */
    public User(String name) {
        this.email = "";
        this.password = "";
        this.name = name;
        this.birthYear = 0;
        this.gender = Gender.OTHER;
        this.isRemote = false;
        this.zipCode = 10000;
        this.teachingList = new HashSet<Subject>();
        this.learningList = new HashSet<Subject>();
    }

    /**
     * Constructor for a User object
     * @param email
     * @param password
     * @param name
     * @param birthYear
     * @param gender
     * @param isRemote
     * @param zipCode
     * @param teachingList
     * @param learningList
     */
    public User(String email, String password, String name, int birthYear, Gender gender, boolean isRemote,
                int zipCode, Set<Subject> teachingList, Set<Subject> learningList) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
        this.isRemote = isRemote;
        this.zipCode = zipCode;
        this.teachingList = teachingList;
        this.learningList = learningList;
    }

    @Override
    public String toString() {

        String result = "";

        result += "Name: " + this.name;
        result += "\nBirth year: " + this.birthYear;
        result += "\nGender: " + this.gender;

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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