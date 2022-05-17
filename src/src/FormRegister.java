import org.tinylog.Logger;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

public class FormRegister extends JDialog{

    //region Fields, buttons, etc.

    private JTextField fieldMail;
    private JTextField fieldFname;
    private JTextField fieldLname;
    private JPasswordField fieldPw;
    private JTextField fieldPhone;
    private JButton buttonRegister;
    private JButton buttonCancel;
    private JPanel registerPanel;

    //endregion

    public FormRegister(JFrame parent){

        //region Settings of the panel

        super(parent);
        setTitle("Z & K Foodies Ltd. | Register an account");
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(450, 450));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //endregion


        // Register -------------------------------------
        buttonRegister.addActionListener(e -> registerUser());

        // Cancel -------------------------------------
        buttonCancel.addActionListener(e -> dispose());

        setVisible(true);
    }


    //region Methods

    public User user;

    private void registerUser() {
        String first_name = fieldFname.getText();
        String last_name = fieldLname.getText();
        String email = fieldMail.getText();
        String phone = fieldPhone.getText();
        String password = String.valueOf(fieldPw.getPassword());

        if (first_name.isEmpty()
                || last_name.isEmpty()
                || email.isEmpty()
                || phone.isEmpty()
                || password.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please fill all required fields!", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        user = addUser(first_name, last_name, email, phone, password);

        if (user != null){
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(this, "An error occurred during registration!\nPlease try again!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    private User addUser(String first_name, String last_name, String email, String phone_number, String password) { // Add the new user to the Db ...
        User u = null;

        // Connection to Db -----------------------
        final String DB_URL = "jdbc:mysql://localhost:3306/foodies?useSSL=false&serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // If connection is successful ... -------------------------
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO users (first_name, last_name, email, phone_number, password) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phone_number);
            preparedStatement.setString(5, password);

            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0){
                u = new User();
                u.first_name = first_name;
                u.last_name = last_name;
                u.email = email;
                u.phone = phone_number;
                u.password = password;
                Logger.info("NEW REGISTRATION SUCCESSFUL! ( " + u.email + " - " + LocalDate.now() + " - " + LocalTime.now() + " )");
            }
            else{
                Logger.info("NEW REGISTRATION FAILED! ( " + fieldMail.getText() + " - " + LocalDate.now() + " - " + LocalTime.now() + " )");
            }

            stmt.close();
            conn.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }

        return u;
    }

    //endregion


    // MAIN -----------------------------
    public static void main(String[] args){

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Windows look instead of the ugly default one
        } catch (Exception e) {
            e.printStackTrace();
        }

        FormRegister reg = new FormRegister(null);
        User user = reg.user;

        if (user != null){
            FormLogin.main(null);
        }
    }
}
