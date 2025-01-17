package com.usuario.logica.util;
import com.usuario.logica.excepciones.FormatoInvalidoAliasException;
import com.usuario.logica.excepciones.FormatoInvalidoCorreoException;
import com.usuario.logica.modelo.Usuario;

import java.util.LinkedList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Esta clase se encarga de validar
 * los datos de los usuarios
 *
 * @author Paola Zambrano
 * @version 1.0
 */
public class Validar {
    public Validar() {
    }

    //Valida que la estructura del correo sea valida

    /**
     * Este metodo se encarga de validar
     * la estructura del correo del usuario
     *
     * @param email correo a validar
     * @return devuelve verdadero si cumple con el patron de la expresion, falso si no cumple
     */
    private boolean validaExpresionRegularEmail(String email) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    //Valida que el correo sea valido

    /**
     * Este metodo se encarga de validar
     * que el correo cumpla con los requisitos
     *
     * @param correo correo del usuario
     * @throws FormatoInvalidoCorreoException lanza una excepcion si el correo es invalido
     */
    public void validarCorreo(String correo) throws FormatoInvalidoCorreoException {
        if (!validaExpresionRegularEmail(correo))
            throw new FormatoInvalidoCorreoException();
    }

    //Validar que el usuario sea valido

    /**
     * Este metodo se encarga de validar
     * que el alias cumpla con los requisitos
     *
     * @param alias alias del usuario
     * @throws FormatoInvalidoAliasException lanza una excepcion si el alias es imvalido
     */
    public void validarUsuario(String alias)throws FormatoInvalidoAliasException{
        if(alias == null || alias.isEmpty() || alias.length() < 3){
            throw new FormatoInvalidoAliasException();
        }


    }

    //Comprueba que el correo de un usuario nuevo no sea uno ya registrado

    /**
     * Esta metodo se encarga de comprobar
     * si al ingresar un nuevo usuario el
     * correo ya existe
     *
     * @param correo correo que se desea comprobar
     * @param usuarios lista de usuarios ya registrados
     * @return devuleve verdadero si el correo no esta en la lista (es unico), falso si ya existe (duplicado)
     */
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

