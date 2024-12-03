package com.example.gd_dolgozat24_12_02;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String title = getIntent().getStringExtra("book_title");
        String author = getIntent().getStringExtra("book_author");
        int pages = getIntent().getIntExtra("book_pages", 0);

        TextView textViewKonyvCim = findViewById(R.id.textViewKonyvCim);
        TextView textViewKonyvSzerzo = findViewById(R.id.textViewKonyvSzerzo);
        TextView textViewOldal = findViewById(R.id.textViewOldal);
        TextView textViewRandom = findViewById(R.id.textViewRandomEv);
        Button backButton = findViewById(R.id.backButton);
        Button torlesButton = findViewById(R.id.torlesButton);

        textViewKonyvCim.setText("Cím: " + title);
        textViewKonyvSzerzo.setText("Szerző: " + author);
        textViewOldal.setText("Oldalszám: " + pages);

        Random r = new Random();
        int randomYear = r.nextInt(54) + 1970;
        textViewRandom.setText("Év: " + randomYear);

        backButton.setVisibility(View.VISIBLE);
        torlesButton.setVisibility(View.GONE);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
