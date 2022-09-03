package com.example.interfaces;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

public class HelloController implements Initializable {

    @FXML
    private ImageView fondoImg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fondoImg.setVisible(true);
    }

}