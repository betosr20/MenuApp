package com.example.menuapp3;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import Adapter.BreakfastAdapter;
import Model.ListBreakfastItem;

public class DrinkActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListBreakfastItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setSupportActionBar(toolbar);
        //        up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Busca e inicializa el recyclerView
        recyclerView = findViewById(R.id.drinksRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Llamada a la funcion que popula la lista con las cenas
        createDrinks();

        //Crea un nuevo adapter con la lista de items creada previamente y le fija el adapter al recyclerView
        adapter =  new BreakfastAdapter(this, listItems);
        recyclerView.setAdapter(adapter);

    }
    private void createDrinks() {
        listItems = new ArrayList<>();
        ListBreakfastItem item;
        item = new ListBreakfastItem(
                "Coca Cola", "Coca Cola", "Precio: 1000 i.v.i",
                "android.resource://com.example.menuapp3/drawable/cocacola");
        listItems.add(item);

        item = new ListBreakfastItem(
                "Té frío", "Té frío con Limón de la casa" +
                "acompañada de papas fritas", "Precio: 1200 i.v.i",
                "android.resource://com.example.menuapp3/drawable/icetea");
        listItems.add(item);

        item = new ListBreakfastItem(
                "Batido de fresa", "Batido de fresa en leche con una fresa y una rodaja de banano",
                "Precio: 10000 i.v.i",
                "android.resource://com.example.menuapp3/drawable/strawberrysmoothie");
        listItems.add(item);

        item = new ListBreakfastItem(
                "Limonada con hierbabuena", "Deliciosa limonada con hierbabuena",
                "Precio: 4500 i.v.i",
                "android.resource://com.example.menuapp3/drawable/limonadahierbabuena");
        listItems.add(item);
    }
}
