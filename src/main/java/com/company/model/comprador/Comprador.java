package com.company.model.comprador;

/**
 *
 * @author JUS
 */
public class Comprador {

    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private int numeroRegistro;

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(int numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public Comprador() {
    }

    public Comprador(String[] data) {
        this.id = data[0];
        this.nombre = data[1];
        this.apellido = data[2];
        this.email = data[3];
        this.telefono = data[4];
        if (data.length == 6) {
            this.numeroRegistro = Integer.parseInt(data[5]);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
