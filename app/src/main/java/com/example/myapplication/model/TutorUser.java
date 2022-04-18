package com.example.myapplication.model;

import androidx.annotation.NonNull;

import java.util.*;

public class TutorUser extends User{

    // fields
    double ratePerHour;
    int numStudents;
    Currency currency;

    // fields not relevant to this iteration yet
    // List<String> testimonies;

    /** Default constructor
     *
     */
    TutorUser(){

    }

    /*
    Constructor for a TutorUser object
     */
    public TutorUser(String email, String password, String name, int birthYear, Gender gender, boolean isRemote,
                     int zipCode, Set<Subject> teachingList, Set<Subject> learningList, double ratePerHour, int numStudents,
                     Currency currency) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
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
        this.gender = user.gender;
        this.isRemote = isRemote;
        this.zipCode = zipCode;
        this.teachingList = user.teachingList;
        this.learningList = user.learningList;
        this.ratePerHour = ratePerHour;
        this.numStudents = numStudents;
        this.currency = currency;
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