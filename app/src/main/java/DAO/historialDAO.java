package DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import Modelo.HistorialT;

@Dao
public interface historialDAO {

    @Query("SELECT * FROM HistorialT WHERE cliente=:clientNo")
    public HistorialT buscarUsuario(String clientNo);

    //Altas
    @Insert
    public void insertarUsuarioHistorial(HistorialT alum);

    @Query("delete from HistorialT where cliente=:clientNo")
    public HistorialT eliminarUsHistorial(String clientNo);

    @Query("SELECT * FROM HistorialT")
    public List<HistorialT> obtenerTodosHistorial();
}
