package Daos;

import CentroComputo.Hardware;
import java.util.List;

/**
 * interfaz con los metodos publicos
 * 
 * @author Irasema Caicero
 * @version 1.0
 */
public interface InterfaceHardwareDao {
  public boolean agregarHardware(Hardware hardware);

  public boolean actualizarHardware(Hardware hardware);

  public List<Hardware> obtenerListaHardware();

  public Hardware buscarHardware(String noInventarioUv);

  public boolean eliminarHardware(Hardware hardware);
}
