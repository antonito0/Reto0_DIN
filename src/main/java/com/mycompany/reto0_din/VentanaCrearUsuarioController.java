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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.ImplementacionFichero;
import modelo.Persona;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author UO
 */
public class VentanaCrearUsuarioController implements Initializable {
    
    private ImplementacionFichero modelo = new ImplementacionFichero();
    
    private File fichero;

    @FXML
    private TextField textFieldDni;
    @FXML
    private TextField textFieldNombre;
    @FXML
    private TextField textFieldApellido;
    @FXML
    private TextField textFieldUsuario;
    @FXML
    private TextField textFieldContrasena;
    @FXML
    private DatePicker dateFechaNacimiento;
    @FXML
    private Button buttonVolver;
    @FXML
    private Button buttonCrear;
    @FXML
    private Label labelError;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void setDatos(File fichero) {
        this.fichero = fichero;
    }
    
    public void crearUsuario(ActionEvent event) throws IOException {
        
        if (textFieldDni.getText().equals("")||
                textFieldNombre.getText().equals("")||
                textFieldApellido.getText().equals("")||
                textFieldUsuario.getText().equals("")||
                textFieldContrasena.getText().equals("")||
                dateFechaNacimiento.getValue()==null) {
            labelError.setText("Por favor introduzca todos los datos correctamente");
        } else {
            if (modelo.encontrarPersona(fichero, textFieldUsuario.getText())==null) {
                Usuario usu = new Usuario (textFieldDni.getText()
                                        , dateFechaNacimiento.getValue()
                                        , textFieldUsuario.getText()
                                        , textFieldContrasena.getText()
                                        , textFieldNombre.getText()
                                        , textFieldApellido.getText());
                modelo.insertarUsuario(fichero, usu);
                
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("VentanaLogIn.fxml"));
                Parent root = fxmlLoader.load();
                
                VentanaLogInController controlador = fxmlLoader.getController();
                controlador.setDatos(fichero);

                Stage stage = new Stage();
                stage.setTitle("Iniciar Sesión");
                stage.setScene(new Scene(root));
                stage.show();

                Stage ventanaActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
                ventanaActual.close();
            } else {
                labelError.setText("Ya existe un usuario registrado con ese nombre");
            }
        }
        
    }
    
    @FXML    
    private void volver(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("VentanaLogIn.fxml"));
        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        stage.setTitle("Iniciar Sesión");
        stage.setScene(new Scene(root));
        stage.show();

        Stage ventanaActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ventanaActual.close();
    }
    
}
