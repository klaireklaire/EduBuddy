package com.example.myapplication.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class SubjectFilter implements IFilter, Serializable {

    Subject teachingSubject;

    public SubjectFilter(SubjectLevel subjectLevel, String subject) {
        this.teachingSubject = new Subject(subject, subjectLevel);
    }


    /**
     * Return a new set of tutors that only contains tutors that match the list of teaching subjects
     * @param users - the tutors set being filtered
     * @return a new set of users
     */
    @Override
    public HashSet<User> filter(HashSet<User> users) {
        HashSet<User> resUsers = new HashSet<User>();
        for (User user : users) {
            if (user.teachingList.contains(this.teachingSubject)) {
                resUsers.add(user);
            }
        }
        return resUsers;
    }
}
