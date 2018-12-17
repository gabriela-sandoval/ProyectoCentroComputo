package Daos;

import CentroComputo.Software;
import CentroComputo.Validador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * clase que se para implementar los metodos de administracion del software conectandose con la base
 * de datos (CRUD)
 * 
 * @author Irasema Caicero
 * @since 8-12-18
 * @version 1.0
 */
public class SoftwareDao implements InterfaceSoftwareDao {
  private String consulta;
  private List<Software> listaSoftware;

  /**
   * registra en la base de datos un nuevo software
   * 
   * @param software objeto a guardar
   * @return booleano true
   */
  @Override
  public boolean agregarSoftware(Software software) {
    Validador validador = new Validador();
    validador.validaIdSoftware(software.getIdSoftware());
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    validador.validarFechaMaxima(sdf.format(software.getFechaAdquisicion()));
    consulta = "insert into software values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try {
      Connection connection = AccesoDataBase.obtenerConexionBaseDatos();
      PreparedStatement consultaParametrizada = connection.prepareStatement(consulta);
      consultaParametrizada.setString(1, software.getIdSoftware());
      consultaParametrizada.setString(2, software.getNombre());
      consultaParametrizada.setString(3, software.getOrigen());
      consultaParametrizada.setString(4, software.getObservaciones());
      consultaParametrizada.setDate(5, software.getFechaAdquisicion());
      consultaParametrizada.setString(6, software.getTipoSoftware());
      consultaParametrizada.setString(7, software.getMarca());
      consultaParametrizada.setBoolean(8, software.isRequiereActualizacion());
      consultaParametrizada.setDouble(9, software.getVersion());
      consultaParametrizada.setBoolean(10, software.isDisponible());
      consultaParametrizada.setString(11, software.getSistemaOperativo());
      consultaParametrizada.setString(12, software.getIdioma());
      consultaParametrizada.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace();
    } finally {
      AccesoDataBase.cerrarConexion();
    }
    return true;
  }

  /**
   * modifica un software que ya existe
   * 
   * @param software a modificar
   * @return true
   */
  @Override
  public boolean actualizarSoftware(Software software) {

    boolean actualizar = false;

    consulta = "update software set nombreSoftware = ?, origen = ?, "
            + "Observaciones = ?, fechaAdquisicion = ?, tipoSoftware = ?,"
            + "marca = ?, requiereActualizacion = ?, version = ?, disponible = ?,"
            + "sistemaOperativo = ?, idioma = ? where idSoftware = ?";
    try {
      Connection connection = AccesoDataBase.obtenerConexionBaseDatos();
      PreparedStatement statement = connection.prepareStatement(consulta);
      statement.setString(1, software.getNombre());
      statement.setString(2, software.getOrigen());
      statement.setString(3, software.getObservaciones());
      statement.setDate(4, software.getFechaAdquisicion());
      statement.setString(5, software.getTipoSoftware());
      statement.setString(6, software.getMarca());
      statement.setBoolean(7, software.isRequiereActualizacion());
      statement.setDouble(8, software.getVersion());
      statement.setBoolean(9, software.isDisponible());
      statement.setString(10, software.getSistemaOperativo());
      statement.setString(11, software.getIdioma());
      statement.setString(12, software.getIdSoftware());
      statement.executeUpdate();
      actualizar = true;
    } catch (SQLException ex) {
      ex.printStackTrace();
    } finally {
      AccesoDataBase.cerrarConexion();
    }
    return actualizar;
  }

  @Override
  public List<Software> obtenerListaSoftware() {
    consulta = "select * from Software";
    List<Software> listaSoftware = new ArrayList<>();

    try {
      Connection conection = AccesoDataBase.obtenerConexionBaseDatos();
      PreparedStatement consultaParametrizada = conection.prepareStatement(consulta);
      ResultSet resultado = consultaParametrizada.executeQuery();
      while (resultado.next()) {
        Software software = new Software();

        software.setNombre(resultado.getString("nombreSoftware"));
        software.setIdSoftware(resultado.getString("idSoftware"));
        software.setMarca(resultado.getString("marca"));
        software.setVersion(resultado.getDouble("version"));
        software.setOrigen(resultado.getString("origen"));
        software.setTipoSoftware(resultado.getString("tipoSoftware"));
        software.setFechaAdquisicion(resultado.getDate("fechaAdquisicion"));
        software.setIdioma(resultado.getString("idioma"));
        software.setSistemaOperativo(resultado.getString("sistemaOperativo"));
        software.setRequiereActualizacion(resultado.getBoolean("requiereActualizacion"));
        software.setObservaciones(resultado.getString("Observaciones"));
        software.setDisponible(resultado.getBoolean("disponible"));
        listaSoftware.add(software);
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    } finally {
      AccesoDataBase.cerrarConexion();
    }
    return listaSoftware;
  }

  /**
   * busca un software existente en la base de datos
   * 
   * @param idSoftware a buscar
   * @return software encontrado
   */
  @Override
  public Software buscarSoftware(String idSoftware) {
    consulta = "select * from software where idSoftware = ?";
    Software software = new Software();
    try {
      PreparedStatement consultaParametrizada =
          AccesoDataBase.obtenerConexionBaseDatos().prepareStatement(consulta);
      consultaParametrizada.setString(1, idSoftware);
      ResultSet resultado = consultaParametrizada.executeQuery();
      resultado.next();
      software.setNombre(resultado.getString("nombreSoftware"));
      software.setIdSoftware(resultado.getString("idSoftware"));
      software.setMarca(resultado.getString("marca"));
      software.setVersion(resultado.getDouble("version"));
      software.setOrigen(resultado.getString("origen"));
      software.setTipoSoftware(resultado.getString("tipoSoftware"));
      software.setFechaAdquisicion(resultado.getDate("fechaAdquisicion"));
      software.setIdioma(resultado.getString("idioma"));
      software.setSistemaOperativo(resultado.getString("sistemaOperativo"));
      software.setRequiereActualizacion(resultado.getBoolean("requiereActualizacion"));
      software.setObservaciones(resultado.getString("Observaciones"));
      software.setDisponible(resultado.getBoolean("disponible"));

    } catch (SQLException ex) {
      ex.printStackTrace();
    } finally {
      AccesoDataBase.cerrarConexion();
    }
    return software;
  }

  /**
   * coloca el software como "desahibilitado" en la base de datos, no lo borra realmente
   * 
   * @param software a deshabilitar
   * @return true
   */
  @Override
  public boolean eliminarSoftware(Software software) {
    consulta = "update software set disponible=false where idSoftware= ?";
    try {
      PreparedStatement consultaParametrizada =
          AccesoDataBase.obtenerConexionBaseDatos().prepareStatement(consulta);
      consultaParametrizada.setString(1, software.getIdSoftware());
      consultaParametrizada.executeUpdate();

    } catch (SQLException ex) {
      ex.printStackTrace();
    } finally {
      AccesoDataBase.cerrarConexion();
    }
    return true;
  }
}
