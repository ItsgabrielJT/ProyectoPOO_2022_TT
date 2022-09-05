package com.example.interfaces.clases;

public class Stock
{
    private int id;
    private String fecha;
    private int cantidad = 0;
    private int usuario = 0;
    private int producto = 0;
    private String proceso;
    private int cliente = 0;

    public Stock(String fecha, int cantidad, int usuario, int proucto, String proceso) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.usuario = usuario;
        this.producto = proucto;
        this.proceso = proceso;
    }

    public Stock(int id) {
        this.id = id;
    }

    public Stock() {

    }

    public String getProceso() {
        return proceso;
    }

    public String getFecha() {
        return fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getUsuario() {
        return usuario;
    }

    public int getProducto() {
        return producto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }
}
