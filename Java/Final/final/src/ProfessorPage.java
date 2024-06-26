import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProfessorPage extends JFrame {
    private JButton manageCourses;
    private JButton viewStudents;
    private JButton assignGradesButton;
    private String professorId;
    private JButton logoutButton;

    public ProfessorPage(String professorId) {
        this.professorId = professorId;
        setTitle("Professor Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Components();
        setVisible(true);
    }

    private void Components() {
        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(0, 87, 153));
        headerPanel.setPreferredSize(new Dimension(600, 70));

        JLabel headerLabel = new JLabel("Professor Dashboard", SwingConstants.CENTER);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        headerPanel.add(headerLabel, BorderLayout.CENTER);

        add(headerPanel, BorderLayout.NORTH);

        // Main content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(3, 1, 10, 10));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
        contentPanel.setBackground(Color.WHITE);

        manageCourses = createButton("Manage Courses");
        viewStudents = createButton("View Students");
        assignGradesButton = createButton("Assign Grades");

        contentPanel.add(manageCourses);
        contentPanel.add(viewStudents);
        contentPanel.add(assignGradesButton);

        add(contentPanel, BorderLayout.CENTER);

        manageCourses.addActionListener(this::manageCourses);
        viewStudents.addActionListener(this::viewStudents);
        assignGradesButton.addActionListener(this::assignGrades);

        // Footer panel
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        footerPanel.setBackground(Color.WHITE);

        logoutButton = createButton("Logout");
        logoutButton.addActionListener(e -> logout());

        footerPanel.add(logoutButton);

        add(footerPanel, BorderLayout.SOUTH);
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

    private void manageCourses(ActionEvent event) {
        new ManageCourses(professorId);
    }

    private void viewStudents(ActionEvent event) {
        new ViewStudents(professorId);
    }

    private void assignGrades(ActionEvent event) {
        new AssignGrades(professorId);
    }

    private void logout() {
        this.dispose();
        new LoginPage();
    }

    public static void main(String[] args) {
        new ProfessorPage("wookLee");
    }
}
