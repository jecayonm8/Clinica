package clinica.proyecto.clinica.controller;

import java.net.URL;
import java.util.ResourceBundle;

import clinica.proyecto.clinica.Aplication;
import clinica.proyecto.clinica.exception.PacienteException;
import clinica.proyecto.clinica.model.Cita;
import clinica.proyecto.clinica.model.Clinica;
import clinica.proyecto.clinica.model.Paciente;
import javafx.beans.binding.ListBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ClinicaController {

    ObservableList<Paciente> listaPaciente = FXCollections.observableArrayList();
    ObservableList<Cita> listaCita = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarEmpleado;

    @FXML
    private Button btnAgregarCita;

    @FXML
    private Button btnEliminarCita;

    @FXML
    private Button btnEliminarPaciente;

    @FXML
    private Button btnNuevaCita;

    @FXML
    private Button bttnActualizarPaciente;

    @FXML
    private Button bttnCrearPaciente;

    @FXML
    private Button bttnNUevoPaciente;

    @FXML
    private ChoiceBox<Enum> chxTipoCita;

    @FXML
    private TableColumn<Cita, String> clmCedulaCita;

    @FXML
    private TableColumn<Paciente, String> clmCedulaPaciente;

    @FXML
    private TableColumn<Cita, String> clmCodigoCita;

    @FXML
    private TableColumn<Paciente, String> clmCorreoPaciente;

    @FXML
    private TableColumn<Cita, String> clmFechaCita;

    @FXML
    private TableColumn<Cita, String> clmHoraCita;

    @FXML
    private TableColumn<Paciente, String> clmNombrePaciente;

    @FXML
    private TableColumn<Paciente, String> clmTelefonoPaciente;

    @FXML
    private TableColumn<Cita, Enum> clmTipoCita;

    @FXML
    private TableColumn<Paciente, String> clmTipoSangrePaciente;

    @FXML
    private Tab tabCita;

    @FXML
    private Tab tabPaciente;

    @FXML
    private TableView<Cita> tblCita;

    @FXML
    private TableView<Paciente> tblPaciente;

    @FXML
    private TextField txtCedulaCita;

    @FXML
    private TextField txtCedulaPaciente;

    @FXML
    private TextField txtCodigoCita;

    @FXML
    private TextField txtCorreoPaciente;

    @FXML
    private TextField txtHoraCita;

    @FXML
    private TextField txtFechaCita;

    @FXML
    private TextField txtNombrePaciente;

    @FXML
    private TextField txtSangrePaciente;

    @FXML
    private TextField txtTelefonoPaciente;

    Paciente pacienteSeleccionado;
    private Aplication aplication;
    private Clinica clinica;


    @FXML
    void actualizarCitaEvent(ActionEvent event) {

    }

    @FXML
    void actualizarPacienteEvent(ActionEvent event) throws PacienteException {
        actualizarPacienteAction();
    }

    private void actualizarPacienteAction() throws PacienteException {

        String nombre = txtNombrePaciente.getText();
        String cedula = txtCedulaPaciente.getText();
        String telefono = txtTelefonoPaciente.getText();
        String correo = txtCorreoPaciente.getText();
        String tipoSangre = txtSangrePaciente.getText();

        if (datosPacienteValidos(nombre,cedula, telefono, correo, tipoSangre)){

            Paciente paciente = new Paciente(nombre, cedula, telefono, correo, tipoSangre);
            if (clinica.verificarPacienteExistente(cedula)){
                clinica.actualizarPaciente(paciente);
                mostrarMensaje("Notificacion administrador", "Paciente actualizado", "El Paciente se ha actualizado con exito", Alert.AlertType.INFORMATION);
                limpiarCamposPaciente();
                tblPaciente.refresh();
            }else{
                mostrarMensaje("Notificacion Administrador", "Paciente existe", "El Paciente no se ha actualizado", Alert.AlertType.ERROR);

            }
        }else{
            mostrarMensaje("Notificacion Administrador", "Datos invalidos", "El Paciente no se ha actualizado", Alert.AlertType.ERROR);


        }
    }

    @FXML
    void agregarCitaEvent(ActionEvent event) {

    }

    @FXML
    void crearPacienteEvent(ActionEvent event) throws PacienteException {
        crearPacienteAction();
    }

    private void crearPacienteAction() throws PacienteException {

        String nombre = txtNombrePaciente.getText();
        String cedula = txtCedulaPaciente.getText();
        String telefono = txtTelefonoPaciente.getText();
        String correo = txtCorreoPaciente.getText();
        String tipoSangre = txtSangrePaciente.getText();

        if(datosPacienteValidos(nombre, cedula, telefono, correo, tipoSangre)){

            Paciente paciente  = new Paciente(nombre, cedula, telefono, correo, tipoSangre);
            if(!clinica.verificarPacienteExistente(cedula)){
                clinica.crearPaciente(paciente);
                listaPaciente.add(paciente);
                mostrarMensaje("Notificacion Administrador", "Datos Validos", "Paciente registrado", Alert.AlertType.INFORMATION);
                limpiarCamposPaciente();
            }else{
                mostrarMensaje("Notificacion Administrador", "Datos Validos", "Paciente existente", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificacion Administrador", "Datos invalidos", "El paciente no fue registrado", Alert.AlertType.ERROR);
        }
    }

    private boolean datosPacienteValidos(String nombre, String cedula, String telefono, String correo, String tipoSangre) {

        String mensaje="";
        if(nombre == null || nombre.equals(""))
            mensaje = "No se ha ingresado el nombre del Paciente";
        if(cedula == null || cedula.equals(""))
            mensaje = "No se ha ingresado la cedula del Paciente";
        if(telefono == null || telefono.equals(""))
            mensaje = "No se ha ingresado el telefono del Paciente";
        if(correo == null || correo.equals(""))
            mensaje = "No se ha ingresado el correo del Paciente";
        if(tipoSangre == null || tipoSangre.equals(""))
            mensaje = "No se ha ingresado el tipo de sangre del Paciente";

        if( mensaje == "")
            return true;

        return false;
    }

    @FXML
    void eliminarCitaEvent(ActionEvent event) {

    }

    @FXML
    void eliminarPacienteEvent(ActionEvent event) throws PacienteException {
        eliminarPacienteAction();

    }

    private void eliminarPacienteAction() throws PacienteException{

        if (pacienteSeleccionado != null) {
            Paciente paciente = (Paciente) pacienteSeleccionado;
            String cedula = paciente.getCedula();
            clinica.eliminarPaciente(cedula);


        }

    }

    @FXML
    void nuevaCitaEvent(ActionEvent event) {

    }

    @FXML
    void nuevoPacienteEvent(ActionEvent event) {
        limpiarCamposPaciente();
    }




    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private void limpiarCamposPaciente() {

        txtNombrePaciente.setText("");
        txtCedulaPaciente.setText("");
        txtTelefonoPaciente.setText("");
        txtCorreoPaciente.setText("");
        txtSangrePaciente.setText("");
    }


    public void setAplication(Aplication aplication) {
        this.aplication = aplication;
        this.clinica = aplication.getClinica();
    }

    @FXML
    public void initialize() {


    }

    private void listenerSelection() {
        tblPaciente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            pacienteSeleccionado = newSelection;
            mostrarInformacionPaciente(pacienteSeleccionado);
        } );
    }

    private void mostrarInformacionPaciente(Paciente pacienteSeleccionado) {
        if(pacienteSeleccionado != null){
            txtNombrePaciente.setText(pacienteSeleccionado.getNombre());
            txtCedulaPaciente.setText(pacienteSeleccionado.getCedula());
            txtTelefonoPaciente.setText(pacienteSeleccionado.getTelefono());
            txtCorreoPaciente.setText(pacienteSeleccionado.getCorreo());
            txtSangrePaciente.setText(pacienteSeleccionado.getTipoSangre());
        }
    }


    private void iniPaciente() {
        clmNombrePaciente.setCellValueFactory(cellDate -> new SimpleStringProperty(cellDate.getValue().getNombre()));
        clmCedulaPaciente.setCellValueFactory(cellDate -> new SimpleStringProperty(cellDate.getValue().getCedula()));
        clmTelefonoPaciente.setCellValueFactory(cellDate -> new SimpleStringProperty(cellDate.getValue().getTelefono()));
        clmCorreoPaciente.setCellValueFactory(cellDate -> new SimpleStringProperty(cellDate.getValue().getCorreo()));
        clmTipoSangrePaciente.setCellValueFactory(cellDate -> new SimpleStringProperty(cellDate.getValue().getTipoSangre()));

        obtenerPaciente();
    }

   private ObservableList<Paciente>obtenerPaciente(){
        listaPaciente.addAll(clinica.getListaPaciente());
        return listaPaciente;
   }


}
