package com.example.menuapp3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import Adapter.OrderAdapter;
import Model.ListBreakfastItem;

public class OrderActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //        up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //float action button
        fab = findViewById(R.id.fab);

        //Busca e inicializa el recyclerView
        recyclerView = findViewById(R.id.rv_order);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //search the list from localStorage
        SharedPreferences sharedPreferences = OrderActivity.this.getSharedPreferences("shared preferences", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final Gson gson =  new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<ListBreakfastItem>>() {}.getType();
        final ArrayList<ListBreakfastItem> listFromStorage;

        //Trea la lista del localStorage
        listFromStorage = gson.fromJson(json, type);

        //Crea un nuevo adapter con la lista de items creada previamente y le fija el adapter al recyclerView
        if (!listFromStorage.isEmpty()) {
            adapter =  new OrderAdapter(this, listFromStorage);
            recyclerView.setAdapter(adapter);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFinishOrder(v);
                String jsonAdd = gson.toJson(new ArrayList<ListBreakfastItem>());
                editor.putString("task list", jsonAdd);
                editor.apply();
            }
        });

    }

    public void openFinishOrder(View view) {
        Intent intent = new Intent(OrderActivity.this, OrderFeedbackActivity.class);
        startActivity(intent);
    }

}
