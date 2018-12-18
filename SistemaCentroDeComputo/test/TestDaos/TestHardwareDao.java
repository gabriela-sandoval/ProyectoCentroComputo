package TestDaos;

import CentroComputo.Hardware;
import Daos.AccesoDataBase;
import Daos.HardwareDao;
import Daos.SoftwareDao;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * clase de prueba de metodos de hardware publicos
 * 
 * @author Irasema Caicero
 * @since 17/12/18
 * @version 1.0
 */
public class TestHardwareDao {

  public TestHardwareDao() {

  }

  /**
   * prueba insertar un hardware con todos sus parametros
   */
  @Test
  public void testAgregarHardwareCompleto() {
    Connection connection = null;
    try {
      connection = AccesoDataBase.obtenerConexionBaseDatos();

    } catch (NullPointerException e) {
      Logger.getLogger(SoftwareDao.class.getName()).log(Level.SEVERE, null, e);
    }
    Hardware hardware = new Hardware();
    hardware.setNoInventarioUv("H001");
    hardware.setMarca("Dell");
    hardware.setModelo("mini-lp");
    hardware.setEstado("disponible");
    hardware.setTipoDispositivo("laptop");
    hardware.setFechaAdquisicion(Date.valueOf("2017-01-02"));
    hardware.setNumeroSerie(12345);

    HardwareDao hardwareDao = new HardwareDao();
    boolean esperado = false;
    try {
      esperado = hardwareDao.agregarHardware(hardware);
    } catch (NullPointerException e) {
      e.printStackTrace();
    }
    assertTrue("Prueba agregar Hardware", esperado);

  }

  /**
   * prueba actualizar un hardware
   */
  @Test
  public void testActualizarHardwareCorrectamente() {
    Connection conexion;
    conexion = AccesoDataBase.obtenerConexionBaseDatos();
    Hardware hardware = new Hardware();

    hardware.setNoInventarioUv("H001");
    hardware.setMarca("Dell");
    hardware.setModelo("mini-lp");
    hardware.setEstado("prestado");
    hardware.setTipoDispositivo("laptop");
    hardware.setFechaAdquisicion(Date.valueOf("2017-01-02"));
    hardware.setNumeroSerie(12345);

    HardwareDao hardwareDao = new HardwareDao();
    boolean esperado = true;
    try {
      esperado = hardwareDao.actualizarHardware(hardware);
    } catch (Exception e) {
      e.printStackTrace();
    }
    Assert.assertTrue("actualizacion del hardware", esperado);
  }

  /**
   * obtiene la lista disponible
   */
  @Test
  public void testObtenerListaHardware() {
    HardwareDao hardwDao = new HardwareDao();

    final int NUMERODELALISTA_ESPERADO = 0;
    final String NOINVENTARIO_ESPERADO = "H001";
    final String MARCA_ESPERADA = "Dell";
    final String MODELO_ESPERADO = "mini-lp";
    int NUMSERIE_ESPERADO = 12345;
    final String ESTADO_ESPERADO = "disponible";
    final String TIPODISPOSITIVO_ESPERADO = "laptop";
    final Date FECHAADQUIRIDO_ESPERADO = Date.valueOf("2017-01-02");

    List<Hardware> listaHardware = new ArrayList();
    listaHardware = hardwDao.obtenerListaHardware();

    final String NOINVENTARIO_OBTENIDO =
        listaHardware.get(NUMERODELALISTA_ESPERADO).getNoInventarioUv();
    final String MARCA_OBTENIDO = listaHardware.get(NUMERODELALISTA_ESPERADO).getMarca();
    final String MODELO_OBTENIDO = listaHardware.get(NUMERODELALISTA_ESPERADO).getModelo();
    int NUMSERIE_OBTENIDO = listaHardware.get(NUMERODELALISTA_ESPERADO).getNumeroSerie();
    final String ESTADO_OBTENIDO = listaHardware.get(NUMERODELALISTA_ESPERADO).getEstado();
    final String TIPODISPOSITIVO_OBTENIDO =
        listaHardware.get(NUMERODELALISTA_ESPERADO).getTipoDispositivo();
    final Date FECHAADQUIRIDO_OBTENIDO =
        listaHardware.get(NUMERODELALISTA_ESPERADO).getFechaAdquisicion();

    assertEquals(NOINVENTARIO_ESPERADO, NOINVENTARIO_OBTENIDO);
    assertEquals(MARCA_ESPERADA, MARCA_OBTENIDO);
    assertEquals(MODELO_ESPERADO, MODELO_OBTENIDO);
    assertEquals(NUMSERIE_ESPERADO, NUMSERIE_OBTENIDO);
    assertEquals(ESTADO_ESPERADO, ESTADO_OBTENIDO);
    assertEquals(TIPODISPOSITIVO_ESPERADO, TIPODISPOSITIVO_OBTENIDO);
    assertEquals(FECHAADQUIRIDO_ESPERADO, FECHAADQUIRIDO_OBTENIDO);
  }

  /**
   * busca un hardware en la base de datos
   */
  @Test
  public void testBuscarHardwareCorrectamente() {
    HardwareDao hardwDao = new HardwareDao();

    final String NOINVENTARIO_ESPERADO = "H001";
    final String MARCA_ESPERADA = "Dell";
    final String MODELO_ESPERADO = "mini-lp";
    final int NUMSERIE_ESPERADO = 12345;
    final String ESTADO_ESPERADO = "disponible";
    final String TIPODISPOSITIVO_ESPERADO = "laptop";
    final Date FECHAADQUIRIDO_ESPERADO = Date.valueOf("2017-01-02");

    Hardware obtenido = new Hardware();
    obtenido = hardwDao.buscarHardware(NOINVENTARIO_ESPERADO);

    final String NOINVENTARIO_OBTENIDO = obtenido.getNoInventarioUv();
    final String MARCA_OBTENIDO = obtenido.getMarca();
    final String MODELO_OBTENIDO = obtenido.getModelo();
    int NUMSERIE_OBTENIDO = obtenido.getNumeroSerie();
    final String ESTADO_OBTENIDO = obtenido.getEstado();
    final String TIPODISPOSITIVO_OBTENIDO = obtenido.getTipoDispositivo();
    final Date FECHAADQUIRIDO_OBTENIDO = obtenido.getFechaAdquisicion();

    assertEquals("prueba inventario", NOINVENTARIO_ESPERADO, NOINVENTARIO_OBTENIDO);
    assertEquals("prueba inventario", MARCA_ESPERADA, MARCA_OBTENIDO);
    assertEquals("prueba inventario", NUMSERIE_ESPERADO, NUMSERIE_OBTENIDO);
    assertEquals("prueba inventario", ESTADO_ESPERADO, ESTADO_OBTENIDO);
    assertEquals("prueba inventario", TIPODISPOSITIVO_ESPERADO, TIPODISPOSITIVO_OBTENIDO);
    assertEquals("prueba inventario", FECHAADQUIRIDO_ESPERADO, FECHAADQUIRIDO_OBTENIDO);
  }

  /**
   * Deshabilita el hardware
   */
  @Test
  public void testEliminarHardwareCorrectamente() {
    Hardware hardware = new Hardware();
    hardware.setEstado("deshabilitado");
    hardware.setNoInventarioUv("H001");
    boolean esperado = true;
    HardwareDao hardwareDao = new HardwareDao();
    esperado = hardwareDao.eliminarHardware(hardware);
    assertTrue("elimina el hardware", esperado);
  }


}
