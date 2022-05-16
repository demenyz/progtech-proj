import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.time.LocalDateTime;

public class FormBase extends JDialog{
    //private static FormBase basePanel;
    private JButton buttonOrder;
    private JPanel basePanel;
    private JTabbedPane panelSettings;
    private JButton buttonSave;
    private JTabbedPane FoodType;
    private JPanel Hamburger_field;
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
    private JTextField Ham_ing_text;
    private JTextField Ham_cal_text;
    private JTextField Ham_hot_text;
    private JLabel cal;
    private JButton searchAddButton;

    public FormBase(JFrame parent) {

        super(parent);
        setTitle("Z & K Foodies Ltd. | Place your order!");
        setContentPane(basePanel);
        setMinimumSize(new Dimension(800, 400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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
        Ham_cheese_radio.addActionListener(e -> {
            AbstractFactory hamburger_factory = FactoryProducer.getFactory(true);
            BaseFood hamburger = (BaseFood) hamburger_factory.create("CHEESE");
            Ham_price_text.setText( String.valueOf(hamburger.Price()));
            Ham_cal_text.setText(String.valueOf(hamburger.Calories()));
            Ham_ing_text.setText("ezt még meg kell csinálni");
            Ham_hot_text.setText(hamburger.Ishot() ? "Yes" : "No" );
        });
        Ham_jalapeno_radio.addActionListener(e -> {
            AbstractFactory hamburger_factory = FactoryProducer.getFactory(true);
            BaseFood hamburger = (BaseFood) hamburger_factory.create("JALAPENO");
            Ham_price_text.setText( String.valueOf(hamburger.Price()));
            Ham_cal_text.setText(String.valueOf(hamburger.Calories()));
            Ham_ing_text.setText("ezt még meg kell csinálni");
            Ham_hot_text.setText(hamburger.Ishot() ? "Yes" : "No" );
        });

        Ham_retro_radio.addActionListener(e -> {
            AbstractFactory hamburger_factory = FactoryProducer.getFactory(true);
            BaseFood hamburger = (BaseFood) hamburger_factory.create("RETRO");
            Ham_price_text.setText( String.valueOf(hamburger.Price()));
            Ham_cal_text.setText(String.valueOf(hamburger.Calories()));
            Ham_ing_text.setText("ezt még meg kell csinálni");
            Ham_hot_text.setText(hamburger.Ishot() ? "Yes" : "No" );
        });

        Ham_bacon_radio.addActionListener(e -> {
            AbstractFactory hamburger_factory = FactoryProducer.getFactory(true);
            BaseFood hamburger = (BaseFood) hamburger_factory.create("BACON");
            Ham_price_text.setText( String.valueOf(hamburger.Price()));
            Ham_cal_text.setText(String.valueOf(hamburger.Calories()));
            Ham_ing_text.setText("ezt még meg kell csinálni");
            Ham_hot_text.setText(hamburger.Ishot() ? "Yes" : "No" );
        });
        //------------------------------------------------------------------------
        //                  Pizza Radio_Buttons
        //------------------------------------------------------------------------

        Pizza_bolognese_radio.addActionListener(e -> {
            BaseFood pizza = new PizzaBolognese((BaseFood) new Pizza());
            Pizz_price_text.setText( String.valueOf(pizza.Price()));
            Pizz_cal_text.setText(String.valueOf(pizza.Calories()));
            Pizz_ing_text.setText("ezt még meg kell csinálni");
            Pizz_hot_text.setText(pizza.Ishot() ? "Yes" : "No" );
        });
        Pizza_margherita_radio.addActionListener(e -> {
            BaseFood pizza = new PizzaMargherita((BaseFood) new Pizza());
            Pizz_price_text.setText( String.valueOf(pizza.Price()));
            Pizz_cal_text.setText(String.valueOf(pizza.Calories()));
            Pizz_ing_text.setText("ezt még meg kell csinálni");
            Pizz_hot_text.setText(pizza.Ishot() ? "Yes" : "No" );
        });
        Pizza_threecheese_radio.addActionListener(e -> {
            BaseFood pizza = new PizzaThreeCheese((BaseFood) new Pizza());
            Pizz_price_text.setText( String.valueOf(pizza.Price()));
            Pizz_cal_text.setText(String.valueOf(pizza.Calories()));
            Pizz_ing_text.setText("ezt még meg kell csinálni");
            Pizz_hot_text.setText(pizza.Ishot() ? "Yes" : "No" );
        });
        Pizza_ungarische_radio.addActionListener(e -> {
            BaseFood pizza = new PizzaUngarische((BaseFood) new Pizza());
            Pizz_price_text.setText( String.valueOf(pizza.Price()));
            Pizz_cal_text.setText(String.valueOf(pizza.Calories()));
            Pizz_ing_text.setText("ezt még meg kell csinálni");
            Pizz_hot_text.setText(pizza.Ishot() ? "Yes" : "No" );
        });

        //------------------------------------------------------------------------
        //                  Pasta Radio_Buttons
        //------------------------------------------------------------------------


        Pasta_ham_radio.addActionListener(e -> {
            AbstractFactory pasta_factory = FactoryProducer.getFactory(false);
            BaseFood hamburger = (BaseFood) pasta_factory.create("HAM");
            Pas_price_text.setText( String.valueOf(hamburger.Price()));
            Pas_cal_text.setText(String.valueOf(hamburger.Calories()));
            Pas_ing_text.setText("ezt még meg kell csinálni");
            Pas_hot_text.setText(hamburger.Ishot() ? "Yes" : "No" );
        });
        Pasta_carbonara_radio.addActionListener(e -> {
            AbstractFactory pasta_factory = FactoryProducer.getFactory(false);
            BaseFood hamburger = (BaseFood) pasta_factory.create("CARBONARA");
            Pas_price_text.setText( String.valueOf(hamburger.Price()));
            Pas_cal_text.setText(String.valueOf(hamburger.Calories()));
            Pas_ing_text.setText("ezt még meg kell csinálni");
            Pas_hot_text.setText((hamburger.Ishot()) ? "Yes" : "No");
        });
        Pasta_cheese_radio.addActionListener(e -> {
            AbstractFactory pasta_factory = FactoryProducer.getFactory(false);
            BaseFood hamburger = (BaseFood) pasta_factory.create("CHEESE");
            Pas_price_text.setText( String.valueOf(hamburger.Price()));
            Pas_cal_text.setText(String.valueOf(hamburger.Calories()));
            Pas_ing_text.setText("ezt még meg kell csinálni");
            Pas_hot_text.setText((hamburger.Ishot()) ? "Yes" : "No");
        });
        Pasta_bolognese_radio.addActionListener(e -> {
            AbstractFactory pasta_factory = FactoryProducer.getFactory(false);
            BaseFood hamburger = (BaseFood) pasta_factory.create("BOLOGNESE");
            Pas_price_text.setText( String.valueOf(hamburger.Price()));
            Pas_cal_text.setText(String.valueOf(hamburger.Calories()));
            Pas_ing_text.setText("ezt még meg kell csinálni");
            Pas_hot_text.setText((hamburger.Ishot()) ? "Yes" : "No");
        });

        //------------------------------------------------------------------------
        //                         End_Food_Buttons
        //------------------------------------------------------------------------


        buttonOrder.addActionListener(e -> {
            BaseFood pizza = new PizzaThreeCheese((BaseFood) new Pizza());
        });

        buttonSave.addActionListener(e -> {
            if (userHasAddress()){
                JOptionPane.showMessageDialog(parent, "You already have an address registered on your account!", "Error!", JOptionPane.ERROR_MESSAGE);
                checkUserAddress();
            }
            else{
                addUserAddress();
            }
        });

        searchAddButton.addActionListener(e -> {
            if (userHasAddress()){
                checkUserAddress();
            }
            else{
                JOptionPane.showMessageDialog(parent, "No addresses found on your account!\nPlease add a new address using the form!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }

    // METHODS ---------------------------------

    public static String userId = FormLogin.getUserId();

    public Address add;
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

            preparedStatement.setInt(1, Integer.parseInt(userId));
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
    public void checkUserAddress() {

        add = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/foodies?useSSL=false&serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "SELECT user_id,city,street,number,apartment FROM user_address INNER JOIN users ON user_address.user_id=users.id WHERE user_address.user_id=?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userId);

            // Get the information of the currently logged-in user's address ... ----------------------
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()){
                add = new Address();
                add.user_id = rs.getInt("user_id");
                add.city = rs.getString("city");
                add.street = rs.getString("street");
                add.number = rs.getString("number");
                add.apartment = rs.getString("apartment");

            }


            fieldCity.setText(add.city);
            this.fieldStreet.setText(add.street);
            this.fieldNum.setText(add.number);
            this.fieldApartment.setText(add.apartment);
            System.out.println("|| LOG: User's address with the ID of '"+userId +"':\nCity: "+ add.city +"\nStreet: "+ add.street +" "+ add.number +"\nApartment: "+add.apartment);

            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        //return add; // Return the address of the user with the given ID ...
    }
    public boolean userHasAddress(){
        final String DB_URL = "jdbc:mysql://localhost:3306/foodies?useSSL=false&serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "SELECT user_id FROM user_address INNER JOIN users ON user_address.user_id=users.id WHERE user_address.user_id=?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userId);

            // Get the information of the currently logged-in user's address ... ----------------------
            ResultSet rs = preparedStatement.executeQuery();

            if (!rs.isBeforeFirst() ) {
                System.out.println("|| LOG: Address of the user does not exist. Please save one.");
                return false;
            }


            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return true;
    }
    public void addOrderLog(){
        try{
            final String DB_URL = "jdbc:mysql://localhost:3306/foodies?useSSL=false&serverTimezone=UTC";
            final String USERNAME = "root";
            final String PASSWORD = "";

            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // If connection is successful ... -------------------------
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO orders (order_date, order_price, order_qty, order_txt) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);


            preparedStatement.setString(1, String.valueOf(LocalDateTime.now()));
            preparedStatement.setString(2, "");
            preparedStatement.setInt(3, 10);
            preparedStatement.setString(4, "");


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

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        FormBase base = new FormBase(null);
    }

}
