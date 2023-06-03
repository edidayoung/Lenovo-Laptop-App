package com.devedidayg.lenovocomputersapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devedidayg.lenovocomputersapp.Models.CategoriesItems;
import com.devedidayg.lenovocomputersapp.R;
import com.devedidayg.lenovocomputersapp.Listeners.SelectListener;
import com.devedidayg.lenovocomputersapp.ViewModels.CategoriesViewHolder;

import java.util.List;

public class CategoriesRecyclerView extends RecyclerView.Adapter<CategoriesViewHolder>  {

    private Context context;
    private List<CategoriesItems> categoriesItems;
   final private SelectListener listener;

    public CategoriesRecyclerView(Context context, List<CategoriesItems> categoriesItems, SelectListener listener) {
        this.context = context;
        this.categoriesItems = categoriesItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoriesViewHolder(LayoutInflater.from(context).inflate(R.layout.categories_items_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
         holder.imageView.setImageResource(categoriesItems.get(position).getImages());
         holder.textView.setText(categoriesItems.get(position).getNames());

         holder.cardView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 listener.onItemClicked(categoriesItems.get(position));
             }
         });
    }

    @Override
    public int getItemCount() {
        return categoriesItems.size();
    }
}
