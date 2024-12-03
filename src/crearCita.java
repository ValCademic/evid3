import entidades.Citas;
import entidades.Doctor;
import entidades.Paciente;
import metodos.CitasManager;
import metodos.doctoresCRUD;
import metodos.pacientesCRUD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static metodos.CitasManager.getAppointmentByPatientId;
import static metodos.CitasManager.leerCitas;

public class crearCita extends JFrame {
    private JButton cancelarButton;
    private JButton btnIngresar;
    private JButton buscarButton;
    private JTextArea txtObserv;
    private JComboBox cmbHora;
    private JComboBox cmbMinutos;
    private JComboBox cmbAnio;
    private JComboBox cmbMes;
    private JComboBox cmbDia;
    private JTextField txtPaciente;
    private JComboBox cmbPaciente;
    private JTextField txtFecha;
    private JPanel miPanel;
    private JComboBox cmbDoctor;
    private JTextField txtDoctor;
    private JButton eliminarButton;
    ArrayList<Paciente> lista;
    ArrayList<Doctor> list;

    public static void main(String[] args) {
        crearCita vC = new crearCita();
        vC.setContentPane(vC.miPanel);
        vC.setSize(500, 500);
        vC.setTitle("Citas");
        vC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vC.setVisible(true);
    }

    public boolean validaFecha(String fecha) {
        SimpleDateFormat formatoFecha =
                new SimpleDateFormat("dd/MM/yyyy");
        try {
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // Constructor
    public crearCita() {
        String filePathPacientes="c:\\Sistema_HealthPlus\\pacientes.txt";
        String filePathDoctores="c:\\Sistema_HealthPlus\\doctores.txt";
        txtFecha.setEditable(false);
        // leer los datos de la lista pacientes
        try {
            FileInputStream leer =
                    new FileInputStream(filePathPacientes);
            ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
            Object o = lectorObjetos.readObject();
            lista = (ArrayList<Paciente>) o;

            //se agregan al combo box de pacientes
            for (Paciente a : lista) {
                cmbPaciente.addItem(a.getID());
                lectorObjetos.close();
                leer.close();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        // leer los datos de la lista doctores
        try {
            FileInputStream leer =
                    new FileInputStream(filePathDoctores);

            ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
            Object o = lectorObjetos.readObject();
            list = (ArrayList<Doctor>) o;

            //se agregan al combo box de doctores
            for (Doctor a : list) {
                cmbDoctor.addItem(a.getID());
                lectorObjetos.close();
                leer.close();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String file_path="c:\\Sistema_HealthPlus\\pacientes.txt";
                String id = String.valueOf(cmbPaciente.getSelectedItem());
                //leer archivo pacientes
                try (FileInputStream leer = new FileInputStream(file_path);
                     ObjectInputStream miStream2 = new ObjectInputStream(leer)) {

                    ArrayList<Paciente> listaPacientes = (ArrayList<Paciente>) miStream2.readObject();

                    for (Paciente k : listaPacientes) { //se comparan los ids con el ingresado
                        System.out.println("Comparando con el #ID: " + k.getID());

                        if (id.equals(k.getID())) { //si coincide el id del paciente con uno de la lista
                            Citas cita = CitasManager.getAppointmentByPatientId(k.getID());
                            if (cita != null) {
                                // se actualizan los datos con los del paciente encontrado

                                String fecha = cita.getFecha();
                                String doctor = cita.getDoctor();
                                String notas = cita.getNotas();
                                cmbHora.setSelectedItem(cita.getHora().substring(0, 2));
                                cmbMinutos.setSelectedItem(cita.getHora().substring(3, 5));
                                cmbPaciente.setSelectedItem(k);
                                doctoresCRUD crud = new doctoresCRUD();
                                cmbDoctor.setSelectedItem(cita.getDoctorID());
                                txtDoctor.setText("Dr. " + cita.getDoctor());
                                txtPaciente.setText(k.getNombre() + " " + k.getApellidoPat() + " " + k.getApellidoMat());
                                txtFecha.setText(cita.getFecha());
                                txtObserv.setText(cita.getNotas());

                                //se vuelven ineditables los cuadros de texto y combo box, excepto la del id de paciente (para poder buscar a otro paciente)
                                txtObserv.setEditable(false);

                                JTextField[] txts = { txtPaciente, txtDoctor, txtFecha };
                                for (JTextField textField : txts) {
                                    textField.setEditable(false);
                                }
                                JComboBox[] cmbs1 = { cmbDoctor, cmbAnio, cmbMes, cmbDia, cmbHora, cmbMinutos };

                                for (JComboBox comboBox : cmbs1) {
                                    comboBox.setEditable(false);
                                    comboBox.setEnabled(false);
                                }


                                JOptionPane.showMessageDialog(miPanel, "Se ha encontrado al paciente #" + k.getID() + " exitosamente.");
                                miPanel.revalidate();
                                miPanel.repaint();
                            } else { //si no coincide el id del paciente
                                JOptionPane.showMessageDialog(miPanel, "No se encontraron citas para este paciente.");
                                //se borran los datos y se vuelven editables los cuadros de texto y combo box

                                cmbHora.setSelectedItem(null);
                                cmbMinutos.setSelectedItem(null);
                                cmbPaciente.setSelectedItem(k);
                                cmbDoctor.setSelectedItem(null);
                                txtDoctor.setText(null);
                                txtPaciente.setText(k.getNombre()+" "+k.getApellidoPat()+" "+k.getApellidoMat());
                                txtFecha.setText(null);
                                txtObserv.setText(null);
                                txtPaciente.setEditable(false);
                                txtObserv.setEditable(true);
                                JTextField[] txts = { txtDoctor, txtFecha };
                                for (JTextField textField : txts) {
                                    textField.setEditable(true);
                                }
                                JComboBox[] cmbs1 = { cmbDoctor, cmbAnio, cmbMes, cmbDia, cmbHora, cmbMinutos };

                                for (JComboBox comboBox : cmbs1) {
                                    comboBox.setEditable(true);
                                }
                                JComponent[] cmbs2 = { cmbDoctor, cmbAnio, cmbMes,cmbDia ,cmbHora, cmbMinutos  };

                                for (JComponent component : cmbs2) {
                                    component.setEnabled(true);
                                }
                            }
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(miPanel, "Paciente no encontrado.");
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(miPanel, "Archivo no encontrado: " + ex.getMessage());
                } catch (ClassNotFoundException | IOException ex) {
                    JOptionPane.showMessageDialog(miPanel, "Error: " + ex.getMessage());
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(miPanel, "¿Desea volver al menu?", "Salir", JOptionPane.YES_NO_OPTION);
                if (respuesta == 0) {
                    dispose();
                    String[] tipoUsuario = {"admin"};
                    Sistema.main(tipoUsuario);
                }
            }
        });
        cmbPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = String.valueOf(cmbPaciente.getSelectedItem());
                try (FileInputStream leer = new FileInputStream(filePathPacientes);
                     ObjectInputStream miStream2 = new ObjectInputStream(leer)) {

                    ArrayList<Paciente> listaPacientes = (ArrayList<Paciente>) miStream2.readObject();
                    for (Paciente k : listaPacientes) {
                        System.out.println("Comparando con el #ID: " + k.getID()); // para debugging, se muestra en consola

                        if (id.equals(k.getID())) { //si el id del paciente ingresado coincide con uno en la lista
                            Citas cita = CitasManager.getAppointmentByPatientId(k.getID());
                                cmbPaciente.setSelectedItem(k);
                             txtPaciente.setText(k.getNombre() + " " + k.getApellidoPat() + " " + k.getApellidoMat());
                                miPanel.revalidate();
                                miPanel.repaint();
                            return;
                        }
                    }

                } catch (FileNotFoundException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        cmbDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = String.valueOf(cmbDoctor.getSelectedItem());
                try (FileInputStream leer = new FileInputStream(filePathDoctores);
                     ObjectInputStream miStream2 = new ObjectInputStream(leer)) {

                    ArrayList<Doctor> listaDoctores = (ArrayList<Doctor>) miStream2.readObject();
                    for (Doctor k : listaDoctores) {
                        System.out.println("Comparando con el #ID: " + k.getID()); // para debugging, se muestra en consola

                        if (id.equals(k.getID())) { //si el id del doctor ingresado coincide con uno en la lista
                            Citas cita = CitasManager.getAppointmentByPatientId(k.getID());
                            if (cita != null) {
                                cmbDoctor.setSelectedItem(k.getID());
                                txtDoctor.setText("Dr. "+k.getNombre() + " " + k.getApellidoPat() + " " + k.getApellidoMat());
                                miPanel.revalidate();
                                miPanel.repaint();
                            }
                            else{cmbDoctor.setSelectedItem(k.getID());
                                txtDoctor.setText("Dr. "+k.getNombre() + " " + k.getApellidoPat() + " " + k.getApellidoMat());
                                miPanel.revalidate();
                                miPanel.repaint();}
                            return;
                        }
                    }

                } catch (FileNotFoundException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Citas miCita = new Citas();
                miCita.setId(String.valueOf(cmbPaciente.getSelectedItem()));
                miCita.setFecha(cmbDia.getSelectedItem()+"/"+cmbMes.getSelectedItem()+"/"+cmbAnio.getSelectedItem());
                miCita.setHora(cmbHora.getSelectedItem()+":"+cmbMinutos.getSelectedItem());
                miCita.setNotas(txtObserv.getText());
                miCita.setDoctor(txtDoctor.getText().substring(4));
                miCita.setDoctorID(String.valueOf(cmbDoctor.getSelectedItem()));

                CitasManager crud = new CitasManager();
                crud.guardarCita(miCita);
                JOptionPane.showMessageDialog(miPanel,"Se ha agregado exitosamente.");
            }
        });
    }
}