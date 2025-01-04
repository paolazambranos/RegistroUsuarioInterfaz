package com.usuario.interfaz.usuariointerfaz;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class UsuarioController {
    private Stage stage;
    private Scene scene;
    public Button ingresarUsuarioButton;
    public Label correoInvalidoLabel;
    public Label usuarioInvalidoLabel;
    public Button volverMenuButton;

    public void ingresarUsuario(MouseEvent mouseEvent) {
    }

    public void volverMenu(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("main-menu.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
