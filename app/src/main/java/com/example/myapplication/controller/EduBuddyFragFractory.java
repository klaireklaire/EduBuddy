package com.example.myapplication.controller;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

import com.example.myapplication.view.AccountFragment;
import com.example.myapplication.view.FilteredTutorsFragment;
import com.example.myapplication.view.PickModeFragment;
import com.example.myapplication.view.SearchSubjectFragment;
import com.example.myapplication.view.EditAccountFragment;
import com.example.myapplication.view.AddBirthdayFragment;
import com.example.myapplication.view.AddNameFragment;
import com.example.myapplication.view.AddEmailPasswordFragment;
import com.example.myapplication.view.ProfileFragment;
import com.example.myapplication.view.TutorInfoFragment;

import java.util.Set;


public class EduBuddyFragFractory extends  FragmentFactory{

    private SetupActivity controller;

    public EduBuddyFragFractory(SetupActivity controller) { this.controller = controller;}

    /**
     * Method used by fragment manager/transaction to instantiate fragments.
     * @param classLoader object to use to load fragment class
     * @param className name of fragment class to instantiate
     * @return instantiated fragment
     */
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className) {

        Class<? extends Fragment> fragClass = loadFragmentClass(classLoader, className);

        if (fragClass == AccountFragment.class)
            return new AccountFragment(controller);
        else if (fragClass == SearchSubjectFragment.class)
            return new SearchSubjectFragment(controller);
        else if (fragClass == AddNameFragment.class)
            return new AddNameFragment(controller);
        else if (fragClass == AddBirthdayFragment.class)
            return new AddBirthdayFragment(controller);
        else if (fragClass == AddEmailPasswordFragment.class)
            return new AddEmailPasswordFragment(controller);
        else if (fragClass == TutorInfoFragment.class)
            return new TutorInfoFragment(controller);
        else if (fragClass == PickModeFragment.class)
            return new PickModeFragment(controller);
        else if (fragClass == EditAccountFragment.class)
            return new EditAccountFragment(controller);
//        else if (fragClass == AuthFragment.class)
//            return new AuthFragment(controller);
        else
            return super.instantiate(classLoader, className);
    }

}
