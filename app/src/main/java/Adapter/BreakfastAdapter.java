package Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menuapp3.R;

import java.util.List;

import Model.ListBreakfastItem;

public class BreakfastAdapter extends RecyclerView.Adapter<BreakfastAdapter.ViewHolder> {
    private Context context;
    private List<ListBreakfastItem> listItem;

    public BreakfastAdapter (Context context, List listItem){
        this.context = context;
        this.listItem = listItem;
    }
    @NonNull
    @Override
    public BreakfastAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.breakfast_list_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BreakfastAdapter.ViewHolder holder, int position) {
        ListBreakfastItem item = listItem.get(position);
        holder.tittle.setText(item.getTittle());
        holder.description.setText(item.getDescription());
        holder.price.setText(item.getPrice());

    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView tittle, description, price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageBreakfast);
            tittle = itemView.findViewById(R.id.breakfastTittle);
            description = itemView.findViewById(R.id.breakfastDescription);
            price = itemView.findViewById(R.id.breakfastPrice);
        }
    }
}
