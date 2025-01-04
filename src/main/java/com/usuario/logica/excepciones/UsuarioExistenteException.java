package com.usuario.logica.excepciones;

public class UsuarioExistenteException extends Throwable {
    public UsuarioExistenteException(){
    }
    public String excUsuarioExistente(){return"El usuario ya existe";}
}
