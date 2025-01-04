package com.usuario.logica.util;
import com.usuario.logica.excepciones.FormatoInvalidoAliasException;
import com.usuario.logica.excepciones.FormatoInvalidoCorreoException;
import com.usuario.logica.modelo.Usuario;

import java.util.LinkedList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validar {
    public Validar() {
    }

    //Valida que la estructura del correo sea valida
    private boolean validaExpresionRegularEmail(String email) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    //Valida que el correo sea valido
    public void validarCorreo(String correo) throws FormatoInvalidoCorreoException {
        if (!validaExpresionRegularEmail(correo))
            throw new FormatoInvalidoCorreoException();
    }

    //Validar que el usuario sea valido
    public void validarUsuario(String alias)throws FormatoInvalidoAliasException{
        if(alias == null || alias.isEmpty() || alias.length() < 3){
            throw new FormatoInvalidoAliasException();
        }


    }

    //Comprueba que el correo de un usuario nuevo no sea uno ya registrado
    public boolean comprobarCorreosIguales(String correo, LinkedList<Usuario> usuarios) {
        boolean validador = true;
        for (Usuario elemento : usuarios){
            if (Objects.equals(elemento.getCorreo(), correo)){
                validador = false;
                break;
            }
        }
        return validador;
    }

}

