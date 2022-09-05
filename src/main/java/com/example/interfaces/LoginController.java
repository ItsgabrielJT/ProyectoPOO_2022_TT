package com.example.interfaces;

import com.example.interfaces.clases.Usuario;
import com.example.interfaces.utils.ProcesarDato;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController
{
    private Stage prymaryStage;
    @FXML
    private PasswordField passwordTXT;
    @FXML
    private TextField usuarioTXT;
    @FXML
    private Label messageTXT;


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
        comprobarUsuario(stage);
    }

    private void comprobarUsuario(Stage stage) throws IOException {
        String password = passwordTXT.getText();
        String nickname = usuarioTXT.getText();
        Usuario usr = new Usuario();
        ProcesarDato<Usuario> usuarioProcesarDato = new ProcesarDato<>(usr);
        usuarioProcesarDato.mostrarDatos();
        ArrayList<Usuario> lista = usuarioProcesarDato.getLista();
        for (Usuario u: lista) {
            if ( (nickname.equals(u.getNickname())) && password.equals(u.getPassword()) ) {
                stage.show();
                this.prymaryStage.close();
            }
            else {
                messageTXT.setText("Usuario o Password incorrectos");
                usuarioTXT.setText("");
                passwordTXT.setText("");
            }
        }
    }

    public void show() {
        prymaryStage.show();
    }
}
