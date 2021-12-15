package com.example.crud_tbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ConexionBD.Conexion;
import Modelo.UsuarioT;

public class Activity_login extends AppCompatActivity implements View.OnTouchListener {
    TextView a;
    EditText user,contra;
    Button iniciarSesion;
    Button iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        a=(TextView) findViewById(R.id.lbl_creaCuenta);
        a.setOnTouchListener(this);

        //-------------------

        iniciarSesion = (Button) findViewById(R.id.btn_iniciar);

        user = findViewById(R.id.et_User);
        contra = findViewById(R.id.et_ps_contra);
        iniciar = findViewById(R.id.btn_iniciar);

    }

        public void inicio(View v){
        String userid = user.getText().toString().trim();
        String contra = user.getText().toString().trim();
            if (!(userid.equals("")) && !(contra.equals(""))){
                Intent i = new Intent(this,Activity_inicio.class);
                startActivity(i);
            }

        }


        @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            Intent i;
            i = new Intent(this, Activity_Registro.class);
            startActivity(i);
        }
        return false;
    }
}