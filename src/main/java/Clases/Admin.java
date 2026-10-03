/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Unai.Ibarguren
 */
public class Admin extends Persona{
    
    private boolean baja;

    public Admin(String usuario, String contrasena, String nombre, String apellido) {
        super(usuario, contrasena, nombre, apellido);
        this.baja = false;
    }

    public Admin() {
        super();
        this.baja = false;
    }
    
    
}
