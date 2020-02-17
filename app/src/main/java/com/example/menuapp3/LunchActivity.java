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

public class LunchActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListBreakfastItem> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //        up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Busca e inicializa el recyclerView
        recyclerView = findViewById(R.id.lunchRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Llamada a la funcion que popula la lista con los desayunos
        createLunches();

        //Crea un nuevo adapter con la lista de items creada previamente y le fija el adapter al recyclerView
        adapter =  new BreakfastAdapter(this, listItems);
        recyclerView.setAdapter(adapter);
    }

    private void createLunches() {
        listItems = new ArrayList<>();
        ListBreakfastItem item;
        item = new ListBreakfastItem(
                "Arroz con camarones", "Delicioso arroz con camarones, acompañado de papas fritas y ensalada", "Precio: 6000 i.v.i",
                "android.resource://com.example.menuapp3/drawable/arrozcamarones");
        listItems.add(item);

        item = new ListBreakfastItem(
                "Casado", "Casado típico que consiste de arroz, frijoles, plátano maduro y carne en salsa, pescado o bistec", "Precio: 3000 i.v.i",
                "android.resource://com.example.menuapp3/drawable/casado");
        listItems.add(item);

        item = new ListBreakfastItem(
                "Empanada arreglada", "Empanada de la casa (carne, chicharron, queso) arreglada con repollo, salsa de tomate y mayonesa",
                "Precio: 4000 i.v.i",
                "android.resource://com.example.menuapp3/drawable/empanada");
        listItems.add(item);

        item = new ListBreakfastItem(
                "Pollo a la plancha", "Pollo a la plancha, acompañado de papas fritas y ensalada o verduras",
                "Precio: 4500 i.v.i",
                "android.resource://com.example.menuapp3/drawable/polloplancha");
        listItems.add(item);
    }
}
