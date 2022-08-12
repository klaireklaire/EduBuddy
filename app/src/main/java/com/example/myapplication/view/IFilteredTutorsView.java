package com.example.myapplication.view;

import com.example.myapplication.model.SubjectLevel;
import com.example.myapplication.model.User;
import com.example.myapplication.model.UserLibrary;

/**
 * An interface specifying method to view tutors detailed profile
 *
 */
public interface IFilteredTutorsView {
    interface Listener {
        /**
         * This method finds the tutor information that student click on within the user library and displays the tutor profile
         * @param userName
         */
        void onShowProfile(String userName);


    }



}
