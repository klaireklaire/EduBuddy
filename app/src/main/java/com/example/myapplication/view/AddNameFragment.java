package com.example.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentAddNameBinding;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class AddNameFragment extends Fragment implements IAddNameView {

    private FragmentAddNameBinding binding;
    private IAddNameView.Listener listener;
    String firstName;
    String lastName;

    public AddNameFragment(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentAddNameBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        this.binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // get first name
                Editable firstNameText = AddNameFragment.this.binding.editFirstName.getText();
                firstName = firstNameText.toString();

                // get last name
                Editable lastNameText = AddNameFragment.this.binding.editLastName.getText();
                lastName = lastNameText.toString();

                // confirm we have both last name and first name
                if (firstName.length() == 0 || lastName.length() == 0) {
                    Snackbar.make(view, "Both first name and last name are mandatory!",
                            Snackbar.LENGTH_LONG).show();
                    return;
                }

                String fullName = firstName + " " + lastName;

//                firstNameText.clear();
//                lastNameText.clear();

                // let view listener know that it should add a new user
                AddNameFragment.this.listener.onAddedUser(fullName);
            }
        });

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("firstName", firstName);
        outState.putString("lastName", lastName);

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if (savedInstanceState != null) {// restore saved state from bundle
            this.firstName = savedInstanceState.getString("firstName");
            this.lastName = savedInstanceState.getString("lastName");
        }

    }
}
