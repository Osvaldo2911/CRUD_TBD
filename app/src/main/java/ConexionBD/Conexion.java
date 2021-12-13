package ConexionBD;

import android.content.Context;
import android.graphics.Region;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.crud_tbd.R;

import Modelo.Cliente;
import Modelo.Historial;
import Modelo.Usuario;


@Database(entities = {Cliente.class, Usuario.class, Historial.class},version =1,exportSchema = false)

public abstract class Conexion extends RoomDatabase {

    //DAO

    private static Conexion INSTANCE;

    private static RoomDatabase.Callback CALLBACK = null;

    public static Conexion gettAppDatabase(Context context){

        //*--*
        if(INSTANCE==null){

            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    Conexion.class,"@northwind").addCallback(CALLBACK).build();
            /*INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    Northwind.class,"@northwind").build();*/
        }
        //*--*


     return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE=null;
    }

}
