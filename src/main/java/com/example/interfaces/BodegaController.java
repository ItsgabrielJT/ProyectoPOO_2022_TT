package com.example.interfaces;

import com.example.interfaces.clases.Cliente;
import com.example.interfaces.clases.Producto;
import com.example.interfaces.clases.Usuario;
import com.example.interfaces.utils.ProcesarDato;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class BodegaController
{
    private HomeController controller;
    private Stage primaryStage;
    @FXML
    private TextField cantidadTXT;
    @FXML
    private TextField idTXT;
    @FXML
    private TextField nombreTXT;
    @FXML
    private Label messageTXT;
    @FXML
    private TextField precioTXT;
    @FXML
    void agregarProductos(MouseEvent event) throws IOException {
        String nombre = nombreTXT.getText();
        Double precio = Double.parseDouble(precioTXT.getText());
        int cantidad = Integer.parseInt(cantidadTXT.getText());
        Producto pd = new Producto(nombre, precio, cantidad);
        ProcesarDato<Producto> datos = new ProcesarDato<>(pd);
        datos.introducirDatos();
        messageTXT.setText("Producto agregado correctamente !");
    }
    @FXML
    void buscarProducto(ActionEvent event) throws IOException {
        Producto pd = new Producto();
        ProcesarDato<Producto> datos = new ProcesarDato<>(pd);
        datos.mostrarDatos();
        ArrayList<Producto> productos = datos.getLista();
        for (Producto p: productos) {
            String id = String.valueOf(p.getId());
            if (id.equals(idTXT.getText())) {
                nombreTXT.setText(p.getNombre());
                precioTXT.setText(String.valueOf(p.getPrecio()));
                cantidadTXT.setText(String.valueOf(p.getCantidad()));
            }
        }
    }
    @FXML
    void aumentarCantidad(ActionEvent event) {
        int cantidad = Integer.parseInt(cantidadTXT.getText());
        int aumento = cantidad + 1;
        cantidadTXT.setText(String.valueOf(aumento));
    }
    @FXML
    void disminuirCantidad(ActionEvent event) {
        int cantidad = Integer.parseInt(cantidadTXT.getText());
        int disminuir = cantidad - 1;
        cantidadTXT.setText(String.valueOf(disminuir));
    }
    @FXML
    void editarProducto(MouseEvent event) throws IOException {
        int id = Integer.parseInt(idTXT.getText());
        String nombre = nombreTXT.getText();
        Double precio = Double.parseDouble(precioTXT.getText());
        int cantidad = Integer.parseInt(cantidadTXT.getText());
        Producto pd = new Producto(id, nombre, precio, cantidad);
        ProcesarDato<Producto> datos = new ProcesarDato<>(pd);
        datos.modificarDatos();
        messageTXT.setText("Producto actualizado correctamente !");
    }
    @FXML
    void eliminarProducto(MouseEvent event) throws IOException {
        int id = Integer.parseInt(idTXT.getText());
        Producto pd = new Producto(id);
        ProcesarDato<Producto> datos = new ProcesarDato<>(pd);
        datos.eliminarDatos();
        messageTXT.setText("Producto actualizado correctamente !");
    }
    @FXML
    void refrescarTabla(MouseEvent event) {

    }
    @FXML
    void borrarDatos(MouseEvent event) {
        idTXT.setText("");
        nombreTXT.setText("");
        precioTXT.setText("");
        cantidadTXT.setText("0");
        messageTXT.setText("");
    }
    @FXML
    void mostrarVentanaHome(ActionEvent event) {
        controller.show();
        primaryStage.close();
    }

    public void setController(HomeController controller) {
        this.controller = controller;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
