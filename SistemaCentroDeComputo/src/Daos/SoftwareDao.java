package Daos;

import CentroComputo.Software;
import ccExcepciones.NoExisteRegistroException;
import centroDeComputo.Validador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * clase que se para implementar los metodos de administracion del
 * software conectandose con la base de datos (CRUD)
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
        consulta= "insert into software values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
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
        Connection connection = null;
        Statement statement = null;
        
        boolean actualizar = false;
        
        consulta = "update software set " +
                "nombreSoftware ='" +software.getNombre()+ "', origen = '" + software.getOrigen() + 
                "', Observaciones ='" +software.getObservaciones()+"', fechaAdquisicion = " + software.getFechaAdquisicion()+
                "', tipoSoftware ='" +software.getTipoSoftware()+"', marca ='" +software.getMarca()+ 
                "', requiereActualizacion ='" +software.isRequiereActualizacion() + "', version ='" + software.getVersion()+
                "', disponible ='" +software.isDisponible()+ "', sistemaOperativo = '" +software.getSistemaOperativo()+
                "', idioma = '" +software.getIdioma() + "' where idSoftware= '" + software.getIdSoftware();
        try{
            connection = AccesoDataBase.obtenerConexionBaseDatos();            
            statement= connection.createStatement();
            statement.execute(consulta);
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
        List<Software> listaSoftware = new ArrayList <>();
        
        try{
            Connection conection  = AccesoDataBase.obtenerConexionBaseDatos();
            PreparedStatement consultaParametrizada = conection.prepareStatement(consulta);
            ResultSet resultado = consultaParametrizada.executeQuery();
            while (resultado.next()){
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
        }finally {
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
        try{
            PreparedStatement consultaParametrizada = AccesoDataBase.obtenerConexionBaseDatos().prepareStatement(consulta);
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
        }finally{
            AccesoDataBase.cerrarConexion();
        }
       return software;
    }

    /**
     * coloca el software como "desahibilitado" en la base de datos, no lo
     * borra realmente
     * 
     * @param software a deshabilitar
     * @return true
     */
    @Override
    public boolean eliminarSoftware(Software software) {      
        consulta= "update software set disponible=false where idSoftware= ?";
        try{
            PreparedStatement consultaParametrizada = AccesoDataBase.obtenerConexionBaseDatos().prepareStatement(consulta);
            consultaParametrizada.setString(1, software.getIdSoftware());
            consultaParametrizada.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            AccesoDataBase.cerrarConexion();
        }
       return true;
    }
    
    
    
}
