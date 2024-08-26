package clinica.proyecto.clinica;

import clinica.proyecto.clinica.controller.ClinicaController;
import clinica.proyecto.clinica.model.Clinica;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Aplication extends Application {

    private Stage primarystage;
    private Clinica clinica;


    @Override
    public void start(Stage primarystage) throws IOException {
        this.primarystage = primarystage;
        this.clinica = new Clinica();

        mostrarVentanaPrincipal();
    }

    private void mostrarVentanaPrincipal() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplication.class.getResource("/clinica/proyecto/clinica/ventana.fxml"));
            AnchorPane anchorPane = (AnchorPane) loader.load();
            ClinicaController clinicaController = loader.getController();
            clinicaController.setAplication(this);
            Scene scene = new Scene(anchorPane);
            primarystage.setScene(scene);
            primarystage.show();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public Stage getPrimarystage() {
        return primarystage;
    }

    public void setPrimarystage(Stage primarystage) {
        this.primarystage = primarystage;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public static void main(String[] args) {

        launch(args);
    }


}