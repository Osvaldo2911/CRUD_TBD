package Modelo;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HistorialT {
    @NonNull
    String usuario;
    @NonNull
    String cliente;
    @NonNull
    String fechaYhora;
    @NonNull
    String accion;

    public HistorialT(@NonNull String usuario, @NonNull String cliente, @NonNull String fechaYhora, @NonNull String accion) {
        this.usuario = usuario;
        this.cliente = cliente;
        this.fechaYhora = fechaYhora;
        this.accion = accion;
    }

    @NonNull
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(@NonNull String usuario) {
        this.usuario = usuario;
    }

    @NonNull
    public String getCliente() {
        return cliente;
    }

    public void setCliente(@NonNull String cliente) {
        this.cliente = cliente;
    }

    @NonNull
    public String getFechaYhora() {
        return fechaYhora;
    }

    public void setFechaYhora(@NonNull String fechaYhora) {
        this.fechaYhora = fechaYhora;
    }

    @NonNull
    public String getAccion() {
        return accion;
    }

    public void setAccion(@NonNull String accion) {
        this.accion = accion;
    }
}
