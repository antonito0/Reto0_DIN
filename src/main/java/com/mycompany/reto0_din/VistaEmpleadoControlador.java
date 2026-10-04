/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.reto0_din;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import modelo.ImplementacionFichero;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author rebeca
 */
public class VistaEmpleadoControlador {

    private File fichero;

    @FXML
    private Button salir;
    @FXML
    private ListView<String> listaUs;
    @FXML
    private Button visualizar;

    public void setDatos(File fichero) {
        this.fichero = fichero;
    }

    @FXML
    public void visualizarUsuarios(ActionEvent event) {

        listaUs.setVisible(true); // mostrar la lista

        listaUs.getItems().clear();

        ImplementacionFichero imp = new ImplementacionFichero();

        for (Usuario u : imp.obtenerUsuarios(fichero)) {
            listaUs.getItems().add(u.getNombre() + " " + u.getApellido() + " - Usuario: " + u.getUsuario());
        }
    }

    @FXML
    public void cerrarSesion(ActionEvent event) {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }

}
