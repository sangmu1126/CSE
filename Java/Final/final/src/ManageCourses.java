import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class ManageCourses extends JFrame {
    private JList<String> courseList;
    private DefaultListModel<String> courseModel;
    private JButton addButton, deleteButton, updateButton;
    private JTextField courseField;
    private String professorId;

    public ManageCourses(String professorId) {
        this.professorId = professorId;
        setTitle("Manage Courses");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setupUI();
        loadCourses();
        setVisible(true);
    }

    private void setupUI() {
        setLayout(new BorderLayout());

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(0, 87, 153));
        headerPanel.setPreferredSize(new Dimension(600, 70));

        JLabel headerLabel = new JLabel("Manage Courses", SwingConstants.CENTER);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        headerPanel.add(headerLabel, BorderLayout.CENTER);

        add(headerPanel, BorderLayout.NORTH);

        courseModel = new DefaultListModel<>();
        courseList = new JList<>(courseModel);
        courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        courseList.setBackground(Color.WHITE);
        courseList.setFont(new Font("Arial", Font.PLAIN, 16));
        add(new JScrollPane(courseList), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        inputPanel.setBackground(new Color(240, 240, 240));

        courseField = new JTextField(20);
        addButton = createButton("Add Course");
        updateButton = createButton("Update Course");

        inputPanel.add(new JLabel("Course:"));
        inputPanel.add(courseField);
        inputPanel.add(addButton);
        inputPanel.add(updateButton);

        add(inputPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bottomPanel.setBackground(new Color(240, 240, 240));
        deleteButton = createButton("Delete Course");
        bottomPanel.add(deleteButton);

        add(bottomPanel, BorderLayout.SOUTH);

        addButton.addActionListener(this::addCourse);
        deleteButton.addActionListener(this::deleteCourse);
        updateButton.addActionListener(this::updateCourse);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0, 153, 204));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return button;
    }

    private void loadCourses() {
        courseModel.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("Final/final/courses.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                courseModel.addElement(line);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Failed to load courses.");
        }
    }

    private void addCourse(ActionEvent e) {
        String course = courseField.getText().trim();
        if (!course.isEmpty() && !courseModel.contains(course)) {
            courseModel.addElement(course);
            courseField.setText("");
            saveCourses();
        }
    }

    private void deleteCourse(ActionEvent e) {
        int index = courseList.getSelectedIndex();
        if (index != -1) {
            courseModel.remove(index);
            saveCourses();
        }
    }

    private void updateCourse(ActionEvent e) {
        int index = courseList.getSelectedIndex();
        if (index != -1 && !courseField.getText().trim().isEmpty()) {
            courseModel.set(index, courseField.getText().trim());
            courseField.setText("");
            saveCourses();
        }
    }

    private void saveCourses() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Final/final/courses.txt"))) {
            for (int i = 0; i < courseModel.size(); i++) {
                writer.write(courseModel.get(i) + "\n");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Failed to save courses.");
        }
    }

    public static void main(String[] args) {
        new ManageCourses("wookLee");
    }
}
