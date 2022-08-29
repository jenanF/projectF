package com.example.myfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class stores_activity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://kcfinalproject1-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();



    ArrayList<Books> store = new ArrayList<>();
    ArrayList<Books> pubhouse = new ArrayList<>();
    ArrayList<Books> usedo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores);




        RecyclerView options = findViewById(R.id.main_rv);
        options.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        options.setLayoutManager(llm);
        rvAdapter ra = new rvAdapter(store,this);
        options.setAdapter(ra);

        Query stores = dbRef.child("BookStores");

        stores.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot p :dataSnapshot.getChildren()){
                    Books sect = p.getValue(Books.class);
                    store.add(sect);

                    ra.notifyDataSetChanged();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });










        RecyclerView houses = findViewById(R.id.publishing_rv);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        houses.setLayoutManager(lm);



        houseAdapter r = new houseAdapter(pubhouse,this);
        houses.setAdapter(r);


        Query publishing = dbRef.child("Publishing houses");

        publishing.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot sh :dataSnapshot.getChildren()){
                    Books sc = sh.getValue(Books.class);
                    pubhouse.add(sc);
                }
                r.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });








        RecyclerView usedbooks = findViewById(R.id.used_rv);
        usedbooks.setHasFixedSize(true);
        LinearLayoutManager lam = new LinearLayoutManager(this);
        lam.setOrientation(LinearLayoutManager.HORIZONTAL);
        usedbooks.setLayoutManager(lam);

        rvAdapter rb = new rvAdapter(usedo,this);
        usedbooks.setAdapter(rb);






    }
}