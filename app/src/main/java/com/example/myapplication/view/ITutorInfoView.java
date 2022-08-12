package com.example.myapplication.view;

import com.example.myapplication.model.Currency;
import com.example.myapplication.model.User;
import com.example.myapplication.model.Subject;
/**
 * An interface displaying tutor's editing required profile information
 *
 */
public interface ITutorInfoView {

    interface Listener {
        /**
         * This method requests tutor to input additional information to complete tutor profile
         * @param ratePerHour
         * @param numStudents
         * @param currency
         * @param zipCode
         * @param isRemote
         * @param teachingSubject
         */
        void onAddedTutorInfo(double ratePerHour, int numStudents, Currency currency, int zipCode, boolean isRemote, Subject teachingSubject);
    }

}
