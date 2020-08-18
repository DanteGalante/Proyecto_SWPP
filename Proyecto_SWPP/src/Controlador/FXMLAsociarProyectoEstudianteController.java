/*
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */
package Controlador;

import Modelo.DocenteDAOImp;
import Modelo.DocenteVO;
import Modelo.EstudianteDAOImp;
import Modelo.EstudianteVO;
import Modelo.ExpedienteDAOImp;
import Modelo.ExpedienteVO;
import Modelo.PreferenciaProyectoDAOImp;
import Modelo.PreferenciaProyectoVO;
import Modelo.ProyectoDAOImp;
import Modelo.ProyectoVO;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Clave del programa: SWPP<br>
 * Autor: olver <br>
 * Fecha: 20/07/2020 <br>
 * Descripción: Controlador de la pantalla "Asociar proyecto con estudiante"
 */
public class FXMLAsociarProyectoEstudianteController implements Initializable {
    @FXML
    private AnchorPane apVentana;
    /**
     * Tabla que contiene todos los estudiantes que no tienen proyecto asignado
     */
    @FXML
    private TableView<EstudianteVO> tbEstudiantes;
    /**
     * Columna que contiene las matriculas de los estudiantes que no tienen proyecto asignado
     */
    @FXML
    private TableColumn tcMatriculaEstudiante;
    /**
     * Columna que contiene los nombres de los estudiantes que no tienen proyecto asignado
     */
    @FXML
    private TableColumn tcNombreEstudiante;
    /**
     * Tabla que contiene todos los proyectos que estan disponibles para seleccionar
     */
    @FXML
    private TableView<ProyectoVO> tbProyectos;
    /**
     * Columna que contiene los nombres de los proyectos disponibles para seleccionar
     */
    @FXML
    private TableColumn tcNombreProyecto;
    /**
     * Columna que contiene las descripciones de los proyectos disponibles para seleccionar
     */
    @FXML
    private TableColumn tcDescripcionProyecto;
    /**
     * Columna que contiene el numero de estudiantes solicitados de los proyectos disponibles para seleccionar
     */
    @FXML
    private TableColumn tcNumEstudiantesSolicitados;
    /**
     * Etiqueta que lista los proyectos que un estudiante especifico selecciono durante la etapa de seleccion de proyectos
     */
    @FXML
    private Label lbPreferenciaProyectos;
    /**
     * Intermediario entre los datos recibidos de la base de datos y la table view correspondiente a los Estudiantes
     */
    private ObservableList<EstudianteVO> listaEstudiantes;
    /**
     * Intermediario entre los datos recibidos de la base de datos y la table view correspondiente a los Estudiantes
     */
    private ObservableList<ProyectoVO> listaProyectos;
    
    /**
     * Lista de los estudiantes seleccionados en la tabla tbEstudiantes
     */
    private ObservableList<EstudianteVO> estudiantesSeleccionadosPAsociar;
    /**
     * Proyecto seleccionado de la tabla tbProyecto
     */
    private ProyectoVO proyectoSeleccionadoPAsociar;
    
    /**
     * Acciones que realiza la ventana a la hora de inicializar
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        //Establecemos que valores van a recibir cada columna de la tabla tbEstudiantes
        this.tcMatriculaEstudiante.setCellValueFactory(new PropertyValueFactory("matricula"));
        this.tcNombreEstudiante.setCellValueFactory(new PropertyValueFactory("nombre"));
        
        //Establecemos que valores van a recibir cada columna de la tabla tbProyectos
        this.tcNombreProyecto.setCellValueFactory(new PropertyValueFactory("nombreProyecto"));
        this.tcDescripcionProyecto.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.tcNumEstudiantesSolicitados.setCellValueFactory(new PropertyValueFactory("personasRequeridas"));
        
        //Permite la seleccion de varios elementos a la vez dentro del tableview
        tbEstudiantes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //Agregamos un listener que detecte las selecciones en la tabla tbEstudiantes
        tbEstudiantes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<EstudianteVO>() {
            @Override
            public void changed(ObservableValue observable, EstudianteVO oldValue, EstudianteVO newValue) {
                FXMLAsociarProyectoEstudianteController.this.mostrarPreferenciaEstudiante(newValue);
                FXMLAsociarProyectoEstudianteController.this.seleccionarEstudiante();
            }
        });
        //Agregamos un listener que detecta las selecciones en la tabla tbProyectos
        tbProyectos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> seleccionarProyecto(newValue));
        
        recuperarEstudiantes();
        recuperarProyectos();
        mostrarVentana();
        
    }    
    /**
     * Recupera los estudiantes de la base de datos en una ObservableList
     * @see javafx.collections.ObservableList
     */
    private void recuperarEstudiantes(){
        try {
            EstudianteDAOImp estudianteDAO = new EstudianteDAOImp();
            listaEstudiantes = estudianteDAO.readAll("Aprobado");
        } catch (Exception ex) {
            System.out.println("Error al tratar de recuperar a los estudiantes");
            Alert mensajeEmergente = new Alert(Alert.AlertType.ERROR);
            mensajeEmergente.setTitle("ERROR: BASE DE DATOS");
            mensajeEmergente.setHeaderText(null);
            mensajeEmergente.setContentText("Error al tratar de conectar con la base de datos");
            mensajeEmergente.show();
            
            ex.printStackTrace();
        }
    }
    /**
     * Recupera los proyectos de la base de datos en una ObservableList
     */
    private void recuperarProyectos(){
        ProyectoDAOImp proyectoDAO = new ProyectoDAOImp();
        listaProyectos = proyectoDAO.readAll("En espera");
    }
    public ObservableList<EstudianteVO> getListaEstudiantes(){
        return listaEstudiantes;
    }
    /**
     * Muestra la informacion pertinente, proyectos, estudiantes y su preferencia de proyectos, en la ventana;
     */
    private void mostrarVentana(){
        tbEstudiantes.setItems(listaEstudiantes);
        tbProyectos.setItems(listaProyectos);
    }
    /**
     * Muestra en un label la preferencia de proyectos del estudiante seleccionado     
     * @param estudianteSeleccionado estudiante actualmente seleccionado
     * @see javafx.scene.control.Label
     */
    private void mostrarPreferenciaEstudiante(EstudianteVO estudianteSeleccionado){
        PreferenciaProyectoDAOImp preferencia = new PreferenciaProyectoDAOImp();
        String proyectosPreferidos = "";
        try{
            ObservableList<PreferenciaProyectoVO> listaPreferencias = preferencia.readAll(estudianteSeleccionado.getMatricula());
            for(int i=0; i<listaPreferencias.size(); i++){
                proyectosPreferidos = proyectosPreferidos + (i+1) + ": " + listaPreferencias.get(i).getNombreProyectoVinculado() + "\n";
            }
        }catch(NullPointerException ex){
            System.out.println("El estudiante seleccionado no tiene preferencia de proyectos");
        }
        
        this.lbPreferenciaProyectos.setText(proyectosPreferidos);
    }
    /**
     * Guarda en una variable el proyecto que esta siendo seleccionado en ese momento
     * @param proyectoSeleccionado objeto seleccionado
     */
    private void seleccionarProyecto(ProyectoVO proyectoSeleccionado){
        this.proyectoSeleccionadoPAsociar = proyectoSeleccionado;
    }

    private void seleccionarEstudiante(){
        if(tbEstudiantes.getSelectionModel().getSelectedItem() != null){    
            TableViewSelectionModel selectionModel = tbEstudiantes.getSelectionModel();
            ObservableList<EstudianteVO> selectedCells = selectionModel.getSelectedItems();
            
            this.estudiantesSeleccionadosPAsociar = selectedCells;
        }
    }
    @FXML
    private void clicAsociar(ActionEvent e){
        ExpedienteDAOImp expedienteDAO = new ExpedienteDAOImp();
        ProyectoDAOImp proyectoDAO = new ProyectoDAOImp();
        EstudianteDAOImp estudianteDAO = new EstudianteDAOImp();
        
        if(this.proyectoSeleccionadoPAsociar == null || this.estudiantesSeleccionadosPAsociar == null){
            mostrarVentanaMensaje("No se puede realizar la asociación debido a que no se ha seleccionado al menos 1 proyecto y un estudiante",Alert.AlertType.ERROR);
        }else{
            if(verificarNumEstudiantesSolicitados()){
                boolean opcion = mostrarVentanaConfirmacion("¿Esta seguro que desea asociar este proyecto a este(os) estudiantes?");
            
                if(opcion==true){
                    asociarProyectoConEstudiante();
                }
            }           
        }
    }
     @FXML
    private void clicSalir(ActionEvent event) {
        ocultarVentanaActual();
    }
    private boolean verificarNumEstudiantesSolicitados(){
        System.out.println("Personas requeridas: "+proyectoSeleccionadoPAsociar.getPersonasRequeridas()+
                "\n"+ "# estudiantes seleccionados: "+estudiantesSeleccionadosPAsociar.size());
        if(proyectoSeleccionadoPAsociar.getPersonasRequeridas() < estudiantesSeleccionadosPAsociar.size()){
            Alert mensajeEmergente = new Alert(Alert.AlertType.ERROR);
            mensajeEmergente.setTitle(null);
            mensajeEmergente.setHeaderText(null);
            mensajeEmergente.setContentText("No se puede realizar la asociación debido a que se ha excedido el número de estudiantes permitidos para este proyecto");
            mensajeEmergente.show();
            return false;
        }
        return true;
    }

    private Boolean mostrarVentanaConfirmacion(String contenido) {
        Alert mensajeConfirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        mensajeConfirmacion.setTitle(null);
        mensajeConfirmacion.setHeaderText(null);
        mensajeConfirmacion.setContentText(contenido);
        Optional<ButtonType> botonPresionado = mensajeConfirmacion.showAndWait();
        
        return botonPresionado.get() == ButtonType.OK;
    }
    
    private void mostrarVentanaMensaje(String mensaje, Alert.AlertType tipo) {
        Alert ventanaMensaje = new Alert(tipo);
        ventanaMensaje.setTitle(null);
        ventanaMensaje.setHeaderText(null);
        ventanaMensaje.setContentText(mensaje);
        ventanaMensaje.show();
    }
    
    private DocenteVO buscarDocente(String nrc) {
        DocenteDAOImp docenteDAO = new DocenteDAOImp();
        try {
            DocenteVO docenteBuscado = docenteDAO.readPorGrupo(nrc);
            return docenteBuscado;
        }catch (Exception ex) {
            mostrarVentanaMensaje("No se pudo asociar el proyecto con el/los estudiantes debido a un problema con la conexión a la base de datos",Alert.AlertType.ERROR);
        }
        return null;
    }

    private void asociarProyectoConEstudiante() {
        ProyectoDAOImp proyectoDAO = new ProyectoDAOImp();
        EstudianteDAOImp estudianteDAO = new EstudianteDAOImp();
        ExpedienteDAOImp expedienteDAO = new ExpedienteDAOImp();
        
        String periodoActual = 
            this.proyectoSeleccionadoPAsociar.getMesInicioPeriodo() + " " +
            this.proyectoSeleccionadoPAsociar.getAnioInicioPeriodo() + " - " +
            this.proyectoSeleccionadoPAsociar.getMesFinalPeriodo() + " " +
            this.proyectoSeleccionadoPAsociar.getAnioFinalPeriodo();
        
        this.proyectoSeleccionadoPAsociar.setEstatus("En ejecucion");
        
        for(int i=0; i<this.estudiantesSeleccionadosPAsociar.size(); i++ ){
            try {
                this.estudiantesSeleccionadosPAsociar.get(i).setEstatus("Trabajando");
                ExpedienteVO expedienteNuevo = new ExpedienteVO(
                        this.estudiantesSeleccionadosPAsociar.get(i).getMatricula(),
                        this.proyectoSeleccionadoPAsociar.getNombreProyecto(),
                        periodoActual,
                        0,
                        0,
                        buscarDocente(this.estudiantesSeleccionadosPAsociar.get(i).getNRC()).getCedulaProfesional()
                );
                
                estudianteDAO.update(this.estudiantesSeleccionadosPAsociar.get(i).getMatricula(), this.estudiantesSeleccionadosPAsociar.get(i));
                expedienteDAO.create(expedienteNuevo);
            } catch (Exception ex) {
                Logger.getLogger(FXMLAsociarProyectoEstudianteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        proyectoDAO.update(this.proyectoSeleccionadoPAsociar.getNombreProyecto(),this.proyectoSeleccionadoPAsociar);
    }

    public void ocultarVentanaActual(){
        Stage stageActual = (Stage)this.apVentana.getScene().getWindow();
        stageActual.hide(); 
    }
}
