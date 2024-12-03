import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entidades.Paciente;
import metodos.pacientesCRUD;

public class regisPaciente extends JFrame {
    private JButton btnBuscar;
    private JButton btnEliminar;
    private JButton btnAgregar;
    private JButton btnCancelar;
    public JPanel miPanel;
    private JTextField txtNombre;
    private JTextField txtApPat;
    private JTextField txtApMat;
    private JTextField txtEdad;
    private JComboBox cmbSexo;
    private JTextField txtID;
    private JButton btnActualizar;


    public regisPaciente() {
        cmbSexo.setSelectedItem(null);
        JTextField[] txts = {txtID, txtNombre, txtApPat, txtApMat, txtEdad};
        for (JTextField textField : txts) {
            textField.setText(null);
        }
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean validarBlank = false;
                pacientesCRUD crud = new pacientesCRUD();
                String id = txtID.getText();
                Paciente a = crud.getInfoPacientePorID(id);
                if (a == null) {
                    int respuesta = JOptionPane.showConfirmDialog(miPanel, "No se encuentra información del paciente con #ID " + id + ". ¿Desea ingresarlo?", "Registro", JOptionPane.YES_NO_OPTION);

                    if (respuesta == 0) {
                        //sí quiere dar de alta el paciente inexistente
                        btnAgregar.setEnabled(true);
                        txtNombre.requestFocus();
                    } else if (respuesta == 1) {

                        txtID.setText("");
                        txtNombre.setText("");
                        txtApPat.setText("");
                        txtApMat.setText("");
                        txtEdad.setText("");
                        cmbSexo.setSelectedItem(null);
                    }
                } else {

                    //se encontro el paciente
                    txtNombre.setText(a.getNombre());
                    txtApPat.setText(a.getApellidoPat());
                    txtApMat.setText(a.getApellidoMat());
                    txtEdad.setText(String.valueOf(a.getEdad()));
                    cmbSexo.setSelectedItem(a.getSexo());

                    btnCancelar.setEnabled(true);
                    btnEliminar.setEnabled(true);
                }
            }
        });
        btnAgregar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                Paciente miPaciente = new Paciente();
                int validarBlank = 0;

                JTextField[] txts = {txtID, txtNombre, txtApPat, txtApMat, txtEdad};
                for (JTextField textField : txts)
                    if (textField.getText().trim().isEmpty()) {
                        validarBlank++;
                    }

                if (cmbSexo.getSelectedItem() == null) {
                    validarBlank++;
                }

                if (validarBlank == 0) {
                    miPaciente.setID(txtID.getText());
                    miPaciente.setNombre(txtNombre.getText());
                    miPaciente.setApellidoPat(txtApPat.getText());
                    miPaciente.setApellidoMat(txtApMat.getText());
                    miPaciente.setEdad(txtEdad.getText());
                    String sex = String.valueOf(cmbSexo.getSelectedItem());
                    miPaciente.setSexo(sex);

                    pacientesCRUD crud = new pacientesCRUD();
                    crud.agregarPaciente(miPaciente);
                    JOptionPane.showMessageDialog(miPanel, "Se ha agregado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(miPanel, "Faltan datos.");
                }
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
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
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int respuesta = JOptionPane.showConfirmDialog(miPanel, "Seguro que deseas eliminar al paciente?");
                if (respuesta == 0) {
                    pacientesCRUD crud = new pacientesCRUD();
                    String id = txtID.getText();
                    Paciente a = crud.getInfoPacientePorID(id);
                    crud.eliminarPaciente(a);
                    txtID.setText(null);
                    txtNombre.setText(null);
                    txtApPat.setText(null);
                    txtApMat.setText(null);
                    txtEdad.setText(null);
                    cmbSexo.setSelectedItem(null);
                    JOptionPane.showMessageDialog(miPanel,"Se ha eliminado la informacion exitosamente.");
                }

            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int validarBlank = 0;
                JTextField[] txts = {txtID, txtNombre, txtApPat, txtApMat, txtEdad};
                for (JTextField textField : txts)
                    if (textField.getText().trim().isEmpty()) {
                        validarBlank++;
                    }

                if (cmbSexo.getSelectedItem() == null) {
                    validarBlank++;
                }

                if (validarBlank == 0) {
                    Paciente miPaciente = new Paciente();
                    miPaciente.setID(txtID.getText());
                    miPaciente.setNombre(txtNombre.getText());
                    miPaciente.setApellidoPat(txtApPat.getText());
                    miPaciente.setApellidoMat(txtApMat.getText());
                    miPaciente.setEdad(txtEdad.getText());
                    String sex = String.valueOf(cmbSexo.getSelectedItem());
                    miPaciente.setSexo(sex);

                    pacientesCRUD crud = new pacientesCRUD();
                    crud.actualizarPaciente(miPaciente);
                    JOptionPane.showMessageDialog(miPanel,"Se ha actualizado la informacion exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(miPanel, "Faltan datos.");
                }
            }
        });
    }
        public static void main (String[]args)
        {
            regisPaciente v = new regisPaciente();
            v.setContentPane(v.miPanel);
            v.setSize(500, 500);
            v.setTitle("Registrar o Consultar Pacientes");
            v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            v.setVisible(true);
        }
    }
