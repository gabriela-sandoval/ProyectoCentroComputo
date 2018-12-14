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
    static final String DB_URL = "jdbc:mysql://localhost";
    private static Connection conexion;
    
    private static void conectar(){
        try {
            
            String url= "jdbc:mysql://localhost/";
            String databaseName = "centrocomputo";
            String userName = "root";
            String password = "ruletarusa98";
       
            conexion = (Connection)DriverManager.getConnection(url+databaseName,userName,password);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AccesoDataBase.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static Connection obtenerConexionBaseDatos(){
        conectar();
        return AccesoDataBase.conexion;
    }
    
    public static void cerrarConexion() {
        if(conexion!= null) {
         try{   
             if(!conexion.isClosed()){
                 conexion.close();
             }       
         }  catch (SQLException ex) {
                Logger.getLogger(AccesoDataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
