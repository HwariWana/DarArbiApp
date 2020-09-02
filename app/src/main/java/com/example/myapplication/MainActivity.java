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

import java.text.DecimalFormat;

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
                RadioButton poche = (RadioButton) findViewById(R.id.ButtonPoche);
                RadioButton dos = (RadioButton) findViewById(R.id.ButtonDos);

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
                double PT = 0.000;
                double PU = 0.000;

                if (EditQté.getText().toString().length() == 0 &&
                        EditCl.getText().toString().length() == 0 &&
                        EditCc.getText().toString().length() == 0
                ){
                    ButtonJoin.setEnabled(false);
                }else {
                    ButtonJoin.setEnabled(true);
                }





                if (poche.isChecked()) {



                    if(Cl > 0 && Cl < 3) {
                        PU = (30 / Qté) + (0.2 * Cl * Cc) + 0.2;
                    }

                    if(Cl > 2 && Cl < 5) {
                        PU = (60 / Qté) + (0.2 * Cl * Cc) + 0.2;
                    }

                }

                if(dos.isChecked()){

                    if(Cl > 0 && Cl < 3) {
                        PU = (40 / Qté) + (0.3 * Cl * Cc) + 0.2;
                    }

                    if(Cl > 2 && Cl < 5) {
                        PU = (80 / Qté) + (0.3 * Cl * Cc) + 0.2;
                    }
                    }

                    PT = (PU * Qté);
                    if(PT != 0.0){
                        ViewPU.setText("PU: "+ new DecimalFormat("##.###").format(PU) + " DT");
                        ViewPT.setText("PT: "+ new DecimalFormat("##.###").format(PT) + " DT");
                    }
                } ;

        });

    }}