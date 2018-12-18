package CentroComputo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * valida los tipos de estructura que requieren los campos idSoftware y fechas
 * 
 * @author irasema caicero
 * @since 16/12/2018
 * @version 1.0
 */
public class Validador {
  private Pattern patron;
  private Matcher comparaPatron;

  /**
   * constructor que inicializa el patron y para comparar
   */
  public Validador() {
    patron = null;
    comparaPatron = null;
  }

  /**
   * valida la estructura que debe tener un software
   * 
   * @param idSoftware a validar
   * @return true
   */
  public boolean validaIdSoftware(String idSoftware) {
    String REGEX_PARA_NOMBRE = "(^S[0-9]{3}$)";
    patron = Pattern.compile(REGEX_PARA_NOMBRE);

    comparaPatron = patron.matcher(idSoftware);
    boolean resultado = comparaPatron.find();
    return resultado;
  }

  /**
   * valida el id del hardware
   * 
   * @param numeroInventario a evaluar
   * @return true
   */
  public boolean validarNoInventarioHardware(String numeroInventario) {
    String REGEX_PARA_NOMBRE = "(^H[0-9]{3}$)";
    patron = Pattern.compile(REGEX_PARA_NOMBRE);

    comparaPatron = patron.matcher(numeroInventario);
    boolean resultado = comparaPatron.find();
    return resultado;
  }

  /**
   * valida el formato que debe tener una fecha
   * 
   * @param fecha a validar
   * @return true
   */
  public boolean validarEstructuraFecha(String fecha) {
    final String REGEX_PARA_FECHA = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";
    patron = Pattern.compile(REGEX_PARA_FECHA);
    comparaPatron = patron.matcher(fecha);
    boolean resultadoEvaluacion = comparaPatron.find();
    return resultadoEvaluacion;
  }

  /**
   * valida que la fecha no se exceda de los parametros
   * 
   * @param fecha a evaluar
   * @return true
   */
  public boolean validarFechaMaxima(String fecha) {
    final int MES = 1;
    final int DIA = 2;
    final int ANIO = 1;
    final int MES_MAXIMO = 12;
    final int DIA_MAXIMO = 31;
    final int ANIO_MAXIMO = 2018;
    String[] fechaSeparada = fecha.split("-");
    int mes = Integer.parseInt(fechaSeparada[MES]);
    int dia = Integer.parseInt(fechaSeparada[DIA]);
    int anio = Integer.parseInt(fechaSeparada[ANIO]);
    boolean resultadoEvaluacion = (anio <= ANIO_MAXIMO && mes <= MES_MAXIMO && dia <= DIA_MAXIMO);
    return resultadoEvaluacion;
  }
  
  public boolean validarNumeroSerie(String numeroSerie) {
      final String REGEX_PARA_NUMSERIE = "^[0-9]{1,}";
      patron = Pattern.compile(REGEX_PARA_NUMSERIE);
      comparaPatron = patron.matcher(numeroSerie);
      boolean resultado = comparaPatron.find();
      
      return resultado;
  }
 

  /**
   * 
   * @param requiereActualizacion
   * @return
   */
  public String convertirActualizacionAString(boolean requiereActualizacion) {
    String cadena = null;
    if (requiereActualizacion == true) {
      return cadena = "si";
    }
    if (requiereActualizacion == false);
      return cadena = "no";
  }

  /**
   * 
   * @param disponible
   * @return
   */
  public String convertirDisponibleAString(boolean disponible) {
    String cadena = null;
    if (disponible == true) {
      return cadena = "si";
    }
    if (disponible == false); 
      return cadena = "no";
  }
}
