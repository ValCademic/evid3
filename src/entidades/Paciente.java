package entidades;
import java.io.Serializable;
import java.util.ArrayList;

public class Paciente implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String id, nombre, apellidoPat, apellidoMat, edad, sexo;
    private ArrayList<Citas> citas;  // List of appointments

    // Constructor with ID, name, and last names
    public Paciente(String id, String nombre, String apellidoPat, String apellidoMat, String edad, String sexo)
    {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.edad = edad;
        this.sexo =  sexo;
        this.citas = new ArrayList<>();  // Initialize the citas list
    }

    public Paciente() {
        this.citas = new ArrayList<>();
    }

    // Getter and setter for the ID
    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    // Getter and setter for the name
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter and setter for the last names
    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    // Getter and setter for age
    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    // Getter for the citas list (appointments)
    public ArrayList<Citas> getCitas() {
        return citas;
    }

    // Setter for citas list (appointments)
    public void setCitas(ArrayList<Citas> citas) {
        this.citas = citas;
    }

    // Method to add a single appointment (Cita)
    public void addCita(Citas cita) {
        this.citas.add(cita);
    }
}