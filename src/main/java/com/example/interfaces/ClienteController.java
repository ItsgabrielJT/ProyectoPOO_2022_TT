package com.example.interfaces;

import com.example.interfaces.clases.Cliente;
import com.example.interfaces.clases.Usuario;
import com.example.interfaces.utils.ProcesarDato;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class ClienteController {

    private CajaController controller;
    private Stage primaryStage;

    @FXML
    private TextField apellidoBT;

    @FXML
    private TextField cedulaTXT;

    @FXML
    private TextField direccionBT;

    @FXML
    private Label messageTXT;

    @FXML
    private TextField nombreBT;

    @FXML
    private TextField numeroBT;

    public void setController(CajaController cajaController) {
        this.controller = cajaController;
    }

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    @FXML
    void mostrarVentanaHome(ActionEvent event) {
        controller.show();
        primaryStage.close();
    }
    @FXML
    void agregarCliente(ActionEvent event) throws IOException {
        String nombre = nombreBT.getText();
        String apellido = apellidoBT.getText();
        String cedula = cedulaTXT.getText();
        String numero = numeroBT.getText();
        String direccion = direccionBT.getText();
        Cliente cliente = new Cliente(nombre, apellido, cedula, numero, direccion);
        ProcesarDato<Usuario> datos = new ProcesarDato<>(cliente);
        datos.introducirDatos();
    }
    @FXML
    void vaciarTextos(ActionEvent event) {
        nombreBT.setText("");
        apellidoBT.setText("");
        cedulaTXT.setText("");
        numeroBT.setText("");
        direccionBT.setText("");
        messageTXT.setText("");
    }
    @FXML
    void buscarClientes(ActionEvent event) throws IOException {
        boolean isExist = false;
        Cliente cl = new Cliente();
        ProcesarDato<Cliente> datos = new ProcesarDato<>(cl);
        datos.mostrarDatos();
        ArrayList<Cliente> clientes = datos.getLista();
        for (Cliente c: clientes) {
            if (c.getCedula().equals(cedulaTXT.getText())) {
                nombreBT.setText(c.getNombre());
                apellidoBT.setText(c.getApellido());
                numeroBT.setText(c.getNumero());
                direccionBT.setText(c.getDireccion());
            }
        }
        if (isExist) {
            messageTXT.setText("No existente, quiere agregar ?");
        }
    }
    @FXML
    void aceptarCliente(ActionEvent event) {

    }
}

