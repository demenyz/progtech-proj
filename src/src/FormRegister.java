import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class FormRegister extends JDialog{
    private JTextField fieldMail;
    private JTextField fieldFname;
    private JTextField fieldLname;
    private JPasswordField fieldPw;
    private JTextField fieldPhone;
    private JButton buttonRegister;
    private JButton buttonCancel;
    private JPanel registerPanel;

    public FormRegister(JFrame parent){ // Reg. panel
        super(parent);
        setTitle("Z & K Foodies Ltd. | Register an account");
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(450, 450));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        // Register -------------------------------------
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });

        // Cancel -------------------------------------
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    // METHODS -----------------------------

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

    public User user;
    private User addUser(String first_name, String last_name, String email, String phone, String password) { // Add the new user to the Db ...
        User u = null;

        // Connection to Db -----------------------
        final String DB_URL = "jdbc:mysql://localhost:3306/foodies?useSSL=false&serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // If connection is successful ... -------------------------
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO users (first_name, last_name, email, phone, password) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, password);

            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0){
                u = new User();
                u.first_name = first_name;
                u.last_name = last_name;
                u.email = email;
                u.phone = phone;
                u.password = password;
            }

            stmt.close();
            conn.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }

        return u;
    }


    // MAIN -----------------------------
    public static void main(String[] args){
        FormRegister reg = new FormRegister(null);
        User user = reg.user;

        if (user != null){
            System.out.println("Successful registration with the E-mail of: " + user.email);
        }
        else{
            System.out.println("An error occurred during registration!");
        }
    }
}
