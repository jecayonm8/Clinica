package clinica.proyecto.clinica.model;

import clinica.proyecto.clinica.exception.CitaException;
import clinica.proyecto.clinica.exception.PacienteException;

import java.util.ArrayList;
import java.util.Objects;

public class Clinica {
    //atributos
    private String nombre;
    private ArrayList<Paciente> listaPaciente = new ArrayList<>();
    private ArrayList<Cita> listaCita = new ArrayList<>();


    public Clinica() {
        super();
        Paciente paciente = new Paciente("Javier", "1223", "3190989797", "juanerscasallas@gmail.com", "O+");
    }

    //constructor
    public Clinica(String nombre, ArrayList<Paciente> listaPaciente, ArrayList<Cita> listaCita) {
        this.nombre = nombre;
        this.listaPaciente = listaPaciente;
        this.listaCita = listaCita;
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Paciente> getListaPaciente() {
        return listaPaciente;
    }

    public void setListaPaciente(ArrayList<Paciente> listaPaciente) {
        this.listaPaciente = listaPaciente;
    }

    public ArrayList<Cita> getListaCita() {
        return listaCita;
    }

    public void setListaCita(ArrayList<Cita> listaCita) {
        this.listaCita = listaCita;
    }

    //metodo toString
    @Override
    public String toString() {
        return "Clinica{" +
                "nombre='" + nombre + '\'' +
                ", listaPaciente=" + listaPaciente +
                ", listaCita=" + listaCita +
                '}';
    }

    //metodo equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clinica clinica = (Clinica) o;
        return Objects.equals(nombre, clinica.nombre) && Objects.equals(listaPaciente, clinica.listaPaciente) && Objects.equals(listaCita, clinica.listaCita);
    }

    //metodo hashCode
    @Override
    public int hashCode() {
        return Objects.hash(nombre, listaPaciente, listaCita);
    }

    //metodo para crearPaciente
    public void crearPaciente(Paciente paciente) throws PacienteException {
        Paciente nuevoPaciente = null;
        boolean pacienteExiste = verificarPacienteExistente(paciente.getCedula());
        if (pacienteExiste) {
            throw new PacienteException("El Paciente con cedula: " + paciente.getCedula() + " ya existe");
        } else {
            nuevoPaciente = new Paciente();
            nuevoPaciente.setNombre(paciente.getNombre());
            nuevoPaciente.setCedula(paciente.getCedula());
            nuevoPaciente.setTelefono(paciente.getTelefono());
            nuevoPaciente.setCorreo(paciente.getCorreo());
            nuevoPaciente.setTipoSangre(paciente.getTipoSangre());


            getListaPaciente().add(nuevoPaciente);
        }
    }

    //metodo para agregarPaciente
    public void agregarPaciente(Paciente nuevoPaciente) throws PacienteException {
        getListaPaciente().add(nuevoPaciente);
    }


    //metodo actualizarPaciente
    public void actualizarPaciente(Paciente paciente) throws PacienteException {
        Paciente pacienteActual = obtenerPaciente(paciente.getCedula());
        if (pacienteActual == null)
            throw new PacienteException("El Paciente a actualizar no existe");
        else {
            pacienteActual.setNombre(paciente.getNombre());
            pacienteActual.setCedula(paciente.getCedula());
            pacienteActual.setTelefono(paciente.getTelefono());
            pacienteActual.setCorreo(paciente.getCorreo());
            pacienteActual.setTipoSangre(paciente.getTipoSangre());
        }
    }

    //metodo eliminarPaciente
    public Boolean eliminarPaciente(String cedula) throws PacienteException {
        Paciente paciente = null;
        boolean flagExiste = false;
        paciente = obtenerPaciente(cedula);
        if (paciente == null)
            throw new PacienteException("El Paciente a eliminar no existe");
        else {
            getListaPaciente().remove(paciente);
            flagExiste = true;
        }
        return flagExiste;
    }


    //metodo verificarPacienteExistente
    public boolean verificarPacienteExistente(String cedula) throws PacienteException {
        if (pacienteExiste(cedula)) {
            throw new PacienteException("El Paciente con cedula: " + cedula + " ya existe");
        } else {
            return false;
        }
    }


    //metodo obtenerPaciente
    public Paciente obtenerPaciente(String cedula) {
        Paciente pacienteEncontrado = null;
        for (Paciente paciente : getListaPaciente()) {
            if (paciente.getCedula().equalsIgnoreCase(cedula)) {
                pacienteEncontrado = paciente;
                break;
            }
        }
        return pacienteEncontrado;
    }


    public ArrayList<Paciente> obtenerPaciente() {
        // TODO Auto-generated method stub
        return getListaPaciente();
    }

    //metodo pacienteExiste
    public boolean pacienteExiste(String cedula) {
        boolean pacienteEncontrado = false;
        for (Paciente paciente : getListaPaciente()) {
            if (paciente.getCedula().equalsIgnoreCase(cedula)) {
                pacienteEncontrado = true;
                break;
            }
        }
        return pacienteEncontrado;
    }


///////////////////////////////////////////////CRUD CITA ///////////////////////////////////////////////////////////

    public Cita crearCita(Cita cita) throws CitaException {
        Cita nuevaCita = null;
        boolean citaExiste = verificarCitaExistente(cita.getCodigo());
        if(citaExiste){
            throw new CitaException("La cita con el codigo: "+ cita.getCodigo()+" ya existe");
        }else{
            nuevaCita = new Cita();
            nuevaCita.setFecha(cita.getFecha());
            nuevaCita.setHora(cita.getHora());
            nuevaCita.setTipoCita(cita.getTipoCita());


            getListaCita().add(nuevaCita);
        }
        return nuevaCita;
    }

    public void agregarCita(Cita nuevaCita) throws CitaException{
        getListaCita().add(nuevaCita);
    }


    public Boolean eliminarCita(String codigo) throws CitaException {
        Cita cita = null;
        boolean flagExiste = false;
        cita = obtenerCita(codigo);
        if(cita == null)
            throw new CitaException("La Cita a eliminar no existe");
        else{
            getListaCita().remove(cita);
            flagExiste = true;
        }
        return flagExiste;
    }


    public boolean verificarCitaExistente(String codigo) throws CitaException {
        if(citaExiste(codigo)){
            throw new CitaException("La Cita con Codigo: "+codigo+" ya existe");
        }else{
            return false;
        }
    }



    public Cita obtenerCita(String codigo) {
        Cita citaEncontrada = null;
        for (Cita cita : getListaCita()) {
            if(cita.getCodigo().equalsIgnoreCase(codigo)){
                citaEncontrada = cita;
                break;
            }
        }
        return citaEncontrada;
    }


    public ArrayList<Cita> obtenerCita() {
        // TODO Auto-generated method stub
        return getListaCita();
    }

    public boolean citaExiste(String codigo) {
        boolean citaEncontrada = false;
        for (Cita cita : getListaCita()) {
            if(cita.getCodigo().equalsIgnoreCase(codigo)){
                citaEncontrada = true;
                break;
            }
        }
        return citaEncontrada;
    }
}