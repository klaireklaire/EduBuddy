package com.example.myapplication.view;

import com.example.myapplication.model.User;
/**
 * An interface taking user input: email and password
 *
 */

public interface IAddEmailPasswordView {

    interface Listener {
        /**
         * This method updates user email and password, allows user to log in
         * @param email
         * @param password
         */
        void onEditedEmail(String email, String password);
    }

}
