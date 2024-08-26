package clinica.proyecto.clinica.model;

import java.util.Objects;

public class Cita {

    private String codigo;
    private String fecha;
    private String hora;
    private TipoCita tipoCita;
    private Paciente paciente;

    public Cita() {
    }

    public Cita(String codigo, String fecha, String hora, TipoCita tipoCita, Paciente paciente) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.tipoCita = tipoCita;
        this.paciente = paciente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public TipoCita getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(TipoCita tipoCita) {
        this.tipoCita = tipoCita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "codigo='" + codigo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", tipoCita=" + tipoCita +
                ", paciente=" + paciente +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cita cita = (Cita) o;
        return Objects.equals(codigo, cita.codigo) && Objects.equals(fecha, cita.fecha) && Objects.equals(hora, cita.hora) && tipoCita == cita.tipoCita && Objects.equals(paciente, cita.paciente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, fecha, hora, tipoCita, paciente);
    }
}
