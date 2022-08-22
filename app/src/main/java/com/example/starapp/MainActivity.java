package com.example.starapp;

import android.content.Intent;
import android.databinding.tool.util.StringUtils;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.starapp.api.ApiClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    String endPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialise client
        ApiClient.getApiClient();

        //Create List View to show categories
        ListView categories_lv = findViewById(R.id.categories_lv);
        List<String> categories = new ArrayList<>();
        int count=0;
        for(Map.Entry<String,String> entry : ApiClient.Categories.entrySet()){
            categories.add(StringUtils.capitalize( entry.getKey()));
        }

        categories_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String category="";

                List<String> endpoints = new ArrayList<>(ApiClient.Categories.values());
                for(int j=0;j<categories.size();j++){
                    if(j==i){
                        endPoint = endpoints.get(j);
                        category = categories.get(j).toLowerCase();
                    }
                }

                //open new activity
                Bundle b = new Bundle();
                b.putString("endPoint", endPoint);
                b.putString("category",category);

                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putExtras(b);
                startActivity(intent);

            }
        });

        ArrayAdapter<String> adapter= new ArrayAdapter<>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                categories);

        categories_lv.setAdapter(adapter);


    }


}