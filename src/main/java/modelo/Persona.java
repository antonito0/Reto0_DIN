/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Unai.Ibarguren
 */
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String usuario;
    protected String contrasena;
    protected String nombre;
    protected  String apellido;

    public Persona(String usuario, String contrasena, String nombre, String apellido) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public Persona(String contrasena, String nombre, String apellido) {
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public Persona() {
        this.usuario = "";
        this.contrasena = "";
        this.nombre = "";
        this.apellido = "";
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Persona{" + "usuario=" + usuario + ", contrasena=" + contrasena + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
}
