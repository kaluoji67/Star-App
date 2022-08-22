package com.example.starapp.model;

import android.text.TextUtils;

import java.util.ArrayList;


public class DataList<T> {

    public int count;
    public String next;
    public String previous;
    public ArrayList<T> results;
}
