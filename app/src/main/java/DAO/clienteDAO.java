package DAO;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import Modelo.ClienteT;

@Dao
public interface clienteDAO {
/*
    @Query("SELECT * FROM ClienteT WHERE clientNo=:clientNo")
    public ClienteT buscarCliente(String clientNo);

    //Altas
    @Insert
    public void insertarCliente(ClienteT alum);

    @Query("delete from ClienteT where ClientNo=:clientNo")
    public void eliminarCliente(String clientNo);

    @Query("update ClienteT set fName=:fName,lName=:lName,telNo=:telNo,prefType=:prefType,maxRent=:maxRent where clientNo=:clientNo")
    public void modificarCliente(String clientNo, String fName, String lName, String telNo, String prefType, String maxRent);

    @Query("SELECT * FROM ClienteT")
    public List<ClienteT> obtenerTodosClientes();

    @Query("Select * from ClienteT where ClientNo LIKE '%' + ClientNo=:clientNo + '%' AND fName LIKE '%' + fName=:fName + '%' AND lName LIKE '%' + lName=:lName+'%' AND telNo LIKE '%'+ telNo=:telNo + '%' AND prefType LIKE '%'+ prefType=:prefType +'%' AND maxRent LIKE '%' + maxRent=:maxRent +'%';")
    public List<ClienteT> obtenerClientePersonalizado(String clientNo, String fName, String lName, String telNo, String prefType, String maxRent);
*/
}

