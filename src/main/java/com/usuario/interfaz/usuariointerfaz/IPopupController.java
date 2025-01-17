package com.usuario.interfaz.usuariointerfaz;

import javafx.stage.Stage;

import java.io.IOException;
/**
 * Esta interfaz define la creacion de
 * los cuadros del dialogo
 */
public interface IPopupController {
    Stage crearDialogCerrar() throws IOException;
}