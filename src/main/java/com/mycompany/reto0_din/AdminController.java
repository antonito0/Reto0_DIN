/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.reto0_din;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Admin;
import modelo.ImplementacionFichero;
/**
 * FXML Controller class
 *
 * @author ire22
 */
public class AdminController implements Initializable {
    @FXML
    private Label nombreAdmin;
    @FXML
    private Button modificarE;
    @FXML
    private Button registrarE;
    @FXML
    private Button salir;
    
    private ImplementacionFichero modelo = new ImplementacionFichero();
    @FXML
    private CheckBox baja;
    @FXML
    private TextField usuario;

    @FXML
    private TextField contra;
    @FXML
    private TextField apellido;
    @FXML
    private Button modificar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File fichO = new File("nombre.dat");
        Admin admin = modelo.verAdmin(fichO); 
        if (admin != null) {
            rellenarLabels(admin);
        }
    }    
    
    private void rellenarLabels(Admin admin) {
        usuario.setText(admin.getUsuario());
        nombreAdmin.setText(admin.getNombre());
        apellido.setText(admin.getApellido());
        baja.setSelected(admin.isBaja());
    }
    
    @FXML
    private void modificarEmple(ActionEvent event) throws IOException {
         App.setRoot("modificarEmpleado");
    }

    @FXML
    private void registrarEmlpe(ActionEvent event) throws IOException {
         App.setRoot("registrarEmpleado");
    }
@FXML
private void modificar(ActionEvent event) {

    File fichO = new File("nombre.dat");

    // Crear el Admin actualizado con los datos de los TextField
    Admin adminNuevo = new Admin(
            usuario.getText(),      // usuario
            contra.getText(),       // contraseña
            nombreAdmin.getText(),  // nombre
            apellido.getText()      // apellido
    );

    // Bloquear el campo usuario para que no se cambie
    usuario.setEditable(false);

    // Actualizar el boolean del CheckBox
    adminNuevo.setBaja(baja.isSelected());

    // Guardarlo en el fichero
    modelo.actualizarAdmin(fichO, adminNuevo);

    // Volver a rellenar los labels con los datos nuevos
    rellenarLabels(adminNuevo);

    System.out.println("Admin actualizado correctamente.");
}

}
