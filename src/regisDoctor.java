import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entidades.Doctor;
import entidades.Paciente;
import metodos.doctoresCRUD;
import metodos.pacientesCRUD;

public class regisDoctor extends JFrame {
    private JButton btnBuscar;
    private JButton btnEliminar;
    private JButton btnAgregar;
    private JButton btnCancelar;
    public JPanel miPanel;
    private JTextField txtNombre;
    private JTextField txtApPat;
    private JTextField txtApMat;
    private JTextField txtEdad;
    private JTextField txtID;
    private JTextField txtEsp;
    private JButton btnActualizar;


    public regisDoctor() {
        JTextField[] txts = {txtID, txtNombre, txtApPat, txtApMat, txtEdad, txtEsp};
        for (JTextField textField : txts)
        {
            textField.setText(null);
        }

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doctoresCRUD crud = new doctoresCRUD();
                String id = txtID.getText();
                Doctor a = crud.getInfoDoctorPorID(id);
                if(a == null){
                    JOptionPane.showMessageDialog(miPanel,"No se encuentra información del doctor con #ID " + id);
                    txtID.setText(null);
                    txtNombre.setText(null);
                    txtApPat.setText(null);
                    txtApMat.setText(null);
                    txtEdad.setText(null);
                    txtEsp.setText(null);
                }
                else
                {
                    //se encontro el doctor
                    txtID.setText(a.getID());
                    txtNombre.setText(a.getNombre());
                    txtApPat.setText(a.getApellidoPat());
                    txtApMat.setText(a.getApellidoMat());
                    txtEdad.setText(String.valueOf(a.getEdad()));
                    txtEsp.setText(a.getEspecializacion());

                    btnCancelar.setEnabled(true);
                    btnEliminar.setEnabled(true);
                }
            }
        });
        btnAgregar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                Doctor miDoctor = new Doctor();
                int validarBlank = 0;

                JTextField[] txts = {txtID, txtNombre, txtApPat, txtApMat, txtEdad, txtEsp};
                for (JTextField textField : txts)
                    if (textField.getText().trim().isEmpty()) {
                        validarBlank++;
                    }

                if (validarBlank == 0) {
                    miDoctor.setID(txtID.getText());
                    miDoctor.setNombre(txtNombre.getText());
                    miDoctor.setApellidoPat(txtApPat.getText());
                    miDoctor.setApellidoMat(txtApMat.getText());
                    miDoctor.setEdad(txtEdad.getText());
                    miDoctor.setEspecializacion(txtEsp.getText());

                    doctoresCRUD crud = new doctoresCRUD();
                    crud.agregarDoctor(miDoctor);
                    JOptionPane.showMessageDialog(miPanel, "Se ha agregado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(miPanel, "Faltan datos.");
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(miPanel,"Desea volver al menu?","Salir",JOptionPane.YES_NO_OPTION);
                if(respuesta == 0) {
                    dispose();
                    String[] tipoUsuario = {"admin"};
                    Sistema.main(tipoUsuario);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                int respuesta = JOptionPane.showConfirmDialog(miPanel, "Seguro que deseas eliminar al doctor?");
                if (respuesta==0)
                {
                    doctoresCRUD crud = new doctoresCRUD();
                    String id = txtID.getText();
                    Doctor a = crud.getInfoDoctorPorID(id);
                    crud.eliminarDoctor(a);
                    txtID.setText(null);
                    txtNombre.setText(null);
                    txtApPat.setText(null);
                    txtApMat.setText(null);
                    txtEdad.setText(null);
                    txtEsp.setText(null);
                    JOptionPane.showMessageDialog(miPanel,"Se ha eliminado la informacion exitosamente.");
                }

            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Doctor miDoctor = new Doctor();
                miDoctor.setID(txtID.getText());
                miDoctor.setNombre(txtNombre.getText());
                miDoctor.setApellidoPat(txtApPat.getText());
                miDoctor.setApellidoMat(txtApMat.getText());
                miDoctor.setEdad(txtEdad.getText());
                miDoctor.setEspecializacion(txtEsp.getText());

                doctoresCRUD crud = new doctoresCRUD();
                crud.actualizarDoctor(miDoctor);
                JOptionPane.showMessageDialog(miPanel,"Se ha actualizado la informacion exitosamente.");
            }
        });
    }
    public static void main(String[] args)
    {
        regisDoctor vD = new regisDoctor();
        vD.setContentPane(vD.miPanel);
        vD.setSize(500,500);
        vD.setTitle("Registrar o Consultar Doctores");
        vD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vD.setVisible(true);
    }
}
