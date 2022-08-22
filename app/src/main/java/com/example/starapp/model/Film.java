package com.example.starapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Film implements DataDetailsProvider {
    public String title;

    @SerializedName("episode_id")
    public int episodeId;

    @SerializedName("opening_crawl")
    public String openingCrawl;

    public String director;
    public String producer;
    public String url;
    public String created;
    public String edited;

    @SerializedName("species")
    public ArrayList<String> speciesUrls;

    @SerializedName("starships")
    public ArrayList<String> starshipsUrls;

    @SerializedName("vehicles")
    public ArrayList<String> vehiclesUrls;

    @SerializedName("planets")
    public ArrayList<String> planetsUrls;

    @SerializedName("characters")
    public ArrayList<String> charactersUrls;

    @Override
    public String getName() {
        return title;
    }

    @Override
    public String getDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("title : ");
        sb.append(title);
        sb.append("\n");
        sb.append("director : ");
        sb.append(director);

        return sb.toString();
    }
}
