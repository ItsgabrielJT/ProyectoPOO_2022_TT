package com.example.interfaces;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController
{
    private LoginController controller;
    private Stage prymaryStage;
    @FXML
    void mostrarVentanaCaja(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("caja.fxml"));
        Parent root = fxmlLoader.load();
        CajaController controller = fxmlLoader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.getIcons().add(new Image(LoginController.class.getResourceAsStream("assets/iconpharmacy.png")));
        stage.setTitle("EcoPharmacy System");
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        controller.setController(this);
        controller.setPrimaryStage(stage);
        stage.show();
        this.prymaryStage.close();
    }

    @FXML
    void mostrarVentanaBodega(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("bodega.fxml"));
        Parent root = fxmlLoader.load();
        BodegaController controller = fxmlLoader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.getIcons().add(new Image(LoginController.class.getResourceAsStream("assets/iconpharmacy.png")));
        stage.setTitle("EcoPharmacy System");
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        controller.setController(this);
        controller.setPrimaryStage(stage);
        stage.show();
        this.prymaryStage.close();
    }

    @FXML
    void mostrarVentanaUsuario(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("usuarios.fxml"));
        Parent root = fxmlLoader.load();
        UsuarioController controller = fxmlLoader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.getIcons().add(new Image(LoginController.class.getResourceAsStream("assets/iconpharmacy.png")));
        stage.setTitle("EcoPharmacy System");
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        controller.setController(this);
        controller.setPrimaryStage(stage);
        stage.show();
        this.prymaryStage.close();
    }

    @FXML
    void mostrarVentanaHome(MouseEvent event) {
        controller.show();
        prymaryStage.close();
    }

    public void setStage(Stage stage) {
        prymaryStage = stage;
    }

    public void setController(LoginController controller) {
        this.controller = controller;
    }

    public void show() {
        prymaryStage.show();
    }
}