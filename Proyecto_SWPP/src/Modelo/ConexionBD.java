/*
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */
package Modelo;

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
    /**
     * Controlador que permite conectarse con MySQL
     */
    public static String driver = "com.mysql.jdbc.Driver";
    /**
     * Puerto por que se transmite la información
     */
    public static String port = "3306";
    
    /**
     * Objeto que representa una conexion entre una base de datos especifica y el sistema
     * @see java.sql.Connection
     */
    private Connection conn;
    /**
     * Ubicacion de la base de datos
     */
    private static String host = "localhost";
    /**
     * Nombre de la base de datos
     */
    private static String db = "bd_swpp";
    /**
     * Usuario que usara la base de datos
     */
    private static String username = "root";
    /**
     * Contraseña del usuario
     */
    private static String password = "JLDI02092102";
    /**
     * Constructor de la clase ConexionBD, donde se establece la conexion con la base de datos
     * @param host Ubicacion de la base de datos
     * @param db Nombre de la base de datos
     * @param username Usuario que usara la base de datos
     * @param password Contraseña del usuario
     */
    public ConexionBD(){
        String url = "jdbc:mysql://" + host + ":"+port+"/" + db + "?useTimezone=true&serverTimezone=UTC";

        try{
            conn = DriverManager.getConnection(url, username, password);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * Retorna la conexion a la base de datos que proporciona el driver
     * @return Objeto que representa una conexion entre una base de datos especifica y el sistema
     */
    public Connection conectar(){
        try {
            return getConn();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    /**
     * Crea una clase que representa una declaracion de SQL precompilada
     * @param statement cadena de texto que representa una declaracion de SQL
     * @return Una clase que representa una declaracion de SQL precompilada
     * @throws SQLException 
     */
    public PreparedStatement prepareStatement(String statement) throws SQLException{
        PreparedStatement s = getConn().prepareStatement(statement);
        return s;
    }
    /**
     * Recibe una declaracion de consulta precompilada de SQL y es ejecutada en la base de datos
     * @param sQuery declaracion de consulta precompilada de SQL
     * @return Objeto que contiene la informacion de la consulta ejecutada
     * @throws SQLException 
     */
    public ResultSet preparedStatementQuery(PreparedStatement sQuery) throws SQLException { //PARA HACER CONSULTAS
        ResultSet rs = sQuery.executeQuery();
        return rs;
    }
    /**
     * Recibe una declaracion de modificacion precompilada de SQL y es ejecutada en la base de datos
     * @param sUpdate declaracion de modificacion precompilada de SQL
     * @throws SQLException
     */
    public void preparedStatementUpdate(PreparedStatement sUpdate) throws SQLException { // MODIFICACIONES EN TABLAS 
        sUpdate.execute();
    }
    /**
     * Libera los recursos ocupados para una declaracion de SQL precompilada
     * @param s declaracion de SQL precompilada
     */
    public void close(PreparedStatement s) {
        try {
            s.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
        }
    }
    /**
     * Libera los recursos ocupados para la conexion a la base de datos
     */
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
    public Connection getConn(){
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

