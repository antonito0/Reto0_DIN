package com.mycompany.reto0_din;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import modelo.*;

public class AdminController implements Initializable {

    private ImplementacionFichero modelo = new ImplementacionFichero();

    @FXML private Label nombreAdmin;
    @FXML private CheckBox baja;
    @FXML private TextField usuario;
    @FXML private TextField contra;
    @FXML private TextField apellido;

    @FXML private ComboBox<Empleado> empleados;

    @FXML private TextField usuarioE;
    @FXML private TextField contraE;
    @FXML private TextField nombreE;
    @FXML private TextField apeE;
    @FXML private TextField ibanE;

    @FXML private Label alerta;

    private final File fichero = new File("fichero.dat"); // ÚNICO FICHERO

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // === CARGAR ADMIN ===
        Admin admin = modelo.verAdmin(fichero);
        if (admin != null) {
            rellenarLabels(admin);
        }

        // === CARGAR EMPLEADOS ===
        empleados.getItems().clear();
        empleados.getItems().add(null); // opción vacía

        for (Empleado e : modelo.leerEmpleados(fichero)) {
            empleados.getItems().add(e);
        }

        empleados.setOnAction(event -> seleccionarEmpleado());
    }

    private void rellenarLabels(Admin admin) {
        usuario.setText(admin.getUsuario());
        nombreAdmin.setText(admin.getNombre());
        apellido.setText(admin.getApellido());
        baja.setSelected(admin.isBaja());
    }

    // ============================
    //   MENSAJES EN LABEL
    // ============================

    private void mostrarInfo(String msg) {
        alerta.setStyle("-fx-text-fill: green;");
        alerta.setText(msg);
    }

    private void mostrarError(String msg) {
        alerta.setStyle("-fx-text-fill: red;");
        alerta.setText(msg);
    }

    // ============================
    //   EMPLEADOS
    // ============================

    private void seleccionarEmpleado() {

        Empleado emp = empleados.getValue();

        if (emp == null) {
            limpiarCamposEmpleado();
            mostrarInfo("Introduce un nuevo empleado.");
            return;
        }

        usuarioE.setText(emp.getUsuario());
        contraE.setText(emp.getContrasena());
        nombreE.setText(emp.getNombre());
        apeE.setText(emp.getApellido());
        ibanE.setText(emp.getIban());

        mostrarInfo("Empleado cargado.");
    }

    private void limpiarCamposEmpleado() {
        usuarioE.clear();
        contraE.clear();
        nombreE.clear();
        apeE.clear();
        ibanE.clear();
    }

    private boolean ibanRepetido(String iban) {

        for (Empleado e : modelo.leerEmpleados(fichero)) {
            if (e.getIban().equalsIgnoreCase(iban)) {
                return true;
            }
        }
        return false;
    }

    @FXML
    private void actualizarEmpleado(ActionEvent event) {

        Empleado seleccionado = empleados.getValue();

        if (seleccionado == null) {
            mostrarError("Debes seleccionar un empleado para actualizar.");
            return;
        }

        seleccionado.setUsuario(usuarioE.getText());
        seleccionado.setContrasena(contraE.getText());
        seleccionado.setNombre(nombreE.getText());
        seleccionado.setApellido(apeE.getText());
        seleccionado.setIban(ibanE.getText());

        modelo.actualizarEmpleado(fichero, seleccionado);

        mostrarInfo("Empleado actualizado correctamente.");
    }

    @FXML
    private void registrarEmpleado(ActionEvent event) {

        String ibanNuevo = ibanE.getText();

        if (ibanRepetido(ibanNuevo)) {
            mostrarError("El IBAN ya existe. No se puede registrar este empleado.");
            return;
        }

        Empleado nuevo = new Empleado(
                ibanE.getText(),
                usuarioE.getText(),
                contraE.getText(),
                nombreE.getText(),
                apeE.getText()
        );

        modelo.insertarEmpleado(fichero, nuevo);

        mostrarInfo("Empleado registrado correctamente.");

        limpiarCamposEmpleado();
    }
}
