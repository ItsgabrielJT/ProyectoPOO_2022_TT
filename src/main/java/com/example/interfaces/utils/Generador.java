package com.example.interfaces.utils;


import com.example.interfaces.clases.Producto;
import com.example.interfaces.clases.Stock;
import com.example.interfaces.clases.Usuario;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class Generador
{
    private DataConexion conexion = DataConexion.obtenerInstancia();
    private Connection conn = conexion.conectarBaseDatos();
    private final Properties PR;
    private Producto pd;
    private Stock st;
    private Usuario us;
    private Object obj;
    private ArrayList<String> datos = new ArrayList<>();
    private HashMap<Integer, String> accesos = new HashMap<>();

    private static Properties cargarArchivo() throws IOException {
        Properties p = new Properties();
        InputStream archivo = new FileInputStream("src/main/resources/Sentencias.properties");
        p.load(archivo);
        return  p;
    }

    private void cargarClase() {
        if ( obj instanceof Producto )
            pd = (Producto) obj;
        else if ( obj instanceof Usuario )
            us = (Usuario) obj;
        else
            st = (Stock) obj;
    }

    private void InsertarNuevosUsuarios() throws SQLException {
        PreparedStatement p = conn.prepareStatement(construirQueryInsertar("accesos.insertar"));
        p.setInt(1, 14);
        p.setInt(2, 2);
        p.executeUpdate();
    }

    private void cargarTiposAccesos() throws SQLException {
        PreparedStatement c = conn.prepareStatement("SELECT * FROM accesos");
        ResultSet f = c.getResultSet();
        while (f.next()) {
            System.out.println(f.getInt(1));
            System.out.println(f.getString(2));
        }
    }

    private void ejecutarDeleteDatos(int i) throws IOException, SQLException {
        PreparedStatement p = conn.prepareStatement(construirQueryEliminar("acceso.delete", i));
        p.executeUpdate();
    }

    private void insertarDatosProductos(PreparedStatement i) throws SQLException {
        i.setString(1, pd.getNombre());
        i.setDouble(2, pd.getPrecio());
        i.setInt(3, pd.getCantidad());
        i.executeUpdate();
    }

    private void insertarDatosUsuario(PreparedStatement i) throws SQLException {
        i.setString(1, us.getPassword());
        i.setString(2, us.getNickname());
        i.setString(3, us.getEmail());
        i.executeUpdate();
    }

    private void insertarDatosStock(PreparedStatement i) throws SQLException {
        i.setString(1, null);
        i.setString(2, st.getFecha());
        i.setInt(3, st.getCantidad());
        i.setInt(4, st.getUsuario());
        i.setInt(5, st.getProducto());
        i.executeUpdate();
    }

    private String construirQueryEliminar(String str, int i) {
        String sql = PR.getProperty(str) + String.valueOf(i);
        return sql;
    }

    private String construirQueryInsertar(String str) {
        String sql = PR.getProperty(str);
        return sql;
    }

    private String construirQueryModificarUsuario(String str) {
        String sql = PR.getProperty(str);
        datos.clear();
        if (us.getNickname() != null) {
            sql += "nickname = ?,";
            datos.add(us.getNickname());
        }
        if (us.getPassword() != null) {
            sql += "password = ?,";
            datos.add(us.getPassword());
        }
        if (us.getEmail() != null) {
            sql += "email = ? ";
            datos.add(us.getEmail());
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += " WHERE id = " + String.valueOf(us.getId());
        return sql;
    }

    private String construirQueryModificarProducto(String str) {
        String sql = PR.getProperty(str);
        datos.clear();
        if (pd.getNombre() != null) {
            sql += "nombre = ?,";
            datos.add(pd.getNombre());
        }
        if (pd.getPrecio() > 0) {
            sql += "precio = ?,";
            datos.add(String.valueOf(pd.getPrecio()));
        }
        if (pd.getCantidad() > 0) {
            sql += "cantidad = ? ";
            datos.add(String.valueOf(pd.getCantidad()));
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += " WHERE id = " + String.valueOf(pd.getId());
        System.out.println(sql);
        return sql;
    }

    private String construirQueryModificarStock(String str) {
        String sql = PR.getProperty(str);
        datos.clear();
        if (st.getFecha() != null && st.getProceso().equals("ventas")) {
            sql += "fecha_salida = ?,";
            datos.add(st.getFecha());
        }
        else if (st.getFecha() != null) {
            sql += "fecha_ingreso = ?,";
            datos.add(st.getFecha());
        }
        if (st.getCantidad() > 0) {
            sql += "cantidad = ?,";
            datos.add(String.valueOf(st.getCantidad()));
        }
        if (st.getUsuario() > 0) {
            sql += "usuarios_id = ?,";
            datos.add(String.valueOf(st.getUsuario()));
        }
        if (st.getProducto() > 0) {
            sql += "productos_id = ? ";
            datos.add(String.valueOf(st.getProducto()));
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += " WHERE id = " + String.valueOf(st.getId());
        return sql;
    }

    public Generador(Object obj) throws IOException {
        this.obj = obj;
        PR = cargarArchivo();
        cargarClase();
    }

    public String generarSQlRemove() {
        if ( obj instanceof Producto )
            return construirQueryEliminar( "productos.delete", pd.getId());
        else if ( obj instanceof Usuario )
            return construirQueryEliminar( "usuarios.delete", us.getId());
        else if ( obj instanceof Stock && (st.getProceso().equals("venta")) )
            return construirQueryEliminar( "stock_salida.delete", (st.getId()) );
        else
            return construirQueryEliminar( "stock_ingresos.delete", ( st.getId()) );
    }

    public String generarSQlInserccion() {
        if ( obj instanceof Producto )
            return construirQueryInsertar("productos.insertar");
        else if ( obj instanceof Usuario )
            return construirQueryInsertar("usuarios.insertar");
        else if ( obj instanceof Stock && (st.getProceso().equals("venta")) )
            return construirQueryInsertar("stock_salida.insertar");
        else
            return construirQueryInsertar("stock_ingresos.insertar");
    }

    public String generarSQLUpdate() {
        if ( obj instanceof  Usuario )
            return construirQueryModificarUsuario("usuarios.update");
        else if ( obj instanceof Producto )
            return construirQueryModificarProducto("productos.update");
        else if ( obj instanceof Stock && (st.getProceso().equals("venta")) )
            return construirQueryModificarStock("stock_salida.update");
        else
            return construirQueryModificarStock("stock_ingresos.update");
    }

    public void ejecutarInsertarDatos(PreparedStatement i) throws SQLException {
        if (obj instanceof Producto) {
            insertarDatosProductos(i);
        } else if (obj instanceof Usuario) {
            insertarDatosUsuario(i);
            InsertarNuevosUsuarios();
        } else {
            insertarDatosStock(i);
        }
    }

    public void ejecutarEliminarDatos(PreparedStatement i) throws SQLException, IOException {
        if (obj instanceof Usuario) {
            ejecutarDeleteDatos(us.getId());
        }
        i.executeUpdate();
    }

    public void ejecutarActualizarDatos(PreparedStatement i) throws SQLException {
        modificarDatos(i);
        i.executeUpdate();
    }

    private void modificarDatos(PreparedStatement i) throws SQLException {
        for (int j = 1; j <= datos.size(); j++) {
            i.setString(j, datos.get(j-1));
        }
    }
}
