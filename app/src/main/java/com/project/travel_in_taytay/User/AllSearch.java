package com.project.travel_in_taytay.User;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.project.travel_in_taytay.R;

public class AllSearch extends AppCompatActivity {
 ImageView backbuttonS1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_search);

        backbuttonS1 = findViewById(R.id.back_pressed_S);
        backbuttonS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllSearch.super.onBackPressed();
            }
        });
    }
}