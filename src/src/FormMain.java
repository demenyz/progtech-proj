import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormMain extends JDialog {

    //region Fields, buttons, etc.

    private JButton buttonReg;
    private JButton buttonLog;
    private JPanel mainPanel;

    //endregion

    public FormMain(JFrame parent) {

        //region Settings of the panel

        super(parent);
        setTitle("Z & K Foodies Ltd. | Please login or register!");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(350, 300));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //endregion


        //region Register & Login button

        buttonReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                FormRegister.main(null);
            }
        });

        buttonLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                FormLogin.main(null);
            }
        });

        //endregion

        setVisible(true);
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Windows look instead of the ugly default one
        } catch (Exception e) {
            e.printStackTrace();
        }

        FormMain main = new FormMain(null);
    }
}