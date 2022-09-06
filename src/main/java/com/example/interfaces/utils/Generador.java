package com.example.interfaces.utils;


import com.example.interfaces.clases.Cliente;
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
import java.util.Properties;

public class Generador
{
    private DataConexion conexion = DataConexion.obtenerInstancia();
    private Connection conn = conexion.conectarBaseDatos();
    private final Properties PR;
    private Producto pd;
    private Stock st;
    private Usuario us;
    private Cliente cl;
    private Object obj;
    private ArrayList<String> datos = new ArrayList<>();
    private ArrayList<Object> lista = new ArrayList<>();


    private static Properties cargarArchivo() throws IOException {
        Properties p = new Properties();
        InputStream archivo = new FileInputStream("src/main/resources/com/example/interfaces/Sentencias.properties");
        p.load(archivo);
        return  p;
    }

    private void cargarClase() {
        if ( obj instanceof Producto )
            pd = (Producto) obj;
        else if ( obj instanceof Usuario )
            us = (Usuario) obj;
        else if ( obj instanceof Cliente)
            cl = (Cliente) obj;
        else
            st = (Stock) obj;
    }

    private void InsertarNuevosUsuarios(String acceso) throws SQLException {
        PreparedStatement p = conn.prepareStatement(construirQueryInsertar("accesos.insertar"));
        p.setInt(1, obetnerIdUsuario());
        p.setInt(2, obetnerIdAcceso(acceso));
        p.executeUpdate();
    }

    private int obetnerIdUsuario() throws SQLException {
        datos.clear();
        PreparedStatement consultar = conn.prepareStatement("SELECT id FROM usuarios");
        ResultSet result = consultar.executeQuery();
        while (result.next()) {
            datos.add(String.valueOf(result.getInt(1)));
        }
        int longitud = datos.size();
        return Integer.parseInt(datos.get(longitud - 1));
    }

    private int obetnerIdAcceso(String acceso) throws SQLException {
        datos.clear();
        PreparedStatement consultar = conn.prepareStatement("SELECT tipo_acceso FROM accesos");
        ResultSet result = consultar.executeQuery();
        while (result.next()) {
            datos.add(result.getString(1));
        }
        int id = 0;
        for (int i = 1; i <= datos.size(); i++) {
            if (datos.get(i-1).equals(acceso)) {
                id = i;
            }
        }
        return id;
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

    private void insertarDatosClientes(PreparedStatement i) throws SQLException {
        i.setString(1, cl.getNombre());
        i.setString(2, cl.getApellido());
        i.setString(3, cl.getCedula());
        i.setString(4, cl.getNumero());
        i.setString(5, cl.getDireccion());
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
        datos.add(us.getNickname());
        datos.add(us.getPassword());
        datos.add(us.getEmail());
        sql += String.valueOf(us.getId());
        return sql;
    }

    private String construirQueryModificarProducto(String str) {
        String sql = PR.getProperty(str);
        datos.clear();
        datos.add(pd.getNombre());
        datos.add(String.valueOf(pd.getPrecio()));
        datos.add(String.valueOf(pd.getCantidad()));
        sql += String.valueOf(pd.getId());
        System.out.println(sql);
        return sql;
    }

    private String construirQueryConsultar(String str) {
        String sql = PR.getProperty(str);
        return sql;
    }

    public Generador(Object obj) throws IOException {
        this.obj = obj;
        PR = cargarArchivo();
        cargarClase();
    }

    public Generador() throws IOException {
        PR = cargarArchivo();
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
        else if (obj instanceof Cliente)
            return construirQueryInsertar("clientes.insertar");
        else if ( obj instanceof Stock && (st.getProceso().equals("venta")) )
            return construirQueryInsertar("stock_salida.insertar");
        else
            return construirQueryInsertar("stock_ingresos.insertar");
    }

    public String generarSQLUpdate() {
        if ( obj instanceof  Usuario )
            return construirQueryModificarUsuario("usuarios.update");
        else
            return construirQueryModificarProducto("productos.update");
    }

    public String generarSQLConsult() {
        if ( obj instanceof  Usuario )
            return construirQueryConsultar("usuarios.consult");
        else if ( obj instanceof Producto )
            return construirQueryConsultar("productos.consult");
        else if ( obj instanceof Cliente )
            return construirQueryConsultar("clientes.consult");
        else if ( obj instanceof Stock && (st.getProceso().equals("venta")) )
            return construirQueryConsultar("stock_salida.update");
        else
            return construirQueryConsultar("stock_ingresos.update");
    }

    public void ejecutarInsertarDatos(PreparedStatement i) throws SQLException {
        if (obj instanceof Producto) {
            insertarDatosProductos(i);
        } else if (obj instanceof Usuario) {
            insertarDatosUsuario(i);
            InsertarNuevosUsuarios(us.getAcceso());
        } else if (obj instanceof Cliente) {
            insertarDatosClientes(i);
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

    public ArrayList ejecutarConsultarDatos(ResultSet r) throws SQLException {
        if (obj instanceof Producto) {
            return ejecutarConsultarDatosProductos(r);
        } else if (obj instanceof Usuario) {
            return ejecutarConsultarDatosUsuarios(r);
        } else if (obj instanceof Cliente) {
            return ejecutarConsultarDatosClientes(r);
        } else {
            return null;
        }
    }

    public ArrayList ejecutarConsultarDatosUsuarios(ResultSet r) throws SQLException {
        lista.add(new Usuario(
                r.getInt(1),
                r.getString(2),
                r.getString(3),
                r.getString(4),
                r.getString(5)
        ));
        return lista;
    }

    public ArrayList ejecutarConsultarDatosClientes(ResultSet r) throws SQLException {
        lista.add(new Cliente(
                r.getInt(1),
                r.getString(2),
                r.getString(3),
                r.getString(4),
                r.getString(5),
                r.getString(6)
        ));
        return lista;
    }
    public ArrayList ejecutarConsultarDatosProductos(ResultSet r) throws SQLException {
        lista.add(new Producto(
                r.getInt(1),
                r.getString(2),
                r.getDouble(3),
                r.getInt(4)
        ));
        return lista;
    }

    private void modificarDatos(PreparedStatement i) throws SQLException {
        for (int j = 1; j <= datos.size(); j++) {
            i.setString(j, datos.get(j-1));
        }
    }
}
