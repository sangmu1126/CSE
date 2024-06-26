import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ViewGrades extends JFrame {
    JTextArea gradesArea;

    public ViewGrades(String studentId) {
        setTitle("View Grades");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        gradesArea = new JTextArea(10, 30);
        gradesArea.setEditable(false);
        add(new JScrollPane(gradesArea));

        loadGrades(studentId);

        setVisible(true);
    }

    private void loadGrades(String studentId) {
        File file = new File("Final/final/grades.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[0].equals(studentId)) {
                    gradesArea.append(parts[1] + ": " + parts[2] + "\n");
                }
            }
        } catch (IOException ex) {
            gradesArea.setText("Failed to load grades");
        }
    }
}
