package com.niazi.mynotes.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.niazi.mynotes.Adoptor.Notes_adobtor;
import com.niazi.mynotes.MainActivity;
import com.niazi.mynotes.Model_Class.Notes_Model_Class;
import com.niazi.mynotes.SQLite_Data_Base.DatabaseHelper;
import com.niazi.mynotes.databinding.FragmentUploadNotesBinding;

import java.util.ArrayList;

public class UploadNotesFragment extends Fragment {

    //
    public UploadNotesFragment() {
        // Required empty public constructor
    }
    RecyclerView recyclerView;

    DatabaseHelper databasehelper;

    Notes_Model_Class modelClass;
    String getid, getname, getsurnamew, getmark;
    Notes_adobtor adobtor;
    ArrayList<Notes_Model_Class> list;

    FragmentUploadNotesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentUploadNotesBinding.inflate(inflater,container,false);



        binding.button.setOnClickListener(view -> {

            String notesname = "";
            String notes = "";


            if (binding.edName.getText().toString().equals("")) {
                Toast.makeText(view.getContext(), "Fill Name", Toast.LENGTH_SHORT).show();
            } else {
                notesname = binding.edName.getText().toString();
            }
            if (binding.edNotes.getText().toString().equals("")) {
                Toast.makeText(view.getContext(), "Fill Notes", Toast.LENGTH_SHORT).show();
            } else {
                notes = binding.edNotes.getText().toString();
            }

            boolean isInsurted = databasehelper.insertData(binding.edName.getText().toString(), binding.edNotes.getText().toString());

            if (isInsurted == true) {
                Toast.makeText(view.getContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            } else {
                Toast.makeText(view.getContext(), "Data Not Inserted", Toast.LENGTH_SHORT).show();

            }
        });

        return binding.getRoot();
    }

}