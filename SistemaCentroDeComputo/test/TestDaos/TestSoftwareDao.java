package TestDaos;

import CentroComputo.Software;
import Daos.SoftwareDao;
import java.sql.SQLException;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

/**
 * @author Irasema Caicero
 */
public class TestSoftwareDao {
    
    public void agregarSoftwareCompleto(){
        Software softwarePrueba = new Software();
        
        softwarePrueba.setIdSoftware("S001");
        softwarePrueba.setNombre("sait");
        softwarePrueba.setOrigen("comprado");
        softwarePrueba.setObservaciones("sin fallas bla bla bla");
        softwarePrueba.setFechaAdquisicion("2017-02-11");
        softwarePrueba.setTipoSoftware("administrativo");
        softwarePrueba.setMarca("Sait");
        softwarePrueba.setRequiereActualizacion(true);
        softwarePrueba.setVersion(1.7);
        softwarePrueba.setDisponible(true);
        softwarePrueba.setSistemaOperativo("windows");
        softwarePrueba.setIdioma("español");
        
        SoftwareDao softwareDaoPrueba = new SoftwareDao();
        boolean resultado = true;
        try{
            resultado = softwareDaoPrueba.agregarSoftware(softwarePrueba);          
        }catch(Exception e){
           e.printStackTrace();            
        }
        assertTrue("prueba agregacion: ", resultado);                  
    }
    
}
