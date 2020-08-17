/*
------------------------
Alan Adair Morgado Morales
UNIVERSIDAD VERACRUZANA
------------------------
 */

package Modelo;

/**
 * Clave del programa: SWPP<br>
 * Autor: Morgado <br>
 * Fecha: 10/08/2020 <br>
 * Actualizacion: 17/08/2020
 * Descripción: Clase que representa a la tabla DocumentoRequerido de la base de datos<br>
 **/
public class DocumentoRequeridoVO {
    /**
     * ID del documento requerido que el estudiante entrego
     */
    private int idDocumentoRequerido;
    /**
     * Titulo del documento entregado por el estudiante
     */
    private String titulo;
    /**
     * Descripcion del documento requerido entregado por el estudiante
     */
    private String descripcion;
    /**
     * Matricula del estudiante
     */
    private String expediente_Estudiante_Matricula;
    /**
     * Nombre del proyecto asignado al estudiante
     */
    private String expediente_Proyecto_NombreProyecto;
      
    public DocumentoRequeridoVO () {}
    /**
     * Constructor del objeto DocumentoRequeridoVO
     * @param idDocumentoRequerido ID del documento que el estudiante entrego
     * @param titulo Titulo del documento entregado por el estudiante
     * @param descripcion Descripcion del documento requerido entregado por el estudiante
     * @param expediente_Estudiante_Matricula Matricula del estudiante
     * @param expediente_Proyecto_NombreProyecto Nombre del proyecto asignado al estudiante
     */
    public DocumentoRequeridoVO(int idDocumentoRequerido, String titulo, String descripcion, String expediente_Estudiante_Matricula, String expediente_Proyecto_NombreProyecto) {
        this.idDocumentoRequerido = idDocumentoRequerido;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.expediente_Estudiante_Matricula = expediente_Estudiante_Matricula;
        this.expediente_Proyecto_NombreProyecto = expediente_Proyecto_NombreProyecto;
    }
    /**
     * Recupera el ID del documento que el estudiante entrego
     * @return IDDocumentoRequerido del documento entregado por el estudiante
     */
    public int getIdDocumentoRequerido() {
        return idDocumentoRequerido;
    }
    /**
     * Establece el ID del documento que el estudiante entrego
     * @param idDocumentoRequerido del documento entregado por el estudiante
     */
    public void setIdDocumentoRequerido(int idDocumentoRequerido) {
        this.idDocumentoRequerido = idDocumentoRequerido;
    }
    /**
     * Recupera el titulo del documento que el estudiante entrego
     * @return Titulo del documento entregado por el estudiante
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * Establece el titulo del documento que el estudiante entrego
     * @param titulo del documento entregado por el estudiante
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Recupera la descripcion del documento que el estudiante entrego
     * @return Descripcion del documento entregado por el estudiante
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Establece la descripcion del documento que el estudiante entrego
     * @param descripcion del documento entregado por el estudiante
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Recupera la matricula del estudiante que entrego el documento
     * @return Matricula del estuiante que entrego el documento
     */
    public String getExpediente_Estudiante_Matricula() {
        return expediente_Estudiante_Matricula;
    }
    /**
     * Establece la matricula del documento del estudiante que entrego el documento
     * @param expediente_Estudiante_Matricula del estudiante que entrego el documento
     */
    public void setExpediente_Estudiante_Matricula(String expediente_Estudiante_Matricula) {
        this.expediente_Estudiante_Matricula = expediente_Estudiante_Matricula;
    }
    /**
     * Recupera nombre del proyecto en el cual esta trabajando el estudiante actualmente
     * @return Nombre del proyecto en el cual esta trabajando el estudiante actualmente
     */
    public String getExpediente_NombreProyecto() {
        return expediente_Proyecto_NombreProyecto;
    }
    /**
     * Establece el nombre del proyecto en el cual trabaja un estudiante
     * @param expediente_Proyecto_NombreProyecto del estudiante
     */
    public void setExpediente_NombreProyecto(String expediente_Proyecto_NombreProyecto) {
        this.expediente_Proyecto_NombreProyecto = expediente_Proyecto_NombreProyecto;
    }
    
    @Override
    public String toString() {
        return "DocumentoRequeridoVO:\n" + "idDocumentoRequerido = " + idDocumentoRequerido 
                + "\ntitulo = " + titulo 
                + "\ndescripcion = " + descripcion
                + "\nexpediente_Estudiante_Matricula" + expediente_Estudiante_Matricula
                + "\nexpediente_Proyecto_NombreProyecto" + expediente_Proyecto_NombreProyecto;
    }
}
 