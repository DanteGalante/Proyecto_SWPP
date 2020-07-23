/*
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */
package Controlador;

import Modelo.EstudianteDAOImp;
import Modelo.EstudianteVO;
import Modelo.ProyectoDAOImp;
import Modelo.ProyectoVO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Clave del programa: SWPP<br>
 * Autor: olver <br>
 * Fecha: 20/07/2020 <br>
 * Descripción: Controlador de la pantalla "Asociar proyecto con estudiante"
 */
public class FXMLAsociarProyectoEstudianteController implements Initializable {
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
     * Acciones que realiza la ventana a la hora de inicializar
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Permite la seleccion de varios elementos a la vez dentro del tableview
        tbEstudiantes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tbEstudiantes.getSelectionModel().getSelectedItems().addListener(listener);
        
        //Establecemos que valores van a recibir cada columna de la tabla tbEstudiantes
        this.tcMatriculaEstudiante.setCellValueFactory(new PropertyValueFactory("matricula"));
        this.tcNombreEstudiante.setCellValueFactory(new PropertyValueFactory("nombre"));
        
        //Establecemos que valores van a recibir cada columna de la tabla tbProyectos
        this.tcNombreProyecto.setCellValueFactory(new PropertyValueFactory("nombreProyecto"));
        this.tcDescripcionProyecto.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.tcNumEstudiantesSolicitados.setCellValueFactory(new PropertyValueFactory("personasRequeridas"));
        
        recuperarEstudiantes();
        recuperarProyectos();
        mostrarVentana();
    }    
    /**
     * Recupera los estudiantes de la base de datos en una ObservableList
     */
    private void recuperarEstudiantes() {
        EstudianteDAOImp estudianteDAO = new EstudianteDAOImp();
        listaEstudiantes = estudianteDAO.readAll();
    }
    /**
     * Recupera los proyectos de la base de datos en una ObservableList
     */
    private void recuperarProyectos() {
        ProyectoDAOImp proyectoDAO = new ProyectoDAOImp();
        listaProyectos = proyectoDAO.readAll();
    }
    /**
     * Muestra la informacion pertinene, proyectos, estudiantes y su preferencia de proyectos, en la ventana;
     */
    private void mostrarVentana() {
        tbEstudiantes.setItems(listaEstudiantes);
        tbProyectos.setItems(listaProyectos);
    }
}
