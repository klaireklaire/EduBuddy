package com.example.myapplication.model;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Subject implements Serializable {

    // fields
    public String subjectName;
    public SubjectLevel subjectLevel;

    public Subject(String subjectName, SubjectLevel subjectLevel) {
        this.subjectName = subjectName;
        this.subjectLevel = subjectLevel;
    }

    public Subject() { }

    // methods

    @NonNull
    public Map<String,Object> toMap() {
        Map<String,Object> map = new HashMap<>();
        map.put("subjectName", subjectName);
        map.put("subjectLevel", subjectLevel);
        return map;
    }

    public static Subject fromMap(@NonNull Map<String, Object> map) {
        String subjectName = (String) map.get("subjectName");
        String subjectLevelString = (String) map.get("subjectLevel");
        SubjectLevel subjectLevel = SubjectLevel.valueOf(subjectLevelString.toUpperCase());
        return new Subject(subjectName, subjectLevel);
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Subject)) return false;
        Subject newSubject = (Subject) o;
        return (this.subjectName.equals(newSubject.subjectName) && this.subjectLevel == newSubject.subjectLevel);

    }

    @Override
    public int hashCode() {
        return (subjectName + subjectLevel).hashCode();
    }

    @Override
    public String toString() {

        String result = "";

        result += this.subjectName + ", ";

        switch (this.subjectLevel) {

            case PRIMARY:
                result += "Primary level";
                break;

            case MIDDLE_SCHOOL:
                result += "Middle school level";
                break;

            case HIGH_SCHOOL:
                result += "High school level";
                break;

            case COLLEGE:
                result += "College level";
                break;

        }

        return result;

    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public SubjectLevel getSubjectLevel() {
        return subjectLevel;
    }

    public void setSubjectLevel(SubjectLevel subjectLevel) {
        this.subjectLevel = subjectLevel;
    }
}