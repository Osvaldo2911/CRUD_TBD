package Modelo;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HistorialT {
    @NonNull
    String apellido;
    @PrimaryKey
    @NonNull
    String cliente;
    @NonNull
    String nombre;
    @NonNull
    String tel;

    public HistorialT(@NonNull String apellido, @NonNull String cliente, @NonNull String nombre, @NonNull String tel) {
        this.apellido = apellido;
        this.cliente = cliente;
        this.nombre = nombre;
        this.tel = tel;
    }

    @NonNull
    public String getApellido() {
        return apellido;
    }

    public void setApellido(@NonNull String apellido) {
        this.apellido = apellido;
    }

    @NonNull
    public String getCliente() {
        return cliente;
    }

    public void setCliente(@NonNull String cliente) {
        this.cliente = cliente;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    public String getTel() {
        return tel;
    }

    public void setTel(@NonNull String tel) {
        this.tel = tel;
    }
}
