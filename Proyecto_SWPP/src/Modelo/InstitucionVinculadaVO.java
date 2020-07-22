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
 * Fecha: 22/07/2020 <br>
 * Descripción: Clase que representa a la tabla InstitucionVinculada de la base de datos
 */
public class InstitucionVinculadaVO {
    private String nombre;
    private String direccion;
    private String sector;
    private String correoElectronico;

    public InstitucionVinculadaVO() {
    }

    public InstitucionVinculadaVO(String nombre, String direccion, String sector, String correoElectronico) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.sector = sector;
        this.correoElectronico = correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public String toString() {
        return "InstitucionVinculadaVO:\n" + "nombre = " + nombre 
                + "\ndireccion = " + direccion 
                + "\nsector = " + sector 
                + "\ncorreoElectronico = " + correoElectronico;
    }
    
}
