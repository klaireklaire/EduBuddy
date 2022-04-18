package com.example.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentAddBirthdayBinding;
import com.example.myapplication.databinding.FragmentPickModeBinding;
import com.example.myapplication.model.User;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PickModeFragment} factory method to
 * create an instance of this fragment.
 */
public class PickModeFragment extends Fragment implements IPickModeView {

    private FragmentPickModeBinding binding;
    private IPickModeView.Listener listener;
    private User user;

    public PickModeFragment(IPickModeView.Listener listener) {
        this.listener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentPickModeBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){

        // user click on studentButton
        this.binding.studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TODO: just swap fragment to addSubject (no additional steps for student user)
                PickModeFragment.this.listener.onPickedStudent();

            }
        });

        // user click on tutorButton
        this.binding.tutorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TODO: convert User object to TutorUser (populate new fields)
                PickModeFragment.this.listener.onPickedTutor();

            }
        });

        // user click on bothButton
        this.binding.bothButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TODO: convert User object to TutorUser (populate new fields)
                PickModeFragment.this.listener.onPickedTutor();

            }
        });

    }

}