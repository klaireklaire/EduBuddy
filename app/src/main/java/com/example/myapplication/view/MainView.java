package com.example.myapplication.view;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
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
}
