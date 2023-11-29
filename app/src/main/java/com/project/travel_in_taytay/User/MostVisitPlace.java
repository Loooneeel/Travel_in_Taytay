package com.project.travel_in_taytay.User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.project.travel_in_taytay.R;
import com.project.travel_in_taytay.User.Categories.ShopCategories;

public class MostVisitPlace extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_most_visit_place);
        ImageView backButton = findViewById(R.id.back_pressed);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MostVisitPlace.super.onBackPressed();
            }
        });
    }
}