package com.usuario.logica.util;


import com.google.gson.Gson;
import com.usuario.logica.excepciones.UsuarioExistenteException;
import com.usuario.logica.modelo.Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Escritor {
    String nombreArchivo = "archivoRegistro.json";

    //Guarda los datos de los Usuarios en un JSON
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

    public boolean actualizarUsuarios(List<Usuario> usuariosActualizar) throws UsuarioExistenteException {
        return guardarUsuariosEnArchivo(usuariosActualizar);
    }

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
