package metodos;

import entidades.Doctor;
import entidades.Paciente;
import java.io.*;
import java.util.ArrayList;

public class pacientesCRUD {

    public Paciente getInfoPacientePorID(String id) {
        String file_path = "c:\\Sistema_HealthPlus\\pacientes.txt";
        try (FileInputStream leer = new FileInputStream(file_path);
             ObjectInputStream miStream2 = new ObjectInputStream(leer)) {
            Object miLista = miStream2.readObject();
            ArrayList<Paciente> listaPacientes = (ArrayList<Paciente>) miLista;

            for (Paciente k : listaPacientes) {
                System.out.println("Comparando con el #ID: " + k.getID()); // para debugging
                if (id.equals(k.getID())) {
                    return k;
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

    public static void agregarPaciente(Paciente a) {
        String file_path = "c:\\Sistema_HealthPlus\\pacientes.txt";
        ArrayList<Paciente> lista = new ArrayList<>();

        // leer archivo pacientes
        try {
            File file = new File(file_path);
            if (file.exists()) { // valida si el archivo existe
                FileInputStream leer = new FileInputStream(file);
                ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
                Object o = lectorObjetos.readObject();

                if (o instanceof ArrayList<?>) { // valida que el archivo sea un array
                    lista = (ArrayList<Paciente>) o;
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
        }
    }

    public void actualizarPaciente(Paciente a) {
        String file_path = "c:\\Sistema_HealthPlus\\pacientes.txt";
        ArrayList<Paciente> lista = new ArrayList<>();
        boolean pacienteModificado = false;

        // leer lista pacientes
        try {
            File file = new File(file_path);
            if (file.exists() && file.length() > 0) { // valida que el documento existe y no esta en blanco
                FileInputStream leer = new FileInputStream(file);
                ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
                Object o = lectorObjetos.readObject();

                if (o instanceof ArrayList<?>) { // valida que el archivo sea un array
                    lista = (ArrayList<Paciente>) o;
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

        // actualiza los detalles del paciente
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getID().equals(a.getID())) { // checa si coincide el id del paciente con el de la lista
                lista.set(i, a); // reemplaza la info de la lista con la info (actualizada) del paciente
                pacienteModificado = true;
                break;
            }
        }

        // si el paciente no se encuentra
        if (!pacienteModificado) {
            System.out.println("Paciente no encontrado.");
            return;
        }

        // reescribe la lista actualizada dentro del archivo
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
    }

    public static void eliminarPaciente(Paciente a) {
        String file_path = "c:\\Sistema_HealthPlus\\pacientes.txt";
        ArrayList<Paciente> lista = new ArrayList<>();
        boolean pacienteModificado = false;

        // leer archivo pacientes
        try {
            File file = new File(file_path);
            if (file.exists() && file.length() > 0) { // valida si el archivo existe y no esta vacio
                FileInputStream leer = new FileInputStream(file);
                ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
                Object o = lectorObjetos.readObject();

                if (o instanceof ArrayList<?>) { // valida que sea un array (la del archivo)
                    lista = (ArrayList<Paciente>) o;
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

        // actualizar los detalles del paciente
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getID().equals(a.getID())) { // coincide la id del paciente con el de la lista
                a.setEdad("");
                a.setSexo("");
                a.setNombre("");
                a.setApellidoPat("");
                a.setApellidoMat("");
                a.setID("");
            lista.set(i, a); // reemplaza la informacion con los blanks (arriba), eliminandolo de la lista
                pacienteModificado = true;
                break;
            }
        }

        // si no se encuentra el pacciente
        if (!pacienteModificado) {
            System.out.println("Paciente no encontrado.");
            return;
        }

        // reescribe la lista actualizada dentro del archivo
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
    }
}
