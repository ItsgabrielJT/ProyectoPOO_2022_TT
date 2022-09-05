package com.example.interfaces.utils;


import com.example.interfaces.Iclases.AcederDato;
import com.example.interfaces.clases.Usuario;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProcesarDato<T> implements AcederDato<T>
{
    private T t;
    private Generador gn;
    private ArrayList<T> lista = new ArrayList<>();

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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminarDatos() {
        try {
            PreparedStatement delete = conexion.prepareStatement(gn.generarSQlRemove());
            gn.ejecutarEliminarDatos(delete);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void modificarDatos() {
        try {
            PreparedStatement actualizar = conexion.prepareStatement(gn.generarSQLUpdate());
            gn.ejecutarActualizarDatos(actualizar);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void mostrarDatos() {
        try {
            PreparedStatement consultar = conexion.prepareStatement(gn.generarSQLConsult());
            ResultSet result = consultar.executeQuery();
            while (result.next()) {
                lista = gn.ejecutarConsultarDatos(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<T> getLista() {
        return lista;
    }
}
