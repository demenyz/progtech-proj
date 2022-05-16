import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class FormLogin extends JDialog{
    private JTextField fieldMail;
    private JButton buttonLogin;
    private JPasswordField fieldPw;
    private JPanel loginPanel;

    public FormLogin(JFrame parent) {

        super(parent);
        setTitle("Z & K Foodies Ltd. | Log in");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(500, 285));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        buttonLogin.addActionListener(e -> {
            String email = fieldMail.getText();
            String pw = String.valueOf(fieldPw.getPassword());

            u = authenticateUser(email, pw);

            if (email.isEmpty() || pw.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please fill all required fields!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            else{
                if (u != null){
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this,
                            "The provided credentials are invalid!\nPlease try again!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }


        });

        setVisible(true);

    }

    // Methods \/ -----------------------------------

    public User u;
    public static String user_id; // For other panels

    private User authenticateUser(String email, String pw) {

        User u = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/foodies?useSSL=false&serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE email=? AND password=?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, pw);

            // Get the information of the currently logged in user ... ----------------------
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()){
                u = new User();
                u.userid = rs.getString("id");
                u.first_name = rs.getString("first_name");
                u.last_name = rs.getString("last_name");
                u.email = rs.getString("email");
                u.phone = rs.getString("phone_number");
                u.password = rs.getString("password");
            }

            user_id = u.userid;

            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }


        return u;
    }
    private static String getIpAdd() {

        String ipAdd = "";

        try {
            URL getIpFromURL = new URL("https://checkip.amazonaws.com");

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    getIpFromURL.openStream()));

            ipAdd = in.readLine();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return ipAdd;
    }
    private static void addUserLog(FormLogin form, User u) {

        try{
            final String DB_URL = "jdbc:mysql://localhost:3306/foodies?useSSL=false&serverTimezone=UTC";
            final String USERNAME = "root";
            final String PASSWORD = "";

            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // If connection is successful ... -------------------------
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO user_log (email, login_date, ipaddress, status) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            if (u != null){
                preparedStatement.setString(1, u.email);
                preparedStatement.setString(4, "Successful");
            }
            else{
                preparedStatement.setString(1, form.fieldMail.getText());
                preparedStatement.setString(4, "Failed");
            }

            preparedStatement.setString(2, String.valueOf(LocalDateTime.now()));
            preparedStatement.setString(3, getIpAdd());


            preparedStatement.executeUpdate();

            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    public static String getUserId(){ // Needed to return the user's ID to other form ...

        return user_id;
    }

    // Main \/ -----------------------------------

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        FormLogin login = new FormLogin(null);
        User u = login.u;

        if (u != null) {
            System.out.println("|| LOG: A user just logged in! ( " + u.email + " - " + LocalDate.now() + " - " + LocalTime.now() + " )");

            login.dispose();
            FormBase.main(null);
            addUserLog(login, u);
        } else {
            addUserLog(login, u);
            System.out.println("|| LOG: Login failed! ( " + login.fieldMail.getText() + " - " + LocalDate.now() + " - " + LocalTime.now() + " )");
        }


    }
}
