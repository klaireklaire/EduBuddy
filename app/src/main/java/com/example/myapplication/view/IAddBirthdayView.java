package com.example.myapplication.view;

import com.example.myapplication.model.User;

/**
 * An interface asking user input birth year
 *
 */
public interface IAddBirthdayView {

    interface Listener {
        /**
         * This method calculate the age of user by subtracting user input birth year from current year
         * @param birthYear
         */
        void onEditedBirthday(int birthYear);
    }

}