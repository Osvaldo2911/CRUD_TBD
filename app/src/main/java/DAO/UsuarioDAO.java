package DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import Modelo.UsuarioT;

@Dao
public interface UsuarioDAO {

    @Query("SELECT * FROM UsuarioT WHERE nombre1=:nombreEntrada AND userName=:nomUser AND contraseña=:con")
    public UsuarioT buscarUsuario(String nombreEntrada, String nomUser, String con);

    //Altas
    @Insert
    public void insertarUsuario(UsuarioT alum);
}
