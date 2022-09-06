package com.example.interfaces;

import com.example.interfaces.clases.Usuario;
import com.example.interfaces.utils.ProcesarDato;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UsuarioController implements Initializable
{
    private int id;
    private HomeController controller;
    private Stage primaryStage;
    @FXML
    private TextField accesoTXT;
    @FXML
    private TextField emailTXT;
    @FXML
    private TextField passwordTXT;
    @FXML
    private TextField usuarioTXT;
    @FXML
    private TableColumn<UsuarioTabla, String> columnaAcceso = new TableColumn<>("Acceso");
    @FXML
    private TableColumn<UsuarioTabla, String> columnaEmail = new TableColumn<>("Email");
    @FXML
    private TableColumn<UsuarioTabla, Integer> columnaId = new TableColumn<>("Id");
    @FXML
    private TableColumn<UsuarioTabla, String> columnaPassword = new TableColumn<>("Contraseña");
    @FXML
    private TableColumn<UsuarioTabla, String> columnaUsuario = new TableColumn<>("Nickname");
    @FXML
    private TableView<UsuarioTabla> tablaUsuariosFX;
    @FXML
    private Label messageTXT;
    private ArrayList<UsuarioTabla> listaUsuarios = new ArrayList<>();

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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            cargarDatos();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void cargarDatos() throws IOException {
        cargarListaUsuarios();
        columnaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnaPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        columnaUsuario.setCellValueFactory(new PropertyValueFactory<>("nickname"));
        columnaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnaAcceso.setCellValueFactory(new PropertyValueFactory<>("acceso"));
        ObservableList<UsuarioTabla> lista = FXCollections.observableArrayList(
                listaUsuarios
        );
        tablaUsuariosFX.setItems(lista);
    }
    @FXML
    void agregarUsuario(MouseEvent event) throws IOException {
        String usuario = usuarioTXT.getText();
        String password = passwordTXT.getText();
        String email = emailTXT.getText();
        String acceso = accesoTXT.getText();
        Usuario user = new Usuario(password, email, usuario, acceso);
        ProcesarDato<Usuario> datos = new ProcesarDato<>(user);
        datos.introducirDatos();
        messageTXT.setText("Usuario agregado correctamente !");
        cargarDatos();
    }
    @FXML
    void editarUsuario(MouseEvent event) throws IOException {
        String usuario = usuarioTXT.getText();
        String password = passwordTXT.getText();
        String email = emailTXT.getText();
        String acceso = accesoTXT.getText();
        Usuario user = new Usuario(id, password, usuario, email, acceso);
        ProcesarDato<Usuario> datos = new ProcesarDato<>(user);
        datos.modificarDatos();
        messageTXT.setText("Usuario actualizado correctamente !");
        cargarDatos();
    }

    @FXML
    void eliminarUsuario(MouseEvent event) throws IOException {
        Usuario us = new Usuario(id);
        ProcesarDato<Usuario> datos = new ProcesarDato<>(us);
        datos.eliminarDatos();
        messageTXT.setText("Usuario eliminado correctamente !");
        cargarDatos();
    }
    @FXML
    void buscarUsuario(ActionEvent event) throws IOException {
        Usuario us = new Usuario();
        ProcesarDato<Usuario> datos = new ProcesarDato<>(us);
        datos.mostrarDatos();
        ArrayList<Usuario> usuarios = datos.getLista();
        for (Usuario p: usuarios) {
            if (p.getNickname().equals(usuarioTXT.getText())) {
                passwordTXT.setText(p.getPassword());
                emailTXT.setText(p.getEmail());
                accesoTXT.setText(p.getAcceso());
                id = p.getId();
            }
        }
    }
    @FXML
    void limpiarPantalla(MouseEvent event) {
        usuarioTXT.setText("");
        passwordTXT.setText("");
        emailTXT.setText("");
        accesoTXT.setText("");
        messageTXT.setText("");
    }

    private void cargarListaUsuarios() throws IOException {
        Usuario us = new Usuario();
        ProcesarDato<Usuario> datos = new ProcesarDato<>(us);
        datos.mostrarDatos();
        ArrayList<Usuario> usuarios = datos.getLista();
        for (Usuario p: usuarios) {
            listaUsuarios.add(new UsuarioTabla(
                    p.getId(),
                    p.getPassword(),
                    p.getNickname(),
                    p.getEmail(),
                    p.getAcceso()
                    ));
        }
    }

}
