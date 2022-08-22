package com.example.starapp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.starapp.R;
import com.example.starapp.helpers.RecyclerItemClickListener;
import com.example.starapp.helpers.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class ListFragment extends Fragment {

    public interface OnListFragmentItemClick {
        public void onClick(int position);
        public void next();
        public void previous();
    }
    OnListFragmentItemClick onListFragmentItemClick;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            onListFragmentItemClick = (OnListFragmentItemClick) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+ "must implement onImageClickListener");
        }
    }


    final String TAG = "ListFragment";
    RecyclerView recyclerView;
    Button previousBtt;
    Button nextBtt;
    public RecyclerViewAdapter adapter;
    List<String> names = new ArrayList<>();

    public ListFragment() {
        // Required empty public constructor
        adapter = new RecyclerViewAdapter(names);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = root.findViewById(R.id.list_rv);

        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity().getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        onListFragmentItemClick.onClick(position);
                    }
                })
        );
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        previousBtt = root.findViewById(R.id.previous_btt);
        previousBtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onListFragmentItemClick.previous();
            }
        });
        nextBtt = root.findViewById(R.id.next_btt);
        nextBtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onListFragmentItemClick.next();
            }
        });

        return root;
    }

    public void setData(List<String> list, String next, String previous) {
        Log.d(TAG,"setting");
        names.clear();
        names.addAll(list);
        adapter.notifyDataSetChanged();

        Log.d("TAG","next : "+ next);

        if(TextUtils.isEmpty(next))
            nextBtt.setVisibility(View.GONE);
        else
            nextBtt.setVisibility(View.VISIBLE);

        if(TextUtils.isEmpty(previous))
            previousBtt.setVisibility(View.GONE);
        else
            previousBtt.setVisibility(View.VISIBLE);
    }
}