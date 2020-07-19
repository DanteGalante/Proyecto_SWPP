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
 * Fecha: 07/09/2020
 * Descripción: Clase que representa a la tabla Proyecto de la base de datos 
 */
public class ProyectoVO {
    private String nombreProyecto;
    private String descripcion;
    private String estatus;
    private String nomLiderProyecto;
    private int personasRequeridas;
    private String mesInicioPeriodo;
    private String anioInicioPeriodo;
    private String mesFinalPeriodo;
    private String anioFinalPeriodo;
    
    public ProyectoVO(){}

    public ProyectoVO(String nombreProyecto, String descripcion, String estatus, String nomLiderProyecto, int personasRequeridas, String mesInicioPeriodo, String anioInicioPeriodo, String mesFinalPeriodo, String anioFinalPeriodo) {
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.estatus = estatus;
        this.nomLiderProyecto = nomLiderProyecto;
        this.personasRequeridas = personasRequeridas;
        this.mesInicioPeriodo = mesInicioPeriodo;
        this.anioInicioPeriodo = anioInicioPeriodo;
        this.mesFinalPeriodo = mesFinalPeriodo;
        this.anioFinalPeriodo = anioFinalPeriodo;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getNomLiderProyecto() {
        return nomLiderProyecto;
    }

    public void setNomLiderProyecto(String nomLiderProyecto) {
        this.nomLiderProyecto = nomLiderProyecto;
    }

    public int getPersonasRequeridas() {
        return personasRequeridas;
    }

    public void setPersonasRequeridas(int personasRequeridas) {
        this.personasRequeridas = personasRequeridas;
    }

    public String getMesInicioPeriodo() {
        return mesInicioPeriodo;
    }

    public void setMesInicioPeriodo(String mesInicioPeriodo) {
        this.mesInicioPeriodo = mesInicioPeriodo;
    }

    public String getAnioInicioPeriodo() {
        return anioInicioPeriodo;
    }

    public void setAnioInicioPeriodo(String anioInicioPeriodo) {
        this.anioInicioPeriodo = anioInicioPeriodo;
    }

    public String getMesFinalPeriodo() {
        return mesFinalPeriodo;
    }

    public void setMesFinalPeriodo(String mesFinalPeriodo) {
        this.mesFinalPeriodo = mesFinalPeriodo;
    }

    public String getAnioFinalPeriodo() {
        return anioFinalPeriodo;
    }

    public void setAnioFinalPeriodo(String anioFinalPeriodo) {
        this.anioFinalPeriodo = anioFinalPeriodo;
    }
    
}
