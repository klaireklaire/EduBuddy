package com.example.myapplication.view;

import com.example.myapplication.model.Subject;
import com.example.myapplication.model.SubjectLevel;
import com.example.myapplication.model.User;

/**
 * An interface specifying subject filtering process
 *
 */
public interface ISearchSubjectView {
    interface Listener {
        /**
         * This method filters the user library, collects all tutors teaching the chosen subject and subject level and
         * displays the new list of filtered tutors
         * @param subject
         * @param subjectLevel
         */
        void onSubjectFilter(String subject, SubjectLevel subjectLevel);
    }
}
