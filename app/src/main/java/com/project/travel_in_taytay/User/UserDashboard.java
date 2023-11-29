package com.project.travel_in_taytay.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.android.material.navigation.NavigationView;
import com.project.travel_in_taytay.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.project.travel_in_taytay.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.project.travel_in_taytay.HelperClasses.HomeAdapter.MostViewedAdpater;
import com.project.travel_in_taytay.HelperClasses.HomeAdapter.MostViewedHelperClass;
import com.project.travel_in_taytay.R;
import com.project.travel_in_taytay.User.Categories.BrgyCategories;
import com.project.travel_in_taytay.User.Categories.RestaurantCategories;
import com.project.travel_in_taytay.User.Categories.SchoolsCategories;
import com.project.travel_in_taytay.User.Categories.ShopCategories;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    static final float END_SCALE = 0.7f;
    RecyclerView mostViewedRecycler,featuredRecycler;
    RecyclerView.Adapter adapter;
    //Drawer Menu
    DrawerLayout drawerLayout;
    LinearLayout contentView;
    NavigationView navigationView;
    ImageView menuIcon,schoolDashboardIcon,brgyDashboardIcon,restDashboardIcon,shopDashboardIcon;
    RelativeLayout mostVisited;
    SearchView searchView;
    ListView listView;
    //String [] placeList ={"Taytay tiange","Sm City Taytay", "Manila East"};
    //ArrayAdapter<String> arrayAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //searchView = findViewById(R.id.sear_bar);
        //listView = findViewById(R.id.list_place);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);

        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        navigationDrawer();

        //Functions will be executed automatically when this activity will be created
        featuredRecycler();
        mostViewedRecycler();

        //On Click
        schoolDashboardIcon = findViewById(R.id.school_dashboard_icon);
        schoolDashboardIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SchoolsCategories.class));
            }
        });
        brgyDashboardIcon = findViewById(R.id.brgy_dashboard_icon);
        brgyDashboardIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BrgyCategories.class));
            }
        });
        restDashboardIcon = findViewById(R.id.restaurant_dashboard_icon);
        restDashboardIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RestaurantCategories.class));
            }
        });
        shopDashboardIcon = findViewById(R.id.shop_dashboard_icon);
        shopDashboardIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ShopCategories.class));
            }
        });
        mostVisited = findViewById(R.id.mostVisitedPlace);
        mostVisited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MostVisitPlace.class));
            }
        });


    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }

    @SuppressLint("SuspiciousIndentation")
    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
        super.onBackPressed();
    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClass(R.drawable.taytay_tiangge,"Taytay Tiangge","Visit Here"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.club_manila_east,"Club Manila East","Visit Here"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.shop_sm_city_taytay,"Sm City Taytay","Visit Here"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);
    }
    private void mostViewedRecycler() {
        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.taytay_tiangge, "Taytay Tiangge","Visit Here"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.club_manila_east, "Club Manila east", "Visit Here"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.shop_sm_city_taytay, "Sm City Taytay", "Visit Here"));
        adapter = new MostViewedAdpater(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_all_categories) {
            startActivity(new Intent(getApplicationContext(), AllCategories.class));
        }
        else if (item.getItemId() == R.id.nav_home) {
            startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        }
        else if (item.getItemId() == R.id.nav_search) {
            startActivity(new Intent(getApplicationContext(), AllSearch.class));
        }
        else if (item.getItemId() == R.id.nav_restaurants) {
            startActivity(new Intent(getApplicationContext(), RestaurantCategories.class));
        }
        else if (item.getItemId() == R.id.nav_bank) {
            startActivity(new Intent(getApplicationContext(), BrgyCategories.class));
        }
        else if (item.getItemId() == R.id.nav_education) {
            startActivity(new Intent(getApplicationContext(), SchoolsCategories.class));
        }
        else if (item.getItemId() == R.id.nav_shop) {
            startActivity(new Intent(getApplicationContext(), ShopCategories.class));
        }
        else if (item.getItemId() == R.id.nav_exit) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.create();
            builder.setTitle("C O N F I R M A T I O N");
            builder.setMessage("Do you want to exit?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                UserDashboard.super.onBackPressed();
                finish();
                }
            });
            builder.setNeutralButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                }
            });
            builder.show();
        }
        return true;
    }


}