package com.example.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentAddEmailPasswordBinding;
import com.example.myapplication.databinding.FragmentAddNameBinding;
import com.example.myapplication.model.User;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddEmailPasswordFragment} factory method to
 * create an instance of this fragment.
 */
public class AddEmailPasswordFragment extends Fragment implements IAddEmailPasswordView {

    private FragmentAddEmailPasswordBinding binding;
    private IAddEmailPasswordView.Listener listener;

    public AddEmailPasswordFragment(IAddEmailPasswordView.Listener listener) {
        this.listener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentAddEmailPasswordBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){

        this.binding.nextButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // get email
                Editable emailText = AddEmailPasswordFragment.this.binding.editEmail.getText();
                String email = emailText.toString();

                // get password
                Editable passwordText = AddEmailPasswordFragment.this.binding.editPassword.getText();
                String password = passwordText.toString();

                // confirm we have both email and password
                if (email.length() == 0 || password.length() == 0) {
                    Snackbar.make(view, "Both email and password are mandatory!",
                            Snackbar.LENGTH_LONG).show();
                    return;
                }

//                emailText.clear();
//                passwordText.clear();

                // Let view listener know that it needs to edit the field of the existing User object
                 AddEmailPasswordFragment.this.listener.onEditedEmail(email, password);
            }
        });

    }

}