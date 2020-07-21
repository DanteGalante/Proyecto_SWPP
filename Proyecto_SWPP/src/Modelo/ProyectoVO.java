/*
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */

package Modelo;

/**
 * Clave del programa: SWPP <br>
 * Autor: olver <br>
 * Fecha: 07/09/2020 <br>
 * Descripción: Clase que representa a la tabla Proyecto de la base de datos 
 */
public class ProyectoVO {
    /**
     * Nombre del proyecto
     */
    private String nombreProyecto;
    /**
     * Descripcion breve del proyecto
     */
    private String descripcion;
    /**
     * Estatus actual del producto: <br>
     *     "En espera" <br>
     *     "En ejecucion" <br>
     *     "Concluido" <br>
     */
    private String estatus;
    /**
     * Nombre del lider del proyecto
     */
    private String nomLiderProyecto;
    /**
     * Numero de personas que requieren para el proyecto
     */
    private int personasRequeridas;
    /**
     * Mes del inicio de periodo actual
     */
    private String mesInicioPeriodo;
    /**
     * Año del inicio del periodo actual
     */
    private String anioInicioPeriodo;
    /**
     * Mes final del periodo actual
     */
    private String mesFinalPeriodo;
    /**
     * Año final del periodo actual
     */
    private String anioFinalPeriodo;
    /**
     * Nombre de la institucion vinculada a la que pertenece el proyecto
     */
    private String nombreInstitucionVinculada;
    
    public ProyectoVO(){}
    /**
     * Constructor del objeto ProyectoVO
     * @param nombreProyecto Nombre del proyecto
     * @param descripcion Descripcion breve del proyecto
     * @param estatus Estatus actual del producto
     * @param nomLiderProyecto Nombre del lider del proyecto
     * @param personasRequeridas Numero de personas que requieren para el proyecto
     * @param mesInicioPeriodo Mes del inicio de periodo actual
     * @param anioInicioPeriodo Año del inicio del periodo actual
     * @param mesFinalPeriodo Mes final del periodo actual
     * @param anioFinalPeriodo Año final del periodo actual
     * @param nombreInstitucionVinculada Nombre de la institucion vinculada a la que pertenece el proyecto
     */
    public ProyectoVO(String nombreProyecto, String descripcion, String estatus, String nomLiderProyecto, int personasRequeridas, String mesInicioPeriodo, String anioInicioPeriodo, String mesFinalPeriodo, String anioFinalPeriodo, String nombreInstitucionVinculada) {
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.estatus = estatus;
        this.nomLiderProyecto = nomLiderProyecto;
        this.personasRequeridas = personasRequeridas;
        this.mesInicioPeriodo = mesInicioPeriodo;
        this.anioInicioPeriodo = anioInicioPeriodo;
        this.mesFinalPeriodo = mesFinalPeriodo;
        this.anioFinalPeriodo = anioFinalPeriodo;
        this.nombreInstitucionVinculada = nombreInstitucionVinculada;
    }
    /**
     * Recupera el nombre del proyecto
     * @return Nombre del proyecto
     */
    public String getNombreProyecto() {
        return nombreProyecto;
    }
    /**
     * Establece el nombre del proyecto
     * @param nombreProyecto Nombre del proyecto
     */
    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }
    /**
     * Recupera la descripcion del proyecto
     * @return Descripcion breve del proyecto
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Establece la descripcion del proyecto
     * @param descripcion Descripcion breve del proyecto
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Recupera el estatus actual del proyecto
     * @return Estatus actual del producto
     */
    public String getEstatus() {
        return estatus;
    }
    /**
     * Establece el estatus del producto
     * @param estatus Estatus del producto
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    /**
     * Recupera el nombre del lider del proyecto
     * @return Nombre del lider del proyecto
     */
    public String getNomLiderProyecto() {
        return nomLiderProyecto;
    }
    /**
     * Establece el nombre del lider del proyecto
     * @param nomLiderProyecto Nombre del lider del proyecto
     */
    public void setNomLiderProyecto(String nomLiderProyecto) {
        this.nomLiderProyecto = nomLiderProyecto;
    }
    /**
     * Recupera el numero de personas que requieren para el proyecto
     * @return Numero de personas que requieren para el proyecto
     */
    public int getPersonasRequeridas() {
        return personasRequeridas;
    }
    /**
     * Establece el numero de personas que requieren para el proyecto
     * @param personasRequeridas Numero de personas que requieren para el proyecto
     */
    public void setPersonasRequeridas(int personasRequeridas) {
        this.personasRequeridas = personasRequeridas;
    }
    /**
     * Recupera el mes de inicio de periodo actual
     * @return Mes del inicio de periodo actual
     */
    public String getMesInicioPeriodo() {
        return mesInicioPeriodo;
    }
    /**
     * Establece el mes del inicio de periodo actual
     * @param mesInicioPeriodo Mes del inicio de periodo actual
     */
    public void setMesInicioPeriodo(String mesInicioPeriodo) {
        this.mesInicioPeriodo = mesInicioPeriodo;
    }
    /**
     * Recupera el año de inicio de periodo actual
     * @return Año del inicio de periodo actual
     */
    public String getAnioInicioPeriodo() {
        return anioInicioPeriodo;
    }
    /**
     * Establece el año de inicio del periodo actual
     * @param anioInicioPeriodo Año del inicio de periodo actual
     */ 
    public void setAnioInicioPeriodo(String anioInicioPeriodo) {
        this.anioInicioPeriodo = anioInicioPeriodo;
    }
    /**
     * Recupera el mes final del periodo actual
     * @return Mes final del periodo actual
     */
    public String getMesFinalPeriodo() {
        return mesFinalPeriodo;
    }
    /**
     * Establece el mes final del periodo actual
     * @param mesFinalPeriodo Mes final del periodo actual
     */
    public void setMesFinalPeriodo(String mesFinalPeriodo) {
        this.mesFinalPeriodo = mesFinalPeriodo;
    }
    /**
     * Recupera el año final del periodo actual
     * @return Año final del periodo actual
     */
    public String getAnioFinalPeriodo() {
        return anioFinalPeriodo;
    }
    /**
     * Establece el mes final del periodo actual
     * @param anioFinalPeriodo Año final del periodo actual
     */
    public void setAnioFinalPeriodo(String anioFinalPeriodo) {
        this.anioFinalPeriodo = anioFinalPeriodo;
    }
    /**
     * Recupera el nombre de la institucion vinculada a la que pertenece el proyecto
     * @return Nombre de la institucion vinculada a la que pertenece el proyecto
     */
    public String getNombreInstitucionVinculada() {
        return nombreInstitucionVinculada;
    }
    /**
     * Establece el nombre de la institucion vinculada a la que pertenece el proyecto
     * @param nombreInstitucionVinculada Nombre de la institucion vinculada a la que pertenece el proyecto
     */
    public void setNombreInstitucionVinculada(String nombreInstitucionVinculada) {
        this.nombreInstitucionVinculada = nombreInstitucionVinculada;
    }
}
