package com.example.myapplication.view;

import com.example.myapplication.model.User;
/**
 * An interface specifying methods for users option to tutor or learn
 *
 */
public interface IPickModeView {

    interface Listener {
        /**
         * This method leads student to the searching tutors screen
         */
        void onPickedStudent();

        /**
         * This method leads user to adding information required to tutor
         */
        void onPickedTutor();
    }

}
