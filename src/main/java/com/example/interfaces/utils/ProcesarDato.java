package com.example.interfaces.utils;


import com.example.interfaces.Iclases.AcederDato;

import java.io.IOException;
import java.sql.PreparedStatement;

public class ProcesarDato<T> implements AcederDato<T>
{
    private T t;
    private Generador gn;

    public ProcesarDato() {

    }

    public ProcesarDato(Object obj) throws IOException {
        this.t = (T) obj;
        this.gn = new Generador(obj);
    }

    @Override
    public void introducirDatos() {
        try {
            PreparedStatement insert = conexion.prepareStatement(gn.generarSQlInserccion());
            gn.ejecutarInsertarDatos(insert);
            data_conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminarDatos() {
        try {
            PreparedStatement delete = conexion.prepareStatement(gn.generarSQlRemove());
            gn.ejecutarEliminarDatos(delete);
            data_conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void modificarDatos() {
        try {
            PreparedStatement actualizar = conexion.prepareStatement(gn.generarSQLUpdate());
            gn.ejecutarActualizarDatos(actualizar);
            data_conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void mostrarDatos() {

    }
}
