import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AssignGrades extends JFrame {
    private JComboBox<String> courses;
    private JList<String> studentList;
    private DefaultListModel<String> studentListModel;
    private JComboBox<String> grades;
    private JButton assignGradeButton;
    private String professorId;

    public AssignGrades(String professorId) {
        this.professorId = professorId;
        setTitle("Assign Grades");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        JLabel Header = new JLabel("Assign Grades", SwingConstants.CENTER);
        Header.setForeground(Color.WHITE);
        Header.setFont(new Font("Arial", Font.BOLD, 30));
        headerPanel.add(Header, BorderLayout.CENTER);

        add(headerPanel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        courses = new JComboBox<>();
        loadCourses();
        courses.addActionListener(this::loadStudents);
        mainPanel.add(courses, BorderLayout.NORTH);

        studentListModel = new DefaultListModel<>();
        studentList = new JList<>(studentListModel);
        mainPanel.add(new JScrollPane(studentList), BorderLayout.CENTER);

        JPanel gradePanel = new JPanel();
        gradePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        grades = new JComboBox<>(new String[]{"A+", "A", "B+", "B", "C+", "C", "D+", "D", "F"});
        gradePanel.add(grades);

        assignGradeButton = new JButton("Assign Grade");
        assignGradeButton.addActionListener(this::assignGrade);
        gradePanel.add(assignGradeButton);

        mainPanel.add(gradePanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
    }

    private void loadCourses() {
        try (BufferedReader br = new BufferedReader(new FileReader("Final/final/courses.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[1].equals(professorId)) {
                    courses.addItem(parts[0]);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading courses");
        }
    }

    private void loadStudents(ActionEvent event) {
        studentListModel.clear();
        String selectedCourse = (String) courses.getSelectedItem();
        if (selectedCourse != null) {
            try (BufferedReader br = new BufferedReader(new FileReader("Final/final/enrolled_courses.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts[1].equals(selectedCourse)) {
                        studentListModel.addElement(parts[0]);
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error loading students");
            }
        }
    }

    private void assignGrade(ActionEvent event) {
        String selectedStudent = studentList.getSelectedValue();
        String selectedCourse = (String) courses.getSelectedItem();
        String selectedGrade = (String) grades.getSelectedItem();

        if (selectedStudent != null && selectedCourse != null && selectedGrade != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("Final/final/grades.txt", true))) {
                bw.write(selectedStudent + ":" + selectedCourse + ":" + selectedGrade + "\n");
                JOptionPane.showMessageDialog(this, "Grade assigned successfully.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error assigning grade.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student, course, and grade.");
        }
    }
}
