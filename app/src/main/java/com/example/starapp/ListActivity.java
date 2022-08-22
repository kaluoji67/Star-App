package com.example.starapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Dialog;
import android.databinding.tool.util.StringUtils;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.starapp.api.ApiClient;
import com.example.starapp.api.StarWarsApi;
import com.example.starapp.fragments.ListFragment;
import com.example.starapp.model.DataDetailsProvider;
import com.example.starapp.model.DataList;
import com.example.starapp.model.DisplayDetails;
import com.example.starapp.model.Film;
import com.example.starapp.model.People;
import com.example.starapp.model.Planet;
import com.example.starapp.model.Specie;
import com.example.starapp.model.Starship;
import com.example.starapp.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity<T> extends AppCompatActivity implements ListFragment.OnListFragmentItemClick {

    final String TAG = "List Activity";
    ListFragment listFragment;

    StarWarsApi starWarsApi;
    String category;
    String next;
    String previous;
    boolean loading;
    List<String> names = new ArrayList<>();
    List<DisplayDetails> listDetails = new ArrayList<>();
    int page=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //retrieve information from intent
        Bundle extras = getIntent().getExtras();
        category = extras.getString("category");

        TextView title = findViewById(R.id.category_title);
        title.setText(StringUtils.capitalize(category));

        //add fragment to activity
        listFragment = new ListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.list_container,listFragment)
                .commit();

        //get data from api
        starWarsApi = ApiClient.getApiClient().create(StarWarsApi.class);
        
        //make call to endpoint
        makeApiCall(starWarsApi,page);

    }

    private void makeApiCall(StarWarsApi starWarsApi, int newPage) {
        loading=true;
        switch (category){
            case "films" :
                starWarsApi.getFilms(newPage).enqueue(new Callback<DataList<Film>>() {
                    @Override
                    public void onResponse(Call<DataList<Film>> call, Response<DataList<Film>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(ListActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        loading=false;
                        page=newPage;
                        Log.d(TAG, "onResponse: " + response.body());
                        DataList<Film> datalist = response.body();
                        next = datalist.next;
                        previous = datalist.previous;
                        List<Film> films = datalist.results;
                        getDetails(films);
                    }
                    @Override
                    public void onFailure(Call<DataList<Film>> call, Throwable t) {
                        Toast.makeText(ListActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
                
            case "people" :
                starWarsApi.getPeople(newPage).enqueue(new Callback<DataList<People>>() {
                    @Override
                    public void onResponse(Call<DataList<People>> call, Response<DataList<People>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(ListActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        loading=false;
                        page=newPage;
                        Log.d(TAG, "onResponse: " + response.body());
                        DataList<People> datalist = response.body();
                        next = datalist.next;
                        previous = datalist.previous;
                        List<People> p = datalist.results;
                        getDetails(p);
                    }
                    @Override
                    public void onFailure(Call<DataList<People>> call, Throwable t) {
                        Toast.makeText(ListActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case "planets" :
                starWarsApi.getPlanets(newPage).enqueue(new Callback<DataList<Planet>>() {
                    @Override
                    public void onResponse(Call<DataList<Planet>> call, Response<DataList<Planet>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(ListActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        loading=false;
                        page=newPage;
                        Log.d(TAG, "onResponse: " + response.body());
                        DataList<Planet> datalist = response.body();
                        next = datalist.next;
                        previous = datalist.previous;
                        List<Planet> p = datalist.results;
                        getDetails(p);
                    }
                    @Override
                    public void onFailure(Call<DataList<Planet>> call, Throwable t) {
                        Toast.makeText(ListActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            case "species" :
                starWarsApi.getSpecies(newPage).enqueue(new Callback<DataList<Specie>>() {
                    @Override
                    public void onResponse(Call<DataList<Specie>> call, Response<DataList<Specie>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(ListActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        loading=false;
                        page=newPage;
                        Log.d(TAG, "onResponse: " + response.body());
                        DataList<Specie> datalist = response.body();
                        next = datalist.next;
                        previous = datalist.previous;
                        List<Specie> p = datalist.results;
                        getDetails(p);
                    }
                    @Override
                    public void onFailure(Call<DataList<Specie>> call, Throwable t) {
                        Toast.makeText(ListActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case "starships" :
                starWarsApi.getStarships(newPage).enqueue(new Callback<DataList<Starship>>() {
                    @Override
                    public void onResponse(Call<DataList<Starship>> call, Response<DataList<Starship>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(ListActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        loading=false;
                        page=newPage;
                        Log.d(TAG, "onResponse: " + response.body());
                        DataList<Starship> datalist = response.body();
                        next = datalist.next;
                        previous = datalist.previous;
                        List<Starship> p = datalist.results;
                        getDetails(p);
                    }
                    @Override
                    public void onFailure(Call<DataList<Starship>> call, Throwable t) {
                        Toast.makeText(ListActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case "vehicles" :
                starWarsApi.getVehicles(newPage).enqueue(new Callback<DataList<Vehicle>>() {
                    @Override
                    public void onResponse(Call<DataList<Vehicle>> call, Response<DataList<Vehicle>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(ListActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        loading=false;
                        page=newPage;
                        Log.d(TAG, "onResponse: " + response.body());
                        DataList<Vehicle> datalist = response.body();
                        next = datalist.next;
                        previous = datalist.previous;
                        List<Vehicle> p = datalist.results;
                        getDetails(p);
                    }
                    @Override
                    public void onFailure(Call<DataList<Vehicle>> call, Throwable t) {
                        Toast.makeText(ListActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }


    public <T extends DataDetailsProvider> void getDetails(List<T> list){
        names.clear();
        listDetails.clear();
        //get names for display in recycler view
        for(int i=0; i<list.size();i++){
            T d= list.get(i);
            names.add(d.getName());

            //get details
            DisplayDetails displayDetails = new DisplayDetails(d.getDetails());
            listDetails.add(displayDetails);
        }
        listFragment.setData(names,next,previous);



    }

    @Override
    public void onClick(int position) {
        //create display
        showCustomDialog(position);

        position = (page -1 ) * 10  + position + 1;
        Toast.makeText(this, position+"", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void next() {
        if(loading || TextUtils.isEmpty(next))
            return;
        makeApiCall(starWarsApi,page+1);
    }

    @Override
    public void previous() {
        if(loading || TextUtils.isEmpty(previous))
            return;
        makeApiCall(starWarsApi,page-1);
    }

    //Function to display the custom dialog.
    void showCustomDialog(int position) {
        final Dialog dialog = new Dialog(ListActivity.this);
        //disable the default title.
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //The user will be able to cancel the dialog by clicking anywhere outside the dialog.
        dialog.setCancelable(true);

        //Attach layout of your custom dialog.
        dialog.setContentView(R.layout.popup_menu);

        //Initializing the views of the dialog.
        final TextView details = dialog.findViewById(R.id.details);
        details.setText(listDetails.get(position).details);

        dialog.show();
    }
}