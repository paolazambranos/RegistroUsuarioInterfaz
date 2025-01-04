module com.usuario.interfaz.usuariointerfaz {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    opens com.usuario.interfaz.usuariointerfaz to javafx.fxml;
    opens com.usuario.logica.modelo to com.google.gson;
    exports com.usuario.interfaz.usuariointerfaz;
}