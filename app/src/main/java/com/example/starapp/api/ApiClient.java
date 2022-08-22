package com.example.starapp.api;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit retrofit;
    public final static String BASE_URL = "https://swapi.dev/api/";
    public static Map<String,String> Categories;

    final static String FILMS = "films/";
    final static String PEOPLE = "people/";
    final static String PLANETS = "planets/";
    final static String SPECIES = "species/";
    final static String STARSHIPS = "starships/";
    final static String VEHICLES = "vehicles/";

    public static Retrofit getApiClient(){
        if(retrofit==null){
            populateMap();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    static void populateMap(){
        Categories = new HashMap<>();
        Categories.put("films",FILMS);
        Categories.put("people",PEOPLE);
        Categories.put("Planets",PLANETS);
        Categories.put("species",SPECIES);
        Categories.put("starships",STARSHIPS);
        Categories.put("vehicles",VEHICLES);
    }
}
