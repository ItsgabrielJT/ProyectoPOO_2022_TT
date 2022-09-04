package Interfaces;

import java.sql.Connection;

public interface ConectarBDD
{
    Connection conectarBaseDatos();
    void cerrarConexionBaseDatos();
}
