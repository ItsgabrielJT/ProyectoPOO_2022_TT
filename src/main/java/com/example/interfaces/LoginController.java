package com.example.interfaces;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController
{
    private Stage prymaryStage;
    @FXML
    private Button loginBT;
    @FXML
    private PasswordField passwordTXT;
    @FXML
    private TextField usuarioTXT;

    public void setStage(Stage stage) {
        prymaryStage = stage;
    }
    @FXML
    void mostrarVentanaHome(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
        Parent root = fxmlLoader.load();
        HomeController controller = fxmlLoader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.getIcons().add(new Image(LoginController.class.getResourceAsStream("assets/iconpharmacy.png")));
        stage.setTitle("EcoPharmacy System");
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        controller.setStage(stage);
        controller.setController(this);
        stage.show();
        this.prymaryStage.close();
    }

    public void show() {
        prymaryStage.show();
    }
}
