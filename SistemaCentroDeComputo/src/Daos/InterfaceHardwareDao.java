package Daos;

import CentroComputo.Hardware;
import java.util.List;

/**
 *
 * @author Irasema Caicero
 */
public interface InterfaceHardwareDao {
    public boolean agregarSoftware(Hardware hardware);
    public boolean actualizarSoftware(Hardware hardware);
    public List<Hardware> obtenerListaSoftware();
    public Hardware buscarSoftware(String idSoftware);
    public boolean eliminarSoftware(String noIventarioUv);   
    
}
