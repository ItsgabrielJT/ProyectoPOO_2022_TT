package com.example.interfaces;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProductoTabla
{
    private SimpleIntegerProperty id;
    private SimpleStringProperty nombre;
    private SimpleDoubleProperty precio;
    private SimpleIntegerProperty cantidad;

    public ProductoTabla(int id, String nombre, double precio, int cantidad ) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.precio = new SimpleDoubleProperty(precio);
        this.cantidad = new SimpleIntegerProperty(cantidad);
    }

    public ProductoTabla(int id, String nombre, int cantidad ) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.cantidad = new SimpleIntegerProperty(cantidad);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public String getNombre() {
        return nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public double getPrecio() {
        return precio.get();
    }

    public SimpleDoubleProperty precioProperty() {
        return precio;
    }

    public int getCantidad() {
        return cantidad.get();
    }

    public SimpleIntegerProperty cantidadProperty() {
        return cantidad;
    }
}
