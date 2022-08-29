package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    ArrayList<Sections> sections=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        Sections sec1 = new Sections("Books",R.drawable.books);
        Sections sec2 = new Sections("audio books", R.drawable.audiobook2);
        Sections sec3 = new Sections("Ebooks", R.drawable.ebook);

        sections.add(sec1);
        sections.add(sec2);
        sections.add(sec3);


        secAdapter adapter = new secAdapter(this,0,sections);

        ListView listView= findViewById(R.id.mylistview);

        listView.setAdapter(adapter);
    }
}