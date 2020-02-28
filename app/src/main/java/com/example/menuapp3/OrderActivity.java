package com.example.menuapp3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import Adapter.BreakfastAdapter;
import Adapter.OrderAdapter;
import Model.ListBreakfastItem;

public class OrderActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //        up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Busca e inicializa el recyclerView
        recyclerView = findViewById(R.id.rv_order);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //search the list from localStorage
        SharedPreferences sharedPreferences = OrderActivity.this.getSharedPreferences("shared preferences", Context.MODE_PRIVATE);
        Gson gson =  new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<ListBreakfastItem>>() {}.getType();
        ArrayList<ListBreakfastItem> listFromStorage;

        //Trea la lista del localStorage
        listFromStorage = gson.fromJson(json, type);

        //Crea un nuevo adapter con la lista de items creada previamente y le fija el adapter al recyclerView
        if (!listFromStorage.isEmpty()) {
            adapter =  new OrderAdapter(this, listFromStorage);
            recyclerView.setAdapter(adapter);
        }


    }

}
