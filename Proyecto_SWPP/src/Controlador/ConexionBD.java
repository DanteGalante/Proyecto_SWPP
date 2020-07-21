/*
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clave del programa: SWPP <br>
 * Autor: olver <br>
 * Fecha: 07/20/2020 <br>
 * Descripción: Clase que sirve para conectar la base de datos con el sistema
 */
public class ConexionBD {
    
    public static String driver = "com.mysql.jdbc.Driver";
    public static String port = "3306";
    
    private Connection conn;
    private String host;
    private String db;
    private String username;
    private String password;
    
    public ConexionBD(String host, String db, String username, String password) {
        //oracle.jdbc.driver.OracleDriver
        String url = "jdbc:mysql://" + host + ":"+port+"/" + db + "?useTimezone=true&serverTimezone=UTC";
        this.host = host;
        this.db = db;
        this.username = username;
        this.password = password;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Connection conectar() {
        try {
            return getConn();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public PreparedStatement prepareStatement(String statement) throws SQLException{
        PreparedStatement s = getConn().prepareStatement(statement);
        return s;
    }
    
    public ResultSet query(PreparedStatement sQuery) throws SQLException { //PARA HACER CONSULTAS
        ResultSet rs = sQuery.executeQuery();
        return rs;
    }
    
    public void update(PreparedStatement sUpdate) throws SQLException { // MODIFICACIONES EN TABLAS 
        sUpdate.execute();
    }

    public void close(Statement s) {
        try {
            s.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
        }
    }

    public void close() {
        try {
            if(getConn()!=null){
                getConn().close();   
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
        }
    }
    
    /**
     * Recupera la conexion con la base de datos
     * @return La conexion a base de datos
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * Establece la conexion con la base de datos
     * @param conn La conexion con base de datos
     */
    public void setConn(Connection conn) {
        this.conn = conn;
    }

    /**
     * Recupera el host de la base de datos
     * @return Host de la base de datos
     */
    public String getHost() {
        return host;
    }

    /**
     * Establece el host de la base de datos
     * @param host Host de la base de datos
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Recupera el nombre de la base de datos
     * @return Nombre de la base de datos
     */
    public String getDb() {
        return db;
    }

    /**
     * Establece el nombre de la base de datos
     * @param db Nombre de la base de datos
     */
    public void setDb(String db) {
        this.db = db;
    }

    /**
     * Recupera el usuario de la base de datos
     * @return El usuario de la base de datos
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el usuario de la base de datos
     * @param username El usuario de la base de datos
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Recupera la contraseña de la conexion a la base de datos
     * @return La contraseña de la conexion a la base de datos
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña de la conexion a la base de datos
     * @param password La contraseña de la conexion a la base de datos
     */
    public void setPassword(String password) {
        this.password = password;
    }
}

