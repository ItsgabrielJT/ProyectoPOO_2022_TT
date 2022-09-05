package com.example.interfaces.clases;

import java.util.ArrayList;


public class Usuario
{
    private int id;
    private String password;
    private String email;
    private String nickname;
    private String acceso;

    public Usuario(int id, String password, String nickname, String email, String acceso) {
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.acceso = acceso;
        this.id = id;
    }


    public Usuario(String password, String email, String nickname, String acceso) {
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.acceso = acceso;
    }

    public Usuario(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    public Usuario() {
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAcceso() {
        return acceso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
