package com.project.travel_in_taytay.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.project.travel_in_taytay.R;
import com.project.travel_in_taytay.User.Categories.BrgyCategories;
import com.project.travel_in_taytay.User.Categories.ChurchCategories;
import com.project.travel_in_taytay.User.Categories.HospitalCategories;
import com.project.travel_in_taytay.User.Categories.ResortCategories;
import com.project.travel_in_taytay.User.Categories.RestaurantCategories;
import com.project.travel_in_taytay.User.Categories.SchoolsCategories;
import com.project.travel_in_taytay.User.Categories.ShopCategories;

public class AllCategories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);
        //Back
       ImageView backButton = findViewById(R.id.back_pressed);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllCategories.super.onBackPressed();
            }
        });
        //Expand School
        Button expandSchool = findViewById(R.id.expandSchool);
        expandSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SchoolsCategories.class));
            }
        });
        //Expand Brgy
        Button expandBrgy = findViewById(R.id.expandBrgy);
        expandBrgy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BrgyCategories.class));
            }
        });
        //Expand Restaurant
        Button expandRestaurant = findViewById(R.id.expandRestaurant);
        expandRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RestaurantCategories.class));
            }
        });
        //Expand Hospital
        Button expandHospital = findViewById(R.id.expandHospital);
        expandHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HospitalCategories.class));
            }
        });
        //Expand Shop
        Button expandShop = findViewById(R.id.expandShops);
        expandShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ShopCategories.class));
            }
        });
        //Expand Resort
        Button expandResort = findViewById(R.id.expandResort);
        expandResort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ResortCategories.class));
            }
        });
        //Expand Church
        Button expandChurch = findViewById(R.id.expandChurch);
        expandChurch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ChurchCategories.class));
            }
        });

    }
}