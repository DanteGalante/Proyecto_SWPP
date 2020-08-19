/*
FXML Controller class
Clave del programa: SWPP
Autor: Morgado
Fecha: 10/08/2020
Actualizacion: 17/08/2020
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
import Modelo.ReporteEstudianteDAOImp;
import Modelo.ReporteEstudianteVO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Optional;
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
 * Clase que representa al controlador de la ventana FXMLEntregarReporte <br><br>
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
    
    /**
     * Estudiante seleccionado de la tabla Estudiante
     */
    private EstudianteVO nombreEstudiante;
    
    /**
     * Expediente del alumno seleccionado de la tabla Expediente
     */
    private ExpedienteVO horasAcumEstudiante;
    
    /**
     * reporte seleccionado de la tabla Expediente
     */
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
        /**
        * matricula ingresada por el estduiante que sera puesta en la etiqueta lbMatricula
        **/
        lbMatricula.setText(matriculaExportada);
        
        EstudianteDAOImp estudianteDAO = new EstudianteDAOImp();
        try {
            nombreEstudiante = estudianteDAO.read(lbMatricula.getText());
        } catch (Exception ex) {
            Logger.getLogger(FXMLEntregarReporteController.class.getName()).log(Level.SEVERE, null, ex);
        }
         /**
        * se establece el nombre del estudiante que ingreso su matricula para iniciar sesion en la etiqueta lbNombre
        **/             
        this.lbNombre.setText(nombreEstudiante.getNombre()); 
        
        ExpedienteDAOImp expedienteDAO = new ExpedienteDAOImp();
        try {
            /**
             * horasAcumEstudiante recibe un expdiente con la matricula que esta el parametro del metodo readExpdienteMatricula
             **/
            horasAcumEstudiante = expedienteDAO.readExpedienteMatricula(lbMatricula.getText());
        } catch (Exception ex) {
            Logger.getLogger(FXMLEntregarReporteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        /**
        * Guardamos las horas acumuladas del estudiante en la variable horasTotales
        **/
        int horasTotales = horasAcumEstudiante.getNumHrsTotales();
        /**
        * Guardamos el periodo actual en la variable periodo
        **/
        String periodo = horasAcumEstudiante.getPeriodo();
        /**
        * Muetsra las horas que tiene el estudiante en su expediente
        * */
        this.lbHorasAcumuladas.setText(String.valueOf(horasTotales));
        /**
        * Se le envia el perido actual a la etiqueta
        **/
        this.lbPeriodo.setText(periodo);
        /**
        * Se le envia la fecha actual a la etiqueta
        **/
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
        
        //Preguntamos si el textField de tipo reporte esta vacio, en caso de que si se manda un mensaje
        if(tfTipoReporte.getText().length()==0){
            //Mensaje de error 
            mostrarVentanaDeMensaje("Ingrese un valor de tipo String en el campo de Tipo Reporte");
        }else{
            //Se llama al metodo para verificar si lo que ingreso el usuario en el textField de 

            if(verificarCampoHorasReportadas() == true){
                    //Se envia un mensaje de a la metodo para que nos regrese una ventana la cual escuchara un evento true o false a partir del boton selecionado
                    boolean opcion = mostrarVentanaDeConfirmacion("¿Seguro que quieres continuar?");
                if(opcion ==true){
                    //Se llama al metodo guardar reporte una vez que se verifico que las entrdas son validas para egistrar el reporte
                    guardarReporte();
                }
            }
        }   
    }
    
    /**
     * Acciones que realiza el boton "Salir" cuando se le da clic
     * Se encarga de cerrar la ventana actual y regresa al menu de incio
     */
    @FXML
    private void clicSalirReporte(ActionEvent event) {
        salirDeEntregarReporte();
    }
    
    /**
    *   Metodo encargado de salir del la ventana FXMLEntregarReporteControlller para volver al menu de inicio
    */
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
    * METODO ENCARGADO DE GUARDAR EL REPORTE DEL ESTUDIANTE
    */
    private void guardarReporte(){
    
        try {
            ExpedienteDAOImp expedienteDAO = new ExpedienteDAOImp();
            horasAcumEstudiante = expedienteDAO.readExpedienteMatricula(lbMatricula.getText());
            String nombreDeProyecto = horasAcumEstudiante.getNombreProyectoVinculado();
            int totalDeHoras = Integer.parseInt(tfHoras.getText());
            String tipoReporte = tfTipoReporte.getText();
            String matriculaEstudianteExpediente = lbMatricula.getText();
            String periodo = lbPeriodo.getText();
            String cedulaDeDocente = horasAcumEstudiante.getCedulaDocenteVinculado();
            
            int numeroArchivosParcial = horasAcumEstudiante.getNumeroArchivos();
            int horasEnExpediente = horasAcumEstudiante.getNumHrsTotales();
            int totalDeHorasActualizado = horasEnExpediente + totalDeHoras;
            int numeroArchivosActualizado = numeroArchivosParcial + 1;
            
            //Son de tipo booleano ya que ahi se guarda el resultado(true o false) de la operacion
            boolean resultadoReporte, resultadoExpediente; 
            
            /**
             * Se crea un objeto de tipo ExpedienteVO para 
             */
            ExpedienteVO expedienteNuevo = new ExpedienteVO(matriculaEstudianteExpediente, nombreDeProyecto, periodo, numeroArchivosActualizado, totalDeHorasActualizado,cedulaDeDocente);
            ReporteEstudianteDAOImp reporteEstudianteDAO = new ReporteEstudianteDAOImp();
            nuevoReporte = new ReporteEstudianteVO(0, totalDeHoras, tipoReporte, matriculaEstudianteExpediente, nombreDeProyecto);
            resultadoReporte = reporteEstudianteDAO.create(nuevoReporte);
            //Se actualiza el expediente del estudiante con el numero numero de documentos y las suma de susu horas reportadas
            resultadoExpediente = expedienteDAO.update(matriculaEstudianteExpediente, nombreDeProyecto, expedienteNuevo);
            if(resultadoReporte = true) {
                //Mensaje de confirmacion de exito de la operacion
                Alert alert = new Alert(AlertType.INFORMATION, "La información ha sido guardada en la base de datos del sistema", ButtonType.OK);
                alert.setHeaderText(null);
                alert.showAndWait();
                //Una vez terminadas las operaciones se regresa al usuario al menu principal
                salirDeEntregarReporte();               
            } 
        } catch (SQLException | NumberFormatException ex) {
            Logger.getLogger(FXMLAsociarProyectoEstudianteController.class.getName()).log(Level.SEVERE, null, ex);    
        } catch (Exception ex) {
            Logger.getLogger(FXMLEntregarReporteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    *SE ENCARGA DE VERIFICAR QUE EL CAMPO DE HORAS SOLO TENGA UN NUMERO ENTERO
    */
    private boolean verificarCampoHorasReportadas() {     
        //Contiene el resultado de la comprobacion del TextField "tfHoras" 
        boolean resultado = false;
        
        //Preguntamos si el TextField es diferente de nulo o si es un numero entero
        if(tfHoras.getText() != null){
            try {
                Integer.parseInt(tfHoras.getText());
                resultado = true;            
            } catch (NumberFormatException excepcion) {
                //Mensaje donde se indica al usuario el tipo de entrada valida
                mostrarVentanaDeMensaje("Ingrese un valor de tipo entero en el campo de Horas Reportadas");
                resultado = false;
            }        
        }
        
        return resultado;
    }                     
    
    /**
    *Metodo que muestra una ventana de confirmacion, recibe un texto que muestra en un alert de CONFIRMATION
    */
    private Boolean mostrarVentanaDeConfirmacion(String contenido) {
    Alert mensajeConfirmacion = new Alert(Alert.AlertType.CONFIRMATION);
    mensajeConfirmacion.setTitle(null);
    mensajeConfirmacion.setHeaderText(null);
    mensajeConfirmacion.setContentText(contenido);
    Optional<ButtonType> botonPresionado = mensajeConfirmacion.showAndWait();
    //Si presionan aceptar devuelve true, si presiona cancelar devuelve false
        if(botonPresionado.get() == ButtonType.OK){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Metodo que muestra una ventana de error, recibe un texto que muestra en un alert de ERROR
     */
    private Boolean mostrarVentanaDeMensaje(String contenido) {
    Alert mensajeConfirmacion = new Alert(Alert.AlertType.ERROR);
    mensajeConfirmacion.setTitle(null);
    mensajeConfirmacion.setHeaderText(null);
    mensajeConfirmacion.setContentText(contenido);
    Optional<ButtonType> botonPresionado = mensajeConfirmacion.showAndWait();
    //Si presionan aceptar devuelve true, si presiona cancelar devuelve false
        if(botonPresionado.get() == ButtonType.OK){
            return true;
        }else{
            return false;
        }
    } 
}

    

   

