package model;

public class Cuenta {

    private String id;
    private String usuarios;
    private  String contrase�as;

    public Cuenta(String id, String usuarios, String contrase�as) {
        this.id = id;
        this.usuarios = usuarios;
        this.contrase�as = contrase�as;
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

    public String getContrase�as() {
        return contrase�as;
    }

    public void setContrase�as(String contrase�as) {
        this.contrase�as = contrase�as;
    }
}

