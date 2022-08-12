package com.example.myapplication.view;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.databinding.MainBinding;

public class MainView implements IMainView {

    FragmentActivity activity;
    MainBinding binding;

    public MainView(FragmentActivity activity) {
        this.activity = activity;
        this.binding = MainBinding.inflate(activity.getLayoutInflater());
    }

    @Override
    public View getRootView() {
        return this.binding.getRoot();
    }

    @Override
    public void displayFragment(Fragment fragment, boolean allowBack) {
        FragmentTransaction ft = this.activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(this.binding.fragmentContainerView.getId(), fragment);

        if (allowBack) ft.addToBackStack(null);

        ft.commit();
    }
    /**
     * Display fragment variant that takes in a fragment class and an arguments bundle,
     * instantiates such a fragment using the associated fragment factory, and displays it on
     * the fragment container.
     */
    @Override
    public void displayFragment(Class<? extends Fragment> fragmentClass, Bundle args, boolean allowBack) {
        FragmentManager fm = this.activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(this.binding.fragmentContainerView.getId(), fragmentClass, args);
        if (allowBack) ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public Fragment getCurrentFragment() {
        return this.binding.fragmentContainerView.getFragment();
    }

}
