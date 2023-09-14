package com.niazi.mynotes;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.niazi.mynotes.Activity.Work_Activity;
import com.niazi.mynotes.Adoptor.Notes_adobtor;
import com.niazi.mynotes.Model_Class.Notes_Model_Class;
import com.niazi.mynotes.SQLite_Data_Base.DatabaseHelper;
import com.niazi.mynotes.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    Cursor cursor;
    DatabaseHelper myDb;
    Notes_Model_Class model;
    String getid, getname, getsurnamew, getmark;
    Notes_adobtor adobtor;
    ArrayList<Notes_Model_Class> list;



    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();
        ViewData();


/*
        getid = getIntent().getStringExtra("id");
        getname = getIntent().getStringExtra("name");
        getmark = getIntent().getStringExtra("mark");
        getsurnamew = getIntent().getStringExtra("surname");

        rdid.setText(getid);
        rdid.setEnabled(false);
        edname.setText(getname);
        edmarksd.setText(getmark);
        edsurenm.setText(getsurnamew);
*/


        adobtor.notifyDataSetChanged();
        recyclerView.setLayoutManager((new GridLayoutManager(this, 2)));
        myDb = new DatabaseHelper(this);

        myDb.getWritableDatabase();

        ViewData();

        binding.buttonupload.setOnClickListener(view -> {

            Intent intent = new Intent(MainActivity.this, Work_Activity.class);
            startActivity(intent);
        });




    }
    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


    private void ViewData()
    {
        Cursor cursor = myDb.getAllData();


        list.clear();

        if(cursor.getCount() == 0 )
        {
            showMessage("Error","No Data Found");

            return;
        }
        while (cursor.moveToNext())
        {

            model= new Notes_Model_Class(cursor.getString(0), cursor.getString(1),
                    cursor.getString(2), cursor.getString(3));


            list.add(model);
            adobtor = new Notes_adobtor(list);
            recyclerView.setAdapter(adobtor);

        }
    }}