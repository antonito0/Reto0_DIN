/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.time.LocalDate;

/**
 *
 * @author Unai.Ibarguren
 */
public class Usuario extends Persona {
    
    private String dni;
    private LocalDate fechaNacimiento;

    public Usuario(String dni, LocalDate fechaNacimiento, String usuario, String contrasena, String nombre, String apellido) {
        super(usuario, contrasena, nombre, apellido);
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Usuario() {
        super();
        this.dni = "";
        this.fechaNacimiento = null;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Usuario{" + "dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

   
}
