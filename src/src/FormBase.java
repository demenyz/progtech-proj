import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class FormBase extends JDialog{
    //private static FormBase basePanel;
    private JButton buttonOrder;
    private JPanel basePanel;
    private JTabbedPane panelSettings;
    private JButton buttonSave;
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
    private JTabbedPane panelAddress;
    private JTextField fieldCity;
    private JTextField fieldStreet;
    private JTextField fieldNum;
    private JTextField fieldApartment;

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

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUserAddress();
            }
        });


        setVisible(true);
    }

    // METHODS ---------------------------------

    public User u;


    public void addUserAddress() {

        try{
            final String DB_URL = "jdbc:mysql://localhost:3306/foodies?useSSL=false&serverTimezone=UTC";
            final String USERNAME = "root";
            final String PASSWORD = "";

            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // If connection is successful ... -------------------------
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO user_address (user_id, city, street, number, apartment) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);


            preparedStatement.setInt(1, 20);
            preparedStatement.setString(2, this.fieldCity.getText());
            preparedStatement.setString(3, this.fieldStreet.getText());
            preparedStatement.setString(4, this.fieldNum.getText());
            preparedStatement.setString(5, this.fieldApartment.getText());


            preparedStatement.executeUpdate();

            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    //public static FormBase base;
    public static void main(String[] args){

        FormBase base = new FormBase(null);

    }

}
