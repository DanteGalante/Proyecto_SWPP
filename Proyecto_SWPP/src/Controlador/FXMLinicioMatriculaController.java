/*
------------------------
Alan Adair Morgado Morales
UNIVERSIDAD VERACRUZANA
------------------------
 */
package Controlador;

import Modelo.EstudianteDAOImp;
import Modelo.EstudianteVO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * Clave del programa: SWPP<br>
 * Autor: Morgado <br>
 * Fecha: 10/08/2020 <br>
 * Actualizacion: 17/08/2020
 * Descripción: Clase que representa al controlador de la ventana FXMLincioMatriculaController
 **/
public class FXMLinicioMatriculaController implements Initializable {
    
    /**
     * TextField que contiene la matricula ingresada por el usuario para iniciar sesion
     */
    @FXML
    private TextField tfInicioMatricula;
    
    /**
     * Estudiante seleccionado de la tabla Estudiante
     */
    private EstudianteVO estudianteInicio;
    
    /**
     * Acciones que realiza la ventana a la hora de inicializar
     * @param url parametro que necesario para inicializar
     * @param rb parametro que necesario para inicializar
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /**
     * Acciones que realiza el boton "Iniciar" cuando se le da clic
     */
    @FXML
    private void btIniciarMatricula(ActionEvent event) {
        confirmarMatricula();
    }
    
    /**
     * Metodo para comprobar qu la matricula ingresada por el usuario sea valida para poder iniciar sesion
     */
    public void confirmarMatricula(){
        try {
            EstudianteDAOImp estudianteDAO = new EstudianteDAOImp();
            estudianteInicio = estudianteDAO.read(tfInicioMatricula.getText());
            if(estudianteInicio != null && estudianteInicio.getEstatus().equals("Trabajando"))
                irEntregarReporte();
            else{
                Alert alert = new Alert(AlertType.ERROR, "Ingrese una matricula valida", ButtonType.OK);
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        } catch (Exception ex) {
            Logger.getLogger(FXMLAsociarProyectoEstudianteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo para cambiar de la ventana FXMLinicioMatriculaController a la ventana "FXMLEntregarReporteController
     */
    public void irEntregarReporte(){
        try {
            ocultarVentanaActual();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/FXMLEntregarReporte.fxml"));
            Parent root = (Parent) loader.load();
            
            //Controlador para enviar la matricula ingresada por el estudiante a la siguiente ventana
            FXMLEntregarReporteController siguienteControlador = loader.getController();
            siguienteControlador.mostrarDatosEstudiante(tfInicioMatricula.getText());
            //siguienteControlador.mostrarInfoUsuario(lbMatricula.getText());
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(null);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    /**
     * Metodo que da funcionalidad a al boton "Salir" de la ventana FXMLinicioMatriculaController
     */
    @FXML
    private void btSalirMatricula(ActionEvent event) {
        salirDeInicioMatricula();
    }
    /**
     * Acciones que realiza el boton "Salir" cuando se le da clic
     * Se encarga de cerrar la ventana actual y regresa al menu de incio
     */
    public void salirDeInicioMatricula(){
        try {
            ocultarVentanaActual();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/FXMLInicio.fxml"));
            Parent root = (Parent) loader.load();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(null);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    /**
     * Metodo encargado de ocultar la ventana actual para asi poder pasar a otra escena
     */
    public void ocultarVentanaActual(){
        Stage stageActual = (Stage)tfInicioMatricula.getScene().getWindow();
        stageActual.hide(); 
    }
}