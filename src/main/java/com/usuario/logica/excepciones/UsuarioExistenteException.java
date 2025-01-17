package com.usuario.logica.excepciones;


/**
 *
 * Esta clase es una excepcion personalizada,
 * maneja los errores especificos relacionado
 * cuando se intenta registrar un usuario ya existente
 *
 * @author Paola Zambrano
 * @version 1.0
 */
public class UsuarioExistenteException extends Throwable {
    public UsuarioExistenteException(){
    }
    public String excUsuarioExistente(){return"El usuario ya existe";}
}
