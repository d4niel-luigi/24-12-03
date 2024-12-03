package com.example.gd_dolgozat24_12_02;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends BaseAdapter {

    private List<Book> books;
    private Context context;

    public BookAdapter(List<Book> books, Context context) {
        this.books = books;
        this.context = context;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_details, parent, false);
        }

        TextView textViewKonyvCim = convertView.findViewById(R.id.textViewKonyvCim);
        TextView textViewKonyvSzerzo = convertView.findViewById(R.id.textViewKonyvSzerzo);
        TextView textViewOldal = convertView.findViewById(R.id.textViewOldal);

        Book book = books.get(position);

        textViewKonyvCim.setText(book.getTitle());
        textViewKonyvSzerzo.setText(book.getAuthor());
        textViewOldal.setText("Oldalszám: " + book.getPages());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("book_title", book.getTitle());
                intent.putExtra("book_author", book.getAuthor());
                intent.putExtra("book_pages", book.getPages());
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
