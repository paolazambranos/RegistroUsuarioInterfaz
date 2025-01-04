package com.usuario.interfaz.usuariointerfaz;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

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

    /**
     * Este evento mostrara un dialogo que informa
     * al usuario que los datos han sido guardados y se despide
     * @param mouseEvent
     * @throws IOException
     */
    public void salirUsuario(MouseEvent mouseEvent) throws IOException {
        IPopupController iPopupController = new PopupController();
        final Stage dialog = iPopupController.crearDialogCerrar();
        dialog.show();
    }

    public void cerrarApp(MouseEvent mouseEvent) {
        Platform.exit();
    }
}
