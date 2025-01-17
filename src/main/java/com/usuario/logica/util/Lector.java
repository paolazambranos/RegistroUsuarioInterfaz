package com.usuario.logica.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.usuario.logica.modelo.Usuario;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * Esta clase tiene como proposito
 * leer los archivos JSON
 *
 * @author Paola zambrano
 * @version 1.0
 */
public class Lector {
    //Se encarga de leer el JSON

    /**
     * Este metodo se encarga de leer un archivo
     * JSON que contiene una lista de usuarios
     *
     * @return devuelve una lista de objetos tipo Usuario que son los datos leidos desde el JSON
     */
    public List<Usuario> obtenerUsuariosGuardados() {
        List<Usuario> usuarios;
        File file = new File("../archivoRegistro.json");
        String nombreArchivo = file.getAbsolutePath();
        try (Reader reader = new FileReader(nombreArchivo)) {
            Gson gson = new Gson();
            Type listUsuariosType = new TypeToken<List<Usuario>>(){}.getType ();
            usuarios = gson.fromJson (reader, listUsuariosType);
        } catch (IOException e) {
            throw new Error("Error reading JSON file");
        }
        return usuarios;
    }

}