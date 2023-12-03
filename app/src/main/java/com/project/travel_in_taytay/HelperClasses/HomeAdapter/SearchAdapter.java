package com.project.travel_in_taytay.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.travel_in_taytay.R;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    ArrayList<SearchHelperClass> searchLocations;

    public SearchAdapter(ArrayList<SearchHelperClass> searchLocations) {
        this.searchLocations = searchLocations;
    }


    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_card_design, parent, false);
        SearchAdapter.SearchViewHolder searchViewHolder = new SearchAdapter.SearchViewHolder(view);
        return searchViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        SearchHelperClass searchHelperClass = searchLocations.get(position);
        holder.image.setImageResource(searchHelperClass.getImage());
        holder.title.setText(searchHelperClass.getTitle());


    }

    @Override
    public int getItemCount() {
        return searchLocations.size();
    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.sv_image);
            title = itemView.findViewById(R.id.sv_title);
        }
    }
}
