package TestValidacion;

import CentroComputo.Validador;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * clase que valida los metodos que validan los datos a guardar
 * 
 * @author Irasema Caicero
 * @since 16/12/2018
 * @version 1.0
 */
public class TestValidacion {
  public TestValidacion() {

  }

  /**
   * valida un id de software que le pasamos cumpliendo la estructura correcta
   */
  @Test
  public void probarIdSoftwareCorrecto() {
    Validador validador = new Validador();
    String idSoftware = "S004";
    Boolean obtenido = validador.validaIdSoftware(idSoftware);
    assertTrue("prueba id de software", obtenido);
  }

  /**
   * prueba la validacion del idsoftware ingresando numeros
   */
  @Test
  public void probarIdSoftwareConNumeros() {
    Validador validador = new Validador();
    String idInvalido = "12222";
    Boolean obtenido = validador.validaIdSoftware(idInvalido);
    assertFalse("prueba invalido id", obtenido);
  }

  /**
   * prueba la validacion del formato de la fecha ingresando correctamente
   */
  @Test
  public void probarEstructuraFechaCorrecta() {
    Validador validador = new Validador();
    String fecha = "2018-12-17";
    Boolean obtenido = validador.validarEstructuraFecha(fecha);
    assertTrue("fecha válida", obtenido);
  }

  /**
   * prueba la validacion de la fecha pasndo el formato incorrecto
   */
  @Test
  public void probarEstructuraFechaIncorrecta() {
    Validador validador = new Validador();
    String fecha = "22/12/2012";
    Boolean obtenido = validador.validarEstructuraFecha(fecha);
    assertFalse("fecha invalida", obtenido);
  }

  /**
   * prueba la validacion de la fecha correctamente
   */
  @Test
  public void probarValidarFechaMaxima() {
    Validador validador = new Validador();
    String fecha = "12-12-12";
    Boolean obtenido = validador.validarFechaMaxima(fecha);
    assertTrue("fecha maxima", obtenido);
  }
}

