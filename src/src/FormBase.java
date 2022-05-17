import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Objects;

public class FormBase extends JDialog{
    //private static FormBase basePanel;
    private JButton buttonOrder;
    private JPanel basePanel;
    private JTabbedPane panelSettings;
    private JButton buttonSave;
    private JTabbedPane Basket;
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
    private JTextArea basket_textbox;
    private JTextField Total_Price_text;
    private JButton undoLastItemOrderedButton;
    private JButton clearAllButton;
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
        basket_textbox.append("Your Basket:");

        //Yes and No radiobutton settings ---------------------------------------
        ButtonGroup FoodButtons = new ButtonGroup();
        FoodButtons.add(Ham_bacon_radio);
        FoodButtons.add(Ham_cheese_radio);
        FoodButtons.add(Ham_jalapeno_radio);
        FoodButtons.add(Ham_retro_radio);
        FoodButtons.add(Pizza_bolognese_radio);
        FoodButtons.add(Pizza_margherita_radio);
        FoodButtons.add(Pizza_threecheese_radio);
        FoodButtons.add(Pizza_ungarische_radio);
        FoodButtons.add(Pasta_bolognese_radio);
        FoodButtons.add(Pasta_carbonara_radio);
        FoodButtons.add(Pasta_cheese_radio);
        FoodButtons.add(Pasta_ham_radio);
        //------------------------------------------------------------------------
        //                  Hamburger Radio_Buttons
        //------------------------------------------------------------------------
        Ham_cheese_radio.addActionListener(e -> {
            AbstractFactory hamburger_factory = FactoryProducer.getFactory(true);
            BaseFood hamburger = (BaseFood) hamburger_factory.create("CHEESE");
            Ham_price_text.setText(hamburger.Price() + " HUF");
            Ham_cal_text.setText(hamburger.Calories() + " cal");
            Ham_ing_text.setText(hamburger.toString());
            Ham_hot_text.setText((hamburger.Ishot()) ? "Yes" : "No");
        });
        Ham_jalapeno_radio.addActionListener(e -> {
            AbstractFactory hamburger_factory = FactoryProducer.getFactory(true);
            BaseFood hamburger = (BaseFood) hamburger_factory.create("JALAPENO");
            Ham_price_text.setText(hamburger.Price() + " HUF");
            Ham_cal_text.setText(hamburger.Calories() + " cal");
            Ham_ing_text.setText(hamburger.toString());
            Ham_hot_text.setText((hamburger.Ishot()) ? "Yes" : "No");
        });
        Ham_retro_radio.addActionListener(e -> {
            AbstractFactory hamburger_factory = FactoryProducer.getFactory(true);
            BaseFood hamburger = (BaseFood) hamburger_factory.create("RETRO");
            Ham_price_text.setText(hamburger.Price() + " HUF");
            Ham_cal_text.setText(hamburger.Calories() + " cal");
            Ham_ing_text.setText(hamburger.toString());
            Ham_hot_text.setText((hamburger.Ishot()) ? "Yes" : "No");
        });
        Ham_bacon_radio.addActionListener(e -> {
            AbstractFactory hamburger_factory = FactoryProducer.getFactory(true);
            BaseFood hamburger = (BaseFood) hamburger_factory.create("BACON");
            Ham_price_text.setText(hamburger.Price() + " HUF");
            Ham_cal_text.setText(hamburger.Calories() + " cal");
            Ham_ing_text.setText(hamburger.toString());
            Ham_hot_text.setText((hamburger.Ishot()) ? "Yes" : "No");
        });
        //------------------------------------------------------------------------
        //                  Pizza Radio_Buttons
        //------------------------------------------------------------------------

        Pizza_bolognese_radio.addActionListener(e -> {
            BaseFood pizza = new PizzaBolognese(new Pizza());
            Pizz_price_text.setText(pizza.Price() + " HUF");
            Pizz_cal_text.setText(pizza.Calories() + " cal");
            Pizz_ing_text.setText(pizza.toString());
            Pizz_hot_text.setText((pizza.Ishot()) ? "Yes" : "No");
        });
        Pizza_margherita_radio.addActionListener(e -> {
            BaseFood pizza = new PizzaMargherita(new Pizza());
            Pizz_price_text.setText(pizza.Price() + " HUF");
            Pizz_cal_text.setText(pizza.Calories() + " cal");
            Pizz_ing_text.setText(pizza.toString());
            Pizz_hot_text.setText((pizza.Ishot()) ? "Yes" : "No");
        });
        Pizza_threecheese_radio.addActionListener(e -> {
            BaseFood pizza = new PizzaThreeCheese(new Pizza());
            Pizz_price_text.setText(pizza.Price() + " HUF");
            Pizz_cal_text.setText(pizza.Calories() + " cal");
            Pizz_ing_text.setText(pizza.toString());
            Pizz_hot_text.setText((pizza.Ishot()) ? "Yes" : "No");
        });
        Pizza_ungarische_radio.addActionListener(e -> {
            BaseFood pizza = new PizzaUngarische(new Pizza());
            Pizz_price_text.setText(pizza.Price() + " HUF");
            Pizz_cal_text.setText(pizza.Calories() + " cal");
            Pizz_ing_text.setText(pizza.toString());
            Pizz_hot_text.setText((pizza.Ishot()) ? "Yes" : "No");
        });

        //------------------------------------------------------------------------
        //                  Pasta Radio_Buttons
        //------------------------------------------------------------------------

        Pasta_ham_radio.addActionListener(e -> {
            AbstractFactory pasta_factory = FactoryProducer.getFactory(false);
            BaseFood pasta = (BaseFood) pasta_factory.create("HAM");
            Pas_price_text.setText(pasta.Price() + " HUF");
            Pas_cal_text.setText(pasta.Calories() + " cal");
            Pas_ing_text.setText(pasta.toString());
            Pas_hot_text.setText((pasta.Ishot()) ? "Yes" : "No");
        });
        Pasta_carbonara_radio.addActionListener(e -> {
            AbstractFactory pasta_factory = FactoryProducer.getFactory(false);
            BaseFood pasta = (BaseFood) pasta_factory.create("CARBONARA");
            Pas_price_text.setText(pasta.Price() + " HUF");
            Pas_cal_text.setText(pasta.Calories() + " cal");
            Pas_ing_text.setText(pasta.toString());
            Pas_hot_text.setText((pasta.Ishot()) ? "Yes" : "No");
        });
        Pasta_cheese_radio.addActionListener(e -> {
            AbstractFactory pasta_factory = FactoryProducer.getFactory(false);
            BaseFood pasta = (BaseFood) pasta_factory.create("CHEESE");
            Pas_price_text.setText(pasta.Price() + " HUF");
            Pas_cal_text.setText(pasta.Calories() + " cal");
            Pas_ing_text.setText(pasta.toString());
            Pas_hot_text.setText((pasta.Ishot()) ? "Yes" : "No");
        });
        Pasta_bolognese_radio.addActionListener(e -> {
            AbstractFactory pasta_factory = FactoryProducer.getFactory(false);
            BaseFood pasta = (BaseFood) pasta_factory.create("BOLOGNESE");
            Pas_price_text.setText(pasta.Price() + " HUF");
            Pas_cal_text.setText(pasta.Calories() + " cal");
            Pas_ing_text.setText(pasta.toString());
            Pas_hot_text.setText((pasta.Ishot()) ? "Yes" : "No");
        });


        //------------------------------------------------------------------------
        //                         End_Food_Buttons
        //------------------------------------------------------------------------

        //------------------------------------------------------------------------
        //                         Get_button_text
        //------------------------------------------------------------------------


        buttonOrder.addActionListener(e -> {
            String order = Container.getSelectedButtonText(FoodButtons);
            if (Objects.equals(order, "Jalapeno") || Objects.equals(order, "Cheese") || Objects.equals(order, "Retro") || Objects.equals(order, "Bacon"))
            {
                basket_textbox.append("\n"+order + " Hamburger " + Ham_price_text.getText());
                Container.prices.add(Integer.valueOf(Ham_price_text.getText().substring(0,4)));
                Total_Price_text.setText(sum_prices((ArrayList<Integer>) Container.prices) + " HUF");
            }
            else if (Objects.equals(order, "Bolognese") || Objects.equals(order, "Margherita") || Objects.equals(order, "Threecheese") || Objects.equals(order, "Ungarische"))
            {
                basket_textbox.append("\n"+order + " Pizza " + Pizz_price_text.getText());
                Container.prices.add(Integer.valueOf(Pizz_price_text.getText().substring(0,4)));
                Total_Price_text.setText(sum_prices((ArrayList<Integer>) Container.prices) + " HUF");

            }
            else if (Objects.equals(order, "Milanese") || Objects.equals(order, "Cheese and cream") || Objects.equals(order, "Carbonara") || Objects.equals(order, "Ham")){
                basket_textbox.append("\n"+order + " Pasta " + Pas_price_text.getText());
                Container.prices.add(Integer.valueOf(Pas_price_text.getText().substring(0,4)));
                Total_Price_text.setText(sum_prices((ArrayList<Integer>) Container.prices) + " HUF");
            }
            else {
                System.out.println("Pick any food in the list");
            }

        });

        undoLastItemOrderedButton.addActionListener(e -> {
            String content = null;
            try {
                content = basket_textbox.getDocument().getText(0, basket_textbox.getDocument().getLength());
            } catch (BadLocationException ex) {
                System.out.println("You can't remove more lines");
            }
            int lastLineBreak = content.lastIndexOf('\n');
            try {
                basket_textbox.getDocument().remove(lastLineBreak, basket_textbox.getDocument().getLength() - lastLineBreak);
            } catch (BadLocationException ex) {
                System.out.println("You can't remove more lines");
            }
            if (Container.prices.size() == 0)
            {
                System.out.println("You can't remove more price");
            }
            else{
                Container.total_price = Integer.valueOf(Total_Price_text.getText().substring(0,4));
                Container.prices.remove(Container.prices.size()-1);
                Total_Price_text.setText(sum_prices((ArrayList<Integer>) Container.prices) + " HUF");
            }

        });

        clearAllButton.addActionListener(e -> {
            basket_textbox.setText(null);
            basket_textbox.append("Your Basket:");
            Container.prices.clear();
            Total_Price_text.setText("0 HUF");
        });
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
    public User u;
    // PRICES LIST SUM
    public int sum_prices(ArrayList<Integer> list)
    {
        int amount=0;
        for (int i = 0; i < list.size() ; i++) {
            amount+= list.get(i);
        }
        return amount;
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
