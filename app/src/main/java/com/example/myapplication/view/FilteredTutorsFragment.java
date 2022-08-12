package com.example.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentFilteredTutorsBinding;
import com.example.myapplication.model.SubjectLevel;
import com.example.myapplication.model.User;
import com.example.myapplication.model.UserLibrary;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FilteredTutorsFragment} factory method to
 * create an instance of this fragment.
 */
public class FilteredTutorsFragment extends Fragment implements  IFilteredTutorsView {

    private FragmentFilteredTutorsBinding binding;
    private IFilteredTutorsView.Listener listener;
    private UserLibrary ul;
    ListView tutorList;

    // TODO: Rename and change types of parameters


    public FilteredTutorsFragment(IFilteredTutorsView.Listener listener, UserLibrary ul) {
        this.listener = listener;
        this.ul = ul;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentFilteredTutorsBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        ListView tutorList = binding.tutorList;
        ArrayList<String> nameList = new ArrayList<>();
        HashSet<User> users = ul.getUsers();
        for(User u: users){
            nameList.add(u.getName());
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.getContext(), android.R.layout.simple_list_item_1, nameList);

        tutorList.setAdapter(arrayAdapter);

        // Handling Click Events in ListView

        tutorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FilteredTutorsFragment.this.listener.onShowProfile((String) arrayAdapter.getItem(i));


            }
        });

    }

}