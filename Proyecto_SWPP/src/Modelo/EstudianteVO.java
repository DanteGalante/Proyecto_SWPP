/*
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */

package Modelo;

/**
 * Clave del programa: SWPP
 * Autor: olver
 * Fecha: 19/07/2020
 * Descripción: Clase que representa a la tabla Estudiante de la base de datos
 */
public class EstudianteVO {
    private String matricula;
    private String nombre;
    private String estatus;
    private String NRC;
    
    EstudianteVO(){}

    public EstudianteVO(String matricula, String nombre, String estatus, String NRC) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.estatus = estatus;
        this.NRC = NRC;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getNRC() {
        return NRC;
    }

    public void setNRC(String NRC) {
        this.NRC = NRC;
    }
    
}
