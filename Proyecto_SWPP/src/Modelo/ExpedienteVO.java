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
    /**
     * Matricula del estudiante vinculado al expediente
     */
    private String matriculaEstudianteVinculado;
    /**
     * Nombre del proyecto vinculado al expediente
     */
    private String nombreProyectoVinculado;
    /**
     * Periodo en el que se desarrolla el expediente
     */
    private String periodo;
    /**
     * Numero de archivos que contiene el expediente
     */
    private int numeroArchivos;
    /**
     * Numero de horas totales del estudiante en su proyecto
     */
    private int numHrsTotales;
    /**
     * Cedula profesional del profesor vinculado al expediente
     */
    private String cedulaDocenteVinculado;
    
    ExpedienteVO(){}
    /**
     * Constructor del objeto ExpedienteVO
     * @param matriculaEstudianteVinculado Matricula del estudiante vinculado al expediente
     * @param nombreProyectoVinculado Nombre del proyecto vinculado al expediente
     * @param periodo Periodo en el que se desarrolla el expediente
     * @param numeroArchivos Numero de archivos que contiene el expediente
     * @param numHrsTotales Numero de horas totales del estudiante en su proyecto
     * @param cedulaDocenteVinculado Cedula profesional del profesor vinculado al expediente
     */
    public ExpedienteVO(String matriculaEstudianteVinculado, String nombreProyectoVinculado, String periodo, int numeroArchivos, int numHrsTotales, String cedulaDocenteVinculado) {
        this.matriculaEstudianteVinculado = matriculaEstudianteVinculado;
        this.nombreProyectoVinculado = nombreProyectoVinculado;
        this.periodo = periodo;
        this.numeroArchivos = numeroArchivos;
        this.numHrsTotales = numHrsTotales;
        this.cedulaDocenteVinculado = cedulaDocenteVinculado;
    }
    /**
     * Recupera la matricula del estudiante vinculado al expediente
     * @return Matricula del estudiante vinculado al expediente
     */
    public String getMatriculaEstudianteVinculado() {
        return matriculaEstudianteVinculado;
    }
    /**
     * Establece la matricula del estudiante vinculado al expediente
     * @param matriculaEstudianteVinculado Matricula del estudiante vinculado al expediente
     */
    public void setMatriculaEstudianteVinculado(String matriculaEstudianteVinculado) {
        this.matriculaEstudianteVinculado = matriculaEstudianteVinculado;
    }
    /**
     * Recupera el nombre del proyecto vinculado al expediente
     * @return Nombre del proyecto vinculado al expediente
     */
    public String getNombreProyectoVinculado() {
        return nombreProyectoVinculado;
    }
    /**
     * Establece el nombre del proyecto vinculado al expediente
     * @param nombreProyectoVinculado Nombre del proyecto vinculado al expediente
     */
    public void setNombreProyectoVinculado(String nombreProyectoVinculado) {
        this.nombreProyectoVinculado = nombreProyectoVinculado;
    }
    /**
     * Recupera el periodo en el que se desarrolla el expediente
     * @return Periodo en el que se desarrolla el expediente
     */
    public String getPeriodo() {
        return periodo;
    }
    /**
     * Establece el periodo en el que se desarrolla el expediente
     * @param periodo El periodo en el que se desarrolla el expediente 
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    /**
     * Recupera el numero de archivos que contiene el expediente
     * @return Numero de archivos que contiene el expediente
     */
    public int getNumeroArchivos() {
        return numeroArchivos;
    }
    /**
     * Establece el numero de archivos que contiene el expediente
     * @param numeroArchivos Numero de archivos que contiene el expediente
     */
    public void setNumeroArchivos(int numeroArchivos) {
        this.numeroArchivos = numeroArchivos;
    }
    /**
     * Recupera el numero de horas totales del estudiante en su proyecto
     * @return Numero de horas totales del estudiante en su proyecto
     */
    public int getNumHrsTotales() {
        return numHrsTotales;
    }
    /**
     * Establece el numero de horas totales del estudiante en su proyecto
     * @param numHrsTotales Numero de horas totales del estudiante en su proyecto
     */
    public void setNumHrsTotales(int numHrsTotales) {
        this.numHrsTotales = numHrsTotales;
    }
    /**
     * Recupera el cedula profesional del profesor vinculado al expediente
     * @return Cedula profesional del profesor vinculado al expediente
     */
    public String getCedulaDocenteVinculado() {
        return cedulaDocenteVinculado;
    }
    /**
     * Establece la cedula profesional del profesor vinculado al expediente
     * @param cedulaDocenteVinculado Cedula profesional del profesor vinculado al expediente
     */
    public void setCedulaDocenteVinculado(String cedulaDocenteVinculado) {
        this.cedulaDocenteVinculado = cedulaDocenteVinculado;
    }

    @Override
    public String toString() {
        return "ExpedienteVO:\n" + "matriculaEstudianteVinculado = " + matriculaEstudianteVinculado 
                + "\nnombreProyectoVinculado = " + nombreProyectoVinculado 
                + "\nperiodo = " + periodo 
                + "\nnumeroArchivos = " + numeroArchivos 
                + "\nnumHrsTotales = " + numHrsTotales 
                + "\ncedulaDocenteVinculado = " + cedulaDocenteVinculado;
    }
}
