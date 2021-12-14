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
//-------
        conexion = Conexion.gettAppDatabase(getBaseContext());
        nom = nombre.getText().toString();
        email = user.getText().toString();
        cn = contra.getText().toString().trim();
        cnc = confirmar.getText().toString().trim();




        //------------final

    }

    public void registroBtn(View v){

        resultados.setText("["+nom+"] ["+email+"] ["+cn+"] ["+cnc+"]");

        //----------Inicio

        new Thread(new Runnable() {
            @Override
            public void run() {



                /*
                boolean datosValidos =false;

                if(!nom.equals("")&& !(email.equals("")) &&!cn.equals("")&&!cnc.equals("")){
                    if(cn.equals(cnc) && terminos.isChecked()==true){
                        if (isEmailValid(email)){
                            datosValidos = true;
                        }
                    }
                }
                if (datosValidos = true){
                    //conexion.usuarioDAO().insertarUsuario(new UsuarioT("osvaldo","OS@gmail.com","12345"));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Registro con exito",
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });
                }else{
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Registro con fallido",
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });
                }



                 */


            }
        });

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
    /*
    registro.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        }
        });


            if(nom.isEmpty() && us.isEmpty() && cn.isEmpty() && cnc.isEmpty() && cn.equals(cnc) && terminos.isChecked() ){

                conexion.usuarioDAO().insertarUsuario(new UsuarioT(nom,us,cn));

                UsuarioT a;
                a = conexion.usuarioDAO().buscarUsuario(us,cn);
                Log.d("Prueba", "res = "+a.getUserName()+""+a.getContraseña()+""+a.getNombre());

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Registro con exito",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });


            }

        }
    });

     */





}