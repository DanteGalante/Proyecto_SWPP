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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void clicAsociarProyectoEstudiante(ActionEvent e){
        irVentanaAsociarProyectoEstudiante();
    }
    
    public void irVentanaAsociarProyectoEstudiante(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/FXMLAsociarProyectoEstudiante.fxml"));
            Parent root = (Parent) loader.load();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Asociar proyecto a estudiante");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void ocultarVentanaActual(){
        Stage stageActual = (Stage)lbTitulo.getScene().getWindow();
        stageActual.hide(); 
    }
}
