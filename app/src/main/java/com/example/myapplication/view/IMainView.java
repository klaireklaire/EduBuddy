package com.example.myapplication.view;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;

public interface IMainView {

    public View getRootView();

    public void displayFragment(Fragment fragment, boolean allowBack);
    void displayFragment(Class<? extends Fragment> fragmentClass, Bundle args, boolean allowBack);
    Fragment getCurrentFragment();

}
