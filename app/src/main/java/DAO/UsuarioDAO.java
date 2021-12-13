package DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import Modelo.UsuarioT;

@Dao
public interface UsuarioDAO {

    @Query("SELECT * FROM UsuarioT WHERE nombre=:nombreEntrada AND userName=:nomUser AND contraseña=:con")
    public UsuarioT buscarUsuario(String nombreEntrada, String nomUser, String con);

    //Altas
    @Insert
    public void insertarUsuario(UsuarioT alum);

    @Query("delete from UsuarioT where userName=:nomUser")
    public UsuarioT eliminarUsuario(String nomUser);

    @Query("update UsuarioT set nombre=:nombreN,userName=:nomUser,contraseña=:con where userName=:nomUser")
    public UsuarioT modificarUsuario(String nombreN, String nomUser, String con);

}
