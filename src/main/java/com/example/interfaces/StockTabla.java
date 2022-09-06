package com.example.interfaces;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class StockTabla
{
    private SimpleIntegerProperty id;
    private SimpleStringProperty fecha;
    private SimpleIntegerProperty cantidad;
    private SimpleIntegerProperty usuario;
    private SimpleIntegerProperty producto;
    private SimpleStringProperty proceso;

    public StockTabla(String fecha, int cantidad, int usuario, int proucto, String proceso) {
        this.fecha = new SimpleStringProperty(fecha);
        this.cantidad = new SimpleIntegerProperty(cantidad);
        this.usuario = new SimpleIntegerProperty(usuario);
        this.producto = new SimpleIntegerProperty(proucto);
        this.proceso = new SimpleStringProperty(proceso);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public String getFecha() {
        return fecha.get();
    }

    public SimpleStringProperty fechaProperty() {
        return fecha;
    }

    public int getCantidad() {
        return cantidad.get();
    }

    public SimpleIntegerProperty cantidadProperty() {
        return cantidad;
    }

    public int getUsuario() {
        return usuario.get();
    }

    public SimpleIntegerProperty usuarioProperty() {
        return usuario;
    }

    public int getProducto() {
        return producto.get();
    }

    public SimpleIntegerProperty productoProperty() {
        return producto;
    }

    public String getProceso() {
        return proceso.get();
    }

    public SimpleStringProperty procesoProperty() {
        return proceso;
    }
}
