package TestDaos;

import CentroComputo.Hardware;
import Daos.AccesoDataBase;
import Daos.HardwareDao;
import Daos.SoftwareDao;
import ccExcepciones.ErrorOperacionDB;
import java.sql.Connection;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Irasema Caicero
 */
public class TestHardwareDao {
    
    public TestHardwareDao() {
        Connection connection = null;
        connection= AccesoDataBase.obtenerConexionBaseDatos();
        try{
            throw new ErrorOperacionDB("Sucedio Algo Inoportuno en la Operacion con la DataBase");
        }catch(ErrorOperacionDB e) {
            Logger.getLogger(SoftwareDao.class.getName()).log(Level.SEVERE, null, e);
        }
        String noInventario = "UV003";
        String marca = "dell";
        String modelo = "laverga";
        int numSerie = 12346;
        String estado = "Disponible";
        String tipoDispositivo = "laptop";
        Date fechaAdquirido = Date.valueOf("2012-02-03");
        String ubicacion = "centrodeComputo";
        
        Hardware hardware = new Hardware( noInventario, marca, modelo, numSerie, 
                estado, tipoDispositivo, fechaAdquirido, ubicacion);
        HardwareDao hardwareDao = new HardwareDao();
        
        boolean esperado = true;    
        esperado = hardwareDao.agregarHardware(hardware);
        
        Assert.assertTrue("Prueba agregar Hardware", esperado);
    }
    
    @Test
    public void testAgregarHardwareCompleto(){
        Connection conexion = null;
        conexion = AccesoDataBase.obtenerConexionBaseDatos();
        try{
            throw new ErrorOperacionDB("sucedió algo inoportuno en la operacion con la DB");        
        }catch(ErrorOperacionDB e){
            Logger.getLogger(SoftwareDao.class.getName()).log(Level.SEVERE, null, e);
        }
        
        String noInventario = "UV010";
        String marca = "edicion";
        String modelo = "edicion";
        int numSerie = 12341;
        String estado = "edicion";
        String tipoDispositivo = "edicion";
        Date fechaAdquirido = Date.valueOf("2012-02-03");
        String ubicacion = "cc1";
        
        Hardware hardware = new Hardware (noInventario, marca, modelo, numSerie,
        estado, tipoDispositivo, fechaAdquirido, ubicacion);
        HardwareDao hardwareDao = new HardwareDao();
        boolean esperado = true;     
        esperado = hardwareDao.actualizarHardware(hardware);
        Assert.assertTrue("actualizacion del hardware", esperado);
    }
    
    @Test
    public void testActualizarHardwareCorrectamente(){
        
    }
    
    @Test
    public void testObtenerListaHardware(){
        
        
    }
    
    @Test
    public void testBuscarHardwareCorrectamente(){
        
    }
    
    @Test
    public void testEliminarHardwareCorrectamente(){
        
    }
    
    
}
