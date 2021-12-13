package ConexionBD;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import DAO.UsuarioDAO;
import Modelo.ClienteT;
import Modelo.HistorialT;
import Modelo.UsuarioT;


@Database(entities = {ClienteT.class, UsuarioT.class, HistorialT.class},version =1,exportSchema = false)

public abstract class Conexion extends RoomDatabase {

    public abstract UsuarioDAO usuarioDAO();

    private static Conexion INSTANCE;

    private static RoomDatabase.Callback CALLBACK = null;

    public static Conexion gettAppDatabase(Context context){

        //*--*
        if(INSTANCE==null){
            //uso de transacciones
                /*
            CALLBACK = new RoomDatabase.Callback(){
                @Override
                public void onCreate(SupportSQLiteDatabase db) {
                    super.onCreate(db);

                    // -----------------------------------------

                    // Transaccion
                    db.execSQL("BEGIN TRANSACTION");

                    // Creacion de usuario
                    db.execSQL("INSERT INTO Usuario VALUES('f', 'f')");

                    // Trigger
                    db.execSQL("CREATE TRIGGER IF NOT EXISTS baja_respaldo BEFORE DELETE ON Region BEGIN INSERT INTO Respaldo(respaldoDesc) VALUES(old.regionDesc); END;");

                    // Confirmar transaccion
                    db.execSQL("COMMIT");

                    // -----------------------------------------

                }

                @Override
                public void onOpen(SupportSQLiteDatabase db) {
                    super.onOpen(db);
                }
            };*/

            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    Conexion.class,"@Dreamhome").build();
        }
        //*--*

     return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE=null;
    }

}
