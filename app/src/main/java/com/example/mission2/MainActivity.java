package com.example.mission2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import model.listm;

public class MainActivity extends AppCompatActivity {

    private static final int RESULT_DELETE = 301;
    public static final String TASK = "task";
    public static final String POSITION = "position";
    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;
    private CardView cardView;
    private Intent intent;
    private TextView textView;
    private ProgressBar progressBar2;
    private EditText editnama, editwhy, editwhen;
    static ArrayList<listm> data = new ArrayList<>();
    rvadapter adapter;
    private int position = 0;
    private boolean isEdit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setupRecyclerView();
        listm list = new listm("nama","why","when");


        floatingActionButton = findViewById(R.id.floatingActionButton);
        recyclerView = findViewById(R.id.recyclerView);
        //floatingActionButton = findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,addupdate.class);
                startActivity(intent);

            }
        });

    }

    private void deleteTask(String uid) {
            //method delete
            showProgress();
            db.collection("Tasks").document(uid).delete()
                    .addOnSuccessListener(unused -> {
                        hideProgress();
                        Intent intent = new Intent();
                        intent.putExtra(POSITION, position);
                        setResult(RESULT_DELETE, intent);
                        finish();
                    })
                    .addOnFailureListener(e -> {
                        hideProgress();
                        Toast.makeText(this, "Failed to delete.", Toast.LENGTH_SHORT).show();
                    });

        }




    private void setupRecyclerView(){
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new rvadapter(data);
    }

    private void hideProgress() {
        progressBar2.setVisibility(View.GONE);
    }

    private void showProgress() {
        progressBar2.setVisibility(View.VISIBLE);
    }
}