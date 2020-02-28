package Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menuapp3.LunchActivity;
import com.example.menuapp3.MainActivity;
import com.example.menuapp3.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import Model.ListBreakfastItem;

import com.example.menuapp3.OrderActivity;

import static androidx.core.content.ContextCompat.startActivity;


public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private Context context;
    private List<ListBreakfastItem> listItem;

    public OrderAdapter (Context context, List listItem) {
        this.context = context;
        this.listItem = listItem;
    }
    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.breakfast_list_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, int position) {
        ListBreakfastItem item = listItem.get(position);
        holder.tittle.setText(item.getTittle());
        holder.description.setText(item.getDescription());
        holder.price.setText(item.getPrice());
        Uri uri = Uri.parse(item.getImageURL());
        holder.image.setImageURI(uri);
        holder.buttonAdd.setText("-");
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView tittle, description, price;
        public CheckBox mealCheck;
        public Button buttonAdd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageBreakfast);
            tittle = itemView.findViewById(R.id.breakfastTittle);
            description = itemView.findViewById(R.id.breakfastDescription);
            price = itemView.findViewById(R.id.breakfastPrice);
            buttonAdd = itemView.findViewById(R.id.buttonAdd);

            //Setea el event listener para cada boton
            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    SaveData();

                }
            });

        }

        public void SaveData() {
            // Busca el archivo de shared preferences
            SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson =  new Gson();
            String json = sharedPreferences.getString("task list", null);
            Type type = new TypeToken<ArrayList<ListBreakfastItem>>() {}.getType();
            ArrayList<ListBreakfastItem> listFromStorage;

            //Trea la lista del localStorage
            listFromStorage = gson.fromJson(json, type);
            int position;
            position = getAdapterPosition();

            //Trae el item actual al que se le esta haciendo el on click
            ListBreakfastItem item = listItem.get(position);

            if (listFromStorage != null) {
                listFromStorage.remove(position);
                String jsonAdd = gson.toJson(listFromStorage);
                editor.putString("task list", jsonAdd);
                editor.apply();

                if (!listFromStorage.isEmpty()) {
                    Intent intent = new Intent(context, OrderActivity.class);
                    context.startActivity(intent);
                } else {
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);
                }


            }


            Toast.makeText(context,"El articulo " + item.getTittle() + " ha sido eliminado del carrito",Toast.LENGTH_SHORT).show();

        }
    }
}


