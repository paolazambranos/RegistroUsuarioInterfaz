package com.usuario.interfaz.usuariointerfaz;

import com.usuario.logica.excepciones.FormatoInvalidoAliasException;
import com.usuario.logica.excepciones.FormatoInvalidoCorreoException;
import com.usuario.logica.excepciones.UsuarioExistenteException;
import com.usuario.logica.modelo.Usuario;
import com.usuario.logica.util.Escritor;
import com.usuario.logica.util.Lector;
import com.usuario.logica.util.Validar;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModificarEliminarUsuariosController {


    public Button volverMenuButton;
    public ListView<String> listaUsuarios;
    public Button volverListaButton;
    public Pane listaPanel;
    public Button guardarButton;
    public TextField aliasTextField;
    public TextField correoTextField;
    public Button eliminarUsuarioButton;
    public Pane modificarPanel;
    public Button modificarUsuarioButton;
    public Label mensajeError;
    public Label usuarioInvalidoLabel;
    public Label correoInvalidoLabel;
    public Label mensajeResultado;
    private Stage stage;
    private Scene scene;

    private String usuarioSeleccionado;
    private Usuario usuarioEncontrado;
    private List<Usuario> usuariosGuardados;

    public void initialize() {
        Lector lector = new Lector();
        usuariosGuardados = lector.obtenerUsuariosGuardados();
        cargarListaUsuarios(usuariosGuardados);

    }

    private void cargarListaUsuarios(List<Usuario> usuarios) {
        listaUsuarios.getItems().setAll(new ArrayList<>());
        for(Usuario usuario: usuarios){
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

    public void modificarUsuario(MouseEvent mouseEvent) throws IOException {
        //Limpiar interfaz
        mensajeError.setVisible(false);
        usuarioInvalidoLabel.setVisible(false);
        correoInvalidoLabel.setVisible(false);
        mensajeResultado.setVisible(false);

        //obteniendo usuario seleccionado
        usuarioSeleccionado = listaUsuarios.getSelectionModel().getSelectedItem();
        if(usuarioSeleccionado != null && !usuarioSeleccionado.isEmpty()) {
            usuarioEncontrado = getUsuarioEnUsuariosGuardados(usuarioSeleccionado);

            //asignar a cada label los datos de usuarioEncontrado
            if(usuarioEncontrado != null) {
                aliasTextField.setText(usuarioEncontrado.getAlias());
                correoTextField.setText(usuarioEncontrado.getCorreo());
                listaPanel.setVisible(false);
                modificarPanel.setVisible(true);
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

    private Usuario getUsuarioEnUsuariosGuardados(String usuarioSeleccionado) {
        String[] dataUsuario = usuarioSeleccionado.split(" - ");
        Usuario usuarioEnc = null;
        for (Usuario usuario : usuariosGuardados) {
            if (usuario.getCorreo().equalsIgnoreCase(dataUsuario[1])) {
                usuarioEnc = usuario;
                break;
            }
        }
        return usuarioEnc;
    }

    public void volverLista(MouseEvent mouseEvent) {
        listaPanel.setVisible(true);
        modificarPanel.setVisible(false);
    }

    public void guardarCambiosUsuario(MouseEvent mouseEvent) {
        //limpiarInterfaz
        mensajeResultado.setVisible(false);

        //obtener datos de los textfields
        String aliasNuevo = aliasTextField.getText();
        String correoNuevo = correoTextField.getText();
        //validar los datos
        validarDatosDeEntrada(correoNuevo, aliasNuevo);
        //guardar los datos
        actualizarUsuario(aliasNuevo, correoNuevo);
        cargarListaUsuarios(usuariosGuardados);

    }

    private void actualizarUsuario(String aliasNuevo, String correoNuevo) {
        //Actualizar usuario en lista
        for(Usuario usuarioGuardado: usuariosGuardados){
            if(usuarioGuardado.getCorreo().equalsIgnoreCase(usuarioEncontrado.getCorreo())){
                usuarioGuardado.setCorreo(correoNuevo);
                usuarioGuardado.setAlias(aliasNuevo);
            }
        }

        Escritor escritor = new Escritor();
        try {
            boolean exito = escritor.actualizarUsuarios(usuariosGuardados);
            if (exito) {
                mensajeResultado.setText("Usuario registrado con exito!");
                mensajeResultado.setVisible(true);
            }
        } catch (UsuarioExistenteException e) {
            mensajeResultado.setText(e.excUsuarioExistente());
            mensajeResultado.setVisible(true);
        }
    }

    private void validarDatosDeEntrada(String correo, String alias) {
        try {
            Validar validarObj = new Validar();
            validarObj.validarCorreo(correo);
        } catch (FormatoInvalidoCorreoException e) {
            correoInvalidoLabel.setVisible(true);
        }

        try{
            Validar validarObj = new Validar();
            validarObj.validarUsuario(alias);
        }catch (FormatoInvalidoAliasException e){
            usuarioInvalidoLabel.setVisible(true);
        }
    }

    public void eliminarUsuario(MouseEvent mouseEvent) {
        //limpiar interfaz
        mensajeError.setVisible(false);
        usuarioSeleccionado = listaUsuarios.getSelectionModel().getSelectedItem();
        if (usuarioSeleccionado != null && !usuarioSeleccionado.isEmpty()) {
            usuarioEncontrado = getUsuarioEnUsuariosGuardados(usuarioSeleccionado);
            if (usuarioEncontrado != null) {
                //eliminar usuario de lista
                boolean exito = eliminiarUsuarioDeLista(usuarioEncontrado);
                //eliminar usuario de archivo
                if(exito){
                    Escritor escritor = new Escritor();
                    try {
                        boolean exitoActualizacion = escritor.actualizarUsuarios(usuariosGuardados);
                        if (exitoActualizacion) {
                            mensajeError.setText("Usuario eliminado con exito!");
                            mensajeError.setVisible(true);
                            cargarListaUsuarios(usuariosGuardados);
                        }
                    } catch (UsuarioExistenteException e) {
                        mensajeError.setText(e.excUsuarioExistente());
                        mensajeError.setVisible(true);
                    }
                }
                //actualizar listview
            } else {
                mensajeError.setText("Usuario no encontrado");
                mensajeError.setVisible(true);
            }
        } else {

            mensajeError.setText("Usuario no seleccionado, por favor seleccione un usuario\"");
            mensajeError.setVisible(true);
        }
    }

    private boolean eliminiarUsuarioDeLista(Usuario usuarioEliminar) {
        boolean exito = false;
        boolean encontrado = false;
        int index = 0;
        for(Usuario usuarioGuardado: usuariosGuardados){
            if(usuarioGuardado.getCorreo().equalsIgnoreCase(usuarioEliminar.getCorreo())){
                encontrado = true;
                break;
            }
            index++;
        }
        if(encontrado){
            usuariosGuardados.remove(index);
            exito = true;
        }
        return exito;
    }

}
