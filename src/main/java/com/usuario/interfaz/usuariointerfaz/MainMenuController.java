package com.usuario.interfaz.usuariointerfaz;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
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
        final Stage dialog = crearDialogCerrar();
        dialog.show();
    }

    public void cerrarApp(MouseEvent mouseEvent) {
        Platform.exit();
    }

    private static Stage crearDialogCerrar() throws IOException {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        Scene scene = cargarScenaDialogoCerrar();
        dialog.setScene(scene);
        //Enventos del dialogo
        dialog.setOnCloseRequest(windowEvent -> Platform.exit());
        return dialog;
    }

    private static Scene cargarScenaDialogoCerrar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("popup-cerrar.fxml"));
        return new Scene(fxmlLoader.load(), 420, 206);
    }
}
