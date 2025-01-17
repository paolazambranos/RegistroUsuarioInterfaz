package com.usuario.logica.excepciones;

/**
 * Esta clase es una excepcion personalizada,
 * maneja los errores especificos relacionado
 * con el correo
 *
 * @author Paola Zambrano
 * @version 1.0
 */
public class FormatoInvalidoCorreoException extends Throwable{
    public FormatoInvalidoCorreoException() {
    }
    //Maneja las excepciones de cuando el correo no es valido
    public String excFormatoInvalida(){
        return "El correo no es valido, intentelo de nuevo";
    }
}
