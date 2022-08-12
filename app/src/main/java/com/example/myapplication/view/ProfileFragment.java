package com.example.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentAccountBinding;
import com.example.myapplication.databinding.FragmentProfileBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment implements IProfileView {

    private FragmentProfileBinding binding;
    private IProfileView.Listener listener;

    // fields from User object to display
    String name;
    String rateString;
    String isRemoteString;
    String teachingListString;
    String learningListString;
    int zipCode;
    int numStudents;

    public ProfileFragment(IProfileView.Listener listener, String name, String rateString,
                           String isRemoteString, String teachingListString,
                           String learningListString, int zipCode, int numStudents) {
        this.listener = listener;
        this.name = name;
        this.rateString = rateString;
        this.zipCode = zipCode;
        this.isRemoteString = isRemoteString;
        this.numStudents = numStudents;
        this.teachingListString = teachingListString;
        this.learningListString = learningListString;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentProfileBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){

        // display profile information
        this.binding.nameLabel.setText(this.name);
        this.binding.rateLabel.setText(this.rateString);
        this.binding.zipCodeDisplayText.setText("" + this.zipCode);
        this.binding.remoteDisplayText.setText(this.isRemoteString);
        this.binding.numStudentsDisplayText.setText("" + this.numStudents);
        this.binding.teachingSubjectsText.setText(this.teachingListString);
        this.binding.learningSubjectsText.setText(this.learningListString);

        // TODO: onClick method for sendRequestButton
        this.binding.sendRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Let view listener know that it needs to swap fragment
                ProfileFragment.this.listener.onSendRequest();
            }
        });

    }

}