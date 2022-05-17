import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class FormBase extends JDialog{
    //private static FormBase basePanel;
    private JButton buttonOrder;
    private JPanel basePanel;
    private JTabbedPane panelSettings;
    private JButton buttonSave;
    private JTabbedPane Basket;
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
    private JTextArea basket_textbox;
    private JTextField Total_Price_text;
    private JButton undoLastItemOrderedButton;
    private JButton clearAllButton;

    public FormBase(JFrame parent) {

        super(parent);
        setTitle("Z & K Foodies Ltd. | Place your order!");
        setContentPane(basePanel);
        setMinimumSize(new Dimension(800, 400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        basket_textbox.append("Your Basket:");

        buttonOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

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
        Ham_cheese_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            AbstractFactory hamburger_factory = FactoryProducer.getFactory(true);
            BaseFood hamburger = (BaseFood) hamburger_factory.create("CHEESE");
            Ham_price_text.setText( String.valueOf(hamburger.Price()) + " HUF");
            Ham_cal_text.setText(String.valueOf(hamburger.Calories())+ " cal");
            Ham_ing_text.setText(hamburger.toString());
            Ham_hot_text.setText(String.valueOf((hamburger.Ishot()) ? "Yes" : "No" ));
            }
        });
        Ham_jalapeno_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractFactory hamburger_factory = FactoryProducer.getFactory(true);
                BaseFood hamburger = (BaseFood) hamburger_factory.create("JALAPENO");
                Ham_price_text.setText( String.valueOf(hamburger.Price()) + " HUF");
                Ham_cal_text.setText(String.valueOf(hamburger.Calories())+ " cal");
                Ham_ing_text.setText(hamburger.toString());
                Ham_hot_text.setText(String.valueOf((hamburger.Ishot()) ? "Yes" : "No" ));
            }
        });
        Ham_retro_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractFactory hamburger_factory = FactoryProducer.getFactory(true);
                BaseFood hamburger = (BaseFood) hamburger_factory.create("RETRO");
                Ham_price_text.setText( String.valueOf(hamburger.Price())+ " HUF");
                Ham_cal_text.setText(String.valueOf(hamburger.Calories())+ " cal");
                Ham_ing_text.setText(hamburger.toString());
                Ham_hot_text.setText(String.valueOf((hamburger.Ishot()) ? "Yes" : "No" ));
            }
        });
        Ham_bacon_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractFactory hamburger_factory = FactoryProducer.getFactory(true);
                BaseFood hamburger = (BaseFood) hamburger_factory.create("BACON");
                Ham_price_text.setText( String.valueOf(hamburger.Price())+ " HUF");
                Ham_cal_text.setText(String.valueOf(hamburger.Calories())+ " cal");
                Ham_ing_text.setText(hamburger.toString());
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
                Pizz_price_text.setText( String.valueOf(pizza.Price())+ " HUF");
                Pizz_cal_text.setText(String.valueOf(pizza.Calories())+ " cal");
                Pizz_ing_text.setText(pizza.toString());
                Pizz_hot_text.setText(String.valueOf((pizza.Ishot()) ? "Yes" : "No" ));
            }
        });
        Pizza_margherita_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BaseFood pizza = new PizzaMargherita((BaseFood) new Pizza());
                Pizz_price_text.setText( String.valueOf(pizza.Price())+ " HUF");
                Pizz_cal_text.setText(String.valueOf(pizza.Calories())+ " cal");
                Pizz_ing_text.setText(pizza.toString());
                Pizz_hot_text.setText(String.valueOf((pizza.Ishot()) ? "Yes" : "No" ));
            }
        });
        Pizza_threecheese_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BaseFood pizza = new PizzaThreeCheese((BaseFood) new Pizza());
                Pizz_price_text.setText( String.valueOf(pizza.Price())+ " HUF");
                Pizz_cal_text.setText(String.valueOf(pizza.Calories())+ " cal");
                Pizz_ing_text.setText(pizza.toString());
                Pizz_hot_text.setText(String.valueOf((pizza.Ishot()) ? "Yes" : "No" ));
            }
        });
        Pizza_ungarische_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BaseFood pizza = new PizzaUngarische((BaseFood) new Pizza());
                Pizz_price_text.setText( String.valueOf(pizza.Price())+ " HUF");
                Pizz_cal_text.setText(String.valueOf(pizza.Calories())+ " cal");
                Pizz_ing_text.setText(pizza.toString());
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
                BaseFood pasta = (BaseFood) pasta_factory.create("HAM");
                Pas_price_text.setText( String.valueOf(pasta.Price())+ " HUF");
                Pas_cal_text.setText(String.valueOf(pasta.Calories())+ " cal");
                Pas_ing_text.setText(pasta.toString());
                Pas_hot_text.setText(String.valueOf((pasta.Ishot()) ? "Yes" : "No" ));
            }
        });
        Pasta_carbonara_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractFactory pasta_factory = FactoryProducer.getFactory(false);
                BaseFood pasta = (BaseFood) pasta_factory.create("CARBONARA");
                Pas_price_text.setText( String.valueOf(pasta.Price())+ " HUF");
                Pas_cal_text.setText(String.valueOf(pasta.Calories())+ " cal");
                Pas_ing_text.setText(pasta.toString());
                Pas_hot_text.setText(String.valueOf((pasta.Ishot()) ? "Yes" : "No" ));
            }
        });
        Pasta_cheese_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractFactory pasta_factory = FactoryProducer.getFactory(false);
                BaseFood pasta = (BaseFood) pasta_factory.create("CHEESE");
                Pas_price_text.setText( String.valueOf(pasta.Price())+ " HUF");
                Pas_cal_text.setText(String.valueOf(pasta.Calories())+ " cal");
                Pas_ing_text.setText(pasta.toString());
                Pas_hot_text.setText(String.valueOf((pasta.Ishot()) ? "Yes" : "No" ));
            }
        });
        Pasta_bolognese_radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractFactory pasta_factory = FactoryProducer.getFactory(false);
                BaseFood pasta = (BaseFood) pasta_factory.create("BOLOGNESE");
                Pas_price_text.setText( String.valueOf(pasta.Price())+ " HUF");
                Pas_cal_text.setText(String.valueOf(pasta.Calories())+ " cal");
                Pas_ing_text.setText(pasta.toString());
                Pas_hot_text.setText(String.valueOf((pasta.Ishot()) ? "Yes" : "No" ));
            }
        });

        //------------------------------------------------------------------------
        //                         End_Food_Buttons
        //------------------------------------------------------------------------

        //------------------------------------------------------------------------
        //                         Get_button_text
        //------------------------------------------------------------------------


        buttonOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String order = Container.getSelectedButtonText(FoodButtons);
                if (order =="Jalapeno" ||order =="Cheese" || order =="Retro" || order == "Bacon")
                {
                    basket_textbox.append("\n"+order + " Hamburger " + Ham_price_text.getText());
                    Container.prices.add(Integer.valueOf(Ham_price_text.getText().substring(0,4)));
                    Total_Price_text.setText(String.valueOf(sum_prices((ArrayList<Integer>) Container.prices))+ " HUF");
                }
                else if (order =="Bolognese" ||order =="Margherita" || order =="Threecheese" || order == "Ungarische")
                {
                    basket_textbox.append("\n"+order + " Pizza " + Pizz_price_text.getText());
                    Container.prices.add(Integer.valueOf(Pizz_price_text.getText().substring(0,4)));
                    Total_Price_text.setText(String.valueOf(sum_prices((ArrayList<Integer>) Container.prices))+ " HUF");

                }
                else if (order =="Milanese" ||order =="Cheese" || order =="Carbonara" || order == "Ham"){
                    basket_textbox.append("\n"+order + " Pasta " + Pas_price_text.getText());
                    Container.prices.add(Integer.valueOf(Pas_price_text.getText().substring(0,4)));
                    Total_Price_text.setText(String.valueOf(sum_prices((ArrayList<Integer>) Container.prices))+ " HUF");
                }
                else {
                    System.out.println("Pick any food in the list");
                }

            }
        });

        undoLastItemOrderedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                    Total_Price_text.setText(String.valueOf(sum_prices((ArrayList<Integer>) Container.prices)) + " HUF");
                }

            }
        });

        clearAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            basket_textbox.setText(null);
            basket_textbox.append("Your Basket:");
            Container.prices.clear();
            Total_Price_text.setText("0 HUF");
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
    // PRICES LIST SUM
    public int sum_prices(ArrayList<Integer> list)
    {
        int amount=0;
        for (int i = 0; i < list.size() ; i++) {
            amount+= list.get(i);
        }
        return amount;
    }

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
