package centroDeComputo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author irasema caicero
 */
public class Validador {
    private Pattern patron;
    private Matcher comparaPatron;
    
    public Validador() {
        patron = null;
        comparaPatron = null;
    }
    
    public boolean validaIdSoftware(String idSoftware) {
        String REGEX_PARA_NOMBRE = "(^S[0-9]{3}$)";
        patron = Pattern.compile(REGEX_PARA_NOMBRE);
        
        comparaPatron = patron.matcher(idSoftware);
        boolean resultado = comparaPatron.find();
        return resultado;
    }
    
    public boolean validarEstructuraFecha(String fecha){
    final String REGEX_PARA_FECHA = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";
    patron = Pattern.compile(REGEX_PARA_FECHA);
    comparaPatron = patron.matcher(fecha);
    boolean resultadoEvaluacion= comparaPatron.find();
    return resultadoEvaluacion;
    }
    
    public boolean validarFechaMaxima(String fecha){
    final int MES = 1;
    final int DIA = 2;
    final int MES_MAXIMO = 12;
    final int DIA_MAXIMO = 31;
    String [] fechaSeparada = fecha.split("-");
    int mes =Integer.parseInt(fechaSeparada[MES]);
    int dia = Integer.parseInt(fechaSeparada[DIA]);
    boolean resultadoEvaluacion = (mes <=  MES_MAXIMO && dia <= DIA_MAXIMO);  
    return resultadoEvaluacion;  
  }
    
}
