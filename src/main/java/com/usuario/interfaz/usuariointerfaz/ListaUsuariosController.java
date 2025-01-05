package com.usuario.interfaz.usuariointerfaz;

import com.usuario.logica.modelo.Usuario;
import com.usuario.logica.util.Lector;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ListaUsuariosController {


    public Button verDetallesUsuarioButton;
    public Button volverMenuButton;
    public ListView<String> listaUsuarios;
    public Pane detallesPanel;
    public Button volverListaButton;
    public Pane listaPanel;
    public Label aliasValor;
    public Label correoValor;
    public Label puntosTotalesValor;
    public Label horasJugadasValor;
    public Label palabrasTotalesValor;
    public Label mensajeError;
    private Stage stage;
    private Scene scene;

    private String usuarioSeleccionado;
    private List<Usuario> usuariosGuardados;

    public void initialize() {
        Lector lector = new Lector();
        usuariosGuardados = lector.obtenerUsuariosGuardados();
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

    public void verDetallesUsuario(MouseEvent mouseEvent) throws IOException {
        //Limpiar interfaz
        mensajeError.setVisible(false);

        //obteniendo usuario seleccionado
        usuarioSeleccionado = listaUsuarios.getSelectionModel().getSelectedItem();
        if(usuarioSeleccionado != null && !usuarioSeleccionado.isEmpty()) {
            Usuario usuarioEncontrado = getUsuarioEnUsuariosGuardados();

            //asignar a cada label los datos de usuarioEncontrado
            if(usuarioEncontrado != null) {
                aliasValor.setText(usuarioEncontrado.getAlias());
                correoValor.setText(usuarioEncontrado.getCorreo());
                puntosTotalesValor.setText(String.valueOf(usuarioEncontrado.getPuntosTotales()));
                horasJugadasValor.setText(String.valueOf(usuarioEncontrado.getHorasJugadas()));
                palabrasTotalesValor.setText(String.valueOf(usuarioEncontrado.getCantidadDePalabras()));
                listaPanel.setVisible(false);
                detallesPanel.setVisible(true);
            }else{
                mensajeError.setText("Usuario no encontrado");
                mensajeError.setVisible(true);
            }
        }
        else{

            mensajeError.setText("Usuario no seleccionado, por favor seleccione un usuario\"");
            mensajeError.setVisible(true);
        }



    }

    private Usuario getUsuarioEnUsuariosGuardados() {
        String[] dataUsuario = usuarioSeleccionado.split(" - ");
        Usuario usuarioEncontrado = null;
        for (Usuario usuario : usuariosGuardados) {
            if (usuario.getCorreo().equalsIgnoreCase(dataUsuario[1])) {
                usuarioEncontrado = usuario;
                break;
            }
        }
        return usuarioEncontrado;
    }

    public void volverLista(MouseEvent mouseEvent) {
        listaPanel.setVisible(true);
        detallesPanel.setVisible(false);
    }
}
