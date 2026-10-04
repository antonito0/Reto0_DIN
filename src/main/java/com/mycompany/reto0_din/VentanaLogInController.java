package com.mycompany.reto0_din;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Admin;
import modelo.Empleado;
import modelo.ImplementacionFichero;
import modelo.Persona;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author Unai.Ibarguren
 */
public class VentanaLogInController implements Initializable {

    private ImplementacionFichero modelo = new ImplementacionFichero();

    private File fichero = new File("fichero.dat");

    @FXML
    private TextField textFieldUsuario;
    @FXML
    private PasswordField passwordFieldContrasena;
    @FXML
    private Button buttonIniciarSesion;
    @FXML
    private Button buttonCrearUsuario;
    @FXML
    private Label lblError;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modelo.fillData(fichero);
    }
    
    public void setDatos(File fichero) {
        this.fichero = fichero;
    }

    @FXML
    public void iniciarSesion(ActionEvent event) throws IOException {
        Persona persona = modelo.iniciarSesion(fichero, textFieldUsuario.getText(), passwordFieldContrasena.getText());

        if (persona instanceof Usuario) {

            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Usuario.fxml"));
            Parent root = fxmlLoader.load();

            UsuarioController controlador = fxmlLoader.getController();
            controlador.setDatos((Usuario) persona);
            
            Stage stage = new Stage();
            stage.setTitle("Usuario");
            stage.setScene(new Scene(root));
            stage.show();

            Stage ventanaActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ventanaActual.close();

        } else if (persona instanceof Empleado) {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("VistaEmpleado.fxml"));
            Parent root = fxmlLoader.load();

            VistaEmpleadoControlador controlador = fxmlLoader.getController();
            controlador.setDatos(fichero);

            Stage stage = new Stage();
            stage.setTitle("Empleado");
            stage.setScene(new Scene(root));
            stage.show();

            Stage ventanaActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ventanaActual.close();
        } else if (persona instanceof Admin) {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Admin.fxml"));
            Parent root = fxmlLoader.load();

            AdminController controlador = fxmlLoader.getController();
            controlador.setDatos(persona, fichero);

            Stage stage = new Stage();
            stage.setTitle("Administrador");
            stage.setScene(new Scene(root));
            stage.show();

            Stage ventanaActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ventanaActual.close();
        } else {
            lblError.setText("Usuario o contraseña incorrectos");
        }
    }

    @FXML
    private void crearUsuario(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("VentanaCrearUsuario.fxml"));
        Parent root = fxmlLoader.load();
        
        VentanaCrearUsuarioController controlador = fxmlLoader.getController();
        controlador.setDatos(fichero);

        Stage stage = new Stage();
        stage.setTitle("Crear usuario");
        stage.setScene(new Scene(root));
        stage.show();

        Stage ventanaActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ventanaActual.close();
    }

}
