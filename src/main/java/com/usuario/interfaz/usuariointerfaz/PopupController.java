package com.usuario.interfaz.usuariointerfaz;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class PopupController implements IPopupController {

    @Override
    public Stage crearDialogCerrar() throws IOException {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        Scene scene = cargarScenaDialogoCerrar();
        dialog.setScene(scene);
        //Enventos del dialogo
        dialog.setOnCloseRequest(windowEvent -> Platform.exit());
        return dialog;
    }

    private Scene cargarScenaDialogoCerrar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("popup-cerrar.fxml"));
        return new Scene(fxmlLoader.load(), 420, 206);
    }
}
