package com.example.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentSearchSubjectBinding;
import com.example.myapplication.model.SubjectLevel;
import com.example.myapplication.model.User;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchSubjectFragment} factory method to
 * create an instance of this fragment.
 */
public class SearchSubjectFragment extends Fragment implements ISearchSubjectView {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private FragmentSearchSubjectBinding binding;
    private ISearchSubjectView.Listener listener;

    // TODO: Rename and change types of parameters
    public SubjectLevel subjectLevel;
    public String subject;

    public SearchSubjectFragment(ISearchSubjectView.Listener listener) {
        this.listener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentSearchSubjectBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        Spinner spinner = binding.subjectSpinner;
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(), R.array.subjects, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SearchSubjectFragment.this.subject = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(), subject, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner spinnerLevel = binding.levelSpinner;
        ArrayAdapter<CharSequence> adapterLevel = ArrayAdapter.createFromResource(this.getContext(), R.array.levels, android.R.layout.simple_spinner_item);
        adapterLevel.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerLevel.setAdapter(adapterLevel);
        spinnerLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String level = adapterView.getItemAtPosition(i).toString();
                Log.i("EduBuddy", level);

                if (level.equals("Elementary")){
                    SearchSubjectFragment.this.subjectLevel = SubjectLevel.PRIMARY;
                } else if (level.equals("Middle School")) {
                    SearchSubjectFragment.this.subjectLevel = SubjectLevel.MIDDLE_SCHOOL;
                } else if (level.equals("High School")) {
                    SearchSubjectFragment.this.subjectLevel = SubjectLevel.HIGH_SCHOOL;
                } else {
                    SearchSubjectFragment.this.subjectLevel = SubjectLevel.COLLEGE;
                }


                Toast.makeText(adapterView.getContext(), level, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });

        // user click on studentButton
        this.binding.findTutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TODO: just swap fragment to FilteredTutors (no additional steps for student user)
                SearchSubjectFragment.this.listener.onSubjectFilter(subject, subjectLevel);

            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("SUBJECT", subject);
        outState.putSerializable("SUBJECT_LEVEL", subjectLevel);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle saveInstanceState){
        super.onViewStateRestored(saveInstanceState);
        if (saveInstanceState != null) {
            this.subject = saveInstanceState.getString("SUBJECT");
            this.subjectLevel = (SubjectLevel) saveInstanceState.getSerializable("SUBJECT_LEVEL");
        }

    }
//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        String subject = adapterView.getItemAtPosition(i).toString();
//        Toast.makeText(adapterView.getContext(), subject, Toast.LENGTH_SHORT).show();
////        SearchSubjectFragment.this.listener.onSubjectFilter(user, subject);
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }

    }


