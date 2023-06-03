package com.devedidayg.lenovocomputersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.devedidayg.lenovocomputersapp.Models.ItemsModel;

public class ItemsViewActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView,textView_desc;

    ItemsModel itemsModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_view);

        imageView = findViewById(R.id.imageView_item);
        textView = findViewById(R.id.textView_item_name);
        textView_desc = findViewById(R.id.textView_item_desc);

        Intent intent = getIntent();

       if (intent.getExtras() != null){
            itemsModel = (ItemsModel) intent.getSerializableExtra("item");
            imageView.setImageResource(itemsModel.getImages());
            textView.setText(itemsModel.getName());
            textView_desc.setText(itemsModel.getDesc());

        }
    }
}