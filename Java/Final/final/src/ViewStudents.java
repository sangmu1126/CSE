import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ViewStudents extends JFrame {
    private JList<String> studentList;
    private DefaultListModel<String> listModel;

    public ViewStudents(String professorId) {
        setTitle("View Students");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setupUI();
        loadStudents(professorId);
        setVisible(true);
    }

    private void setupUI() {
        listModel = new DefaultListModel<>();
        studentList = new JList<>(listModel);
        studentList.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(0, 87, 153));
        headerPanel.setPreferredSize(new Dimension(500, 70));

        JLabel headerLabel = new JLabel("View Students", SwingConstants.CENTER);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        headerPanel.add(headerLabel, BorderLayout.CENTER);

        add(headerPanel, BorderLayout.NORTH);
        add(new JScrollPane(studentList), BorderLayout.CENTER);
    }

    private void loadStudents(String professorId) {
        try (BufferedReader brCourses = new BufferedReader(new FileReader("Final/final/courses.txt"));
             BufferedReader brEnrolled = new BufferedReader(new FileReader("Final/final/enrolled_courses.txt"))) {

            Map<String, List<String>> courseStudentMap = new HashMap<>();
            String line;

            while ((line = brCourses.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[1].equals(professorId)) {
                    courseStudentMap.put(parts[0], new ArrayList<>());
                }
            }

            while ((line = brEnrolled.readLine()) != null) {
                String[] parts = line.split(":");
                if (courseStudentMap.containsKey(parts[1])) {
                    courseStudentMap.get(parts[1]).add(parts[0]);
                }
            }

            for (Map.Entry<String, List<String>> entry : courseStudentMap.entrySet()) {
                listModel.addElement(entry.getKey());
                for (String student : entry.getValue()) {
                    listModel.addElement("    - " + student);
                }
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading student data");
        }
    }

    public static void main(String[] args) {
        new ViewStudents("professor1");
    }
}
