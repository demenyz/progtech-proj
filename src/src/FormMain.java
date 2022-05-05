import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormMain extends JDialog {
    private JButton buttonReg;
    private JButton buttonLog;
    private JPanel mainPanel;

    public FormMain(JFrame parent) {

        super(parent);
        setTitle("Z & K Foodies Ltd. | Please choose an option!");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(400, 400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        // REGISTER BUTTON ----------------------------------
        buttonReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                FormRegister.main(null);
            }
        });

        // LOGIN BUTTON ----------------------------------
        buttonLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                FormLogin.main(null);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        FormMain main = new FormMain(null);
    }
}