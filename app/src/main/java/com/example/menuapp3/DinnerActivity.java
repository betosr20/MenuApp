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

public class DinnerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListBreakfastItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //        up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Busca e inicializa el recyclerView
        recyclerView = findViewById(R.id.dinnerRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Llamada a la funcion que popula la lista con las cenas
        createDinners();

        //Crea un nuevo adapter con la lista de items creada previamente y le fija el adapter al recyclerView
        adapter =  new BreakfastAdapter(this, listItems);
        recyclerView.setAdapter(adapter);
    }
    private void createDinners() {
        listItems = new ArrayList<>();
        ListBreakfastItem item;
        item = new ListBreakfastItem(
                "Fish n chips", "El característico Fish n Chips con salsa tártara", "Precio: 6500 i.v.i",
                "android.resource://com.example.menuapp3/drawable/fishnchips");
        listItems.add(item);

        item = new ListBreakfastItem(
                "Hamburguesa con tocino", "Hamburguesa con torta de carne de media libra, queso, tocineta, cebolla, legucha y tomate" +
                "acompañada de papas fritas", "Precio: 3000 i.v.i",
                "android.resource://com.example.menuapp3/drawable/hamburguesa");
        listItems.add(item);

        item = new ListBreakfastItem(
                "Filet Mignong", "Filet Mignon, acompañado de ensalada, vegetales y papas fritas o puré de papa",
                "Precio: 10000 i.v.i",
                "android.resource://com.example.menuapp3/drawable/filetmignong");
        listItems.add(item);

        item = new ListBreakfastItem(
                "Lasagna", "Deliciosa lasagna de pollo en salsa blanca o de carne en salsa de tomate, acompañada de pan con mantequilla de ajo",
                "Precio: 4500 i.v.i",
                "android.resource://com.example.menuapp3/drawable/lasagna");
        listItems.add(item);
    }
}
