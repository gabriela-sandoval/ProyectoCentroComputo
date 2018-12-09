/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class AccesoDataBase {
    static final String JDBC_DRIVER = "com.mwsql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://";
    private static Connection conexion;
    
    private static Connection conectar(){
        String usuario = CredencialesDB.usuario;
        String pass = CredencialesDB.password;
        String db = CredencialesDB.baseDatos;
        String host = CredencialesDB.host;
        
        Connection res = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = DB_URL + host + "/" + db;
            res = DriverManager.getConnection(url,usuario,pass);
        }catch (SQLException exSql){
            exSql.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            res.setAutoCommit(false);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return res;
    }
    
    public static Connection obtenerConexionBaseDatos(){
        return conectar();
    }
    
    public static void cerrarConexion() {
        if(conexion!= null) {
         try{   
             conexion.close();
         
         }  catch (SQLException ex) {
                Logger.getLogger(AccesoDataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
