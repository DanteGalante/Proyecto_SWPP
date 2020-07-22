/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * Clave del programa: SWPP<br>
 * Autor: olver <br>
 * Fecha: 20/07/2020 <br>
 * Descripción: Controlador de la pantalla "Inicio"
 */
public class FXMLInicioController implements Initializable {
    @FXML
    private Label lbTitulo;
    @FXML
    private AnchorPane anPrincipal;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void clicAsociarProyectoEstudiante(ActionEvent e){
        irVentanaAsociarProyectoEstudiante();
    }
    
    public void irVentanaAsociarProyectoEstudiante(){
        
    }
}
