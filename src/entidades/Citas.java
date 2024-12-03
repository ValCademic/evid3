package entidades;

import java.io.Serializable;

public class Citas implements Serializable {
    private String doctorID;
    private String doctor;
    private String fecha;
    private String hora;
    private String notas;
    private String pacienteId;

    // Constructor
    public Citas(String doctorID, String doctor, String fecha, String hora, String notas, String pacienteId) {
        this.doctorID=doctorID;
        this.doctor = doctor;
        this.fecha = fecha;
        this.hora = hora;
        this.notas = notas;
        this.pacienteId = pacienteId;
    }

    public Citas() {
        System.out.println();
    }

    // Getter methods

    public String setDoctor(String doctor) {
        this.doctor = doctor;
        return doctor;
    }
    public String getDoctor() {
        return doctor;
    }
    public String setDoctorID(String doctorID) {
        this.doctorID = doctorID;
        return doctorID;
    }
        public String getDoctorID() {
            return doctorID;
        }
    public String getFecha() {
        return fecha;
    }
    public String setFecha(String fecha) {
        this.fecha = fecha;
        return fecha;
    }

    public String getHora() {
        return hora;
    }
    public String setHora(String hora) {
        this.hora = hora;
        return hora;
    }

    public String getNotas() {
        return notas;
    }
    public String setNotas(String notas) {
        this.notas = notas;
        return notas;
    }
    public String getId() {
        return pacienteId;
    }
    public String setId(String pacienteId) {
        this.pacienteId = pacienteId;
        return pacienteId;
    }

    // To return a string representation of the Cita
    @Override
    public String toString() {
        return "Doctor #" + doctorID + ": " + doctor + ", Fecha: " + fecha + ", Hora: " + hora + ", Notas: " + notas;
    }
}