package com.usuario.interfaz.usuariointerfaz;

import com.usuario.logica.excepciones.FormatoInvalidoAliasException;
import com.usuario.logica.excepciones.FormatoInvalidoCorreoException;
import com.usuario.logica.excepciones.UsuarioExistenteException;
import com.usuario.logica.modelo.Usuario;
import com.usuario.logica.util.Escritor;
import com.usuario.logica.util.Validar;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 * Esta clase se encarga de recibir y validar los
 * datos ingresados por los usuarios y gestionar
 * el registro de nuevos usuarios
 *
 * @author Paola Zambrano
 * @version 1.0
 *
 */
public class UsuarioController {
    public TextField aliasTextField;
    public TextField correoTextField;
    public Button ingresarUsuarioButton;
    public Label correoInvalidoLabel;
    public Label usuarioInvalidoLabel;
    public Button volverMenuButton;
    public Label mensajeResultado;

    private Stage stage;
    private Scene scene;

    /**
     * Este metodo se encarga de obetenr los datos
     * como alias y correo, si son validos procede
     * a registrarlos en el sistema
     *
     * @param mouseEvent interactua con el raton, hace funciones como clic
     */
    public void ingresarUsuario(MouseEvent mouseEvent) {
        limpiarInterfaz();

        //Tomar los datos de los campos (alias y correo)
        String alias = aliasTextField.getText();
        String correo = correoTextField.getText();

        //Validar los campos correo

        if(validarDatosDeEntrada(correo, alias)){
            guardarUsuario(alias, correo);
        }


    }

    /**
     * Este metodo conecta la logica con la interfaz grafica
     * al intentar registrar un nuevo usuario, valida si se
     * ha guardado con exito o no
     *
     * @param alias es el alias ingresado por el usuario
     * @param correo es el correo ingresado por el usuario
     */
    private void guardarUsuario(String alias, String correo) {
        Usuario usuario = new Usuario(alias, correo);
        Escritor escritor = new Escritor();
        try {
            boolean exito = escritor.guardarUsuario(usuario);
            if (exito) {
                mensajeResultado.setText("Usuario registrado con exito!");
                mensajeResultado.setVisible(true);
            }
        } catch (UsuarioExistenteException e) {
            mensajeResultado.setText(e.excUsuarioExistente());
            mensajeResultado.setVisible(true);
        }
    }
//validar datos de entradas

    /**
     * Este metodo valida los datos ingresados por
     * el usuario, asegurando de que sean correctos
     *
     * @param correo es el correo ingresado por el usuario
     * @param alias es el alias ingresado por el usuario
     * @return devuelve verdadero si el correo es valido
     *
     */
    private boolean validarDatosDeEntrada(String correo, String alias) {
        boolean validar = false;
        try {
            Validar validarObj = new Validar();
            validarObj.validarCorreo(correo);
            validar = true;
        } catch (FormatoInvalidoCorreoException e) {
            correoInvalidoLabel.setVisible(true);
        }

        try {
            Validar validarObj = new Validar();
            validarObj.validarUsuario(alias);
        } catch (FormatoInvalidoAliasException e) {
            usuarioInvalidoLabel.setVisible(true);
        }

        return validar;
    }

    /**
     * Este metodo restablece el estado de la
     * interfaz grafica a su estado inicial al
     * ocultar cualquier mensaje
     */
    private void limpiarInterfaz() {
        correoInvalidoLabel.setVisible(false);
        usuarioInvalidoLabel.setVisible(false);
        mensajeResultado.setVisible(false);
    }

    /**
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
}
