/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.reto0_din;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import modelo.ImplementacionF;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author rebeca
 */
public class VistaEmpleadoControlador {

    @FXML
    private Button salir;
    @FXML
    private ListView<String> listaUs;
    @FXML
    private Button visualizar;

    @FXML
    public void visualizarUsuarios(ActionEvent event) {
        listaUs.getItems().clear();

        ImplementacionF imp = new ImplementacionF();
        for (Usuario u : imp.obtenerUsuarios()) {
            listaUs.getItems().add(u.getNombre());
        }
    }

}
