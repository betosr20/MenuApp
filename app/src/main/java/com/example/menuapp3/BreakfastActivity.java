package com.example.menuapp3;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import Adapter.BreakfastAdapter;
import Model.ListBreakfastItem;
public class BreakfastActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListBreakfastItem> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Busca e inicializa el recyclerView
        recyclerView = findViewById(R.id.breakfastRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Llamada a la funcion que popula la lista con los desayunos
        crearDesayunos();

        //Crea un nuevo adapter con la lista de items creada previamente y le fija el adapter al recyclerView
        adapter =  new BreakfastAdapter(this, listItems);
        recyclerView.setAdapter(adapter);
    }

    private void crearDesayunos(){
        listItems =  new ArrayList<>();
        ListBreakfastItem item;
        item = new ListBreakfastItem(
                "Gallo pinto con huevos", "Gallo pinto con huevos fritos o revueltos, natilla y tortillas o pan", "Precio: 3500 i.v.i",
                "android.resource://com.example.menuapp3/drawable/pinto");
        listItems.add(item);

        item = new ListBreakfastItem(
                "Panqueques", "4 deliciosos panqueques de buttermilk, acompañados de hashbrown", "Precio: 5000 i.v.i",
                "android.resource://com.example.menuapp3/drawable/panqueques");
        listItems.add(item);

        item = new ListBreakfastItem(
                "Omelette", "Omelette hecho con 3 huevos, con relleno de queso jamon o salchichas, cebolla y chile dulce",
                "Precio: 4000 i.v.i",
                "android.resource://com.example.menuapp3/drawable/omelette");
        listItems.add(item);

        item = new ListBreakfastItem(
                "Egg Muffin", "Muffin con pan de la casa, con huevo, queso y jamon o salchicha",
                "Precio: 4500 i.v.i",
                "android.resource://com.example.menuapp3/drawable/eggmuffin");
        listItems.add(item);

    }

}
