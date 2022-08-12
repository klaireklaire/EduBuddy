package com.example.myapplication.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentSendRequestBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SendRequestFragment} factory method to
 * create an instance of this fragment.
 */
public class SendRequestFragment extends Fragment implements ISendRequestView {

    private FragmentSendRequestBinding binding;
    private ISendRequestView.Listener listener;

    FloatingActionButton add;
    AlertDialog dialog;
    LinearLayout layout;

    public SendRequestFragment(ISendRequestView.Listener listener) {
        this.listener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentSendRequestBinding.inflate(inflater);
        add = this.binding.addRequestButton;
        layout = this.binding.container;

        buildDialog();

        this.binding.addRequestButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
        return this.binding.getRoot();
    }

    private void buildDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // get the layout inflater
        View view = getLayoutInflater().inflate(R.layout.dialog_add_request, null);

        EditText nameText = view.findViewById(R.id.dialogEditName);
        EditText subjectText = view.findViewById(R.id.dialogEditSubject);

        builder.setView(view);
        builder.setTitle("Enter request details")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        addCard(nameText.getText().toString(),
                                subjectText.getText().toString());
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        dialog = builder.create();

    }

    private void addCard(String name, String subject) {
        View view = getLayoutInflater().inflate(R.layout.card, null);

        TextView cardNameLabel = view.findViewById(R.id.cardNameLabel);
        TextView cardSubjectLabel = view.findViewById(R.id.cardSubjectLabel);
        ImageButton cancelButton = view.findViewById(R.id.cancelButton);

        cardNameLabel.setText(name);
        cardSubjectLabel.setText(subject);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.removeView(view);
            }
        });

        layout.addView(view);
        // listener.updateFire...
    }

//    @Override
//    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
//
//    }
}