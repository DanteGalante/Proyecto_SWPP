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
 * Descripción: Clase que representa a la tabla ReporteEstudiante de la base de datos<br>
 **/
public class ReporteEstudianteVO {
    /**
     * ID del reporte que el estudiante entrego
     */
    private int idReporteEstudiante;
    /**
     * Horas reportadas en el tipo de reporte del estudiante
     */
    private int horasReportadas;
    /**
     * Tipo de reporte del estudiante
     */
    private String tipoDeReporte;
    /**
     * Matricula del estudiante
     */
    private String Expediente_Estudiante_matricula;
    /**
     * Nombre del proyecto en el cual trabaj el estudiante
     */
    private String Expediente_Proyecto_nombreProyecto;
    
    public ReporteEstudianteVO (){}
    /**
     * Constructor del objeto ProyectoVO
     * @param idReporteEstudiante ID del reporte que el estudiante entrego
     * @param horasReportadas Horas reportadas en el tipo de reporte del estudiante
     * @param tipoDeReporte Tipo de reporte del estudiante
     * @param Expediente_Estudiante_matricula
     * @param Expediente_Proyecto_nombreProyecto
     * 
     */
    public ReporteEstudianteVO(int idReporteEstudiante, int horasReportadas, String tipoDeReporte, String Expediente_Estudiante_matricula, String Expediente_Proyecto_nombreProyecto) {
        this.idReporteEstudiante = idReporteEstudiante;
        this.horasReportadas = horasReportadas;
        this.tipoDeReporte = tipoDeReporte;
        this.Expediente_Estudiante_matricula = Expediente_Estudiante_matricula;
        this.Expediente_Proyecto_nombreProyecto = Expediente_Proyecto_nombreProyecto;
    }
    /**
     * Recupera el ID del reporte del estudiante
     * @return ID del reporte que el estudiante entrego
     */
    public int getIdReporteEstudiante() {
        return idReporteEstudiante;
    }
    /**
     * Establece el ID del reporte del estudiante
     * @param idReporteEstudiante del reporte entregado por el estudiante 
     */
    public void setIdReporteEstudiante(int idReporteEstudiante) {
        this.idReporteEstudiante = idReporteEstudiante;
    }
    /**
     * Recupera las horas reportadas por el estudiante
     * @return Numero de horas que reporta el estudiante
     */
    public int getHorasReportadas() {
        return horasReportadas;
    }
    /**
     * Establece el numero de horas reportadas por un estudiante
     * @param horasReportadas Horas reportadas por un estudiante
     */
    public void setHorasReportadas(int horasReportadas) {
        this.horasReportadas = horasReportadas;
    }
    /**
     * Recupera el tipo de reporte que ha entregado un estudiante
     * @return tipo de reporte de un estudiante
     */
    public String getTipoDeReporte() {
        return tipoDeReporte;
    }
    /**
     * Establece el tipo de reporte que entrega un estudiante
     * @param tipoDeReporte tipo de reporte que entrega un estudiante
     */
    public void setTipoDeReporte(String tipoDeReporte) {
        this.tipoDeReporte = tipoDeReporte;
    }
    /**
     * Recupera la matricula del estudiante con el expediente asociado
     * @return Matricula del estudiante
     */
    public String getExpediente_Estudiante_matricula() {
        return Expediente_Estudiante_matricula;
    }
    /**
     * Establece la matricula asociada con el expediente del estudiante
     * @param Expediente_Estudiante_matricula matricula del estudiante
     */
    public void setExpediente_Estudiante_matricula(String Expediente_Estudiante_matricula) {
        this.Expediente_Estudiante_matricula = Expediente_Estudiante_matricula;
    }
/**
     * Recupera el nombre del proyecto en el cual trabaja el estudiante
     * @return Nombre del proyecto
     */
    public String getExpediente_Proyecto_nombreProyecto() {
        return Expediente_Proyecto_nombreProyecto;
    }
    /**
     * Establece el nombre del proyecto en el cual trabaj el estudiante
     * @param Expediente_Proyecto_nombreProyecto matricula del estudiante
     */
    public void setExpediente_Proyecto_nombreProyecto(String Expediente_Proyecto_nombreProyecto) {
        this.Expediente_Proyecto_nombreProyecto = Expediente_Proyecto_nombreProyecto;
    }
    
    @Override
    public String toString() {
        return "ProyectoVO:\n" + "idReporteEstudiante = " + idReporteEstudiante  
                + "\nhorasReportadas = " + horasReportadas 
                + "\ntipoDeReporte = " + tipoDeReporte
                + "\nExpediente_Estudiante_matricula = " + Expediente_Estudiante_matricula
                + "\nExpediente_Proyecto_nombreProyecto = " + Expediente_Proyecto_nombreProyecto;
    } 
}
