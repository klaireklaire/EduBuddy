package com.example.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentPickModeBinding;
import com.example.myapplication.databinding.FragmentTutorInfoBinding;
import com.example.myapplication.model.Currency;
import com.example.myapplication.model.User;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TutorInfoFragment} factory method to
 * create an instance of this fragment.
 */
public class TutorInfoFragment extends Fragment {

    private FragmentTutorInfoBinding binding;
    private ITutorInfoView.Listener listener;
    boolean isRemote;

    public TutorInfoFragment(ITutorInfoView.Listener listener) {
        this.listener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentTutorInfoBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){

        this.binding.nextButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // get preferred rate per hour
                Editable rateText = TutorInfoFragment.this.binding.editRate.getText();
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
                Editable numStudentsText = TutorInfoFragment.this.binding.editNumStudents.getText();
                String numStudentsStr = numStudentsText.toString();

                int numStudents;

                try {
                    numStudents = Integer.parseInt(numStudentsStr);
                } catch (NumberFormatException e) {
                    Snackbar.make(view, "Please put 0 if you want to skip fields.",
                            Snackbar.LENGTH_LONG).show();
                    return;
                }

                // get currency
                Editable currencyText = TutorInfoFragment.this.binding.editCurrency.getText();
                String currencyStr = currencyText.toString();

                Currency currency = Currency.USD;

                if (currencyStr.compareTo("VND") == 0) {
                    currency = Currency.VND;
                }

                // get zipcode
                Editable numZipcode = TutorInfoFragment.this.binding.editZipcode.getText();
                String numZipcodeStr = numZipcode.toString();

                int zipCode;

                try {
                    zipCode = Integer.parseInt(numZipcodeStr);
                } catch (NumberFormatException e) {
                    Snackbar.make(view, "Please put 0 if you want to skip fields.",
                            Snackbar.LENGTH_LONG).show();
                    return;
                }

                // get isRemote
                boolean isRemote = TutorInfoFragment.this.binding.remoteCheckBox.isChecked();

                // confirm we have all fields
                if (rateStr.length() == 0 || numStudentsStr.length() == 0 ||
                        currencyStr.length() == 0 || numZipcodeStr.length() == 0) {
                    Snackbar.make(view, "Please enter all fields.",
                            Snackbar.LENGTH_LONG).show();
                    return;
                } else if (ratePerHour == 0 || numStudents == 0) {
                    Snackbar.make(view, "Inputs need to be greater than zero.",
                            Snackbar.LENGTH_LONG).show();
                    return;
                } else if (currencyStr.compareTo("USD") != 0 && currencyStr.compareTo("VND") != 0) {
                    Snackbar.make(view, "EduBuddy currently only supports USD and VND.",
                            Snackbar.LENGTH_LONG).show();
                    return;
                }

//                numStudentsText.clear();
//                rateText.clear();
//                currencyText.clear();
//                numZipcode.clear();

                // Convert User to TutorUser and add new fields
                TutorInfoFragment.this.listener.onAddedTutorInfo(ratePerHour, numStudents, currency, zipCode, isRemote);
            }
        });

    }

}