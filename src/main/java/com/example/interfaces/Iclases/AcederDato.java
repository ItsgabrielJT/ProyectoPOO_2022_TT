package com.example.interfaces.Iclases;

import com.example.interfaces.utils.DataConexion;

import java.sql.Connection;

public interface AcederDato<T>
{
    DataConexion data_conexion = DataConexion.obtenerInstancia();
    Connection conexion = data_conexion.conectarBaseDatos();
    void introducirDatos();
    void eliminarDatos();
    void modificarDatos();
    void mostrarDatos();
}
