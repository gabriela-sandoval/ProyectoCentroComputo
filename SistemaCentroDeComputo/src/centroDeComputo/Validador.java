package centroDeComputo;

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
     * @param fecha a validar
     * @return true
     */
    public boolean validarEstructuraFecha(String fecha){
    final String REGEX_PARA_FECHA = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";
    patron = Pattern.compile(REGEX_PARA_FECHA);
    comparaPatron = patron.matcher(fecha);
    boolean resultadoEvaluacion= comparaPatron.find();
    return resultadoEvaluacion;
    }
    
    /**
     * valida que la fecha no se exceda de los parametros
     * @param fecha a evaluar
     * @return true
     */
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
    
    /**
     * 
     * @param requiereActualizacion
     * @return 
     */
    public String convertirBooleanoActualizacionAString(boolean requiereActualizacion) {
        String cadena= null;
        if(requiereActualizacion==true) {
            cadena = "si";
        }
        if(requiereActualizacion==false){
            cadena = "no";
        }
        return cadena;
    }
   
    /**
     * 
     * @param disponible
     * @return 
     */
    public String convertirBooleanoDisponibleAString(boolean disponible) {
        String cadena= null;
        if(disponible==true) {
            cadena = "si";
        }
        if(disponible==false){
            cadena = "no";
        }
        return cadena;
    }	
    
}
