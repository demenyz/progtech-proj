import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormBase extends JDialog{
    private JButton buttonOrder;
    private JPanel basePanel;
    private JTabbedPane panelSettings;
    private JButton saveButton;

    public FormBase(JFrame parent) {

        super(parent);
        setTitle("Z & K Foodies Ltd. | Place your order!");
        setContentPane(basePanel);
        setMinimumSize(new Dimension(1500, 800));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        buttonOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setVisible(true);

    }

    public static void main(String[] args){

        FormBase base = new FormBase(null);

    }

}
