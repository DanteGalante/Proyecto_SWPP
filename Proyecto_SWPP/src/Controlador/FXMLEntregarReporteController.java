/*
------------------------
Alan Adair Morgado Morales
UNIVERSIDAD VERACRUZANA
------------------------
 */
package Controlador;

import static Controlador.FXMLEntregarReporteController.establecerFecha;
import Modelo.DocumentoRequeridoDAOImp;
import Modelo.DocumentoRequeridoVO;
import Modelo.EstudianteDAOImp;
import Modelo.EstudianteVO;
import Modelo.ExpedienteDAOImp;
import Modelo.ExpedienteVO;
import Modelo.ReporteEstudianteDAOImp;
import Modelo.ReporteEstudianteVO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * Clave del programa: SWPP<br>
 * Autor: Morgado <br>
 * Fecha: 10/08/2020 <br>
 * Actualizacion: 17/08/2020 <br>
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
     * DocuemntoRequerido del alumno seleccionado de la tabla Expediente
     */
    //private DocumentoRequeridoVO nuevoReporte;
    
    private ReporteEstudianteVO nuevoReporte;
  
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
        try {
            nombreEstudiante = estudianteDAO.read(lbMatricula.getText());
        } catch (Exception ex) {
            Logger.getLogger(FXMLEntregarReporteController.class.getName()).log(Level.SEVERE, null, ex);
        }
                      
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
     * Metodo encargado de ocultar la ventana actual para asi poder pasar a otra escen
     */
    public void ocultarVentanaActual(){
        Stage stageActual = (Stage)tfTipoReporte.getScene().getWindow();
        stageActual.hide(); 
    }
    
    /**
     * Acciones que realiza el boton "Guardar" cuando se le da clic
     */
    
    
    
    private void guardarReporte(){
        
        //verificarCampoTipoReporte();
        verificarCampoHorasReportadas();
        
        try {
            ExpedienteDAOImp expedienteDAO = new ExpedienteDAOImp();
            horasAcumEstudiante = expedienteDAO.readExpedienteMatricula(lbMatricula.getText());
            String nombreProyecto = horasAcumEstudiante.getNombreProyectoVinculado();
            int totalDeHoras = Integer.parseInt(tfHoras.getText());
            String tipoReporte = tfTipoReporte.getText();
            String matriculaEstudianteExpediente = lbMatricula.getText();
            
            
            /*
            DocumentoRequeridoDAOImp DocumentoRequeridoDAO = new DocumentoRequeridoDAOImp();
            String tituloReporte = "Reporte Estudiante";
            String descripcionReporte = lbFecha.getText();
            
            */
            
            boolean resultadoReporte;
                       
            //DocumentoRequeridoVO documentoReporte = new DocumentoRequeridoVO(0, tituloReporte,  descripcionReporte, lbMatricula.getText(),  nombreProyecto);
            //resultadoDocumento = DocumentoRequeridoDAO.create(documentoReporte);
            //Preguntamos por el id del ultimo documento entregado    
            
            ReporteEstudianteDAOImp reporteEstudianteDAO = new ReporteEstudianteDAOImp();
            ReporteEstudianteVO reporteEstudiante = new ReporteEstudianteVO(0, totalDeHoras, tipoReporte, matriculaEstudianteExpediente, nombreProyecto);
            resultadoReporte = reporteEstudianteDAO.create(reporteEstudiante);
            
            
            
            //Alert alert = new Alert(AlertType.ERROR, "Ingrese un valor valido", ButtonType.OK);
            //alert.showAndWait();
        } catch (SQLException | NumberFormatException ex) {
            Logger.getLogger(FXMLAsociarProyectoEstudianteController.class.getName()).log(Level.SEVERE, null, ex);    
        }
    }

    private boolean verificarCampoHorasReportadas() {
        
        //Contiene el resultado de la comprobacion del TextField "tfHoras" 
        boolean resultado;
        
        //Preguntamos si el TextField es diferente de nulo
        if(tfHoras.getText() != null){
            try {
                Integer.parseInt(tfHoras.getText());
                resultado = true;
            } catch (NumberFormatException excepcion) {
                Alert alert = new Alert(AlertType.ERROR, "Ingrese un valor de tipo entero en el campo de Horas Reportadas", ButtonType.OK);
                alert.setHeaderText(null);
                alert.showAndWait();
                resultado = false;
            }
        
        }else{
            Alert alert = new Alert(AlertType.ERROR, "Ingrese un valor en el campo de Horas Reportadas", ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
            resultado = false;
            
        }
        return resultado;
    }
    /*
    private boolean verificarCampoTipoReporte() {
        
        boolean resultado2;
        //Preguntamos si el TextFiled es diferente de nulo
        if(tfTipoReporte.getText() != null){
            try {
                Integer.parseInt(tfHoras.getText());
                resultado2 = true;
      
                Alert alert = new Alert(AlertType.ERROR, "Ingrese un valor de tipo String en el campo de Tipo Reporte", ButtonType.OK);
                alert.setHeaderText(null);
                alert.showAndWait();
                resultado2 = false;
            }
                resultado2 = true;
        }
        return resultado2;                
    }   
    */
      
        
}
   
