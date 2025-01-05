package com.usuario.interfaz.usuariointerfaz;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {
    public Button modificarEliminarUsuarioButton;
    private Stage stage;
    private Scene scene;
    public Button crearUsuarioButton;
    public Button mostrarUsuarioButton;
    public Button salirUsuarioButton;

    public void crearUsuario(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("crear-modificar-usuario.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void modificarEliminarUsuario(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("modificar-eliminar-usuarios.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void mostarUsuario(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("lista-usuarios.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
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
