package com.example.interfaces;

import com.example.interfaces.clases.Producto;
import com.example.interfaces.clases.Usuario;
import com.example.interfaces.utils.ProcesarDato;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CajaController
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
    private TextField precioTXT;
    @FXML
    private TableColumn<ProductoTabla, Integer> columnaCantidad;

    @FXML
    private TableColumn<ProductoTabla, Integer> columnaId;

    @FXML
    private TableColumn<ProductoTabla, String> columnaPd;

    @FXML
    private TableColumn<ProductoTabla, Double> columnaPrecio;
    @FXML
    private TableView<ProductoTabla> tablaProductosTXT;
    @FXML
    private TableColumn<?, ?> columaNom;
    @FXML
    private TableColumn<?, ?> columaNum;
    @FXML
    private TableColumn<?, ?> columnaApe;
    @FXML
    private TableColumn<?, ?> columnaCI;
    @FXML
    private TableView<?> tablaClientesTXT;
    private ArrayList<ProductoTabla> listaProductos = new ArrayList<>();
    private ArrayList<ProductoTabla> listaClientes = new ArrayList<>();

    @FXML
    void mostrarVentanaHome(ActionEvent event) {
        controller.show();
        primaryStage.close();
    }

    @FXML
    void mostrarVentanaCliente(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cliente.fxml"));
        Parent root = fxmlLoader.load();
        ClienteController controller = fxmlLoader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.getIcons().add(new Image(LoginController.class.getResourceAsStream("assets/iconpharmacy.png")));
        stage.setTitle("EcoPharmacy System");
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        controller.setController(this);
        controller.setPrimaryStage(stage);
        stage.show();
        this.primaryStage.close();
    }
    @FXML
    void vaciarTextos(ActionEvent event) {
        idTXT.setText("");
        nombreTXT.setText("");
        precioTXT.setText("");
        cantidadTXT.setText("0");
        int longitud = listaProductos.size();
        listaProductos.remove(longitud - 1);
    }
    @FXML
    void agregarProductoFactura(ActionEvent event) throws IOException {
        columnaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnaPd.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        columnaCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        ObservableList<ProductoTabla> lista = FXCollections.observableArrayList(
                listaProductos
        );
        tablaProductosTXT.setItems(lista);
        tablaProductosTXT.setEditable(true);
    }

    @FXML
    void aumentarCantidad(ActionEvent event) {
        int cantidad = Integer.parseInt(cantidadTXT.getText());
        int aumento = cantidad + 1;
        cantidadTXT.setText(String.valueOf(aumento));
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
                listaProductos.add(new ProductoTabla(
                        p.getId(),
                        p.getNombre(),
                        p.getPrecio(),
                        Integer.parseInt(cantidadTXT.getText())
                ));
            }
        }
    }

    @FXML
    void disminuirCantidad(ActionEvent event) {
        int cantidad = Integer.parseInt(cantidadTXT.getText());
        int disminuir = 0;
        if (cantidad > 0)
            disminuir = cantidad - 1;
        cantidadTXT.setText(String.valueOf(disminuir));
    }
    public void setController(HomeController controller) {
        this.controller = controller;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void show() {
        primaryStage.show();
    }
}
