import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormLogin extends JDialog{
    private JTextField fieldMail;
    private JButton buttonLogin;
    private JPasswordField passwordField1;
    private JPanel loginPanel;

    public FormLogin(JFrame parent) {

        super(parent);
        setTitle("Z & K Foodies Ltd. | Please choose an option!");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(400, 400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setVisible(true);

    }
    public static void main(String[] args){

        FormLogin login = new FormLogin(null);

    }
}
