package Daos;

import CentroComputo.Hardware;
import ccExcepciones.NoExisteRegistroException;
import java.sql.Connection;
import java.sql.Date;
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
 * @since 11/12/2018
 * @version 1.0
 */
public class HardwareDao implements InterfaceHardwareDao {
    private String consulta;
    private Connection conection;

    @Override
    public boolean agregarHardware(Hardware hardware) {
        consulta = "insert into hardware values (?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement consultaParametrizada = AccesoDataBase.obtenerConexionBaseDatos().prepareStatement(consulta);
            consultaParametrizada.setString(1, hardware.getNoInventarioUv());
            consultaParametrizada.setString(2, hardware.getMarca());
            consultaParametrizada.setString(3, hardware.getModelo());
            consultaParametrizada.setInt(4, hardware.getNumeroSerie());
            consultaParametrizada.setString(5, hardware.getEstado());
            consultaParametrizada.setString(6, hardware.getTipoDispositivo());
            consultaParametrizada.setDate(7, hardware.getFechaAdquisicion());
            consultaParametrizada.setString(8, hardware.getUbicacion());
            consultaParametrizada.executeUpdate();            
        } catch (SQLException ex) {
            Logger.getLogger(HardwareDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            AccesoDataBase.cerrarConexion();
        }
        return true;        
    }

    @Override
    public boolean actualizarHardware(Hardware hardware) {
        if(hardware.getNoInventarioUv().isEmpty()){
            try{
                throw new NoExisteRegistroException("El hardware que ingresó no existe");
            } catch (NoExisteRegistroException ex) {
                Logger.getLogger(HardwareDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        consulta = "UPDATE hardware set 'marca'= ?, 'modelo' = ?, 'numeroSerie' = ?,"
                + "'estado' = ?, 'tipoDispositivo' = ?, 'fechaAdquisicion' = ?, "
                + "'ubicacion' = ? ";
        try{
            PreparedStatement consultaParametrizada = AccesoDataBase.obtenerConexionBaseDatos().prepareStatement(consulta);
            consultaParametrizada.setString(1, hardware.getNoInventarioUv());
            consultaParametrizada.setString(2, hardware.getMarca());
            consultaParametrizada.setString(3, hardware.getModelo());
            consultaParametrizada.setInt(4, hardware.getNumeroSerie());
            consultaParametrizada.setString(5, hardware.getEstado());
            consultaParametrizada.setString(6, hardware.getTipoDispositivo());
            consultaParametrizada.setString(7, hardware.getUbicacion());
            consultaParametrizada.executeUpdate();              
        } catch (SQLException ex) {
            Logger.getLogger(HardwareDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            AccesoDataBase.cerrarConexion();
        }     
        return true;
    }

    @Override
    public List<Hardware> obtenerListaHardware() {
        consulta = "select * from hardware";
        List<Hardware> listaHardware = new ArrayList<>();
        try{
            conection = AccesoDataBase.obtenerConexionBaseDatos();
            PreparedStatement consultaParametrizada = conection.prepareStatement(consulta);
            ResultSet resultadoConsulta = consultaParametrizada.executeQuery();
            while(resultadoConsulta.next()) {
                String noInventarioUv = resultadoConsulta.getString("noInventarioUv");
                String marca = resultadoConsulta.getString("marca");
                String modelo = resultadoConsulta.getString("modelo");
                int numeroSerie = resultadoConsulta.getInt("numeroSerie");
                String estado = resultadoConsulta.getString("estado");
                String tipoDispositivo = resultadoConsulta.getString("tipoDispositivo");
                Date fechaAdquirido = resultadoConsulta.getDate("fechaAdquisicion");
                String ubicacion = resultadoConsulta.getString("ubicacion");

                listaHardware.add(new Hardware(noInventarioUv, marca, modelo, numeroSerie, 
                        estado, tipoDispositivo, fechaAdquirido, ubicacion));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(HardwareDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            AccesoDataBase.cerrarConexion();
        }
        return listaHardware;
    }

    @Override
    public Hardware buscarHardware(String noInventarioUv) {
        consulta = "select * from hardware where no.InventarioUv = ? ";
        try{
            conection = AccesoDataBase.obtenerConexionBaseDatos();
            PreparedStatement consultaParametrizada = conection.prepareStatement(consulta);
            consultaParametrizada.setString(1, noInventarioUv);
            ResultSet resultadoConsulta = consultaParametrizada.executeQuery();
            resultadoConsulta.next();
            String numInventario = resultadoConsulta.getString("num Inventario");
            String marca = resultadoConsulta.getString("marca");
            String modelo = resultadoConsulta.getString("modelo");
            int numeroSerie = resultadoConsulta.getInt("numeroSerie");
            String estado = resultadoConsulta.getString("estado");
            String tipoDispositivo = resultadoConsulta.getString("tipoDispositivo");
            Date fechaAdquirido = resultadoConsulta.getDate("fechaAdquisicion");
            String ubicacion = resultadoConsulta.getString("ubicacion");
            
            Hardware hardware = new Hardware(noInventarioUv, marca, modelo, numeroSerie,
            estado, tipoDispositivo, fechaAdquirido, ubicacion);
            return hardware;
            
        } catch (SQLException ex) {
            Logger.getLogger(HardwareDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            AccesoDataBase.cerrarConexion();
        }
        return null;
    }

    @Override
    public boolean eliminarHardware(Hardware hardware) {
        hardware.CambiarEstado("deshabilitado");
        consulta = "update software set estado = 'deshabilitado'  where no.InventarioUv = ?";
        try{
            PreparedStatement consultaParametrizada = AccesoDataBase.obtenerConexionBaseDatos().prepareStatement(consulta);
            consultaParametrizada.setString(5, hardware.getEstado());
            consultaParametrizada.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HardwareDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            AccesoDataBase.cerrarConexion();
        }
        return false;
    }
    
}
