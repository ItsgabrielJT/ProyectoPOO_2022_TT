package com.example.interfaces;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class UsuarioTabla
{
    private SimpleIntegerProperty id;
    private SimpleStringProperty password;
    private SimpleStringProperty email;
    private SimpleStringProperty nickname;
    private SimpleStringProperty acceso;

    public UsuarioTabla(int id, String password, String nickname, String email, String acceso) {
        this.password = new SimpleStringProperty(password);
        this.email = new SimpleStringProperty(email);
        this.nickname = new SimpleStringProperty(nickname);
        this.acceso = new SimpleStringProperty(acceso);
        this.id = new SimpleIntegerProperty(id);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public String getNickname() {
        return nickname.get();
    }

    public SimpleStringProperty nicknameProperty() {
        return nickname;
    }

    public String getAcceso() {
        return acceso.get();
    }

    public SimpleStringProperty accesoProperty() {
        return acceso;
    }
}
