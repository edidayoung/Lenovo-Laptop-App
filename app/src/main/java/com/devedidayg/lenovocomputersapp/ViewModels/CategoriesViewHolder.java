package com.devedidayg.lenovocomputersapp.ViewModels;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.devedidayg.lenovocomputersapp.R;

public class CategoriesViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView textView;
    public CardView cardView;
    public CategoriesViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.categories_image_view);
        textView = itemView.findViewById(R.id.textView_categories_name);
        cardView = itemView.findViewById(R.id.categories_cardView);

    }
}
