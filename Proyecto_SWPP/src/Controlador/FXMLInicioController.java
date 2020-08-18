/*
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */
package Controlador;

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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Clave del programa: SWPP<br>
 * Autor: olver <br>
 * Fecha: 20/07/2020 <br>
 * Descripción: Controlador de la pantalla "Inicio"
 */
public class FXMLInicioController implements Initializable {
    @FXML
    private Label lbTitulo;
    /**
     * Acciones que se realizan en el programa a la hora de inicializar la ventana actual
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    /**
     * Gestiona las acciones que se realizan al hacer clic en Asociar proyecto con estudiante
     * @param e Evento recibido
     */
    @FXML
    public void clicAsociarProyectoEstudiante(ActionEvent e){
        irVentanaAsociarProyectoEstudiante();
    }
    /**
     * Inicializa la ventana asociar proyecto con estudiante
     */
    public void irVentanaAsociarProyectoEstudiante(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/FXMLAsociarProyectoEstudiante.fxml"));
            Parent root = (Parent) loader.load();
            
            FXMLAsociarProyectoEstudianteController siguienteControlador = loader.getController();
            
            //Unicamente si se obtiene una lista de estudiantes se abre la siguiente ventana
            if(siguienteControlador.getListaEstudiantes().size() > 0){
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Asociar proyecto a estudiante");
                stage.show();
            }else{
                Alert mensajeEmergente = new Alert(Alert.AlertType.INFORMATION);
                mensajeEmergente.setTitle("");
                mensajeEmergente.setHeaderText(null);
                mensajeEmergente.setContentText("No hay suficientes estudiantes para asociar");
                mensajeEmergente.show();
            }
        } catch (IOException ex) {
            Logger.getLogger(FXMLInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    /**
     * Oculta la ventana actual
     */
    public void ocultarVentanaActual(){
        Stage stageActual = (Stage)lbTitulo.getScene().getWindow();
        stageActual.hide(); 
    }
}
