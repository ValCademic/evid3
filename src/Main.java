import entidades.Citas;
import entidades.Doctor;
import entidades.Paciente;
import metodos.CitasManager;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //escribe datos base para  el programa
        String filePathPacientes = "c:\\Sistema_HealthPlus\\pacientes.txt";
        String filePathDoctores = "c:\\Sistema_HealthPlus\\doctores.txt";
        // leer lista doctores
        try {
            File file1 = new File(filePathPacientes);
            File file2 = new File(filePathDoctores);
            if (file1.exists() && file1.length() > 0 && file2.exists() && file2.length() > 0) {// valida si el archivo existe
                    System.out.println("Redireccionando a Login...");
                    String[] tipoUsuario = {"usuario"};
                    Login.main(tipoUsuario);
            }
            else {
                try {
                    ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>();

                    Paciente a1 = new Paciente();
                    a1.setID("0000");
                    a1.setNombre("Pedro");
                    a1.setApellidoPat("Jimenez");
                    a1.setApellidoMat("Perez");
                    a1.setEdad("19");
                    a1.setSexo("Masculino");

                    Paciente a2 = new Paciente();
                    a2.setID("0001");
                    a2.setNombre("Ana");
                    a2.setApellidoPat("Gutierrez");
                    a2.setApellidoMat("Sanchez");
                    a2.setEdad("18");
                    a2.setSexo("Femenino");

                    Paciente a3 = new Paciente();
                    a3.setID("0002");
                    a3.setNombre("Juan");
                    a3.setApellidoPat("Lopez");
                    a3.setApellidoMat("Pedroza");
                    a3.setEdad("21");
                    a3.setSexo("Masculino");

                    Paciente a7 = new Paciente();
                    a7.setID("0003");
                    a7.setNombre("Angelica");
                    a7.setApellidoPat("Castro");
                    a7.setApellidoMat("Juarez");
                    a7.setEdad("17");
                    a7.setSexo("Femenino");

                    listaPacientes.add(a1);
                    listaPacientes.add(a2);
                    listaPacientes.add(a3);
                    listaPacientes.add(a7);


                    FileOutputStream escribir = new FileOutputStream(filePathPacientes);
                    ObjectOutputStream miStream = new ObjectOutputStream(escribir);
                    miStream.writeObject(listaPacientes);
                    miStream.flush();
                    miStream.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try {
                    ArrayList<Doctor> listaDoctores = new ArrayList<>();
                    Doctor a0 = new Doctor();
                    a0.setID("1000");
                    a0.setNombre("Erick");
                    a0.setApellidoPat("Lopez");
                    a0.setApellidoMat("Cazarez");
                    a0.setEdad("26");
                    a0.setEspecializacion("Cirugia");

                    Doctor a4 = new Doctor();
                    a4.setID("0034");
                    a4.setNombre("Edith");
                    a4.setApellidoPat("Garcia");
                    a4.setApellidoMat("Suarez");
                    a4.setEdad("23");
                    a4.setEspecializacion("Medicina Interna");

                    Doctor a6 = new Doctor();
                    a6.setID("0022");
                    a6.setNombre("Mario");
                    a6.setApellidoPat("Lechuga");
                    a6.setApellidoMat("Juarez");
                    a6.setEdad("21");
                    a6.setEspecializacion("Pediatria");

                    Doctor a5 = new Doctor();
                    a5.setID("0015");
                    a5.setNombre("Samara");
                    a5.setApellidoPat("Aganza");
                    a5.setApellidoMat("Montaño");
                    a5.setEdad("25");
                    a5.setEspecializacion("Neurologia");

                    listaDoctores.add(a0);
                    listaDoctores.add(a4);
                    listaDoctores.add(a5);
                    listaDoctores.add(a6);
                    FileOutputStream escribir = new FileOutputStream(filePathDoctores);
                    ObjectOutputStream miStream = new ObjectOutputStream(escribir);
                    miStream.writeObject(listaDoctores);
                    miStream.flush();
                    miStream.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                CitasManager.guardarCita(new Citas("0034", "Edith Garcia", "05/12/2024", "10:00", "Resultados examen de tiroide", "0002"));
                CitasManager.guardarCita(new Citas("1000", "Erick Lopez", "13/01/2025", "13:25", "Ultrasonido Uterino", "0000"));
                CitasManager.guardarCita(new Citas("0022", "Mario Lechuga", "07/12/2024", "07:10", "Cita rutinaria", "0001"));

                ArrayList<Citas> citas = CitasManager.leerCitas();
                for (Citas cita : citas) {
                    System.out.println("Doctor: " + cita.getDoctor());
                    System.out.println("Fecha: " + cita.getFecha());
                    System.out.println("Hora: " + cita.getHora());
                    System.out.println("Notas: " + cita.getNotas());
                    System.out.println("Paciente ID: " + cita.getId());
                    System.out.println("----------------------");

                }
                System.out.println("\nSe han terminado de crear los archivos base.");
                String[] tipoUsuario = {"usuario"};
                Login.main(tipoUsuario);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}