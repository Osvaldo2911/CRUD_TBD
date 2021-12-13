package DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import Modelo.ClienteT;

@Dao
public interface UsuarioDAO {

    @Query("SELECT * FROM UsuarioT WHERE nombre=:nombreEntrada AND userName=:nomUser AND contraseña=:con")
    public ClienteT buscarUsuario(String nombreEntrada, String nomUser, String con);

    //Altas
    @Insert
    public void insertarUsuario(ClienteT alum);

    @Query("delete from UsuarioT where userName=:nomUser")
    public ClienteT eliminarUsuario(String nomUser);

    @Query("update UsuarioT set nombre=:nombreN,userName=:nomUser,contraseña=:con where userName=:nomUser")
    public ClienteT modificarUsuario(String nombreN, String nomUser, String con);

}
