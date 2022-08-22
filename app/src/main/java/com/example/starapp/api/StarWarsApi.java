package com.example.starapp.api;

import com.example.starapp.model.DataDetailsProvider;
import com.example.starapp.model.DataList;
import com.example.starapp.model.Film;
import com.example.starapp.model.People;
import com.example.starapp.model.Planet;
import com.example.starapp.model.Specie;
import com.example.starapp.model.Starship;
import com.example.starapp.model.Vehicle;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StarWarsApi {

    @GET("films/")
    Call<DataList<Film>> getFilms(@Query("page") int page);

    @GET("people/")
    Call<DataList<People>> getPeople(@Query("page") int page);

    @GET("planets/")
    Call<DataList<Planet>> getPlanets(@Query("page") int page);

    @GET("species/")
    Call<DataList<Specie>> getSpecies(@Query("page") int page);

    @GET("starships/")
    Call<DataList<Starship>> getStarships(@Query("page") int page);

    @GET("vehicles/")
    Call<DataList<Vehicle>> getVehicles(@Query("page") int page);
}
