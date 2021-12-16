package com.example.crud_tbd;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

import ConexionBD.Conexion;
import Modelo.ClienteT;

public class Activity_datos extends AppCompatActivity {
    TextView reDatos;
    boolean[] activo = {true,true,true,true,true,true,true}; //En Conjunto con el metodo cambioBoton
    String[] datos = new String[6]; //En Conjunto con el metodo cambioBoton
    TextView nom,ap,clNo,tel,rmx,prtyp,filtro;
    String noms,aps,clNos,tels,rmxs,prtyps;
    EditText busquedaFiltro;
    TextView btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);


        //---boton de regresar al inicio
        reDatos = findViewById(R.id.lbl_Regresar);
        regresar(reDatos);
        //--->

        //--- Cambio del estilo de boton al precionarlo
        nom=findViewById(R.id.lbl_f_nom);
        ap=findViewById(R.id.lbl_f_ap);
        clNo=findViewById(R.id.lbl_f_sdni);
        tel=findViewById(R.id.lbl_f_fn);
        rmx=findViewById(R.id.lbl_f_am);
        prtyp=findViewById(R.id.lbl_f_dir);
        busquedaFiltro=findViewById(R.id.ed_busqueda_filtro);
        filtro=findViewById(R.id.lbl_filtros);

        noms = nom.getText().toString();
        aps = ap.getText().toString();
        clNos = clNo.getText().toString();
        tels = tel.getText().toString();
        rmxs = rmx.getText().toString();
        prtyps = prtyp.getText().toString();

        cambioBoton(nom,0,busquedaFiltro);
        cambioBoton(ap,1,busquedaFiltro);
        cambioBoton(clNo,2,busquedaFiltro);
        cambioBoton(tel,3,busquedaFiltro);
        cambioBoton(rmx,4,busquedaFiltro);
        cambioBoton(prtyp,5,busquedaFiltro);


        ConstraintLayout cl = findViewById(R.id.cl_f_opciones); //chico
        TextView ic = findViewById(R.id.lbl_f_icono);
        ConstraintLayout cl2 = findViewById(R.id.cl_datos);

        ic.setRotation(0);
        cl2.setTranslationY(20);
        cl.setVisibility(View.INVISIBLE);

        // Mostrar seccion de filtros
        filtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activo[6] == false){
                    cl.setVisibility(View.INVISIBLE);
                    cl2.setTranslationY(20);
                    ic.setRotation(0);
                    activo[6] = true;
                }else if(activo[6]==true){
                    cl2.setTranslationY(400);
                    cl.setVisibility(View.VISIBLE);
                    activo[6] = false;
                    ic.setRotation(90);
                }
            }
        });
        //--->

        btnBuscar=findViewById(R.id.lbl_buscarBTN);
        buscar(btnBuscar);

    } // fin constructor

    public void cambioBoton(TextView boton,int index,EditText entradaSalida){

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activo[index] == true){
                    boton.setBackgroundResource(R.drawable.filtroa);
                    boton.setTextColor(Color.WHITE);
                    String cbS = entradaSalida.getText().toString().trim();
                    datos[index] = cbS;
                    entradaSalida.setText("");
                    activo[index] = false;
                }else if(activo[index]==false){
                    boton.setBackgroundResource(R.drawable.filtrob);
                    boton.setTextColor(Color.BLACK);
                    entradaSalida.setText(datos[index]);
                    activo[index] = true;
                }
            }
        });
    }



    public void buscar(TextView tv){

                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                        Conexion conexion = Conexion.gettAppDatabase(getBaseContext());
                        List<ClienteT> resConsulta= conexion.clienteDAO().obtenerPersonalizado(noms,aps,clNos,tels,rmxs,prtyps);
                        filtro.setText(resConsulta.toString());
                            }
                        }).start();

                    }
                });
    }

    public void regresar(TextView re){
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void agregarEmpleado(View v) {
        Intent i = new Intent(this, Activity_agregar.class);
        startActivity(i);
    }

}