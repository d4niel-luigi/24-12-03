package com.example.gd_dolgozat24_12_02;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText editTextKonyvCim, editTextSzerzo, editTextOldalszam;
    private Button buttonHozzaadas, torlesButton;
    private ListView listViewKonyvek;
    private BookAdapter bookAdapter;
    private List<Book> bookList;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextKonyvCim = findViewById(R.id.editTextKonyvCim);
        editTextSzerzo = findViewById(R.id.editTextSzerzo);
        editTextOldalszam = findViewById(R.id.editTextOldalszam);
        buttonHozzaadas = findViewById(R.id.buttonHozzaadas);
        listViewKonyvek = findViewById(R.id.listViewKonyvek);
        torlesButton = findViewById(R.id.torlesButton);

        bookList = new ArrayList<>();
        bookAdapter = new BookAdapter(bookList, this);
        listViewKonyvek.setAdapter(bookAdapter);

        buttonHozzaadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTextKonyvCim.getText().toString();
                String author = editTextSzerzo.getText().toString();
                String pagesStr = editTextOldalszam.getText().toString();

                if (title.isEmpty() || author.isEmpty() || pagesStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Minden mező kitöltése kötelező!", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        int pages = Integer.parseInt(pagesStr);
                        if (pages < 50) {
                            Toast.makeText(MainActivity.this, "Az oldalszám legalább 50 kell legyen!", Toast.LENGTH_SHORT).show();
                        } else {
                            Random random = new Random();
                            int year = random.nextInt(124) + 1900;

                            Book newBook = new Book(title, author, pages, year);
                            bookList.add(newBook);
                            bookAdapter.notifyDataSetChanged();

                            editTextKonyvCim.setText("");
                            editTextSzerzo.setText("");
                            editTextOldalszam.setText("");
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Oldalszám nem lehet üres vagy nem szám!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
