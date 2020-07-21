/*
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */

package Modelo;

/**
 * Clave del programa: <br>
 * Autor: olver <br>
 * Fecha: 21/07/2020<br>
 * Descripción: Clase que representa a la tabla PreferenciaProyecto de la base de datos
 */
public class PreferenciaProyectoVO {
    /**
     * Matricula del estudiante que eligio los proyectos
     */
    private String matriculaEstudianteVinculado;
    /**
     * Nombre del proyecto elegido
     */
    private String nombreProyectoVinculado;
    /**
     * Jerarquia de preferencia en proyectos elegidos por el estudiante vinculado
     */
    int posicion;
    
    public PreferenciaProyectoVO (){}
    /**
     * Constructor del objeto PreferenciaProyectoVO
     * @param matriculaEstudianteVinculado Matricula del estudiante que eligio los proyectos
     * @param nombreProyectoVinculado Nombre del proyecto elegido
     * @param posicion Jerarquia de preferencia en proyectos elegidos por el estudiante vinculado
     */
    public PreferenciaProyectoVO(String matriculaEstudianteVinculado, String nombreProyectoVinculado, int posicion) {
        this.matriculaEstudianteVinculado = matriculaEstudianteVinculado;
        this.nombreProyectoVinculado = nombreProyectoVinculado;
        this.posicion = posicion;
    }
    /**
     * Recupera la matricula del estudiante que eleigio los proyectos
     * @return matricula del estudiante que eligio los proyectos
     */
    public String getMatriculaEstudianteVinculado() {
        return matriculaEstudianteVinculado;
    }
    /**
     * Establece la matricula del estudiante que eligio los proyectos
     * @param matriculaEstudianteVinculado Matricula del estudiante que eligio los proyectos
     */
    public void setMatriculaEstudianteVinculado(String matriculaEstudianteVinculado) {
        this.matriculaEstudianteVinculado = matriculaEstudianteVinculado;
    }
    /**
     * Recupera el nombre del proyecto elegido
     * @return Nombre del proyecto elegido
     */
    public String getNombreProyectoVinculado() {
        return nombreProyectoVinculado;
    }
    /**
     * Establece el nombre del proyecto elegido
     * @param nombreProyectoVinculado nombre del proyecto elegido
     */
    public void setNombreProyectoVinculado(String nombreProyectoVinculado) {
        this.nombreProyectoVinculado = nombreProyectoVinculado;
    }
    /**
     * Recupera la jerarquia de preferencia en proyectos elegidos por el estudiante vinculado
     * @return Jerarquia de preferencia en proyectos elegidos por el estudiante vinculado
     */
    public int getPosicion() {
        return posicion;
    }
    /**
     * Establece la jerarquia de preferencia en proyectos elegidos por el estudiante vinculado
     * @param posicion Jerarquia de preferencia en proyectos elegidos por el estudiante vinculado 
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
