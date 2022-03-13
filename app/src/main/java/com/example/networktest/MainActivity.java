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

        Button calculate = findViewById(R.id.quersumme);
        calculate.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            try {
                EditText et = findViewById(R.id.matrNum);
                String matrNum = et.getText().toString();
                ClientThread t = new ClientThread(matrNum);
                Thread newThread = new Thread(t);
                newThread.start();
                newThread.join();
                TextView antwort = findViewById(R.id.antwortServer);
                antwort.setText(t.getMatrNum());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if (view.getId() == R.id.quersumme) {
            EditText et = findViewById(R.id.matrNum);
            String matrNum = et.getText().toString();
            int value = 0;
            if (matrNum.length() != 0) {
                value = Integer.parseInt(matrNum);
            }
            int sum = MathOperations.calcAltQuersumme(value);
            TextView antwort = findViewById(R.id.antwortServer);
            String str = Integer.toString(sum);
            antwort.setText(str);
            antwort.append(MathOperations.isEval(sum) ? "\ntrue" : "\nfalse");
        }

    }

}