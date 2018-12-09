/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import CentroComputo.Licencia;
import CentroComputo.Software;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Irasema Caicero
 */
public class SoftwareDao implements InterfaceSoftwareDao {
    private String consulta;
    private List<Software> listaSoftware;
    

    @Override
    public boolean agregarSoftware(Software software) {
        
        consulta= "insert into software values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement consultaParametrizada = AccesoDataBase.obtenerConexionBaseDatos().prepareStatement(consulta)) {
            consultaParametrizada.setString(1, software.getNombre());
            consultaParametrizada.setString(2, software.getIdSoftware());
            consultaParametrizada.setString(3, software.getMarca());
            consultaParametrizada.setDouble(4, software.getVersion());
            consultaParametrizada.setString(5, software.getOrigen());
            consultaParametrizada.setString(6, software.getTipoSoftware());
            consultaParametrizada.setDate(7, software.getFechaAdquisicion());
            consultaParametrizada.setString(8, software.getIdioma());
            consultaParametrizada.setString(9, software.getSistemaOperativo());
            consultaParametrizada.setBoolean(10, software.getRequiereActualizacion());
            consultaParametrizada.setString(11, software.getObservaciones());
            consultaParametrizada.setBoolean(12, software.getDisponible());
            consultaParametrizada.executeUpdate();                       
        } catch (SQLException ex) {
            Logger.getLogger(SoftwareDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
           AccesoDataBase.cerrarConexion();
        }
        return true;
    }

    @Override
    public boolean actualizarSoftware(Software software) {
        consulta = "UPDATE Software s join SoftwareVersion on s.idsoftware=v.Software_idSoftware set" +
                "'idSoftware' =? , 'nombre'= ?, 'marca'=?, 'version'=?, 'origen'=?, 'tipoSoftware'=?," +
                "'fechaAdquisicion'=?, 'idioma'=?, 'sistemaOperativo'=?, 'requiereActualizacion'=?," + 
                "'observaciones'=? ";
        
        try(PreparedStatement consultaParametrizada = AccesoDataBase.obtenerConexionBaseDatos().prepareStatement(consulta)){
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SoftwareDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            AccesoDataBase.cerrarConexion();
        }
        return true;
    }

    @Override
    public List<Software> obtenerListaSoftware() {
        consulta = "select * from Software";
        listaSoftware = new ArrayList <>();
        
        try{
            PreparedStatement consultaParametrizada = AccesoDataBase.obtenerConexionBaseDatos().prepareStatement(consulta);
            ResultSet resultado = consultaParametrizada.executeQuery();
            while (resultado.next()){
                Software software = new Software();
                software.setNombre(resultado.getString("nombre"));
                software.setIdSoftware(resultado.getString("clave"));
                software.setMarca(resultado.getString("marca"));
                software.setVersion(resultado.getDouble("version"));
                software.setOrigen(resultado.getString("origen"));
                software.setTipoSoftware(resultado.getString("tipo Software"));
                software.setFechaAdquisicion(resultado.getDate("fecha adquisicion"));
                software.setIdioma(resultado.getString("idioma"));
                software.setSistemaOperativo(resultado.getString("sistemaOperativo"));
                software.setRequiereActualizacion(resultado.getBoolean("actualizacion"));
                software.setObservaciones(resultado.getString("observaciones"));
                software.setDisponible(resultado.getBoolean("disponible"));
                listaSoftware.add(software);   
            }
        } catch (SQLException ex) {
            Logger.getLogger(SoftwareDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            AccesoDataBase.cerrarConexion();
        }
        return null;
    }

    @Override
    public Software buscarSoftware(String idSoftware) {
        consulta = "select * from software where idSoftware = ?";
        Software software = new Software();
        try{
            PreparedStatement consultaParametrizada = AccesoDataBase.obtenerConexionBaseDatos().prepareStatement(consulta);
            consultaParametrizada.setString(1, idSoftware);
            ResultSet resultado = consultaParametrizada.executeQuery();
            if(resultado.next()){
                software.setNombre(resultado.getString("nombre"));
                software.setIdSoftware(resultado.getString("clave"));
                software.setMarca(resultado.getString("marca"));
                software.setVersion(resultado.getDouble("version"));
                software.setOrigen(resultado.getString("origen"));
                software.setTipoSoftware(resultado.getString("tipo Software"));
                software.setFechaAdquisicion(resultado.getDate("fecha adquisicion"));
                software.setIdioma(resultado.getString("idioma"));
                software.setSistemaOperativo(resultado.getString("sistemaOperativo"));
                software.setRequiereActualizacion(resultado.getBoolean("actualizacion"));
                software.setObservaciones(resultado.getString("observaciones"));
            }   software.setDisponible(resultado.getBoolean("disponible"));
        } catch (SQLException ex) {
            Logger.getLogger(SoftwareDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            AccesoDataBase.cerrarConexion();
        }
       return software;
    }

    @Override
    public boolean eliminarSoftware(String idSoftware) {
        consulta= "update software set disponible=false where idSoftware= ?";
        try{
            PreparedStatement consultaParametrizada = AccesoDataBase.obtenerConexionBaseDatos().prepareStatement(consulta);
            consultaParametrizada.setBoolean(1, false);
            consultaParametrizada.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SoftwareDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            AccesoDataBase.cerrarConexion();
        }
       return true;
    }
    
    
    
}
