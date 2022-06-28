package com.example.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class retrieve extends AppCompatActivity {
    EditText nameEditText, passwordEditText;
    String user,pass;
    private Button BackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);


        BackBtn = (Button)findViewById(R.id.backID);
        BackBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(retrieve.this, MainActivity.class);
                startActivity(intent);
            }
        });

        nameEditText = (EditText) findViewById(R.id.nameEditTextID);
        passwordEditText = (EditText) findViewById(R.id.passwordEditTextID);
    }

    public void Retrieve(View view){
        try{
            FileInputStream fileInputStream = openFileInput("androidtext.txt");
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while ((read = fileInputStream.read()) !=-1){
                buffer.append((char)read);
            }

            String name = buffer.substring(0, buffer.indexOf(" "));
            String password = buffer.substring(buffer.indexOf(" ") + 1);

            user = nameEditText.getText().toString();
            pass = passwordEditText.getText().toString();

            if (name.equals(user) && password.equals(pass)){
                Toast.makeText(retrieve.this,"successfully retrieved ", Toast.LENGTH_LONG).show();
            }else
                Toast.makeText(retrieve.this,"Error you stupid b!tch ", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Log.e("Exception: ", e.toString());
        }
    }


    public void Back(View view){
        Intent intent = new Intent(retrieve.this,MainActivity.class);
        startActivity(intent);
    }
}