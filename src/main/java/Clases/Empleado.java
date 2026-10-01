/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Unai.Ibarguren
 */
public class Empleado extends Persona{
    
    private String iban;

    public Empleado(String iban, String usuario, String contrasena, String nombre, String apellido) {
        super(usuario, contrasena, nombre, apellido);
        this.iban = iban;
    }

    public Empleado() {
        this.iban = "";
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getIban() {
        return iban;
    }

    @Override
    public String toString() {
        return "Empleado{" + "iban=" + iban + '}';
    }
}
