package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText EditButtonPoche;
    private EditText EditButtonDos;
    private EditText EditQté;
    private EditText EditCl;
    private EditText EditCc;
    private TextView ViewPU;
    private TextView ViewPT;
    private Button ButtonJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditQté = findViewById(R.id.EditQté);
        EditCl = findViewById(R.id.EditCl);
        EditCc = findViewById(R.id.EditCc);
        ViewPU = findViewById(R.id.ViewPU);
        ViewPT = findViewById(R.id.ViewPT);
        ButtonJoin = findViewById(R.id.ButtonJoin);

        ButtonJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Quantité=EditQté.getText().toString();
                String Couleurs=EditCl.getText().toString();
                String Couches=EditCc.getText().toString();

                RadioButton Poche = (RadioButton) findViewById(R.id.ButtonPoche);

                if (Poche.isChecked()) {

                    if (EditQté.getText().toString().length()==0) {
                        EditQté.setText("100");
                    }
                    if (EditCl.getText().toString().length() == 0) {
                        EditCl.setText("1");
                    }
                    if (EditCc.getText().toString().length() == 0) {
                        EditCc.setText("1");
                    }

                    int Qté = Integer.parseInt(EditQté.getText().toString());
                    int Cl = Integer.parseInt(EditCl.getText().toString());
                    int Cc = Integer.parseInt(EditCc.getText().toString());

                        int PU = (40000 / Qté) + (300 * Cl * Cc) + 200;
                        int PT = (PU * Qté);

                        ViewPU.setText(String.valueOf(PU));
                        ViewPT.setText(String.valueOf(PT));

                    }

                 else{

                        if (EditQté.getText().toString().length() == 0) {
                            EditQté.setText("100");
                        }
                        if (EditCl.getText().toString().length() == 0) {
                            EditCl.setText("1");
                        }
                        if (EditCc.getText().toString().length() == 0) {
                            EditCc.setText("1");
                        }

                        int Qté = Integer.parseInt(EditQté.getText().toString());
                        int Cl = Integer.parseInt(EditCl.getText().toString());
                        int Cc = Integer.parseInt(EditCc.getText().toString());

                        int PU = (30000 / Qté) + (200 * Cl * Cc) + 200;
                        int PT = (PU * Qté);

                        ViewPU.setText(String.valueOf(PU));
                        ViewPT.setText(String.valueOf(PT));
                    }


                } ;

        });

    }}