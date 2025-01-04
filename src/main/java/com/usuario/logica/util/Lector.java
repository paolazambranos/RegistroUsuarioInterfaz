package com.usuario.logica.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.usuario.logica.modelo.Usuario;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class Lector {
    String nombreArchivo = "archivoRegistro.json";
    //Se encarga de leer el JSON
   public List<Usuario> obtenerUsuariosGuardados() {
        List<Usuario> usuarios;
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