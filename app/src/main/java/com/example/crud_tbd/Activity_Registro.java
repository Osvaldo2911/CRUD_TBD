package com.example.crud_tbd;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.*;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ConexionBD.Conexion;
import Modelo.UsuarioT;

public class Activity_Registro extends AppCompatActivity implements View.OnTouchListener {
    TextView a,resultados;
     Button registro;
     EditText nombre, user, contra, confirmar;
     CheckBox terminos;
    String nom,email,cn,cnc;
    Conexion conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        a=findViewById(R.id.lbl_iniciaSesion);
        a.setOnTouchListener(this);

        registro = findViewById(R.id.btn_registrar);

        nombre = findViewById(R.id.et_NombreFullRegistro);
        user = findViewById(R.id.et_UserRegistro);
        contra = findViewById(R.id.et_ps_contraRegistrar);
        confirmar = findViewById(R.id.et_ps_contraConfirmarRegistrar);
        terminos = findViewById(R.id.terminosCondiciones);

        resultados = findViewById(R.id.lbl_resultados);

        user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (user.getText().toString().length() > 0) {
                    int punto = 0;
                    int arro = 0;

                    for (int i = 0; i < user.getText().toString().length(); i++) {
                        String ema = user.getText().toString();
                        int a = ema.charAt(i);
                        if (a == 46) {
                            punto = punto + 1;
                        }
                        if (a == 64) {
                            arro = arro + 1;
                        }
                    }

                    if (punto > 0 && arro > 0){
                        email = user.getText().toString();
                    }


                }
            }
        });


        contra.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (contra.getText().length() >= 8) {
                    int n = 0;
                    int ma = 0;
                    int mi = 0;
                    int sim = 0;
                    for (int i = 0; i < contra.getText().length(); i++) {
                        String cont = contra.getText().toString();
                        int a = cont.charAt(i);
                        if (a >= 48 && a <= 57) {
                            n = n + 1;
                        }
                        if (a >= 65 && a <= 90) {
                            ma = ma + 1;
                        }
                        if (a >= 97 && a <= 122) {
                            mi = mi + 1;
                        }
                        if (a >= 33 && a <= 47 || a >= 91 && a <= 96 || a >= 123 && a <= 126) {
                            sim = sim + 1;
                        }
                    }

                    if (n>0&&ma>0&&mi>0&&sim>0){
                        cn=contra.getText().toString();
                    }
                }
            }
        });


    }

    public void registroBtn(View v){
        new Thread(new Runnable() {
            @Override
            public void run() {

                /// inicio hilo


        conexion = Conexion.gettAppDatabase(getBaseContext());

        nom = nombre.getText().toString();
        //email = user.getText().toString();
        cn = contra.getText().toString().trim();
        cnc = confirmar.getText().toString().trim();

        resultados.setText("nom: "+nom);

        if (!nom.equals("")){
            if (!email.equals("")){

                if (!cn.equals("")){
                    if (!(cnc.equals(""))  && cn.equals(cnc)){
                        if (terminos.isChecked()){
                            //--------------------------------------------------
                            resultados.setText("Cumples todos los requisitos");
                            UsuarioT busqueda = conexion.usuarioDAO().usuarioDisponible(email);

                            if (busqueda == null){
                                conexion.usuarioDAO().insertarUsuario(new UsuarioT(nom,email,cn));
                                nombre.setText("");
                                user.setText("");
                                contra.setText("");
                                confirmar.setText("");
                                nom ="";
                                cn="";
                                cnc="";
                                terminos.setChecked(false);
                            }

                            //--------------------------------------------------
                        }else{
                            resultados.setText("terminos no aceptados");
                        }
                    }else{
                        resultados.setText("contraseña confirmar vacio");
                    }
                }else{
                    resultados.setText("contraseña vacio");
                }
            } else{
                resultados.setText("email vacio");
            }
        }else{
            resultados.setText("nombre vacio");
        }
        // fin hilo

            }
        }).start();

    }
    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            onBackPressed();
        }
        return false;
    }





}