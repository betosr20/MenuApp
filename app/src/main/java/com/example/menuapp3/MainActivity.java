package com.example.menuapp3;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView breakfastImage;
    private ImageView lunchImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        breakfastImage = (ImageView) findViewById(R.id.breakfastImageMain);

        //On click para el desayuno
        breakfastImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui va el codigo

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
        lunchImage = (ImageView) findViewById(R.id.dinnerImageMain);

        lunchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui va el codigo

                startActivity(new Intent(MainActivity.this, DinnerActivity.class));
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
