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

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static java.math.BigDecimal.*;

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
                BigDecimal PU = null;

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
                        PU = valueOf(30).divide(valueOf(Qté)).add(valueOf(0.2).multiply(valueOf(Cl)).multiply(valueOf(Cc))).add(valueOf(0.2));
                    }

                    if(Cl > 2 && Cl < 5) {
                        PU = valueOf(60).divide(valueOf(Qté)).add(valueOf(0.2).multiply(valueOf(Cl)).multiply(valueOf(Cc))).add(valueOf(0.2));
                    }

                }

                if(dos.isChecked()){

                    if(Cl > 0 && Cl < 3) {
                        PU = valueOf(40).divide(valueOf(Qté)).add(valueOf(0.3).multiply(valueOf(Cl)).multiply(valueOf(Cc))).add(valueOf(0.2));
                    }

                    if(Cl > 2 && Cl < 5) {
                        PU = valueOf(80).divide(valueOf(Qté)).add(valueOf(0.3).multiply(valueOf(Cl)).multiply(valueOf(Cc))).add(valueOf(0.2));
                    }
                }

                BigDecimal PT = PU.multiply(valueOf(Qté));

                if(!PT.equals(0)){
                    ViewPU.setText("PU: "+ new DecimalFormat("##.###").format(PU) + " DT");
                    ViewPT.setText("PT: "+ new DecimalFormat("##.###").format(PT) + " DT");
                }
            } ;

        });

    }}