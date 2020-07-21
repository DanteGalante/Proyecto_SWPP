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
    /**
     * Matricula del estudiante
     */
    private String matricula;
    /**
     * Nombre del estudiante
     */
    private String nombre;
    /**
     * Estatus del estudiante: <br>
     * "Evaluado" <br>
     * "Aprobado" <br>
     * "Por aprobar" <br>
     * "Por inscribir"
     */
    private String estatus;
    /**
     * NRC del grupo en el que esta el estudiante
     */
    private String NRC;
    
    EstudianteVO(){}
    /**
     * Constructor del objeto EstudianteVO
     * @param matricula Matricula del estudiante
     * @param nombre Nombre del estudiante
     * @param estatus Estatus actual del estudiante
     * @param NRC NRC del grupo en el que esta el estudiante
     */
    public EstudianteVO(String matricula, String nombre, String estatus, String NRC) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.estatus = estatus;
        this.NRC = NRC;
    }
    /**
     * Recupera la matricula del estudiante
     * @return Matricula del estudiante
     */
    public String getMatricula() {
        return matricula;
    }
    /**
     * Establece la matricula del estudiante
     * @param matricula Matricula del estudiante
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    /**
     * Recupera el nombre del estudiante
     * @return Nombre del estudiante
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre del estudiante
     * @param nombre Nombre del estudiante
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Recupera el estatus actual del estudiante
     * @return Estatus actual del estudiante
     */
    public String getEstatus() {
        return estatus;
    }
    /**
     * Establece el estatus del estudiante
     * @param estatus Estatus del estudiante
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    /**
     * Recupera el NRC del grupo en el que esta el estudiante
     * @return NRC del grupo en el que esta el estudiante
     */
    public String getNRC() {
        return NRC;
    }
    /**
     * Establece el NRC del grupo en el que esta el estudiante
     * @param NRC NRC del grupo en el que esta el estudiante
     */
    public void setNRC(String NRC) {
        this.NRC = NRC;
    }
    
}
