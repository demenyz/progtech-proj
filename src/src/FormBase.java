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
    private JPanel Hamburger_field;
    private JRadioButton yesRadioButton;
    private JRadioButton noRadioButton;
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
    private JRadioButton Ham_bacon_radio;
    private JRadioButton Ham_retro_radio;
    private JRadioButton Ham_jalapeno_radio;
    private JRadioButton Ham_cheese_radio;
    private JTextField Ham_price_text;
    private JTextField Pizz_price_text;
    private JTextField Pizz_ing_text;
    private JTextField Pizz_cal_text;
    private JTextField Pizz_hot_text;
    private JTextField Pas_price_text;
    private JTextField Pas_ing_text;
    private JTextField Pas_cal_text;
    private JTextField Pas_hot_text;
    private JRadioButton Pizza_bolognese_radio;
    private JRadioButton Pizza_margherita_radio;
    private JRadioButton Pizza_threecheese_radio;
    private JRadioButton Pizza_ungarische_radio;
    private JRadioButton Pasta_ham_radio;
    private JRadioButton Pasta_carbonara_radio;
    private JRadioButton Pasta_cheese_radio;
    private JRadioButton Pasta_bolognese_radio;
    private JLabel cal;
    private JTextField Ham_ing_text;
    private JTextField Ham_cal_text;
    private JTextField Ham_hot_text;

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
        ButtonGroup Hamburger = new ButtonGroup();
        Hamburger.add(Ham_bacon_radio);
        Hamburger.add(Ham_cheese_radio);
        Hamburger.add(Ham_jalapeno_radio);
        Hamburger.add(Ham_retro_radio);
        ButtonGroup Pizza = new ButtonGroup();
        Pizza.add(Pizza_bolognese_radio);
        Pizza.add(Pizza_margherita_radio);
        Pizza.add(Pizza_threecheese_radio);
        Pizza.add(Pizza_ungarische_radio);
        ButtonGroup Pasta = new ButtonGroup();
        Pasta.add(Pasta_bolognese_radio);
        Pasta.add(Pasta_carbonara_radio);
        Pasta.add(Pasta_cheese_radio);
        Pasta.add(Pasta_ham_radio);
        //------------------------------------------------------------------------
        //                  Hamburger Radio_Buttons
        //------------------------------------------------------------------------
        Ham_cheese_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            AbstractFactory hamburger_factory = FactoryProducer.getFactory(true);
            BaseFood hamburger = (BaseFood) hamburger_factory.create("CHEESE");
            Ham_price_text.setText( String.valueOf(hamburger.Price()));
            Ham_cal_text.setText(String.valueOf(hamburger.Calories()));
            Ham_ing_text.setText("ezt még meg kell csinálni");
            Ham_hot_text.setText(String.valueOf((hamburger.Ishot()) ? "Yes" : "No" ));
            }
        });
        Ham_jalapeno_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractFactory hamburger_factory = FactoryProducer.getFactory(true);
                BaseFood hamburger = (BaseFood) hamburger_factory.create("JALAPENO");
                Ham_price_text.setText( String.valueOf(hamburger.Price()));
                Ham_cal_text.setText(String.valueOf(hamburger.Calories()));
                Ham_ing_text.setText("ezt még meg kell csinálni");
                Ham_hot_text.setText(String.valueOf((hamburger.Ishot()) ? "Yes" : "No" ));
            }
        });

        Ham_retro_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractFactory hamburger_factory = FactoryProducer.getFactory(true);
                BaseFood hamburger = (BaseFood) hamburger_factory.create("RETRO");
                Ham_price_text.setText( String.valueOf(hamburger.Price()));
                Ham_cal_text.setText(String.valueOf(hamburger.Calories()));
                Ham_ing_text.setText("ezt még meg kell csinálni");
                Ham_hot_text.setText(String.valueOf((hamburger.Ishot()) ? "Yes" : "No" ));
            }
        });

        Ham_bacon_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractFactory hamburger_factory = FactoryProducer.getFactory(true);
                BaseFood hamburger = (BaseFood) hamburger_factory.create("BACON");
                Ham_price_text.setText( String.valueOf(hamburger.Price()));
                Ham_cal_text.setText(String.valueOf(hamburger.Calories()));
                Ham_ing_text.setText("ezt még meg kell csinálni");
                Ham_hot_text.setText(String.valueOf((hamburger.Ishot()) ? "Yes" : "No" ));
            }
        });
        //------------------------------------------------------------------------
        //                  Pizza Radio_Buttons
        //------------------------------------------------------------------------

        Pizza_bolognese_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BaseFood pizza = new PizzaBolognese((BaseFood) new Pizza());
                Pizz_price_text.setText( String.valueOf(pizza.Price()));
                Pizz_cal_text.setText(String.valueOf(pizza.Calories()));
                Pizz_ing_text.setText("ezt még meg kell csinálni");
                Pizz_hot_text.setText(String.valueOf((pizza.Ishot()) ? "Yes" : "No" ));
            }
        });
        Pizza_margherita_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BaseFood pizza = new PizzaMargherita((BaseFood) new Pizza());
                Pizz_price_text.setText( String.valueOf(pizza.Price()));
                Pizz_cal_text.setText(String.valueOf(pizza.Calories()));
                Pizz_ing_text.setText("ezt még meg kell csinálni");
                Pizz_hot_text.setText(String.valueOf((pizza.Ishot()) ? "Yes" : "No" ));
            }
        });
        Pizza_threecheese_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BaseFood pizza = new PizzaThreeCheese((BaseFood) new Pizza());
                Pizz_price_text.setText( String.valueOf(pizza.Price()));
                Pizz_cal_text.setText(String.valueOf(pizza.Calories()));
                Pizz_ing_text.setText("ezt még meg kell csinálni");
                Pizz_hot_text.setText(String.valueOf((pizza.Ishot()) ? "Yes" : "No" ));
            }
        });
        Pizza_ungarische_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BaseFood pizza = new PizzaUngarische((BaseFood) new Pizza());
                Pizz_price_text.setText( String.valueOf(pizza.Price()));
                Pizz_cal_text.setText(String.valueOf(pizza.Calories()));
                Pizz_ing_text.setText("ezt még meg kell csinálni");
                Pizz_hot_text.setText(String.valueOf((pizza.Ishot()) ? "Yes" : "No" ));
            }
        });

        //------------------------------------------------------------------------
        //                  Pasta Radio_Buttons
        //------------------------------------------------------------------------


        Pasta_ham_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractFactory pasta_factory = FactoryProducer.getFactory(false);
                BaseFood hamburger = (BaseFood) pasta_factory.create("HAM");
                Pas_price_text.setText( String.valueOf(hamburger.Price()));
                Pas_cal_text.setText(String.valueOf(hamburger.Calories()));
                Pas_ing_text.setText("ezt még meg kell csinálni");
                Pas_hot_text.setText(String.valueOf((hamburger.Ishot()) ? "Yes" : "No" ));
            }
        });
        Pasta_carbonara_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractFactory pasta_factory = FactoryProducer.getFactory(false);
                BaseFood hamburger = (BaseFood) pasta_factory.create("CARBONARA");
                Pas_price_text.setText( String.valueOf(hamburger.Price()));
                Pas_cal_text.setText(String.valueOf(hamburger.Calories()));
                Pas_ing_text.setText("ezt még meg kell csinálni");
                Pas_hot_text.setText(String.valueOf((hamburger.Ishot()) ? "Yes" : "No" ));
            }
        });
        Pasta_cheese_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractFactory pasta_factory = FactoryProducer.getFactory(false);
                BaseFood hamburger = (BaseFood) pasta_factory.create("CHEESE");
                Pas_price_text.setText( String.valueOf(hamburger.Price()));
                Pas_cal_text.setText(String.valueOf(hamburger.Calories()));
                Pas_ing_text.setText("ezt még meg kell csinálni");
                Pas_hot_text.setText(String.valueOf((hamburger.Ishot()) ? "Yes" : "No" ));
            }
        });
        Pasta_bolognese_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractFactory pasta_factory = FactoryProducer.getFactory(false);
                BaseFood hamburger = (BaseFood) pasta_factory.create("BOLOGNESE");
                Pas_price_text.setText( String.valueOf(hamburger.Price()));
                Pas_cal_text.setText(String.valueOf(hamburger.Calories()));
                Pas_ing_text.setText("ezt még meg kell csinálni");
                Pas_hot_text.setText(String.valueOf((hamburger.Ishot()) ? "Yes" : "No" ));
            }
        });

        //------------------------------------------------------------------------
        //                         End_Food_Buttons
        //------------------------------------------------------------------------


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
