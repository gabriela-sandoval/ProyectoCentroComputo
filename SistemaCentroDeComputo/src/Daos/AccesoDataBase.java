package Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * clase encargada de conectarse a la base de datos
 * 
 * @author Irasema Caicero
 * @since 15/12/2018
 * @version 1.0
 */
public class AccesoDataBase {
  private static Connection conexion;

  private static void conectar() {
    try {
      String url = "jdbc:mysql://localhost/";
      String databaseName = "centrocomputo";
      String userName = "root";
      String password = "ruletarusa98";

      conexion = (Connection) DriverManager.getConnection(url + databaseName, userName, password);
    } catch (SQLException ex) {
      java.util.logging.Logger.getLogger(AccesoDataBase.class.getName()).log(Level.SEVERE, null,
          ex);
    }
  }

  /**
   * obtiene la conexion a la base de datos
   * 
   * @return conexion a la database
   */
  public static Connection obtenerConexionBaseDatos() {
    conectar();
    return AccesoDataBase.conexion;
  }

  /**
   * cierra la conexion a la base de datos
   */
  public static void cerrarConexion() {
    if (conexion != null) {
      try {
        if (!conexion.isClosed()) {
          conexion.close();
        }
      } catch (SQLException ex) {
        Logger.getLogger(AccesoDataBase.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

}
