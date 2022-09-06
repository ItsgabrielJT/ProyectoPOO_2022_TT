package com.example.interfaces;

import com.example.interfaces.clases.Usuario;
import com.example.interfaces.utils.ProcesarDato;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;

public class HomeController implements Initializable
{
    private ArrayList<Usuario> listaUser = new ArrayList<>();
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

    public void setListaUser(ArrayList<Usuario> listaUser) {
        this.listaUser = listaUser;
    }

    public void show() {
        prymaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            comprobarUsuario();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void comprobarUsuario() throws IOException {

        Usuario us = new Usuario();
        ProcesarDato<Usuario> usuarios = new ProcesarDato<>(us);
        usuarios.mostrarDatos();
        listaUser = usuarios.getLista();
        for (Usuario u: listaUser) {
            if (u.getAcceso().equals("cajero")) {
                ImageView img = new ImageView();
            } else if (u.getAcceso().equals("bodeguero")) {

            } else {

            }
        }
    }
}