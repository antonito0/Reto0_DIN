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
public class Admin extends Persona implements Serializable {

    private boolean baja;

    public Admin(String usuario, String contrasena, String nombre, String apellido) {
        super(usuario, contrasena, nombre, apellido);
        this.baja = false;
    }
    public Admin(String contrasena, String nombre, String apellido) {
        super(contrasena, nombre, apellido);
        this.baja = false;
    }

    public Admin() {
        this.baja = false;
    }

    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }
}
