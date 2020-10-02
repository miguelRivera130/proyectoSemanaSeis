package com.example.appcliente;

public class Cuenta {

    private String id;
    private String usuarios;
    private  String contraseñas;

    public Cuenta(String id, String usuarios, String contraseñas) {
        this.id = id;
        this.usuarios = usuarios;
        this.contraseñas = contraseñas;
    }

    public Cuenta(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(String usuarios) {
        this.usuarios = usuarios;
    }

    public String getContraseñas() {
        return contraseñas;
    }

    public void setContraseñas(String contraseñas) {
        this.contraseñas = contraseñas;
    }
}
