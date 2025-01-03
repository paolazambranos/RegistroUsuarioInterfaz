package com.usuario.interfaz.usuariointerfaz;

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

    public void salirUsuario(MouseEvent mouseEvent) throws IOException {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("popup-cerrar.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 420, 206);
        dialog.setScene(scene);
        dialog.show();
    }
}
