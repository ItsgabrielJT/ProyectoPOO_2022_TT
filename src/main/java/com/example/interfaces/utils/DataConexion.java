package com.example.interfaces.utils;

import Interfaces.ConectarBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConexion implements ConectarBDD
{
    private static final String URL = "jdbc:mysql://localhost:3306/farmaciatyt";
    private static final String USER = "root";
    private static final String PASSWORD = "toor";
    private static DataConexion instancia;
    private Connection conn;

    private DataConexion() {

    }

    @Override
    public Connection conectarBaseDatos() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cerrarConexionBaseDatos() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DataConexion obtenerInstancia() {
        if (instancia == null) {
            instancia = new DataConexion();
        }
        return instancia;
    }
}
