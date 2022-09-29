package com.firstapp.portrait_to_lansscape;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements PopUp.OnInputListener {

    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;

    public String mInput;
    DataAdapter dataAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recylcer_view_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        floatingActionButton=findViewById(R.id.add_fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp popup=new PopUp();
                popup.show(getSupportFragmentManager(),"popup");



            }
        });


    }

    @Override
    public void sendInput(String input) {
        mInput=input;
        setInputRecyclerView();

    }

    private void setInputRecyclerView() {
        recyclerView.setAdapter(dataAdapter);
    }
}