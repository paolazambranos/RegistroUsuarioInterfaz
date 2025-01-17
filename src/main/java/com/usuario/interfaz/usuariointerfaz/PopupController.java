package com.usuario.interfaz.usuariointerfaz;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Esta clase implementa la interfaz IPopupController
 * y sirve para crear y configurar un cuadro de dialogo
 * que aparece para cerrar la aplicacion
 *
 * @author Paola Zambrano
 * @version 1.0
 */
public class PopupController implements IPopupController {

    /**
     * Este metodo configura el cuadro del dialogo
     * que se va a mostrar encima del la aplicacion
     * que tiene como objetivo cerrarla
     *
     * @return el cuadro del dialogo
     * @throws IOException lanza una excepcion si se encuentras fallas en las operaciones de entrada/salida
     */
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

    /**
     * Este metodo carga un archivo FXML
     * que define el cuadro del dialogo
     * y crea una nueva escena
     *
     *
     * @return el diseño de la escena, es decir, el cuadro del dialogo
     * @throws IOException lanzara una excepcion si encuentra un error en la carga de archivo
     */
    private Scene cargarScenaDialogoCerrar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("popup-cerrar.fxml"));
        return new Scene(fxmlLoader.load(), 420,206);
    }
}
