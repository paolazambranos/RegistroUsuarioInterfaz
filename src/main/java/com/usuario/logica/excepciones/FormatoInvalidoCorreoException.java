package com.usuario.logica.excepciones;

public class FormatoInvalidoCorreoException extends Throwable{
    public FormatoInvalidoCorreoException() {
    }
    //Maneja las excepciones de cuando el correo no es valido
    public String excFormatoInvalida(){
        return "El correo no es valido, intentelo de nuevo";
    }
}
