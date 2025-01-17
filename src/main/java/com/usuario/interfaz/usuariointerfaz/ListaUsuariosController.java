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

/**
 *
 * Esta clase representa la lista de los usuarios,
 * muestra los detalles de cada usuario como:
 * EL alias
 * El correo
 * Los puntos totales
 * Las horas jugadas
 * Y las palabras que ha ingresado en el tablero
 *
 * @author Paola Zambrano
 * @version 1.0
 *
 */
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
    public Pane mainPane;
    private Stage stage;
    private Scene scene;

    private String usuarioSeleccionado;
    private List<Usuario> usuariosGuardados;

    /**
     *
     * Este metodo carga una lista de usuarios mediante el objeto lector,
     * recorre la lista y formatea cada usuario como:
     * Alias-Correo y lo agrega a listaUsuarios
     *
     */
    public void initialize() {
        Lector lector = new Lector();
        usuariosGuardados = lector.obtenerUsuariosGuardados();
        for(Usuario usuario: usuariosGuardados){
            listaUsuarios.getItems().add(usuario.getAlias()+" - "+usuario.getCorreo());
        }

    }

    /**
     *
     * Esta metodo cambia la escena actual de la
     * aplicacion por la escena del menu principal
     *
     * @param mouseEvent interactua con el raton, hace funciones como clic
     * @throws IOException lanza una excepcion si hay problema al cargar el archivo main-menu.fxml
     */
    public void volverMenu(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("main-menu.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    /**
     *
     * Este metodo muestra los detalles del usuario seleccionado,
     * actualiza los datos del usuario o mensajes de error
     * si no se encuentra o no se ha seleccionado un usuario
     *
     * @param mouseEvent interactua con el raton, hace funciones como clic
     * @throws IOException lanza una excepcion si hay problema al cargar los datos
     */
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
                horasJugadasValor.setText(String.valueOf(usuarioEncontrado.getHorasJugadas()) + ":" + String.valueOf(usuarioEncontrado.getMinutosJugados()) + ":" + String.valueOf(usuarioEncontrado.getSegundosJugados()));
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

    /**
     *
     * Este metodo busca en la lista de usuarios guardados
     * un usuario en especifico cuyo correo coincida con el
     * correo del usuario seleccionado
     *
     * @return devuleve el usuario encontrado o null si no lo encuentra
     */
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

    /**
     *
     * Este metodo devuelve la escena donde muestra
     * la lista de usuarios
     *
     * @param mouseEvent interactua con el raton, hace funciones como clic
     */
    public void volverLista(MouseEvent mouseEvent) {
        listaPanel.setVisible(true);
        detallesPanel.setVisible(false);
    }


}
