package TestDaos;

import CentroComputo.Software;
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * @author Irasema Caicero
 */
public class TestSoftwareDao {
    
    public TestSoftwareDao(){
        
    }
    
    @Test
    public void testAgregarSoftwareCompleto(){
        Connection conexion= null;      
        try{
            conexion= AccesoDataBase.obtenerConexionBaseDatos();
               
        }catch(NullPointerException e){
            Logger.getLogger(SoftwareDao.class.getName()).log(Level.SEVERE, null, e);
        }
        Software softwarePrueba = new Software();
        softwarePrueba.setIdSoftware("S001");
        softwarePrueba.setNombre("sait");
        softwarePrueba.setOrigen("comprado");
        softwarePrueba.setObservaciones("sin fallas bla bla bla");
        softwarePrueba.setFechaAdquisicion(Date.valueOf("2018-02-02"));
        softwarePrueba.setTipoSoftware("administrativo");
        softwarePrueba.setMarca("Sait");
        softwarePrueba.setRequiereActualizacion(true);
        softwarePrueba.setVersion(1.7);
        softwarePrueba.setDisponible(true);
        softwarePrueba.setSistemaOperativo("windows");
        softwarePrueba.setIdioma("español");
        
        SoftwareDao softwareDaoPrueba = new SoftwareDao();
        boolean esperado = true;
        try{
            esperado = softwareDaoPrueba.agregarSoftware(softwarePrueba);          
        }catch(Exception e){
           e.printStackTrace();            
        }
        assertTrue("prueba agregar Software ", esperado);                  
    }
    
    @Test
    public void testActualizarSoftwareCorrectamente(){
        Connection conexion;     
        try{
            conexion = AccesoDataBase.obtenerConexionBaseDatos();
            throw new ErrorOperacionDB("sucedió algo inoportuno en la operacion con la DB");        
        }catch(ErrorOperacionDB e){
            Logger.getLogger(SoftwareDao.class.getName()).log(Level.SEVERE, null, e);
        }
        
        Software softwarePrueba = new Software();
                
        softwarePrueba.setNombre("word");
        softwarePrueba.setOrigen("comprado");
        softwarePrueba.setObservaciones("sin fallas bla bla bla");
        softwarePrueba.setFechaAdquisicion(Date.valueOf("2018-02-08"));
        softwarePrueba.setTipoSoftware("administrativo");
        softwarePrueba.setMarca("office");
        softwarePrueba.setRequiereActualizacion(false);
        softwarePrueba.setVersion(7.0);
        softwarePrueba.setDisponible(true);
        softwarePrueba.setSistemaOperativo("windows");
        softwarePrueba.setIdioma("español");
        
        SoftwareDao softwareDaoPrueba = new SoftwareDao(); 
        boolean esperado=true;
        try{
            esperado = softwareDaoPrueba.agregarSoftware(softwarePrueba);          
        }catch(Exception e){
           e.printStackTrace();            
        }
        assertTrue("prueba de actualizacion correcta: ", esperado);           
        
    }
    
    @Test
    public void testObtenerListaSoftware(){
        SoftwareDao softDao = new SoftwareDao();
        final int ELEMENTO_DELA_LISTA = 0;
        final String IDSOFTWARE_ESPERADO = "S003";
        final String NOMBRE_ESPERADO = "Excel";
        final String ORIGEN_ESPERADO = "donado";
        final String OBSERVACIONES_ESPERADAS= "no tiene fallas de ningun tipo";
        final Date FECHAADQUISICION_ESPERADA = Date.valueOf("2018-02-03");
        final String TIPOSOFTWARE_ESPERADO = "administrativo";
        final String MARCA_ESPERADA = "office";
        final boolean REQUIEREACTUALIZACION_ESPERADA= true;
        final double VERSION_ESPERADA = 3.3;
        final boolean DISPONIBLE_ESPERADO= true;
        final String SISTEMAOPERATIVO_ESPERADO = "Windows";
        final String IDIOMA_ESPERADO = "español";
        List<Software> listaSoftware = new ArrayList();
        try{
            listaSoftware = softDao.obtenerListaSoftware();
            throw new ErrorOperacionDB("sucedió algo inoportuno en la operacion con la DB");
        }catch(ErrorOperacionDB e) {
            e.printStackTrace();
        }
        
        final String IDSOFTWARE_OBTENIDO = listaSoftware.get(ELEMENTO_DELA_LISTA).getIdSoftware();
        final String NOMBRE_OBTENIDO = listaSoftware.get(ELEMENTO_DELA_LISTA).getNombre();
        final String ORIGEN_OBTENIDO = listaSoftware.get(ELEMENTO_DELA_LISTA).getOrigen();
        final String OBSERVACIONES_OBTENIDO= listaSoftware.get(ELEMENTO_DELA_LISTA).getObservaciones();
        final Date FECHAADQUISICION_OBTENIDO = listaSoftware.get(ELEMENTO_DELA_LISTA).getFechaAdquisicion();
        final String TIPOSOFTWARE_OBTENIDO = listaSoftware.get(ELEMENTO_DELA_LISTA).getTipoSoftware();
        final String MARCA_OBTENIDO = listaSoftware.get(ELEMENTO_DELA_LISTA).getMarca();
        final boolean REQUIEREACTUALIZACION_OBTENIDO= listaSoftware.get(ELEMENTO_DELA_LISTA).isRequiereActualizacion();
        final double VERSION_OBTENIDO = listaSoftware.get(ELEMENTO_DELA_LISTA).getVersion();
        final boolean DISPONIBLE_OBTENIDO= listaSoftware.get(ELEMENTO_DELA_LISTA).isDisponible();
        final String SISTEMAOPERATIVO_OBTENIDO = listaSoftware.get(ELEMENTO_DELA_LISTA).getSistemaOperativo();
        final String IDIOMA_OBTENIDO = listaSoftware.get(ELEMENTO_DELA_LISTA).getIdioma();
        
        assertEquals("prueba id software", IDSOFTWARE_ESPERADO, IDSOFTWARE_OBTENIDO);
        assertEquals("prueba id software", NOMBRE_ESPERADO, NOMBRE_OBTENIDO);
        assertEquals("prueba id software", ORIGEN_ESPERADO, ORIGEN_OBTENIDO);
        assertEquals("prueba id software", OBSERVACIONES_ESPERADAS, OBSERVACIONES_OBTENIDO);
        assertEquals("prueba id software", FECHAADQUISICION_ESPERADA, FECHAADQUISICION_OBTENIDO);
        assertEquals("prueba id software", TIPOSOFTWARE_ESPERADO, TIPOSOFTWARE_OBTENIDO);
        assertEquals("prueba id software", MARCA_ESPERADA, MARCA_OBTENIDO);
        assertEquals("prueba id software", REQUIEREACTUALIZACION_ESPERADA, REQUIEREACTUALIZACION_OBTENIDO);
        assertEquals("prueba id software", VERSION_ESPERADA, VERSION_OBTENIDO, 0.00);
        assertEquals("prueba id software", DISPONIBLE_ESPERADO, DISPONIBLE_OBTENIDO);
        assertEquals("prueba id software", SISTEMAOPERATIVO_ESPERADO, SISTEMAOPERATIVO_OBTENIDO);
        assertEquals("prueba id software", IDIOMA_ESPERADO, IDIOMA_OBTENIDO);                 
    }
    
    @Test
    public void testBuscarSoftware() {
        SoftwareDao softwareDao = new SoftwareDao();
        
        final String IDSOFTWARE_ESPERADO = "S003";
        final String NOMBRE_ESPERADO = "Excel";
        final String ORIGEN_ESPERADO = "donado";
        final String OBSERVACIONES_ESPERADAS= "no tiene fallas de ningun tipo";
        final Date FECHAADQUISICION_ESPERADA = Date.valueOf("2018-02-03");
        final String TIPOSOFTWARE_ESPERADO = "administrativo";
        final String MARCA_ESPERADA = "office";
        final boolean REQUIEREACTUALIZACION_ESPERADA= true;
        final double VERSION_ESPERADA = 3.3;
        final boolean DISPONIBLE_ESPERADO= true;
        final String SISTEMAOPERATIVO_ESPERADO = "Windows";
        final String IDIOMA_ESPERADO = "español";
               
        Software software = new Software();
        try{
        software = softwareDao.buscarSoftware(IDSOFTWARE_ESPERADO);
        throw new ErrorOperacionDB("sucedió algo inoportuno en la operacion con la DB");
        } catch(ErrorOperacionDB e) {
            e.printStackTrace();
        }
        
        final String IDSOFTWARE_OBTENIDO = software.getIdSoftware();
        final String NOMBRE_OBTENIDO = software.getNombre();
        final String ORIGEN_OBTENIDO = software.getOrigen();
        final String OBSERVACIONES_OBTENIDO= software.getObservaciones();
        final Date FECHAADQUISICION_OBTENIDO = software.getFechaAdquisicion();
        final String TIPOSOFTWARE_OBTENIDO= software.getTipoSoftware();
        final String MARCA_OBTENIDO = software.getMarca();
        final boolean REQUIEREACTUALIZACION_OBTENIDO= software.isRequiereActualizacion();
        final double VERSION_OBTENIDA = software.getVersion();
        final boolean DISPONIBLE_OBTENIDO= software.isDisponible();
        final String SISTEMAOPERATIVO_OBTENIDO = software.getSistemaOperativo();
        final String IDIOMA_OBTENIDO = software.getIdioma();
        
        assertEquals("prueba id del software", IDSOFTWARE_ESPERADO, IDSOFTWARE_OBTENIDO);
        assertEquals("prueba nombre del software", NOMBRE_ESPERADO, NOMBRE_OBTENIDO);
        assertEquals("prueba origen del software", ORIGEN_ESPERADO, ORIGEN_OBTENIDO);
        assertEquals("prueba observaciones del software", OBSERVACIONES_ESPERADAS, OBSERVACIONES_OBTENIDO);
        assertEquals("prueba fechaAdquis. del software", FECHAADQUISICION_ESPERADA, FECHAADQUISICION_OBTENIDO);
        assertEquals("prueba tipo del software", TIPOSOFTWARE_ESPERADO, TIPOSOFTWARE_OBTENIDO);
        assertEquals("prueba marca del software", MARCA_ESPERADA, MARCA_OBTENIDO);
        assertEquals("prueba actualiacion del software", REQUIEREACTUALIZACION_ESPERADA, REQUIEREACTUALIZACION_OBTENIDO);
        assertEquals("prueba version del software", VERSION_ESPERADA, VERSION_OBTENIDA,0.00);
        assertEquals("prueba disponible del software", DISPONIBLE_ESPERADO, DISPONIBLE_OBTENIDO);
        assertEquals("prueba sistema operativo del software", SISTEMAOPERATIVO_ESPERADO, SISTEMAOPERATIVO_OBTENIDO);
        assertEquals("prueba idioma del software", IDIOMA_ESPERADO, IDIOMA_OBTENIDO);    
    }
    
    @Test
    public void testEliminarSoftwareCorrectamente(){
        Software software = new Software();
        software.setDisponible(false);
        boolean esperado = true;
        SoftwareDao softwareDao = new SoftwareDao();
        esperado = softwareDao.eliminarSoftware(software);
        assertTrue("elimina el plan de curso ", esperado);       
    }
    
}
