package com.usuario.logica.excepciones;

/**
 *
 * Esta clase es una excepcion personalizada,
 * maneja los errores especificos relacionado
 * con el alias
 *
 * @author Paola Zambrano
 * @version 1.0
 */
public class FormatoInvalidoAliasException extends Throwable {
    public FormatoInvalidoAliasException(){
    }
    public String excFormatoInvalida(){return"El alias no es valido, intentelo de nuevo";}
}
