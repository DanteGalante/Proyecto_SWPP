/*
Clave del programa: SWPP
Autor: olver
Fecha: 22/07/2020
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */

package Modelo;

/**
 * Clase que representa a la tabla Docente de la base de datos
 */
public class DocenteVO {
    /**
     * Cedula profesional del docente
     */
    private String cedulaProfesional;
    /**
     * Nombre del docente
     */
    private String nombre;
    /**
     * NRC del grupo al que pertenece el docente
     */
    private String grupoNRC;

    /**
     * Constructor del objeto DocenteVO
     * @param cedulaProfesional Cedula profesional del docente
     * @param nombre Nombre del docente
     * @param grupoNRC NRC del grupo al que pertenece el docente
     */
    public DocenteVO(String cedulaProfesional, String nombre, String grupoNRC) {
        this.cedulaProfesional = cedulaProfesional;
        this.nombre = nombre;
        this.grupoNRC = grupoNRC;
    }
    /**
     * Recupera la cedula profesional del docente
     * @return Cedula profesional del docente
     */
    public String getCedulaProfesional() {
        return cedulaProfesional;
    }
    /**
     * Establece la cedula profesional del docente
     * @param cedulaProfesional Cedula profesional del docente
     */
    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }
    /**
     * Recupera el nombre del docente
     * @return Nombre del docente
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre del docente
     * @param nombre Nombre del docente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Recupera el NRC del grupo al que pertenece el docente
     * @return NRC del grupo al que pertenece el docente
     */
    public String getGrupoNRC() {
        return grupoNRC;
    }
    /**
     * Establece el NRC del grupo al que pertenece el docente
     * @param grupoNRC NRC del grupo al que pertenece el docente
     */
    public void setGrupoNRC(String grupoNRC) {
        this.grupoNRC = grupoNRC;
    }
}
