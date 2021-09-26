package com.example.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText userField;
    EditText passwordField;
    public static final String LOG = "CHUU";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userField = findViewById(R.id.editTextUsername);
        passwordField = findViewById(R.id.editTextPassword);
    }

    public void validateLogin(View view) {
        Context context = getApplicationContext();
        if (userField.getText().toString().equals("") || passwordField.getText().toString().equals("")) {
            Toast toast = Toast.makeText(context, "Please enter username and password", Toast.LENGTH_SHORT);
            toast.show();
        } else if (userField.getText().toString().equals("admin") && passwordField.getText().toString().equals("admin")) {
            Intent intent = new Intent(this, MainActivity.class);
            String username = userField.getText().toString();
            intent.putExtra("username", username);
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(context, "User not found", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}