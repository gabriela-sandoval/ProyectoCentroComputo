package ccExcepciones;

/**
 * excepcion para reportar que no existe un registro
 * 
 * @author Irasema Caicero
 * @since 10/12/2018
 * @version 1.0
 */
public class NoExisteRegistroException extends Exception {
    public NoExisteRegistroException(String mensaje) {
        super(mensaje);        
    }
    
}
