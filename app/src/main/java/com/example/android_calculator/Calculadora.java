package com.example.android_calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculadora extends AppCompatActivity implements View.OnClickListener {
    boolean rad = false;
    char operacion;
    double conversion;
    Double[] cifra = new Double[10];
    boolean nuevaOperacion = true;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        Button button0 = findViewById(R.id.button0);
        button0.setOnClickListener(this);
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);
        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);
        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(this);
        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(this);
        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(this);
        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(this);
        Button button_sum = findViewById(R.id.button_sum);
        button_sum.setOnClickListener(this);
        Button button_res = findViewById(R.id.button_res);
        button_res.setOnClickListener(this);
        Button button_mult = findViewById(R.id.button_mult);
        button_mult.setOnClickListener(this);
        Button button_div = findViewById(R.id.button_div);
        button_div.setOnClickListener(this);
        Button button_eq = findViewById(R.id.button_eq);
        button_eq.setOnClickListener(this);
        Button button_clear = findViewById(R.id.button_clear);
        button_clear.setOnClickListener(this);
        Button button_sin = findViewById(R.id.button_sin);
        button_sin.setOnClickListener(this);
        Button button_cos = findViewById(R.id.button_cos);
        button_cos.setOnClickListener(this);
        Button button_tan = findViewById(R.id.button_tan);
        button_tan.setOnClickListener(this);
        Switch rad_change = findViewById(R.id.rad_change);
        rad_change.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean Checked) {
                if (Checked) {
                    rad = false;
                } else {
                    rad = true;
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        TextView respuesta = findViewById(R.id.respuesta);
        int op = view.getId();
        String num = respuesta.getText().toString();


        if (nuevaOperacion) {
            num = "";
            nuevaOperacion = false;
        }

        try {
            if (op == R.id.button0) {
                respuesta.setText(num + "0");
            } else if (op == R.id.button1) {
                respuesta.setText(num + "1");
            } else if (op == R.id.button2) {
                respuesta.setText(num + "2");
            } else if (op == R.id.button3) {
                respuesta.setText(num + "3");
            } else if (op == R.id.button4) {
                respuesta.setText(num + "4");
            } else if (op == R.id.button5) {
                respuesta.setText(num + "5");
            } else if (op == R.id.button6) {
                respuesta.setText(num + "6");
            } else if (op == R.id.button7) {
                respuesta.setText(num + "7");
            } else if (op == R.id.button8) {
                respuesta.setText(num + "8");
            } else if (op == R.id.button9) {
                respuesta.setText(num + "9");
            } else if (op == R.id.button_sum) {
                cifra[0] = Double.parseDouble(num);
                operacion = '+';
                respuesta.setText("");
            } else if (op == R.id.button_res) {
                cifra[0] = Double.parseDouble(num);
                operacion = '-';
                respuesta.setText("");
            } else if (op == R.id.button_mult) {
                cifra[0] = Double.parseDouble(num);
                operacion = '*';
                respuesta.setText("");
            } else if (op == R.id.button_div) {
                cifra[0] = Double.parseDouble(num);
                operacion = '/';
                respuesta.setText("");
            } else if (op == R.id.button_sin) {
                cifra[0] = Double.parseDouble(num);
                respuesta.setText("sin("+ num +")");
                if (rad) {
                    conversion = Math.sin(Math.toRadians(cifra[0]));
                } else {
                    conversion = Math.sin(cifra[0]);
                }
                respuesta.setText(String.valueOf(conversion));
                nuevaOperacion = true;
            } else if (op == R.id.button_cos) {
                cifra[0] = Double.parseDouble(num);
                respuesta.setText("cos("+ num +")");
                if (rad) {
                    conversion = Math.cos(Math.toRadians(cifra[0]));
                } else {
                    conversion = Math.cos(cifra[0]);
                }
                respuesta.setText(String.valueOf(conversion));
                nuevaOperacion = true;
            } else if (op == R.id.button_tan) {
                cifra[0] = Double.parseDouble(num);
                respuesta.setText("tan("+ num +")");
                if (rad) {
                    conversion = Math.tan(Math.toRadians(cifra[0]));
                } else {
                    conversion = Math.tan(cifra[0]);
                }
                respuesta.setText(String.valueOf(conversion));
                nuevaOperacion = true;
            } else if (op == R.id.button_eq) {
                cifra[1] = Double.parseDouble(num);

                if (operacion == '+') {
                    conversion = cifra[0] + cifra[1];
                } else if (operacion == '-') {
                    conversion = cifra[0] - cifra[1];
                } else if (operacion == '*') {
                    conversion = cifra[0] * cifra[1];
                } else if (operacion == '/') {
                    conversion = cifra[0] / cifra[1];
                }

                respuesta.setText(String.valueOf(conversion));
                nuevaOperacion = true;
            } else if (op == R.id.button_clear) {
                respuesta.setText("0");
                nuevaOperacion = true;
            }
        } catch (Exception e) {
            respuesta.setText("Error");
        }
    }
}

