package com.example.starapp.model;

import com.google.gson.annotations.SerializedName;

public class Starship implements DataDetailsProvider {
    public String name;

    @SerializedName("starship_class")
    public String starshipClass;

    @SerializedName("hyperdrive_rating")
    public String hyperdriveRating;

    @SerializedName("MGLT")
    public String mglt;

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


        return sb.toString();
    }
}
