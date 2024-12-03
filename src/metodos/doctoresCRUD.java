package metodos;

import entidades.Citas;
import entidades.Doctor;
import entidades.Paciente;

import java.io.*;
import java.util.ArrayList;

public class doctoresCRUD {
    public static void main(String[] args) {
        String file_path = "c:\\Sistema_HealthPlus\\doctores.txt";
        ArrayList<Doctor> listaDoctores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String id = parts[0];
                    String nombre = parts[1];
                    String apellidoPat = parts[2];
                    String apellidoMat = parts[3];
                    String edad = parts[4];
                    String especialidad = parts[5];

                    // crear objeto doctor y sus segmentos
                    Doctor doctor = new Doctor(id, nombre, apellidoPat, apellidoMat, edad, especialidad);
                    listaDoctores.add(doctor);
                }
            }

            // muestra los doctores existentes
            for (Doctor doctor : listaDoctores) {
                System.out.println(doctor.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Doctor getInfoDoctorPorID(String id) {
        String file_path = "c:\\Sistema_HealthPlus\\doctores.txt";
        try (FileInputStream leer = new FileInputStream(file_path);
             ObjectInputStream miStream2 = new ObjectInputStream(leer)) {
            Object miLista = miStream2.readObject();
            ArrayList<Doctor> listaDoctores = (ArrayList<Doctor>) miLista;
            id = id.split(" ")[0];  // Get first name only
            for (Doctor k : listaDoctores) {
                System.out.println("Comparando con el Registrado: " + k.getNombre()); // Debugging each doctor name
                if (id.equals(k.getID())) {
                    return k;  // si lo encuentra, regresa al doctor
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error IO: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    // Function to add a doctor to the list and update the file
    public static void agregarDoctor(Doctor a) {
        String file_path = "c:\\Sistema_HealthPlus\\doctores.txt";
        ArrayList<Doctor> lista = new ArrayList<>();

        // leer lista doctores
        try {
            File file = new File(file_path);
            if (file.exists()) { // valida si el archivo existe
                FileInputStream leer = new FileInputStream(file);
                ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
                Object o = lectorObjetos.readObject();

                if (o instanceof ArrayList<?>) { // valida que el archivo sea un array
                    lista = (ArrayList<Doctor>) o;
                }

                lectorObjetos.close();
                leer.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Archivo contiene datos invalidos.");
        }

        // agrega al paiente nuevo a la lista
        lista.add(a);

        // reescribe la lista actualizada dentro del archivo
        try {
            FileOutputStream escribir = new FileOutputStream(file_path);
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(escribir);
            escritorObjetos.writeObject(lista);
            escritorObjetos.flush();

            escritorObjetos.close();
            escribir.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }/*
        // Reescribir lista actualizada (en el archivo)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {
            for (Doctor doctor : listaDoctores) {
                writer.write(doctor.getID() + "," + doctor.getNombre() + "," + doctor.getApellidoPat() + "," +
                        doctor.getApellidoMat() + "," + doctor.getEdad() + "," + doctor.getEspecializacion() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public void actualizarDoctor(Doctor a) {
        String file_path = "c:\\Sistema_HealthPlus\\doctores.txt";
        ArrayList<Doctor> lista = new ArrayList<>();
        boolean doctorModificado = false;

        // leer lista de doctores
        try {
            File file = new File(file_path);
            if (file.exists() && file.length() > 0) { // revisa si: 1. existe? && 2. esta vacia?
                FileInputStream leer = new FileInputStream(file);
                ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
                Object o = lectorObjetos.readObject();

                if (o instanceof ArrayList<?>) { // revisa si es un array
                    lista = (ArrayList<Doctor>) o;
                }

                lectorObjetos.close();
                leer.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Archivo contiene datos inválidos.");
        }

        // actualizar los detalles del doctor "if" = si fue encontrado
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getID().equals(a.getID())) { // si el ID de la lista es igual a la del doctor
                lista.set(i, a); // Se reemplaza la informacion con los (nuevos) datos del doctor
                doctorModificado = true;
                break;
            }
        }

        // si el doctor no fue encontrado
        if (!doctorModificado) {
            System.out.println("Doctor no encontrado.");
            return;
        }

        // Reescribir lista actualizada (en el archivo)
        try {
            FileOutputStream escribir = new FileOutputStream(file_path);
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(escribir);
            escritorObjetos.writeObject(lista);
            escritorObjetos.flush();

            escritorObjetos.close();
            escribir.close();
            System.out.println("Informacion actualizada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        // Reescribir lista actualizada (en el archivo)
        try {
            FileOutputStream escribir = new FileOutputStream(file_path);
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(escribir);
            escritorObjetos.writeObject(lista);
            escritorObjetos.flush();

            escritorObjetos.close();
            escribir.close();
            System.out.println("Doctor modificado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void eliminarDoctor(Doctor a) {
        String file_path = "c:\\Sistema_HealthPlus\\doctores.txt";

        ArrayList<Doctor> lista = new ArrayList<>();
            boolean doctorModificado = false;

            // leer lista doctores
            try {
                File file = new File(file_path);
                if (file.exists() && file.length() > 0) { // Check if file exists and is not empty
                    FileInputStream leer = new FileInputStream(file);
                    ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
                    Object o = lectorObjetos.readObject();

                    if (o instanceof ArrayList<?>) { // Validate object type
                        lista = (ArrayList<Doctor>) o;
                    }

                    lectorObjetos.close();
                    leer.close();
                }
            } catch (FileNotFoundException e) {
                System.out.println("Archivo no encontrado.");
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Archivo contiene datos inválidos.");
            }

            // si lo encuentra, actualiza su informacion a blank
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getID().equals(a.getID())) { // encontrar por id

                    a.setEdad("");
                    a.setEspecializacion("");
                    a.setNombre("");
                    a.setApellidoPat("");
                    a.setApellidoMat("");
                    a.setID("");

                    lista.set(i, a); // reemplaza los datos de la lista con los blank de arriba
                    doctorModificado = true;
                    break;
                }
            }

            //si no se encuentra el doctor
            if (!doctorModificado) {
                System.out.println("Doctor no encontrado.");
                return;
            }

            // reescribe el archivo con la lista actualizada
            try {
                FileOutputStream escribir = new FileOutputStream(file_path);
                ObjectOutputStream escritorObjetos = new ObjectOutputStream(escribir);
                escritorObjetos.writeObject(lista);
                escritorObjetos.flush();

                escritorObjetos.close();
                escribir.close();
                System.out.println("Informacion eliminada exitosamente.");
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo: " + e.getMessage());
            }
        // reescribe el archivo con la lista actualizada
        try {
            FileOutputStream escribir = new FileOutputStream(file_path);
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(escribir);
            escritorObjetos.writeObject(lista);
            escritorObjetos.flush();

            escritorObjetos.close();
            escribir.close();
            System.out.println("Informacion eliminada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        }
}
