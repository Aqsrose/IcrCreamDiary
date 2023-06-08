package com.example.icrcreamdiary;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {
    static ArrayList<IceCreamList> content;

    @Override
    public void onCreate() {
        super.onCreate();
        content = new ArrayList<IceCreamList>();
        content.add(new IceCreamList("chocolate", "yummy,sweet choco ice-cream", "icecream"));
        content.add(new IceCreamList("vanilla", "sweet and cold ice-cream", "logo"));
    }
}
