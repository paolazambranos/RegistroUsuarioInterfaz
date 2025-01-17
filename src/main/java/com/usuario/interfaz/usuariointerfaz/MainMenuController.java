package com.usuario.interfaz.usuariointerfaz;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Esta clase se encarga de las escenas
 * de cada opcion del menu principal
 *
 * @author Paola Zambrano
 * @version 1.0
 */
public class MainMenuController {
    public Button modificarEliminarUsuarioButton;
    private Stage stage;
    private Scene scene;
    public Button crearUsuarioButton;
    public Button mostrarUsuarioButton;
    public Button salirUsuarioButton;

    /**
     * Este metodo se encarga de levantar y mostrar la escena
     * de crear usuario
     *
     * @param mouseEvent interactua con el raton, hace funciones como clic
     * @throws IOException lanza una excepcion si hay problema al cargar la escena crear-modificar-usuario.fxml
     */
    public void crearUsuario(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("crear-modificar-usuario.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();


    }

    /**
     *
     * Este metodo se encarga de levantar y mostrar la escena
     * de modificar-eliminar usuario
     *
     * @param mouseEvent interactua con el raton, hace funciones como clic
     * @throws IOException lanza una excepcion si hay problema al cargar la escena modificar-eliminar-usuarios.fxml
     */
    public void modificarEliminarUsuario(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("modificar-eliminar-usuarios.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
    /**
     *
     * Este metodo se encarga de levantar y
     * mostrar la escena de mostrar usuario
     *
     *
     * @param mouseEvent interactua con el raton, hace funciones como clic
     * @throws IOException lanza una excepcion si hay problema al cargar la escena lista-usuarios.fxml
     */
    public void mostarUsuario(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("lista-usuarios.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Este metodo se encarga de mostrar un dialogo que informa
     * al usuario que los datos han sido guardados y se despide
     *
     * @param mouseEvent interactua con el raton, hace funciones como clic
     * @throws IOException lanza una excepcion si hay problema al cargar la escena
     */
    public void salirUsuario(MouseEvent mouseEvent) throws IOException {
        IPopupController iPopupController = new PopupController();
        final Stage dialog = iPopupController.crearDialogCerrar();
        dialog.show();
    }

    /**
     * Este metodo cierra la ventana total de la aplicacion
     *
     * @param mouseEvent interactua con el raton, hace funciones como clic
     */
    public void cerrarApp(MouseEvent mouseEvent) {
        Platform.exit();
    }
}
