package com.devedidayg.lenovocomputersapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CategoriesItemViewActivity extends AppCompatActivity {

    TextView textView, textViewDesc, textViewDetails;
    Button visit;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_item_view);


        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("itemName") && intent.hasExtra("itemImage")) {
            String itemName = intent.getStringExtra("itemName");
            String itemDesc = intent.getStringExtra("itemDesc");
            String itemDetails = intent.getStringExtra("itemDetails");
            int itemImage = intent.getIntExtra("itemImage", 0);

            imageView = findViewById(R.id.imageView_item);
            textView = findViewById(R.id.textView_item_name);
            textViewDesc = findViewById(R.id.textView_item_desc);
            visit = findViewById(R.id.btn_visit);



           imageView.setImageResource(itemImage);
           textView.setText(itemName);
           textViewDesc.setText(itemDesc);

            visit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (isNetworkAvailable()) {
                        String itemDetailsUrl = intent.getStringExtra("itemDetails");
                        if (itemDetails != null && !itemDetails.isEmpty()) {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse(itemDetails));
                            startActivity(intent);
                        }
                    } else {
                        showNoInternetDialog();
                    }
                }
            });
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void showNoInternetDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("No internet connection. Please check your network settings.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}