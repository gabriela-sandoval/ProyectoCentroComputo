package TestDaos;

import CentroComputo.Hardware;
import Daos.AccesoDataBase;
import Daos.HardwareDao;
import Daos.SoftwareDao;
import ccExcepciones.ErrorOperacionDB;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
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
        
    }
    
    @Test
    public void testAgregarHardwareCompleto(){
        Connection connection;       
        try{
            connection= AccesoDataBase.obtenerConexionBaseDatos();
            throw new ErrorOperacionDB("Sucedio Algo Inoportuno en la Operacion con la DataBase");
        }catch(ErrorOperacionDB e) {
            Logger.getLogger(SoftwareDao.class.getName()).log(Level.SEVERE, null, e);
        }
        String noInventario = "UV003";
        String marca = "dell";
        String modelo = "lv";
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
    public void testActualizarHardwareCorrectamente(){
        Connection conexion = null;
       
        try{
             conexion = AccesoDataBase.obtenerConexionBaseDatos();
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
    public void testObtenerListaHardware(){
        HardwareDao hardwDao = new HardwareDao();
        final int NUMERODELALISTA_ESPERADO = 0;
        final String NOINVENTARIO_ESPERADO = "UV001";
        final String MARCA_ESPERADA = "dell";
        String MODELO_ESPERADO = "inspiration 2322";
        int NUMSERIE_ESPERADO = 12345;
        String ESTADO_ESPERADO = "Disponible";
        String TIPODISPOSITIVO_ESPERADO = "laptop";
        Date FECHAADQUIRIDO_ESPERADO = Date.valueOf("2018-02-02");
        String UBICACION_ESPERADA = null;
        
        List <Hardware> listaHardware = new ArrayList();
        listaHardware = hardwDao.obtenerListaHardware();
        
        
        final String NOINVENTARIO_OBTENIDO = listaHardware.get(NUMERODELALISTA_ESPERADO).getNoInventarioUv();
        final String MARCA_OBTENIDO = listaHardware.get(NUMERODELALISTA_ESPERADO).getMarca();
        String MODELO_OBTENIDO = listaHardware.get(NUMERODELALISTA_ESPERADO).getModelo();
        int NUMSERIE_OBTENIDO = listaHardware.get(NUMERODELALISTA_ESPERADO).getNumeroSerie();
        String ESTADO_OBTENIDO = listaHardware.get(NUMERODELALISTA_ESPERADO).getEstado();
        String TIPODISPOSITIVO_OBTENIDO = listaHardware.get(NUMERODELALISTA_ESPERADO).getTipoDispositivo();
        Date FECHAADQUIRIDO_OBTENIDO = listaHardware.get(NUMERODELALISTA_ESPERADO).getFechaAdquisicion();
        String UBICACION_OBTENIDO = listaHardware.get(NUMERODELALISTA_ESPERADO).getUbicacion();
        
        Assert.assertEquals(NOINVENTARIO_ESPERADO, NOINVENTARIO_OBTENIDO);
        Assert.assertEquals(MARCA_ESPERADA, MARCA_OBTENIDO);
        Assert.assertEquals(MODELO_ESPERADO, MODELO_OBTENIDO);
        Assert.assertEquals(NUMSERIE_ESPERADO, NUMSERIE_OBTENIDO);
        Assert.assertEquals(ESTADO_ESPERADO, ESTADO_OBTENIDO);
        Assert.assertEquals(TIPODISPOSITIVO_ESPERADO, TIPODISPOSITIVO_OBTENIDO);
        Assert.assertEquals(FECHAADQUIRIDO_ESPERADO, FECHAADQUIRIDO_OBTENIDO);
        Assert.assertEquals(UBICACION_ESPERADA, UBICACION_OBTENIDO);      
    }
    
    @Test
    public void testBuscarHardwareCorrectamente() {
        HardwareDao hardwDao = new HardwareDao();
        final String NOINVENTARIO_ESPERADO = "UV001";
        final String MARCA_ESPERADA = "dell";
        String MODELO_ESPERADO = "inspiration 2322";
        int NUMSERIE_ESPERADO = 12345;
        String ESTADO_ESPERADO = "Disponible";
        String TIPODISPOSITIVO_ESPERADO = "laptop";
        Date FECHAADQUIRIDO_ESPERADO = Date.valueOf("2018-02-02");
        String UBICACION_ESPERADA = null;
        
        Hardware hardwareEsperado = new Hardware(NOINVENTARIO_ESPERADO, MARCA_ESPERADA, 
        MODELO_ESPERADO, NUMSERIE_ESPERADO, ESTADO_ESPERADO, TIPODISPOSITIVO_ESPERADO, 
        FECHAADQUIRIDO_ESPERADO, UBICACION_ESPERADA);
        
        Hardware obtenido = new Hardware();
        obtenido= hardwDao.buscarHardware(NOINVENTARIO_ESPERADO);
        
        Assert.assertEquals(hardwareEsperado, obtenido);      
    }
    
    @Test
    public void testEliminarHardwareCorrectamente(){
        boolean esperado = true;
        final String NOINVENTARIO_ESPERADO = "UV001";
        final String MARCA_ESPERADA = "dell";
        String MODELO_ESPERADO = "inspiration 2322";
        int NUMSERIE_ESPERADO = 12345;
        String ESTADO_ESPERADO = "deshabilitado";
        String TIPODISPOSITIVO_ESPERADO = "laptop";
        Date FECHAADQUIRIDO_ESPERADO = Date.valueOf("2018-02-02");
        String UBICACION_ESPERADA = null;
        
        Hardware hardware = new Hardware(NOINVENTARIO_ESPERADO, MARCA_ESPERADA, 
        MODELO_ESPERADO, NUMSERIE_ESPERADO, ESTADO_ESPERADO, TIPODISPOSITIVO_ESPERADO, 
        FECHAADQUIRIDO_ESPERADO, UBICACION_ESPERADA);
        
        HardwareDao hardwDao = new HardwareDao();
        esperado = hardwDao.eliminarHardware(hardware);
        Assert.assertTrue("hardware eliminado", esperado);
    }
    
    
}
