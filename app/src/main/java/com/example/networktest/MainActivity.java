package com.example.networktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend = findViewById(R.id.button);
        btnSend.setOnClickListener(MainActivity.this);
    }

    public void onClick(View view)  {
        try {
            EditText et = findViewById(R.id.matrNum);
            String matrNum = et.getText().toString();
            ClientThread t = new ClientThread(matrNum);
            Thread newThread = new Thread(t);
            newThread.start();
            newThread.join();
            TextView antwort = findViewById(R.id.antwortServer);
            antwort.setText(t.getMatrNum());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}