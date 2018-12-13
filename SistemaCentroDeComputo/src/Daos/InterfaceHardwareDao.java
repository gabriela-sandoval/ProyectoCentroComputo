package Daos;

import CentroComputo.Hardware;
import java.util.List;

/**
 *
 * @author Irasema Caicero
 */
public interface InterfaceHardwareDao {
    public boolean agregarHardware(Hardware hardware);
    public boolean actualizarHardware(Hardware hardware);
    public List<Hardware> obtenerListaHardware();
    public Hardware buscarHardware(String idSoftware);
    public boolean eliminarHardware(Hardware hardware);   
    
}
