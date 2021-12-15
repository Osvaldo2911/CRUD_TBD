package com.example.crud_tbd;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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


    }

    public void registroBtn(View v){
        conexion = Conexion.gettAppDatabase(getBaseContext());
        nom = nombre.getText().toString();
        email = user.getText().toString();
        cn = contra.getText().toString().trim();
        cnc = confirmar.getText().toString().trim();

        resultados.setText("nom: "+nom);

        if (!nom.equals("")){
            if (!email.equals("")){
                if (!cn.equals("")){
                    if (!cnc.equals("")){
                        if (terminos.isChecked()){
                            //--------------------------------------------------
                            resultados.setText("Cumples todos los requisitos");

                            List<UsuarioT> busqueda = conexion.usuarioDAO().usuarioDisponible(email);

                            resultados.setText(busqueda.toString()+"<--tabla");

                            if (busqueda == null){
                                resultados.setText("Usuario disponible");
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



       /*
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        */
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