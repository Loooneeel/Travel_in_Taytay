package com.project.travel_in_taytay.HelperClasses.HomeAdapter;

public class MostViewedHelperClass {
    int imageView;
    String titleView,descView;

    public MostViewedHelperClass(int image, String title, String description) {
        this.imageView = image;
        this.descView = description;
        this.titleView = title;
    }

    public int getImageView() {
        return imageView;
    }

    public String getTitleView() {
        return titleView;
    }

    public String getDescView() {
        return descView;
    }
}
