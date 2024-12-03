package metodos;
import entidades.Citas;

import java.io.*;
import java.util.ArrayList;

public class CitasManager {

    // leer lista citas
    public static ArrayList<Citas> leerCitas() {
        String file_path = "c:\\Sistema_HealthPlus\\citas.txt";
        ArrayList<Citas> citasList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    // Create a Cita object and add it to the list
                    Citas cita = new Citas(parts[1], parts[2], parts[3], parts[4],parts[5], parts[0]);
                    citasList.add(cita);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading appointments from file: " + e.getMessage());
        }
        return citasList;
    }
    // guardar citas al archivo
    public static void guardarCita(Citas cita) {
        String file_path = "c:\\Sistema_HealthPlus\\citas.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path, true))) {
            // escribe los datos dentro de la lista en una linea separada por commas
            writer.write(cita.getId() + ","+cita.getDoctorID()+ "," + cita.getDoctor() + "," + cita.getFecha() + "," + cita.getHora() + "," + cita.getNotas());
            writer.newLine();  // agrega una linea nueva despues de cada cita
            //para debugging (se muestra en consola)
            System.out.println("Cita creada y guardada.");
            System.out.println
                    ("----------------------"
                            +"\nDoctor: " + cita.getDoctor()
                            +"\nFecha: " + cita.getFecha()
                            +"\nHora: " + cita.getHora()
                            +"\nNotas: " + cita.getNotas()
                            +"\nPaciente ID: " + cita.getId()
                            +"\n----------------------");
        } catch (IOException e) {
            System.err.println("Error escribiendo en archivo: " + e.getMessage());
        }
    }

    public static Citas getAppointmentByPatientId(String pacienteId) {
        ArrayList<Citas> citasList = leerCitas();
        for (Citas cita : citasList) {
            if (cita.getId().equals(pacienteId)) {
                return cita;
            }
        }
        return null;  // si no se encuentra, regresar null
    }
}