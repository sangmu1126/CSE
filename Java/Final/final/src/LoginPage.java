import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginPage extends JFrame {
    private JTextField user;
    private JPasswordField pw;
    private JButton loginButton;
    private JCheckBox rememberCheckBox;
    private JComboBox<String> langChoice;

    public LoginPage() {
        setTitle("Login");
        setSize(400, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initializeComponents();
        setVisible(true);
    }

    private void initializeComponents() {
        getContentPane().setBackground(new Color(0, 102, 204));

        JLabel loginLabel = new JLabel("LOGIN");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 16));
        loginLabel.setForeground(Color.WHITE);
        loginLabel.setBounds(10, 10, 100, 30);
        add(loginLabel);

        String[] languages = {"Korean", "English"};
        langChoice = new JComboBox<>(languages);
        langChoice.setBounds(300, 10, 80, 25);
        add(langChoice);

        user = new JTextField(20);
        user.setBounds(10, 50, 280, 30);
        add(user);

        pw = new JPasswordField(20);
        pw.setBounds(10, 90, 280, 30);
        add(pw);

        loginButton = new JButton("LOGIN");
        loginButton.setBackground(new Color(0, 153, 204));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBounds(300, 50, 80, 70);
        add(loginButton);

        rememberCheckBox = new JCheckBox("Remember ID");
        rememberCheckBox.setBounds(10, 130, 150, 30);
        rememberCheckBox.setBackground(new Color(0, 102, 204));
        rememberCheckBox.setForeground(Color.WHITE);
        add(rememberCheckBox);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkUser(user.getText(), new String(pw.getPassword()));
            }
        });
    }

    private void checkUser(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Final/final/users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    openDashboard(parts[2], username);
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Invalid username or password");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading from file");
        }
    }

    private void openDashboard(String role, String username) {
        switch (role) {
            case "admin":
                new AdminPage();
                break;
            case "student":
                new StudentPage(username);
                break;
            case "professor":
                new ProfessorPage(username);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Not involved in Inha Univ!");
                break;
        }
        dispose();
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
