package com.example.myapplication.view;
/**
 * An interface specifying methods for editing user profile functionality
 *
 */

import com.example.myapplication.model.Currency;

public interface IEditAccountView {

    interface Listener {

        /**
         * This method update user old profile with the new information they input
         */
        void onFinishedEditingAccount(double ratePerHour, int numStudents, Currency currency,
                                      int zipCode, boolean isRemote, String name);

    }

}
