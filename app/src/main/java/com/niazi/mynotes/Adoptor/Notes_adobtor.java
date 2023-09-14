package com.niazi.mynotes.Adoptor;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.niazi.mynotes.MainActivity;
import com.niazi.mynotes.Model_Class.Notes_Model_Class;
import com.niazi.mynotes.R;
import com.niazi.mynotes.SQLite_Data_Base.DatabaseHelper;
import com.niazi.mynotes.databinding.NoteitenviewBinding;
import java.util.ArrayList;

public class Notes_adobtor extends RecyclerView.Adapter<Notes_adobtor.ViewHolder> {
    ArrayList<Notes_Model_Class> modelClassList;

    DatabaseHelper dataBase;

    public Notes_adobtor(ArrayList<Notes_Model_Class> modelClassList) {
        this.modelClassList = modelClassList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.noteitenview,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.binding.tvnotesName.setText(modelClassList.get(position).getNotesname());
        holder.binding.tvnotesdrtail.setText(modelClassList.get(position).getNotes());
       holder.binding.id.setText(modelClassList.get(position).getId());


        holder.itemView.setOnClickListener(view -> {
            Dialog dialog = new Dialog(view.getContext());
            dialog.setContentView(R.layout.update_dialog);

            Button Updatebutton = dialog.findViewById(R.id.buttonupdate);
            EditText Updatenamenote = dialog.findViewById(R.id.ed_update_name);
            EditText Updatenote = dialog.findViewById(R.id.ed_update_notes);


            Updatebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){

                   /* boolean isupdate = dataBase.updatedata(holder.Id.getText().toString(), holder.Notesname.getText().toString(),
                            holder.Notederta.getText().toString());


                    if (isupdate == true) {
                        Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show();
                        edname.setText("");
                        edsurenm.setText("");
                        edmarksd.setText("");
                        ViewData();
                        recyclerView.scrollToPosition(list.size() - 1);

                    } else {
                        Toast.makeText(this, "Data Not Updated", Toast.LENGTH_SHORT).show();

                    }*/
                }
            });
            dialog.show();
        });

    /*    holder.itemView.setOnClickListener(view -> {

            boolean isupdate = dataBase.updatedata(.getText().toString(), edname.getText().toString(),
                    edsurenm.getText().toString(), edmarksd.getText().toString());


            if (isupdate == true) {
                Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show();
                edname.setText("");
                edsurenm.setText("");
                edmarksd.setText("");
                ViewData();
                recyclerView.scrollToPosition(list.size() - 1);

            } else {
                Toast.makeText(this, "Data Not Updated", Toast.LENGTH_SHORT).show();

            }
        });
    */    holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            intent.putExtra("notesname",modelClassList.get(position).getNotesname());
            intent.putExtra("notesdetail",modelClassList.get(position).getNotes());
            intent.putExtra("time",modelClassList.get(position).getTime());
            intent.putExtra("id",modelClassList.get(position).getId());
            view.getContext().startActivity(intent);
            ((Activity)view.getContext()).finish();

        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                {


                    AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());

                    alert.setTitle("delete this item");
                    alert.setMessage("Are you sure ");

                    alert.setCancelable(false);

                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dataBase = new DatabaseHelper(view.getContext());

                            dataBase.getWritableDatabase();

                            Integer deletedRow =  dataBase.deleteData(modelClassList.get(position).getId());

                            if(deletedRow>0)
                            {
                                Toast.makeText(view.getContext(), "Data Deleted", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(view.getContext(), MainActivity.class);
                                view.getContext().startActivity(intent);
                                ((Activity)view.getContext()).finish();

                            }
                            else
                            {
                                Toast.makeText(view.getContext(), "Data Not Deleted", Toast.LENGTH_SHORT).show();
                            }




                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Toast.makeText(view.getContext(), "Cancel", Toast.LENGTH_SHORT).show();

                        }
                    });


                }
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {

        return modelClassList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

         NoteitenviewBinding binding;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            binding= NoteitenviewBinding.bind(itemView);
        }

    }
}
