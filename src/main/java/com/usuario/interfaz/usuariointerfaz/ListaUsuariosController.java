package com.usuario.interfaz.usuariointerfaz;

import com.usuario.logica.modelo.Usuario;
import com.usuario.logica.util.Lector;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ListaUsuariosController {


    public Button verDetallesUsuarioButton;
    public Button volverMenuButton;
    public ListView listaUsuarios;
    private Stage stage;
    private Scene scene;

    public void initialize() {
        Lector lector = new Lector();
        List<Usuario> usuariosGuardados = lector.obtenerUsuariosGuardados();
        for(Usuario usuario: usuariosGuardados){
            listaUsuarios.getItems().add(usuario.getAlias()+" - "+usuario.getCorreo());
        }

    }

    public void volverMenu(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("main-menu.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void verDetallesUsuario(MouseEvent mouseEvent) {
    }
}
