/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import modelo.Admin;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import utilidades.Utilidades;

/**
 *
 * @author ire22
 */
public class ImplementacionFichero {
   // @Override
    public static void fillData(File fichero) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
        // ADMIN
        Admin admin1 = new Admin("admin1", "1234", "Mireia", "Lopez");
        Admin admin2 = new Admin("admin2", "abcd", "Carlos", "Perez");
        // EMPLEADOS
        Empleado emp1 = new Empleado("ES9820385778983000760234", "emple1", "pass1", "Lucia", "Martinez");
        Empleado emp2 = new Empleado("ES7621000814561234567890", "emple2", "pass2", "Jon", "Garcia");
        // USUARIOS
        Usuario usu1 = new Usuario("12345678A", LocalDate.of(2000, 5, 12), "usu1", "1111", "Mikel", "Lopez");
        Usuario usu2 = new Usuario("98765432B", LocalDate.of(1998, 3, 20), "usu2", "2222", "Ane", "Santos");
        // GUARDAR EN EL FICHERO
        oos.writeObject(admin1);
        oos.writeObject(admin2);
        oos.writeObject(emp1);
        oos.writeObject(emp2);
        oos.writeObject(usu1);
        oos.writeObject(usu2);
        System.out.println("Datos creados correctamente.");
    } catch (IOException e) {
        System.out.println("Error escribiendo el fichero.");
    }
}

    
    public Admin verAdmin(File fichO) {
        boolean finArchivo = false;
        Admin admin=null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichO))) {
            while (!finArchivo) {
                try {
                    admin = (Admin) ois.readObject();
                } catch (EOFException e) {
                    finArchivo = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading the file.");
        }
        return admin;
    }
    
}
