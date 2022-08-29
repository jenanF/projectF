package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        EditText email = findViewById(R.id.editTextEmailAddress);
        EditText password = findViewById(R.id.editTextPassword);
        Button join = findViewById(R.id.buttonJoinUs);



        TextWatcher not = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String myEmail = email.getText().toString().trim();
                String myPass = password.getText().toString().trim();

                join.setEnabled(!myPass.isEmpty()  && !myEmail.isEmpty());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        email.addTextChangedListener(not);
        password.addTextChangedListener(not);


        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent done = new Intent(signinActivity.this, Activity2.class);
                startActivity(done);
            }
        });
    }
}