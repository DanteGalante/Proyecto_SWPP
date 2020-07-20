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
 * Descripción:Clase que representa a la tabla Expediente de la base de datos 
 */
public class ExpedienteVO {
    private String periodo;
    private int numeroArchivos;
    private int numHrsTotales;
    
    ExpedienteVO(){}

    public ExpedienteVO(String periodo, int numeroArchivos, int numHrsTotales) {
        this.periodo = periodo;
        this.numeroArchivos = numeroArchivos;
        this.numHrsTotales = numHrsTotales;
    }
    
    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getNumeroArchivos() {
        return numeroArchivos;
    }

    public void setNumeroArchivos(int numeroArchivos) {
        this.numeroArchivos = numeroArchivos;
    }

    public int getNumHrsTotales() {
        return numHrsTotales;
    }

    public void setNumHrsTotales(int numHrsTotales) {
        this.numHrsTotales = numHrsTotales;
    }
    
}
