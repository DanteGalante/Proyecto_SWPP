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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Implementación de la clase DocenteDAO, la cual da acceso a la información de los docentes contenidos en la base de datos<br><br>
 * 
 * Implementa los metodos de la interfaz DocenteDAO con ayuda de clases pertenecientes a el paquete java.sql
 * y la clase ConexionBD
 * @see java.sql.PreparedStatement
 * @see java.sql.ResultSet
 * @see java.sql.SQLException
 * @see Modelo.ConexionBD
 */
public class DocenteDAOImp implements DocenteDAO{
    @Override
    public boolean create(DocenteVO docente) throws Exception{
        ConexionBD conexBD = new ConexionBD();
        boolean resultado = false;
        try{
            String insertar = "INSERT INTO Docente VALUES (?,?,?)";
            try(PreparedStatement pst = conexBD.prepareStatement(insertar)){
                pst.setString(1, docente.getCedulaProfesional());
                pst.setString(2, docente.getNombre());
                pst.setString(3, docente.getGrupoNRC());
                
                conexBD.preparedStatementUpdate(pst);
            }           
            resultado = true;
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return resultado;
    }

    @Override
    public ObservableList<DocenteVO> readAll() throws Exception{
        ConexionBD conexBD = new ConexionBD();
        ObservableList<DocenteVO> listaDocentes = null;
        try{
            listaDocentes = FXCollections.observableArrayList();
            String consulta = "SELECT * FROM Docente";
            try(PreparedStatement pst = conexBD.prepareStatement(consulta)){
                try(ResultSet rs = conexBD.preparedStatementQuery(pst)){
                    while(rs.next()){
                       listaDocentes.add(
                            new DocenteVO(
                                rs.getString("cedulaProfesional"),
                                rs.getString("nombre"),
                                rs.getString("grupoNRC")
                            )
                        );
                    }   
                }
            }
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return listaDocentes;
    }

    @Override
    public DocenteVO read(String cedulaProf) throws Exception{
        ConexionBD conexBD = new ConexionBD();
        DocenteVO docente = null;
        try{
            String consulta = "SELECT * FROM Docente WHERE cedulaProfesional = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(consulta)){
                pst.setString(1, cedulaProf);
                try(ResultSet rs = conexBD.preparedStatementQuery(pst)){
                    if(rs.next()){
                        docente = new DocenteVO(
                            rs.getString("cedulaProfesional"),
                            rs.getString("nombre"),
                            rs.getString("grupoNRC")
                        );
                    }
                }
            }
            return docente;
        }catch (SQLException ex) {
            throw ex;
        }finally{
            conexBD.close();
        }
    }
    
    @Override
    public DocenteVO readPorGrupo(String NRC) throws Exception {
        ConexionBD conexBD = new ConexionBD();
        DocenteVO docente = null;
        try{
            String consulta = "SELECT * FROM Docente WHERE GrupoNRC = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(consulta)){
                pst.setString(1, NRC);
                try(ResultSet rs = conexBD.preparedStatementQuery(pst)){
                    docente = null;
                    if(rs.next()){
                        docente = new DocenteVO(
                            rs.getString("cedulaProfesional"),
                            rs.getString("nombre"),
                            rs.getString("grupoNRC")
                        );
                    }
                }   
            }
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return docente;
    }

    @Override
    public boolean update(String cedulaProf, DocenteVO docente) throws Exception{
        ConexionBD conexBD = new ConexionBD();
        boolean resultado = false;
        try{
            String actualizacion = "UPDATE Docente SET "
                    + "cedulaProfesional = ?,"
                    + "nombre = ?,"
                    + "grupoNRC = ?,"
                    + "WHERE cedulaProfesional = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(actualizacion)){
                pst.setString(1, docente.getCedulaProfesional());
                pst.setString(2, docente.getNombre());
                pst.setString(3, docente.getGrupoNRC());
                pst.setString(4, cedulaProf);
                
                conexBD.preparedStatementUpdate(pst);
            }
            resultado = true;
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return resultado;
    }

    @Override
    public boolean delete(DocenteVO docente) throws Exception{
        ConexionBD conexBD = new ConexionBD();
        boolean resultado = false;
        try{
            String borrar = "DELETE FROM Docente WHERE cedulaProfesional = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(borrar)){
                pst.setString(1, docente.getCedulaProfesional());
                
                conexBD.preparedStatementUpdate(pst);
            }
            resultado = true;
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return resultado;
    }

    @Override
    public boolean delete(String cedulaProf) throws Exception{
        ConexionBD conexBD = new ConexionBD();
        boolean resultado = false;
        try{
            String borrar = "DELETE FROM Docente WHERE cedulaProfesional = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(borrar)){
                pst.setString(1, cedulaProf);
                
                conexBD.preparedStatementUpdate(pst);
            }
            resultado = true;
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return resultado;
    }
}
