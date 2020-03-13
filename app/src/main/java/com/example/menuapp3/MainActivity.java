package com.example.menuapp3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.Type;
import java.util.ArrayList;

import Model.ListBreakfastItem;

public class MainActivity extends AppCompatActivity {
    private ImageView breakfastImage;
    private ImageView lunchImage;
    private ImageView dinnerImage;
    private ImageView drinksImage;
    private ImageView dessertsImage;
    private FirebaseAnalytics mFirebaseAnalytics;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Inicializa la instancia de Firebase Analytics
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        breakfastImage = (ImageView) findViewById(R.id.breakfastImageMain);

        //On click para el desayuno
        breakfastImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringID;
                stringID = String.valueOf(breakfastImage.getId());
                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, stringID);
                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Breakfast Image");
                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

                startActivity(new Intent(MainActivity.this, BreakfastActivity.class));
            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //On click para el almuerzo
        lunchImage = (ImageView) findViewById(R.id.lunchImageMain);

        lunchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui va el codigo

                startActivity(new Intent(MainActivity.this, LunchActivity.class));
            }
        });

        //On click para las cenas
        dinnerImage = (ImageView) findViewById(R.id.dinnerImageMain);

        dinnerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui va el codigo

                startActivity(new Intent(MainActivity.this, DinnerActivity.class));
            }
        });

        //On click para las bebidas
        drinksImage = (ImageView) findViewById(R.id.drinksImageMain);

        drinksImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui va el codigo

                startActivity(new Intent(MainActivity.this, DrinkActivity.class));
            }
        });

        //On click para los postres
        dessertsImage = (ImageView) findViewById(R.id.dessertImageMain);

        dessertsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui va el codigo

                startActivity(new Intent(MainActivity.this, DessertActivity.class));
            }
        });
        

        //FloatingActionButton fab = findViewById(R.id.fab);
       // fab.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
       //         Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
           //             .setAction("Action", null).show();
       //     }
      //  });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //search the list from localStorage
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences("shared preferences", Context.MODE_PRIVATE);
        Gson gson =  new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<ListBreakfastItem>>() {}.getType();
        ArrayList<ListBreakfastItem> listFromStorage;

        //Trea la lista del localStorage
        listFromStorage = gson.fromJson(json, type);


        //noinspection SimplifiableIfStatement
        if (!listFromStorage.isEmpty() && id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, OrderActivity.class));
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
