import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentPage extends JFrame {
    private String username;
    private Map<String, String> courseProfessorMap;

    public StudentPage(String username) {
        this.username = username;
        this.courseProfessorMap = loadCourseProfessorMap();
        setTitle("I-Class");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setVisible(true);

        JPanel navPanel = new JPanel();
        navPanel.setLayout(new GridLayout(0, 1, 0, 1));
        navPanel.setBackground(new Color(45, 45, 45));
        navPanel.setPreferredSize(new Dimension(250, 800));

        String[] navItems = {"My Page", "Courses", "Non-Courses", "Community", "Chat", "Information"};
        for (String item : navItems) {
            JButton button = new JButton(item);
            button.setFocusPainted(false);
            button.setHorizontalAlignment(SwingConstants.CENTER); // Center align text horizontally
            button.setVerticalAlignment(SwingConstants.CENTER); // Center align text vertically
            button.setForeground(Color.WHITE);
            button.setBackground(new Color(45, 45, 45));
            button.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(200, 200, 200))); // Light gray border
            button.setPreferredSize(new Dimension(250, 40)); // Adjust height

            if (item.equals("My Page")) {
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showGrades();
                    }
                });
            }

            navPanel.add(button);
        }

        add(navPanel, BorderLayout.WEST);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(new Color(0, 87, 153));
        topPanel.setPreferredSize(new Dimension(1200, 70));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(0, 87, 153));
        titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        ImageIcon originalIcon = new ImageIcon("Final/final/inhaimg.png");
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(200, 55, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(resizedIcon);

        titlePanel.add(imageLabel);

        topPanel.add(titlePanel, BorderLayout.WEST);

        JPanel userInfoPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        userInfoPanel.setBackground(new Color(0, 87, 153));
        userInfoPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JLabel profilePicLabel = new JLabel(new ImageIcon(new ImageIcon("Final/final/default_pro.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        profilePicLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        userInfoPanel.add(profilePicLabel);

        JLabel usernameLabel = new JLabel(username);
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        userInfoPanel.add(usernameLabel);

        ImageIcon Icons = new ImageIcon(new ImageIcon("Final/final/icons.png").getImage().getScaledInstance(100, 40, Image.SCALE_SMOOTH));
        JLabel IconLabel = new JLabel(Icons);
        IconLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        userInfoPanel.add(IconLabel);

        JButton logoutButton = new JButton("LOGOUT");
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(new Color(0, 61, 107));
        logoutButton.setFocusPainted(false);
        logoutButton.addActionListener(e -> logout());
        logoutButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        userInfoPanel.add(logoutButton);

        topPanel.add(userInfoPanel, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel(" Courses");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // JList for course list
        DefaultListModel<Course> listModel = new DefaultListModel<>();
        JList<Course> courseList = new JList<>(listModel);
        courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        courseList.setCellRenderer(new CourseCellRenderer());
        courseList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Course selectedCourse = courseList.getSelectedValue();
                if (selectedCourse != null) {
                    new ClassPage(selectedCourse.getCourseName(), selectedCourse.getProfessorName());
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(courseList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getViewport().setBackground(Color.WHITE);

        List<String> courses = getUserCourses(username);

        for (String course : courses) {
            String professorName = courseProfessorMap.getOrDefault(course, "Unknown");
            listModel.addElement(new Course(course, professorName));
        }

        mainPanel.add(scrollPane, BorderLayout.CENTER);
    }

    private Map<String, String> loadCourseProfessorMap() {
        Map<String, String> map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Final/final/courses.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    map.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading courses file: " + e.getMessage());
        }
        return map;
    }

    private List<String> getUserCourses(String username) {
        List<String> userCourses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Final/final/enrolled_courses.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[0].equals(username)) {
                    userCourses.add(parts[1]);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading enrolled courses file: " + e.getMessage());
        }
        return userCourses;
    }

    private Map<String, String> getUserGrades(String username) {
        Map<String, String> grades = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Final/final/grades.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[0].equals(username)) {
                    grades.put(parts[1], parts[2]);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading grades file: " + e.getMessage());
        }
        return grades;
    }

    private void showGrades() {
        JFrame gradesFrame = new JFrame("Grades");
        gradesFrame.setSize(800, 600);
        gradesFrame.setLocationRelativeTo(null);
        gradesFrame.setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(0, 87, 153));
        headerPanel.setPreferredSize(new Dimension(800, 70));

        JLabel headerLabel = new JLabel("Grades", SwingConstants.CENTER);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        headerPanel.add(headerLabel, BorderLayout.CENTER);

        gradesFrame.add(headerPanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Map<String, String> grades = getUserGrades(username);

        String[] columnNames = {"Course", "Grade"};
        Object[][] data = new Object[grades.size()][2];
        int i = 0;
        for (Map.Entry<String, String> entry : grades.entrySet()) {
            data[i][0] = entry.getKey();
            data[i][1] = entry.getValue();
            i++;
        }

        JTable gradesTable = new JTable(data, columnNames);
        gradesTable.setFont(new Font("Arial", Font.PLAIN, 18));
        gradesTable.setRowHeight(30);
        gradesTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        gradesTable.getTableHeader().setBackground(new Color(0, 87, 153));
        gradesTable.getTableHeader().setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(gradesTable);
        scrollPane.setBackground(Color.WHITE);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        gradesFrame.add(contentPanel, BorderLayout.CENTER);

        gradesFrame.setVisible(true);
    }


    private class Course {
        private String courseName;
        private String professorName;

        public Course(String courseName, String professorName) {
            this.courseName = courseName;
            this.professorName = professorName;
        }

        public String getCourseName() {
            return courseName;
        }

        public String getProfessorName() {
            return professorName;
        }
    }

    private class CourseCellRenderer extends JPanel implements ListCellRenderer<Course> {
        private JLabel courseLabel;
        private JLabel professorLabel;
        private JLabel iconLabel;

        public CourseCellRenderer() {
            setLayout(new BorderLayout(10, 10));
            iconLabel = new JLabel();
            iconLabel.setPreferredSize(new Dimension(50, 50));
            courseLabel = new JLabel();
            courseLabel.setFont(new Font("Arial", Font.BOLD, 30));
            professorLabel = new JLabel();
            professorLabel.setFont(new Font("Arial", Font.PLAIN, 20));

            JPanel textPanel = new JPanel();
            textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
            textPanel.setBackground(Color.WHITE); // Set background to white
            textPanel.add(courseLabel);
            textPanel.add(professorLabel);

            add(iconLabel, BorderLayout.WEST);
            add(textPanel, BorderLayout.CENTER);
            setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY), // Add bottom border
                    BorderFactory.createEmptyBorder(5, 10, 5, 10) // Add padding
            ));
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Course> list, Course course, int index, boolean isSelected, boolean cellHasFocus) {
            courseLabel.setText(course.getCourseName());
            professorLabel.setText(course.getProfessorName());
            iconLabel.setIcon(new ImageIcon(new ImageIcon("Final/final/default_pro.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
            setBackground(isSelected ? new Color(200, 200, 255) : Color.WHITE); // Change background on selection
            return this;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentPage("sangmuLee").setVisible(true));
    }

    private void logout() {
        this.dispose();
        new LoginPage();
    }
}
