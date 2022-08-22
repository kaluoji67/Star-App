package com.example.starapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Vehicle implements DataDetailsProvider {
    public String name;
    public String model;

    @SerializedName("vehicle_class")
    public String vehicleClass;

    public String manufacturer;

    @SerializedName("cost_in_credits")
    public String costInCredits;

    public String length;
    public String crew;
    public String passengers;

    @SerializedName("max_atmosphering_speed")
    public String maxAtmospheringSpeed;

    @SerializedName("cargo_capacity")
    public String cargoCapacity;

    public String consumables;
    public String created;
    public String edited;
    public String url;

    @SerializedName("pilots")
    public ArrayList<String> pilotsUrls;

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
        sb.append("Capacity : ");
        sb.append(cargoCapacity);

        return sb.toString();
    }
}
