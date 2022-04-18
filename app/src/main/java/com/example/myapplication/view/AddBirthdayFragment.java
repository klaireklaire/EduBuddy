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
import com.example.myapplication.databinding.FragmentAddEmailPasswordBinding;
import com.example.myapplication.model.User;
import com.google.android.material.snackbar.Snackbar;

import java.time.Year;
import java.time.ZoneId;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddBirthdayFragment} factory method to
 * create an instance of this fragment.
 */
public class AddBirthdayFragment extends Fragment implements IAddBirthdayView {

    private FragmentAddBirthdayBinding binding;
    private IAddBirthdayView.Listener listener;

    private ZoneId zone = ZoneId.systemDefault();
    private Year year = Year.now(zone);
    private int yearNumber = year.getValue();

    public AddBirthdayFragment(IAddBirthdayView.Listener listener) {
        this.listener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentAddBirthdayBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){

        this.binding.nextButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // get birth year
                Editable birthYearText = AddBirthdayFragment.this.binding.editBirthYear.getText();
                String birthYearStr = birthYearText.toString();

                int birthYear = Integer.parseInt(birthYearStr);

                // confirm we have birth year
                if (birthYearStr.length() != 4) {
                    Snackbar.make(view, "Enter birth year per the format suggested.",
                            Snackbar.LENGTH_LONG).show();
                    return;
                } else if (yearNumber - birthYear < 13) {
                    Snackbar.make(view, "You must be at least 13 years old to use this app.",
                            Snackbar.LENGTH_LONG).show();
                    return;
                }

//                birthYearText.clear();

                // Let view listener know that it needs to edit the field of the existing User object
                AddBirthdayFragment.this.listener.onEditedBirthday(birthYear);
            }
        });

    }

}