package clinica.proyecto.clinica.model;

import java.util.ArrayList;
import java.util.Objects;

public class Paciente {

    //atributos
    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;
    private String tipoSangre;
    private ArrayList<Cita>listaCita;

    //public Paciente() {
    //}

    //constructor
    public Paciente() {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.tipoSangre = tipoSangre;
        this.listaCita = listaCita;
    }

    public Paciente(String nombre, String cedula, String telefono, String correo, String tipoSangre) {
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
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
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", tipoSangre='" + tipoSangre + '\'' +
                ", listaCita=" + listaCita +
                '}';
    }

    //metodo equals: para comparar si dos objetos son "iguales" en términos de sus contenidos, no solo si son el mismo objeto en memoria.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(nombre, paciente.nombre) && Objects.equals(cedula, paciente.cedula) && Objects.equals(telefono, paciente.telefono) && Objects.equals(correo, paciente.correo) && Objects.equals(tipoSangre, paciente.tipoSangre) && Objects.equals(listaCita, paciente.listaCita);
    }

    //metodo hashCode
    @Override
    public int hashCode() {
        return Objects.hash(nombre, cedula, telefono, correo, tipoSangre, listaCita);
    }
}
