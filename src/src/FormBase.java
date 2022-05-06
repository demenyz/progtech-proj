import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormBase extends JDialog{
    private JButton buttonOrder;
    private JPanel basePanel;
    private JTabbedPane panelSettings;
    private JButton saveButton;
    private JTabbedPane FoodType;
    private JPanel Pizza_field;
    private JPanel Hamburger_field;
    private JPanel Pasta_field;
    private JRadioButton yesRadioButton;
    private JRadioButton noRadioButton;
    private JRadioButton yesRadioButton1;
    private JRadioButton noRadioButton1;
    private JRadioButton margheritaRadioButton;
    private JRadioButton threeCheeseRadioButton;
    private JRadioButton ungarischeRadioButton;
    private JRadioButton bologneseRadioButton;
    private JTextField PizzaField;

    public FormBase(JFrame parent) {

        super(parent);
        setTitle("Z & K Foodies Ltd. | Place your order!");
        setContentPane(basePanel);
        setMinimumSize(new Dimension(800, 400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        buttonOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //Yes and No radiobutton settings ---------------------------------------
        ButtonGroup group = new ButtonGroup();
        group.add(margheritaRadioButton);
        group.add(ungarischeRadioButton);
        group.add(bologneseRadioButton);
        group.add(threeCheeseRadioButton);
        //------------------------------------------------------------------------



        threeCheeseRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BaseFood pizza = new PizzaThreeCheese((BaseFood) new Pizza());
                System.out.println(pizza.toString());
                PizzaField.setText(pizza.toString());
            }
        });
        buttonOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BaseFood pizza = new PizzaThreeCheese((BaseFood) new Pizza());
                System.out.println(pizza.toString());
            }
        });
        setVisible(true);
    }

    public static void main(String[] args){

        FormBase base = new FormBase(null);
    }

}
