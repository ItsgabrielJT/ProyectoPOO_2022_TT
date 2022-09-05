package com.example.interfaces;

import com.example.interfaces.clases.Usuario;
import com.example.interfaces.utils.ProcesarDato;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Programa extends Application
{
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        LoginController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.getIcons().add(new Image(LoginController.class.getResourceAsStream("assets/iconpharmacy.png")));
        stage.setTitle("EcoPharmacy System");
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.show();
    }
    public static void main(String[] args) throws IOException {
        launch();
    }
}
