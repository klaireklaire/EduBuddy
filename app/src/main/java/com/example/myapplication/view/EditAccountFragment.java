package com.example.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentAccountBinding;
import com.example.myapplication.databinding.FragmentEditAccountBinding;
import com.example.myapplication.model.Currency;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditAccountFragment} factory method to
 * create an instance of this fragment.
 */
public class EditAccountFragment extends Fragment implements IEditAccountView {

    private FragmentEditAccountBinding binding;
    private IEditAccountView.Listener listener;
    private static final String NAME = "name";
    private static final String IS_REMOTE = "isRemoteString";
    private static final String CURRENCY = "currency";
    private static final String RATE_PER_HOUR = "rateperhour";

    private static final String TEACHING_LIST = "teachingListString";
    private static final String LEARNING_LIST = "learningListString";
    private static final String ZIP_CODE = "zipCode";
    private static final String NUM_STUDENTS = "numStudents";

    // fields from User object to display
    String name;
    double ratePerHour;
    Currency currency;
    boolean isRemote;
    String teachingListString;
    String learningListString;
    int zipCode;
    int numStudents;

    public EditAccountFragment(IEditAccountView.Listener listener) {
        //, String name, double ratePerHour, Currency currency,
       // boolean isRemote, String teachingListString,
        //        String learningListString, int zipCode, int numStudents
        this.listener = listener;
//        this.name = name;
//        this.ratePerHour = ratePerHour;
//        this.currency = currency;
//        this.zipCode = zipCode;
//        this.isRemote = isRemote;
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
            this.isRemote = args.getBoolean(IS_REMOTE);
            this.currency = (Currency) args.getSerializable(CURRENCY);
            this.ratePerHour = args.getDouble(RATE_PER_HOUR);
            this.teachingListString = args.getString(TEACHING_LIST);
            this.learningListString = args.getString(LEARNING_LIST);
            this.zipCode = args.getInt(ZIP_CODE);
            this.numStudents = args.getInt(NUM_STUDENTS);
        } else {
            this.name = "Your name";
            this.isRemote = false;
            this.currency = Currency.VND;
            this.ratePerHour = 0;
            this.teachingListString = "";
            this.learningListString = "";
            this.zipCode = 0;
            this.numStudents = 0;
        }
    }


    public static Bundle makeArgsBundle(String name, Double ratePerHour, Currency currency, Boolean isRemote,  String teachingListString, String learningListString, int zipCode, int numStudents){
        Bundle args = new Bundle();
        args.putString(NAME, name);
        args.putBoolean(IS_REMOTE, isRemote);
        args.putDouble(RATE_PER_HOUR, ratePerHour);
        args.putSerializable(CURRENCY, currency);
        args.putString(TEACHING_LIST, teachingListString);
        args.putString(LEARNING_LIST, learningListString);
        args.putInt(ZIP_CODE, zipCode);
        args.putInt(NUM_STUDENTS, numStudents);
        return args;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentEditAccountBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){

        // display pre-populated information
        this.binding.editProfileName.setText(this.name);
        this.binding.editProfileRate.setText("" + this.ratePerHour);

        String currencyStr = "";
        if (currency == Currency.USD) {
            currencyStr = "USD";
        } else { currencyStr = "VND"; }
        this.binding.editProfileCurrency.setText(currencyStr);

        this.binding.editProfileZipcode.setText("" + this.zipCode);
        this.binding.profileRemoteCheckbox.setChecked(isRemote);
        this.binding.editProfileNumStudents.setText("" + this.numStudents);
        this.binding.teachingSubjectsText.setText(this.teachingListString);
        this.binding.learningSubjectsText.setText(this.learningListString);

        this.binding.finishEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // fetch edits from user inputs
                // fetch edits from user inputs
                // get preferred rate per hour
                Editable rateText = EditAccountFragment.this.binding.editProfileRate.getText();
                String rateStr = rateText.toString();
                double ratePerHour;
                try {
                    ratePerHour = Double.parseDouble(rateStr);
                } catch (NumberFormatException e) {
                    Snackbar.make(view, "Please put 0 if you want to skip fields.",
                            Snackbar.LENGTH_LONG).show();
                    return;
                }

                // get maximum number of students
                Editable numStudentsText = EditAccountFragment.this.binding.editProfileNumStudents.getText();
                String numStudentsStr = numStudentsText.toString();
                int numStudents;
                try {
                    numStudents = Integer.parseInt(numStudentsStr);
                } catch (NumberFormatException e) {
                    Snackbar.make(view, "Please put 0 if you want to skip fields.",
                            Snackbar.LENGTH_LONG).show();
                    return;
                }

                // get zipcode
                Editable numZipcode = EditAccountFragment.this.binding.editProfileZipcode.getText();
                String numZipcodeStr = numZipcode.toString();
                int zipCode;
                try {
                    zipCode = Integer.parseInt(numZipcodeStr);
                } catch (NumberFormatException e) {
                    Snackbar.make(view, "Please put 0 if you want to skip fields.",
                            Snackbar.LENGTH_LONG).show();
                    return;
                }

                // get currency
                Editable currencyText = EditAccountFragment.this.binding.editProfileCurrency.getText();
                String currencyStr = currencyText.toString();
                Currency currency = Currency.USD;
                if (currencyStr.compareTo("VND") == 0) {
                    currency = Currency.VND;
                }

                // get isRemote
                boolean isRemote = EditAccountFragment.this.binding.profileRemoteCheckbox.isChecked();

                // get name
                Editable nameText = EditAccountFragment.this.binding.editProfileName.getText();
                String name = nameText.toString();

                // swap to AccountFragment with edited information
                EditAccountFragment.this.listener.onFinishedEditingAccount(ratePerHour, numStudents,
                        currency, zipCode, isRemote, name);

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