module com.usuario.interfaz.usuariointerfaz {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    opens com.usuario.interfaz.usuariointerfaz to javafx.fxml;
    exports com.usuario.interfaz.usuariointerfaz;
}