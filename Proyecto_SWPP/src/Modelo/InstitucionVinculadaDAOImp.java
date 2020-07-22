/*
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */

package Modelo;

import Controlador.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clave del programa: <br>
 * Autor: olver <br>
 * Fecha: 22/07/2020 <br>
 * Descripción: Implementación de la clase InstitucionVinculadoDAO, la cual da acceso a la información de las instituciones vinculadas contenidos en la base de datos<br>
 */
public class InstitucionVinculadaDAOImp implements InstitucionVinculadaDAO{

    @Override
    public boolean create(InstitucionVinculadaVO institucionVinculada) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try{
            String insertar = "INSERT INTO InstitucionVinculada VALUES (?,?,?,?)";
            PreparedStatement pst = conexBD.prepareStatement(insertar);
            
            pst.setString(1, institucionVinculada.getNombre());
            pst.setString(2, institucionVinculada.getDireccion());
            pst.setString(3, institucionVinculada.getSector());
            pst.setString(4, institucionVinculada.getCorreoElectronico());
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        }catch(SQLException ex){
            Logger.getLogger(InstitucionVinculadaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }
    }

    @Override
    public List<InstitucionVinculadaVO> readAll() {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            List<InstitucionVinculadaVO> listaInstituciones = new ArrayList<InstitucionVinculadaVO>();
            String consulta = "SELECT * FROM InstitucionVinculada";
            PreparedStatement pst = conexBD.prepareStatement(consulta);
            ResultSet rs = conexBD.preparedStatementQuery(pst);
            
            while(rs.next()){
                listaInstituciones.add(
                    new InstitucionVinculadaVO(
                        rs.getString("nombre"),
                        rs.getString("direccion"),
                        rs.getString("sector"),
                        rs.getString("correoElectronico")
                    )
                );
            }
            
            pst.close();
            rs.close();
            conexBD.close();
            return listaInstituciones;
        } catch (SQLException ex) {
            Logger.getLogger(InstitucionVinculadaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return null;
        }
    }

    @Override
    public InstitucionVinculadaVO read(String nombreInstitucion) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String consulta = "SELECT * FROM InstitucionVinculada WHERE nombre = ?";
            PreparedStatement pst = conexBD.prepareStatement(consulta);
            
            pst.setString(1, nombreInstitucion);
            
            ResultSet rs = conexBD.preparedStatementQuery(pst);
            
            InstitucionVinculadaVO institucion = null;
            if(rs.next()){
                institucion = new InstitucionVinculadaVO(
                rs.getString("nombre"),
                rs.getString("direccion"),
                rs.getString("sector"),
                rs.getString("correoElectronico")
                );
            }
            
            pst.close();
            rs.close();
            conexBD.close();
            return institucion;
        } catch (SQLException ex) {
            Logger.getLogger(InstitucionVinculadaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return null;
        }
    }

    @Override
    public boolean update(String nombreInstitucion, InstitucionVinculadaVO institucionVinculada) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String actualizacion = "UPDATE InstitucionVinculada SET "
                    + "nombre = ?,"
                    + "direccion = ?,"
                    + "sector = ?,"
                    + "correoElectronico = ?"
                    + "WHERE nombre = ? ";
            PreparedStatement pst = conexBD.prepareStatement(actualizacion);
            
            pst.setString(1, institucionVinculada.getNombre());
            pst.setString(2, institucionVinculada.getDireccion());
            pst.setString(3, institucionVinculada.getSector());
            pst.setString(4, institucionVinculada.getCorreoElectronico());
            pst.setString(5, nombreInstitucion);
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(InstitucionVinculadaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }
    }

    @Override
    public boolean delete(InstitucionVinculadaVO institucionVinculada) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String borrar = "DELETE FROM InstitucionVinculada WHERE nombre = ?";
            PreparedStatement pst = conexBD.prepareStatement(borrar);
            
            pst.setString(1, institucionVinculada.getNombre());
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(InstitucionVinculadaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }  
    }

    @Override
    public boolean delete(String nombreInstitucion) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String borrar = "DELETE FROM InstitucionVinculada WHERE nombre = ?";
            PreparedStatement pst = conexBD.prepareStatement(borrar);
            
            pst.setString(1, nombreInstitucion);
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(InstitucionVinculadaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }  
    }

}
