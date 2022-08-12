package com.example.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentAccountBinding;
import com.example.myapplication.databinding.FragmentEditAccountBinding;
import com.example.myapplication.model.Subject;

import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment implements IAccountView {

    private FragmentAccountBinding binding;
    private IAccountView.Listener listener;

    private static final String NAME = "name";
    private static final String IS_REMOTE = "isRemoteString";
    private static final String RATE_STRING = "rateString";
    private static final String TEACHING_LIST = "teachingListString";
    private static final String LEARNING_LIST = "learningListString";
    private static final String ZIP_CODE = "zipCode";
    private static final String NUM_STUDENTS = "numStudents";

    // fields from User object to display
    String name;
    String rateString;
    String isRemoteString;
    String teachingListString;
    String learningListString;
    int zipCode;
    int numStudents;


    public AccountFragment(IAccountView.Listener listener) {
        this.listener = listener;
//        this.name = name;
//        this.rateString = rateString;
//        this.zipCode = zipCode;
//        this.isRemoteString = isRemoteString;
//        this.numStudents = numStudents;
//        this.teachingListString = teachingListString;
//        this.learningListString = learningListString;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = this.getArguments();
        if (args != null) {
            this.name = args.getString(NAME);
            this.rateString = args.getString(RATE_STRING);
            this.zipCode = args.getInt(ZIP_CODE);
            this.isRemoteString = args.getString(IS_REMOTE);
            this.numStudents = args.getInt(NUM_STUDENTS);
            this.teachingListString = args.getString(TEACHING_LIST);
            this.learningListString = args.getString(LEARNING_LIST);
        }

    }

    public static Bundle makeArgsBundle(String name, String rateString, String isRemoteString, String teachingListString, String learningListString, int zipCode, int numStudents) {
        Bundle args = new Bundle();
        args.putString(NAME, name);
        args.putString(IS_REMOTE, isRemoteString);
        args.putString(RATE_STRING, rateString);
        args.putString(TEACHING_LIST, teachingListString);
        args.putString(LEARNING_LIST, learningListString);
        args.putInt(ZIP_CODE, zipCode);
        args.putInt(NUM_STUDENTS, numStudents);
        return args;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentAccountBinding.inflate(inflater);
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

        // onClick method for EditAccountButton
        this.binding.editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Let view listener know that it needs to swap fragment
                AccountFragment.this.listener.onEditAccount();
            }
        });

    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle saveInstanceState) {
        super.onViewStateRestored(saveInstanceState);

    }

}