import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame {
    private JTextField txtUsuario;
    private JTextField txtPassword;
    private JButton btnLogin;
    private JButton btnCancelar;
    private JPanel miPanel;

    public Login() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (txtUsuario.getText().equals("admin") && txtPassword.getText().equals("0000"))
                {
                    JOptionPane.showMessageDialog(miPanel,"Bienvenido, Administrador");
                    dispose();
                    String[] tipoUsuario={"admin"};
                    Sistema.main(tipoUsuario);
                }
                else if(txtUsuario.getText().equals("usuario") && txtPassword.getText().equals("2222"))
                {
                    JOptionPane.showMessageDialog(miPanel,"Bienvenido, Usuario");
                    dispose();
                    String[] tipoUsuario={"usuario"};
                    Sistema.main(tipoUsuario);
                }
                else
                {
                    //info no valida
                    JOptionPane.showMessageDialog(miPanel,"El usuario o contraseña es invalido.");

                }
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void  main(String[] args){
        Login vLogin = new Login();
        vLogin.setContentPane(vLogin.miPanel);
        vLogin.setSize(300,300);
        vLogin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        vLogin.setVisible(true);
    }
}
