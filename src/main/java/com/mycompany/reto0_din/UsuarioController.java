/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.reto0_din;

import java.io.File;
import java.io.IOException;
import modelo.Persona;
import modelo.Usuario;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class UsuarioController implements Initializable {

    @FXML
    private Label UserWelcome;
    @FXML
    private Label labelNombre;
    @FXML
    private Label lblApellido;
    @FXML
    private Label lblFechaNac;
    @FXML
    private Label lblDNI;
    @FXML
    private Button btnLogOut;
    @FXML
    private Label infoApellido;
    @FXML
    private Label infoNacimiento;
    @FXML
    private Label infoNombre;

    Usuario p1;
    @FXML
    private Label infoDNI;

    private File fichero;

    /**
     * Initializes the controller class.
     *
     * @param user
     */
    public void setDatos(Usuario user) {
        this.p1 = user;

        infoNombre.setText(p1.getNombre());

        infoApellido.setText(p1.getApellido());

        infoDNI.setText(p1.getDni());

        infoNacimiento.setText(p1.getFechaNacimiento().toString());

        UserWelcome.setText(p1.getUsuario());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    public void cerrarSesion() {
        Stage stage = (Stage) btnLogOut.getScene().getWindow();
        stage.close();
    }

}
