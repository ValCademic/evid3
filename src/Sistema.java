import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sistema extends JFrame{
    private JPanel miPanel;
    private JButton citasButton;
    private JButton registrarPacienteButton;
    private JButton registrarDoctorButton;
    private JButton acercaDeButton;
    private JButton salirButton;

    public Sistema() {
        acercaDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(miPanel, "En HealthPlus, establecido el año 2013, nuestra misión es brindar servicios médicos de calidad, ya sea general o de especialidad, a precios accesibles para la población mexicana." +
                        "\nDeseamos crear más empleos para jóvenes médicos, beneficiando así a ambos médicos y pacientes.\n");
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(miPanel,"¿Desea salir del programa?","Salir",JOptionPane.YES_NO_OPTION);
                if(respuesta == 0){
                dispose();

                }
            }
        });
        citasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                String[] tipoUsuario={"admin"};
                crearCita.main(tipoUsuario);
            }
        });
        registrarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                String[] tipoUsuario={"admin"};
                regisPaciente.main(tipoUsuario);
            }
        });
        registrarDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                String[] tipoUsuario={"admin"};
                regisDoctor.main(tipoUsuario);
            }
        });
    }

    public static void main(String[] args) {
        Sistema vS = new Sistema();
        vS.setContentPane(vS.miPanel);
        vS.setSize(500,500);
        vS.setTitle("Registrar o Consultar Pacientes");
        vS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vS.setVisible(true);
    }
}
