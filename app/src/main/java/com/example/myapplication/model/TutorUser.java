package com.example.myapplication.model;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.*;

public class TutorUser extends User implements Serializable {

    // fields
    double ratePerHour;
    int numStudents;
    Currency currency;

    // fields not relevant to this iteration yet
    // List<String> testimonies;

    // references strings for database access
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String NAME = "name";
    private static final String BIRTH_YEAR = "birthYear";
    private static final String IS_REMOTE = "isRemote";
    private static final String ZIP_CODE = "zipCode";
    private static final String TEACHING_LIST = "teachingList";
    private static final String LEARNING_LIST = "learningList";
    private static final String RATE_PER_HOUR = "ratePerHour";
    private static final String NUM_STUDENTS = "numStudents";
    private static final String CURRENCY = "currency";

    /** Default constructor
     *
     */
    TutorUser(){

    }

    /*
    Constructor for a TutorUser object
     */
    public TutorUser(String email, String password, String name, int birthYear, boolean isRemote,
                     int zipCode, Set<Subject> teachingList, Set<Subject> learningList, double ratePerHour, int numStudents,
                     Currency currency) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.birthYear = birthYear;
        this.isRemote = isRemote;
        this.zipCode = zipCode;
        this.teachingList = teachingList;
        this.learningList = learningList;
        this.ratePerHour = ratePerHour;
        this.numStudents = numStudents;
        this.currency = currency;
    }

    /*
    Constructor that converts a User object to a TutorUser object
     */
    public TutorUser(User user, double ratePerHour, int numStudents, Currency currency,
                     int zipCode, boolean isRemote) {
        this.email = user.email;
        this.password = user.password;
        this.name = user.name;
        this.birthYear = user.birthYear;
        this.isRemote = isRemote;
        this.zipCode = zipCode;
        this.teachingList = user.teachingList;
        this.learningList = user.learningList;
        this.ratePerHour = ratePerHour;
        this.numStudents = numStudents;
        this.currency = currency;
    }

    @Override
    public Map<String,Object> toMap() {
        Map<String,Object> map = super.toMap();
        // fields related to tutor
        map.put(RATE_PER_HOUR, ratePerHour);
        map.put(NUM_STUDENTS, numStudents);
        map.put(CURRENCY, currency);
        return map;
    }



    public static TutorUser fromMap(@NonNull Map<String, Object> map) {
        User u = User.fromMap(map);

        boolean isRemote = (boolean) map.get(IS_REMOTE);
        long zipCode = (long) map.get(ZIP_CODE);
        int zipCodeInt = Math.toIntExact(zipCode);
        double ratePerHour = (double) map.get(RATE_PER_HOUR);
        long numStudentsLong = (long) map.get(NUM_STUDENTS);
        int numStudents = Math.toIntExact(numStudentsLong);
        String currencyString = (String) map.get(CURRENCY);
        Currency currency = Currency.valueOf(currencyString.toUpperCase());


        return new TutorUser(u, ratePerHour, numStudents, currency, zipCodeInt, isRemote);

    }

    /*
    Method: Produces textual representation of a TutorUser object
     */
    @NonNull
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

        result += "\nPreferred rate per hour tutoring: " + this.ratePerHour + " " + this.currency;
        result += "\nPreferred maximum number of students: " + this.numStudents;

        return result;

    }

    /*
    Getter methods
     */
    public double getRatePerHour() {
        return ratePerHour;
    }

    public int getNumStudents() {
        return numStudents;
    }

    public Currency getCurrency() {
        return currency;
    }

    /*
    Setter methods
     */
    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /*
    Maker methods
     */
    public String makeRateString() {
                    return this.ratePerHour + " " + this.currency;
                }

}