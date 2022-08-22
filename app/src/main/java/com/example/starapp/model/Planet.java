package com.example.starapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Planet implements DataDetailsProvider {
    public String name;
    public String diameter;
    public String gravity;
    public String population;
    public String climate;
    public String terrain;
    public String created;
    public String edited;
    public String url;

    @SerializedName("rotation_period")
    public String rotationPeriod;

    @SerializedName("orbital_period")
    public String orbitalPeriod;

    @SerializedName("surface_water")
    public String surfaceWater;

    @SerializedName("residents")
    public ArrayList<String> residentsUrls;

    @SerializedName("films")
    public ArrayList<String> filmsUrls;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("name : ");
        sb.append(name);
        sb.append("\n");
        sb.append("Population : ");
        sb.append(population);

        return sb.toString();
    }
}
