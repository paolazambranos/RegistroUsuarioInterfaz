package com.usuario.logica.util;


import com.google.gson.Gson;
import com.usuario.logica.excepciones.UsuarioExistenteException;
import com.usuario.logica.modelo.Usuario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Esta clase se encarga de manejar los
 * objetos de tipo usuario en un arhcivo JSON
 *
 * @author Paola Zambrano
 * @version 1.0
 */
public class Escritor {
    File file = new File("../archivoRegistro.json");
    String nombreArchivo = file.getAbsolutePath();

    //Guarda los datos de los Usuarios en un JSON

    /**
     * Este metodo se encarga de agregar un nuevo usuario a un
     * archivo JSON, asegurandose de que no haya duplicados
     * basandose en el correo del usuario, y a su vez escribe los datos
     * en el JSON
     *
     * @param nuevoUsuario nuevo usuario que desea agregar
     * @return devuelve true si fue guardado con exito, falso si emite un error
     * @throws UsuarioExistenteException lanza una excepcion si detecta que el usuario ya existe
     */
    public boolean guardarUsuario(Usuario nuevoUsuario) throws UsuarioExistenteException {
        boolean exito;
        //Leer JSON actual
        Lector lector = new Lector();
        List<Usuario> usuariosGuardados = lector.obtenerUsuariosGuardados();
        //Verficar que no exista el usuario en el JSON actual
        boolean aptoParaGuardar = verificarExistencia(nuevoUsuario, usuariosGuardados);

        //Escribe lo datos en el JSON
        if(aptoParaGuardar) {
            exito = guardarUsuario(nuevoUsuario, usuariosGuardados);
        }
        else {
            throw new UsuarioExistenteException();
        }
        return exito;
    }

    /**
     *
     * Este metodo sobreescribi la lista de
     * usuarios almacenada en el archivo de los
     * JSON con una  nueva lista como parametro
     *
     * @param usuariosActualizar usuarios que se desean guardar en el archivo
     * @return devuelve true si fue sobreescrito con exito, falso si emite un error
     * @throws UsuarioExistenteException lanza una excepcion si detecta que el usuario ya existe
     */
    public boolean actualizarUsuarios(List<Usuario> usuariosActualizar) throws UsuarioExistenteException {
        return guardarUsuariosEnArchivo(usuariosActualizar);
    }

    /**
     * Este metodo agrega un nuevo usuario a la
     * lista de usuarios guardados
     *
     * @param nuevoUsuario nuevo usuario que desea agregar
     * @param usuariosGuardados usuarios que se han guardado anteriormente
     * @return devuelve verdadero si fue guardado con exito, falso si emite un error
     */
    private boolean guardarUsuario(Usuario nuevoUsuario, List<Usuario> usuariosGuardados) {
        //La primera vez no habran usuarios en el sistema y puede que la lista sea nula
        if(usuariosGuardados == null){
            usuariosGuardados = new ArrayList<>();
        }
        //Agregar usuario a la lista final
        usuariosGuardados.add(nuevoUsuario);
        boolean exito = guardarUsuariosEnArchivo(usuariosGuardados);
        return exito;
    }

    /**
     * Este metodo guarda la lista de usuarios
     * en un archivo JSON
     *
     * @param usuariosGuardados usuarios que se han guardado anteriormente
     * @return devuelve verdadero si el archivo se guardo con exito, falso si emite un error
     */
    private boolean guardarUsuariosEnArchivo(List<Usuario> usuariosGuardados) {
        boolean exito = false;
        try (FileWriter file = new FileWriter(nombreArchivo)) {
            Gson gson = new Gson();
            file.write(gson.toJson(usuariosGuardados));
            System.out.println("Archivos gruardados con exito!");
            exito = true;
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error para guardar los datos!");
        }
        return exito;
    }

    /**
     * Este metodo verifica si un nuevo usuarios
     * ya existe en la lista de usuarios guardados
     *
     * @param nuevoUsuario nuevo usuario que desea agregar
     * @param usuariosGuardados usuarios que se han guardado anteriormente
     * @return devuelve verdadero si el usuario no existe y es valido agregar, falso si el usuario ya existe y no debe agregarse
     */
    private static boolean verificarExistencia(Usuario nuevoUsuario, List<Usuario> usuariosGuardados) {
        boolean aptoParaGuardar = true;
        if(usuariosGuardados != null && !usuariosGuardados.isEmpty()) {
            for (Usuario usuarioGuardado : usuariosGuardados){
                if (usuarioGuardado.getCorreo().equalsIgnoreCase(nuevoUsuario.getCorreo())) {
                    aptoParaGuardar = false;
                    break;
                }
            }
        }
        return aptoParaGuardar;
    }



}
