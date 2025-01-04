package com.usuario.logica.util;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.usuario.logica.excepciones.UsuarioExistenteException;
import com.usuario.logica.modelo.Usuario;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Escritor {
    String nombreArchivo = "archivoRegistro.json";

    //Guarda los datos de los Usuarios en un JSON
    public boolean guardarUsuario(Usuario nuevoUsuario) throws UsuarioExistenteException {
        boolean exito;
        //Leer JSON actual
        Gson gson = new Gson ();
        List<Usuario> usuariosGuardados = obtenerUsuariosGuardados(gson);
        //Verficar que no exista el usuario en el JSON actual
        boolean aptoParaGuardar = verificarExistencia(nuevoUsuario, usuariosGuardados);

        //Escribe lo datos en el JSON
        if(aptoParaGuardar) {

            exito = guardarUsuarioEnArchivo(nuevoUsuario, usuariosGuardados, gson);
        }
        else {
            throw new UsuarioExistenteException();
        }
        return exito;
    }

    private boolean guardarUsuarioEnArchivo(Usuario nuevoUsuario, List<Usuario> usuariosGuardados, Gson gson) {
        boolean exito = false;
        //La primera vez no habran usuarios en el sistema y puede que la lista sea nula
        if(usuariosGuardados == null){
            usuariosGuardados = new ArrayList<>();
        }
        //Agregar usuario a la lista final
        usuariosGuardados.add(nuevoUsuario);
        try (FileWriter file = new FileWriter(nombreArchivo)) {
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

    private List<Usuario> obtenerUsuariosGuardados(Gson gson) {
        List<Usuario> usuarios;
        try (Reader reader = new FileReader(nombreArchivo)) {
            Type listUsuariosType = new TypeToken<List<Usuario>>(){}.getType ();
            usuarios = gson.fromJson (reader, listUsuariosType);
        } catch (IOException e) {
            throw new Error("Error reading JSON file");
        }
        return usuarios;
    }

}
