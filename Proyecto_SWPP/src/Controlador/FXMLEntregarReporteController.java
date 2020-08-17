/*
------------------------
Alan Adair Morgado Morales
UNIVERSIDAD VERACRUZANA
------------------------
 */
package Controlador;

import static Controlador.FXMLEntregarReporteController.establecerFecha;
import Modelo.EstudianteDAOImp;
import Modelo.EstudianteVO;
import Modelo.ExpedienteDAOImp;
import Modelo.ExpedienteVO;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * Clave del programa: SWPP<br>
 * Autor: Morgado <br>
 * Fecha: 10/08/2020 <br>
 * Actualizacion: 17/08/2020
 * Descripción: Clase que representa al controlador de la ventana FXMLEntregarReporte
 **/
public class FXMLEntregarReporteController implements Initializable {
    
    /**
     * TextField que contiene la matricula ingresada por el usuario para iniciar sesion
     */
    @FXML
    private TextField tfTipoReporte;
    @FXML
    private TextField tfHoras;
    @FXML
    private Label lbNombre;
    @FXML
    private Label lbMatricula;
    @FXML
    private Label lbHorasAcumuladas;
    @FXML
    private Label lbFecha; 
    @FXML
    private Label lbPeriodo;
    
    /**
     * Es la matricula ingresada por el estudiante para iniciar sesion
     */
    private String matriculaExportada;
    
    
    //private EstudianteVO estudianteEntregaReporte;
    
    /**
     * Estudiante seleccionado de la tabla Estudiante
     */
    private EstudianteVO nombreEstudiante;
    
    /**
     * Expediente del alumno seleccionado de la tabla Expediente
     */
    private ExpedienteVO horasAcumEstudiante;
  
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
    *Funcion encargada de cargar los datos del estudiante en la ventana
    * Carga los datos en las "label" de la ventana FXMLEntregarReporteController
    * @param matriculaExportada es la matricula ingresada por el estudiante para inciar sesion
    **/
    public void mostrarDatosEstudiante(String matriculaExportada){
        
        lbMatricula.setText(matriculaExportada);
        
        EstudianteDAOImp estudianteDAO = new EstudianteDAOImp();
        nombreEstudiante = estudianteDAO.read(lbMatricula.getText());
                      
        this.lbNombre.setText(nombreEstudiante.getNombre()); 
        
        ExpedienteDAOImp expedienteDAO = new ExpedienteDAOImp();
        horasAcumEstudiante = expedienteDAO.readExpedienteMatricula(lbMatricula.getText());
        int horasTotales = horasAcumEstudiante.getNumHrsTotales();
        String periodo = horasAcumEstudiante.getPeriodo();
        
        this.lbHorasAcumuladas.setText(String.valueOf(horasTotales));
        
        this.lbPeriodo.setText(periodo);
        
        this.lbFecha.setText(establecerFecha());       
    }
    
    /**
    * Funcion encargada de establecer la fecha actual en la ventana FXMLEntregarReporteController
    * @return fecha
    **/
    public static String establecerFecha(){
        Date fecha = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY"); 
        
        return formatter.format(fecha);
    }             
    
    /**
    * Metodo que da funcionalidad al boton "Guardar" de la ventana FXMLEntregarReporteController
    **/
    @FXML
    private void clicGuardarReporte(ActionEvent event) {
        guardarReporte();
    }
    
    /**
     * Acciones que realiza el boton "Salir" cuando se le da clic
     * Se encarga de cerrar la ventana actual y regresa al menu de incio
     */
    @FXML
    private void clicSalirReporte(ActionEvent event) {
        salirDeEntregarReporte();
    }
    
            public void salirDeEntregarReporte(){
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
        Stage stageActual = (Stage)tfTipoReporte.getScene().getWindow();
        stageActual.hide(); 
    }
    
    /**
     * Acciones que realiza el boton "Guardar" cuando se le da clic
     */
    private void guardarReporte(){
        
    }
    
}
