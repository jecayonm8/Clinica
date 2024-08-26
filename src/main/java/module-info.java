module clinica.proyecto.clinica {
    requires javafx.controls;
    requires javafx.fxml;


    opens clinica.proyecto.clinica to javafx.fxml;
    exports clinica.proyecto.clinica;
    exports clinica.proyecto.clinica.exception;
    exports clinica.proyecto.clinica.model;
    exports clinica.proyecto.clinica.controller;
    opens clinica.proyecto.clinica.controller to javafx.fxml;
}