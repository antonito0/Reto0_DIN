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
    
    private Persona persona;
    private File fichero;

    @FXML private Label nombreAdmin;
    @FXML private CheckBox baja;
    @FXML private TextField usuario;
    @FXML private TextField contra;
    @FXML private TextField apellido;
    @FXML
    private Button salir;
    
    @FXML private ComboBox<Empleado> empleados;

    @FXML private TextField usuarioE;
    @FXML private TextField contraE;
    @FXML private TextField nombreE;
    @FXML private TextField apeE;
    @FXML private TextField ibanE;

    @FXML private Label alerta;

    @FXML
    private Button modificarE;
    @FXML
    private Button registrarE;
    @FXML
    private Button modificar;
    @FXML
    private Button EmpleadoV;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        empleados.getItems().clear();
        empleados.getItems().add(null);
        for (Empleado e : modelo.leerEmpleados(fichero)) {
            empleados.getItems().add(e);
        }

        empleados.setOnAction(event -> seleccionarEmpleado());
    }
    
   public void setDatos(Persona persona, File fichero) {
    this.persona = persona;
    this.fichero = fichero;

    usuario.setText(persona.getUsuario());
    apellido.setText(persona.getApellido());
    contra.setText(persona.getContrasena());
    nombreAdmin.setText(persona.getNombre());
    
    if (persona instanceof Admin) { //ya que la baja es un atributo de admin 
        Admin admin = (Admin) persona;
        baja.setSelected(admin.isBaja());
    }

    cargarEmpleados();
    empleados.setOnAction(event -> seleccionarEmpleado());
}

    private void cargarEmpleados() {
        empleados.getItems().clear();
        empleados.getItems().add(null); // opción para crear nuevo empleado

        for (Empleado e : modelo.leerEmpleados(fichero)) {
            empleados.getItems().add(e);
        }
    }
 
    //mensaje para admin para informar 
    private void mostrarInfo(String msg) {
        alerta.setStyle("-fx-text-fill: green;");
        alerta.setText(msg);
    }

    private void mostrarError(String msg) {
        alerta.setStyle("-fx-text-fill: red;");
        alerta.setText(msg);
    }

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
    private void modificarEmple(ActionEvent event) {

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
    private void modificarAdmin(ActionEvent event) {

        File fichO = new File("fichero.dat");

        Admin adminNuevo = new Admin(
                usuario.getText(),     
                contra.getText(),       
                nombreAdmin.getText(),  
                apellido.getText()      
        );

        // Actualizar el boolean del CheckBox
        adminNuevo.setBaja(baja.isSelected());

        modelo.actualizarAdmin(fichero, adminNuevo);

        mostrarInfo("Admin actualizado correctamente.");
    }

    @FXML
    private void registrarEmlpe(ActionEvent event) {

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
    
    @FXML
    private void salir(ActionEvent event) {
        // Obtener la ventana actual y cerrarla
        salir.getScene().getWindow().hide();
    }
    
    @FXML
    private void abrirVistaEmpleado(ActionEvent event) {
        try {
            App.setRoot("VistaEmpleado");   // nombre del FXML SIN .fxml
        } catch (Exception e) {
            System.out.println("No se pudo abrir VistaEmpleado");
        }
    }

}
