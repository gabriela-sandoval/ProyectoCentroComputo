package ccExcepciones;

/**
 * excepcion creada para reportar un error en la operacion con la data base
 * 
 * @author Irasema Caicero
 * @since 10/12/2018
 * @version 1.0
 */

public class ErrorOperacionDB extends Exception {
    public ErrorOperacionDB(String mensaje){
        super(mensaje);
    }
    
}
