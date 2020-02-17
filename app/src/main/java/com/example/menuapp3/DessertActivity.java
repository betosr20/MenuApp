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

public class DessertActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListBreakfastItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //        up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Busca e inicializa el recyclerView
        recyclerView = findViewById(R.id.dessertRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Llamada a la funcion que popula la lista con las cenas
        createDesserts();

        //Crea un nuevo adapter con la lista de items creada previamente y le fija el adapter al recyclerView
        adapter =  new BreakfastAdapter(this, listItems);
        recyclerView.setAdapter(adapter);

    }
    private void createDesserts() {
        listItems = new ArrayList<>();
        ListBreakfastItem item;
        item = new ListBreakfastItem(
                "Tres Leches", "Tres Leches de la casa acompañado de chispitas de chocolate", "Precio: 3000 i.v.i",
                "android.resource://com.example.menuapp3/drawable/fishnchips");
        listItems.add(item);

        item = new ListBreakfastItem(
                "Flan de coco", "Flan de coco de la casa" +
                "acompañada de papas fritas", "Precio: 3000 i.v.i",
                "android.resource://com.example.menuapp3/drawable/flancoco");
        listItems.add(item);

        item = new ListBreakfastItem(
                "Churros", "Churros hechos en la casa, rellenos con dulce de leche y cubiertos con azúcar y chocolate",
                "Precio: 2500 i.v.i",
                "android.resource://com.example.menuapp3/drawable/churros");
        listItems.add(item);

        item = new ListBreakfastItem(
                "Helados de vainilla", "2 bolitas de helado de vainilla con un barquillo de chocolate",
                "Precio: 2000 i.v.i",
                "android.resource://com.example.menuapp3/drawable/helados");
        listItems.add(item);
    }
}
