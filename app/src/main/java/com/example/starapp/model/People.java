package com.example.starapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class People implements DataDetailsProvider {
    public String name;

    @SerializedName("birth_year")
    public String birthYear;

    public String gender;

    @SerializedName("hair_color")
    public String hairColor;

    public String height;

    @SerializedName("homeworld")
    public String homeWorldUrl;

    public String mass;

    @SerializedName("skin_color")
    public String skinColor;

    public String created;
    public String edited;
    public String url;

    @SerializedName("films")
    public ArrayList<String> filmsUrls;

    @SerializedName("species")
    public ArrayList<String> speciesUrls;

    @SerializedName("starships")
    public ArrayList<String> starshipsUrls;

    @SerializedName("vehicles")
    public ArrayList<String> vehiclesUrls;

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
        sb.append("Birth Year : ");
        sb.append(birthYear);

        return sb.toString();
    }
}
