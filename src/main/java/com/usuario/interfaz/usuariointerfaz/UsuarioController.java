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

    public void ingresarUsuario(MouseEvent mouseEvent) {
        limpiarInterfaz();

        //Tomar los datos de los campos (alias y correo)
        String alias = aliasTextField.getText();
        String correo = correoTextField.getText();

        //Validar los campos correo
        validarDatosDeEntrada(correo, alias);

        guardarUsuario(alias, correo);

    }

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

    private void limpiarInterfaz() {
        correoInvalidoLabel.setVisible(false);
        usuarioInvalidoLabel.setVisible(false);
        mensajeResultado.setVisible(false);
    }

    public void volverMenu(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("main-menu.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
