package com.project.travel_in_taytay.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.project.travel_in_taytay.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.project.travel_in_taytay.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.project.travel_in_taytay.HelperClasses.HomeAdapter.SearchAdapter;
import com.project.travel_in_taytay.HelperClasses.HomeAdapter.SearchHelperClass;
import com.project.travel_in_taytay.R;

import java.util.ArrayList;
import java.util.List;

public class AllSearch extends AppCompatActivity {
    RecyclerView searchRecycler;
    ImageView backbuttonS1;
    SearchView searchView;
    List<SearchHelperClass> searchLocations;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_search);


        searchRecycler = findViewById(R.id.search_recycler);
        backbuttonS1 = findViewById(R.id.back_pressed_S);
        
        searchRecycler();
        backbuttonS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllSearch.super.onBackPressed();
            }
        });
    }




    private void searchRecycler() {
        searchRecycler.setHasFixedSize(true);
        searchRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ArrayList<SearchHelperClass> searchLocations = new ArrayList<>();
        searchLocations.add(new SearchHelperClass(R.drawable.brgy_dolores,"Baranggay Dolores"));
        searchLocations.add(new SearchHelperClass(R.drawable.brgy_muzon,"Baranggay Muzon"));
        searchLocations.add(new SearchHelperClass(R.drawable.brgy_sanisidro,"Baranggay San Isidro"));
        searchLocations.add(new SearchHelperClass(R.drawable.brgy_sanjuan,"Baranggay San Juan"));
        searchLocations.add(new SearchHelperClass(R.drawable.brgy_staana,"Baranggay Sta Ana"));
        searchLocations.add(new SearchHelperClass(R.drawable.church_kingparish,"Christ the King Parish Church in the sky"));
        searchLocations.add(new SearchHelperClass(R.drawable.church_sanfelipe,"San Felipe Neri Parish"));
        searchLocations.add(new SearchHelperClass(R.drawable.church_sanlo,"San Lorenzo Ruiz Parish"));
        searchLocations.add(new SearchHelperClass(R.drawable.church_stjohn,"St. John the Baptist Parish Church - San Isidro, Taytay, Rizal"));
        searchLocations.add(new SearchHelperClass(R.drawable.club_manila_east,"Club Manila East"));
        searchLocations.add(new SearchHelperClass(R.drawable.hospital_manilaeast,"Manila East Medical Center"));
        searchLocations.add(new SearchHelperClass(R.drawable.hospital_rphs,"Rizal Provincial Hospital System"));
        searchLocations.add(new SearchHelperClass(R.drawable.hospital_taytaydocs,"Taytay Doctors Multispecialty Hospital"));
        searchLocations.add(new SearchHelperClass(R.drawable.hospital_taytayemer,"Taytay Emergency Hospital"));
        searchLocations.add(new SearchHelperClass(R.drawable.resto_bahaykawayan,"Bahay Kawayan Restauran"));
        searchLocations.add(new SearchHelperClass(R.drawable.resto_catalan,"Catalan Grill & Restaurant"));
        searchLocations.add(new SearchHelperClass(R.drawable.resto_kinakap,"Kinakap Bar And Restaurant"));
        searchLocations.add(new SearchHelperClass(R.drawable.resto_matteo,"Matteo's Restaurant"));
        searchLocations.add(new SearchHelperClass(R.drawable.resto_tyvogrill,"Tyvo Grill & Cafe Taytay"));
        searchLocations.add(new SearchHelperClass(R.drawable.school_collageofarts,"College of Arts & Sciences of Asia & the Pacific"));
        searchLocations.add(new SearchHelperClass(R.drawable.school_icct,"ICCT Colleges - Taytay Campus"));
        searchLocations.add(new SearchHelperClass(R.drawable.school_ncb,"National College of Business and Arts"));
        searchLocations.add(new SearchHelperClass(R.drawable.school_siena,"Siena College of Taytay"));
        searchLocations.add(new SearchHelperClass(R.drawable.school_urs_taytay,"University of Rizal System,Taytay Campus"));
        searchLocations.add(new SearchHelperClass(R.drawable.shop_sm_city_taytay,"Sm City Taytay"));
        searchLocations.add(new SearchHelperClass(R.drawable.taytay_tiangge,"Taytay tiangge"));

        SearchAdapter adapter = new SearchAdapter(searchLocations);
        searchRecycler.setAdapter(adapter);
    }

}