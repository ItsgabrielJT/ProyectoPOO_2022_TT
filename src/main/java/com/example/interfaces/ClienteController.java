package com.example.interfaces;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

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
}

