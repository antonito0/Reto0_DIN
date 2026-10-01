package com.mycompany.reto0_din;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Unai.Ibarguren
 */
public class VentanaLogInController implements Initializable {

    @FXML
    private TextField textFieldUsuario;
    @FXML
    private PasswordField passwordFieldContrasena;
    @FXML
    private Button buttonIniciarSesion;
    @FXML
    private Button buttonCrearUsuario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
