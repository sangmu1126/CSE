import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminPage extends JFrame {
    private JButton manageUsers;
    private JButton manageCourses;
    private JButton logoutButton;

    public AdminPage() {
        setTitle("Admin Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initializeComponents();
        setVisible(true);
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());


        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(0, 87, 153));
        headerPanel.setPreferredSize(new Dimension(600, 70));

        JLabel headerLabel = new JLabel("Admin Dashboard", SwingConstants.CENTER);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        headerPanel.add(headerLabel, BorderLayout.CENTER);

        add(headerPanel, BorderLayout.NORTH);


        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2, 1, 10, 10));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
        contentPanel.setBackground(Color.WHITE);

        manageUsers = createButton("Manage Users");
        manageCourses = createButton("Manage Courses");

        contentPanel.add(manageUsers);
        contentPanel.add(manageCourses);

        add(contentPanel, BorderLayout.CENTER);

        manageUsers.addActionListener(this::manageUsers);
        manageCourses.addActionListener(this::manageCourses);


        JPanel logoutPanel = new JPanel();
        logoutPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        logoutPanel.setBackground(Color.WHITE);

        logoutButton = createButton("Logout");
        logoutButton.addActionListener(e -> logout());

        logoutPanel.add(logoutButton);

        add(logoutPanel, BorderLayout.SOUTH);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0, 153, 204));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return button;
    }

    private void manageUsers(ActionEvent event) {
        new ManageUsers();
    }

    private void manageCourses(ActionEvent event) {
        new ManageCourses("admin");
    }

    private void logout() {
        this.dispose();
        new LoginPage();
    }

    public static void main(String[] args) {
        new AdminPage();
    }
}
