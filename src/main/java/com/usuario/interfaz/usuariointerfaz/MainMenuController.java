package com.usuario.interfaz.usuariointerfaz;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MainMenuController {
    public Button crearUsuarioButton;
    public Button modificarDatoButton;
    public Button mostrarUsuarioButton;
    public Button eliminarUsuarioButton;
    public Button salirUsuarioButton;

    public void crearUsuario(MouseEvent mouseEvent) {
        System.out.println("Crear usuario click");
    }

    public void modificarDato(MouseEvent mouseEvent) {
        System.out.println("Modificar dato click");
    }

    public void mostarUsuario(MouseEvent mouseEvent) {
        System.out.println("Mostrar usuario click");
    }

    public void eliminarUsuario(MouseEvent mouseEvent) {
        System.out.println("Eliminar usuario click");
    }

    public void salirUsuario(MouseEvent mouseEvent) {
        System.out.println("Salir click");
    }
}
