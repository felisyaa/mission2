package com.example.mission2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import model.listm;

public class addupdate extends AppCompatActivity {

    private static final int RESULT_DELETE = ;
    private Button bsub;
    private TextView editnama, editwhy, editwhen;
    private ImageView poto;
    private ArrayList<listm> list;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addupdate);

        bsub = findViewById(R.id.bsub);
        editnama = findViewById(R.id.editnama);
        editwhy = findViewById(R.id.editwhy);
        editwhen = findViewById(R.id.editwhen);
        poto = findViewById(R.id.poto);

        bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = editnama.getText().toString().trim();
                String why = editwhy.getText().toString().trim();
                String when = editwhen.getText().toString().trim();
                Toast.makeText(getApplicationContext(), "Berhasil hore", Toast.LENGTH_SHORT).show();

                listm list = new listm(nama, why, when);
                Intent intent=new Intent(addupdate.this, cardview.class);
                //list.putParcelableArrayList(, list)
                intent.putExtra("listm", list);


                startActivity(intent);
            }
        });

        if (isEdit) {
            editnama.setText(task.getName());
            editwhy.setText(task.getDescription());
            editwhen.setText(task.getDeadline());
        } else {
            task = new Task();
        }

            //memastikan setiap field tidak kosong
            if (editnama.isEmpty() || editwhy.isEmpty() || editwhen.isEmpty()) {
                Toast.makeText(this, "Complete all forms.", Toast.LENGTH_SHORT).show();
                return;
            }

            //jika is edit bernilai true maka memanggil method update, jika false maka memanggil method add
            if (isEdit) {
                updateTask(task.getId(), editnama, editwhy, editwhen);
            } else {
                addTask(nama, description, deadline);
            }
        });
    }



}