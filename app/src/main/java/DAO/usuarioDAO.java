package DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import Modelo.UsuarioT;

@Dao
public interface usuarioDAO {

    @Query("SELECT * FROM UsuarioT WHERE userName=:nomUser AND contraseña=:contraseña")
    public UsuarioT buscarUsuario(String nomUser, String contraseña);

    //Altas
    @Insert
    public void insertarUsuario(UsuarioT usuarioT);

    @Query("delete from UsuarioT where userName=:user")
    public void eliminarUsuario(String user);

    @Query("update UsuarioT set nombre=:nombreN,userName=:nomUser,contraseña=:con where userName=:nomUser")
    public void modificarUsuario(String nombreN, String nomUser, String con);

}
