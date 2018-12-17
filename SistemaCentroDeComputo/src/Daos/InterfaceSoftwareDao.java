package Daos;

import CentroComputo.Software;
import java.util.List;

/**
 * interfaz del software que para acceder a sus metodos
 * 
 * @author Irasema Caicero
 * @since 8/12/2018
 * @version 1.0
 */
public interface InterfaceSoftwareDao {
  public boolean agregarSoftware(Software software);

  public boolean actualizarSoftware(Software software);

  public List<Software> obtenerListaSoftware();

  public Software buscarSoftware(String idSoftware);

  public boolean eliminarSoftware(Software software);
}
