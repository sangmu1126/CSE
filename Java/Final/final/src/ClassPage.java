import javax.swing.*;
import java.awt.*;

public class ClassPage extends JFrame {
    public ClassPage(String courseName, String professorName) {
        setTitle(courseName);
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(0, 87, 153));
        headerPanel.setPreferredSize(new Dimension(1200, 50));

        JLabel courseLabel = new JLabel(courseName, SwingConstants.CENTER);
        courseLabel.setForeground(Color.WHITE);
        courseLabel.setFont(new Font("Arial", Font.BOLD, 30));
        courseLabel.setPreferredSize(new Dimension(1200, 50));
        headerPanel.add(courseLabel, BorderLayout.CENTER);

        add(headerPanel);

        JPanel professorPanel = new JPanel();
        professorPanel.setLayout(new BorderLayout());
        professorPanel.setBackground(new Color(34, 34, 34));
        professorPanel.setPreferredSize(new Dimension(1200, 100));

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        leftPanel.setBackground(new Color(34, 34, 34));

        JLabel profilePicLabel = new JLabel(new ImageIcon(new ImageIcon("Final/final/default_pro.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
        JLabel professorLabel = new JLabel(professorName);
        professorLabel.setForeground(Color.WHITE);
        professorLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        leftPanel.add(profilePicLabel);
        leftPanel.add(professorLabel);

        professorPanel.add(leftPanel, BorderLayout.WEST);


        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setBackground(new Color(34, 34, 34));

        JLabel noticeTitleLabel = new JLabel("Notices", SwingConstants.CENTER);
        noticeTitleLabel.setForeground(Color.WHITE);
        noticeTitleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        noticeTitleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        rightPanel.add(noticeTitleLabel, BorderLayout.NORTH);

        JPanel noticePanel = new JPanel(new GridLayout(0, 1));
        noticePanel.setBackground(new Color(34, 34, 34));
        rightPanel.add(noticePanel, BorderLayout.CENTER);

        professorPanel.add(rightPanel, BorderLayout.CENTER);

        add(professorPanel);


        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPanel.setPreferredSize(new Dimension(1200, 100));

        JLabel overviewTitle = new JLabel("Course Outline");
        overviewTitle.setFont(new Font("Arial", Font.BOLD, 24));
        contentPanel.add(overviewTitle, BorderLayout.NORTH);


        JPanel overviewPanel = new JPanel();
        overviewPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

        JButton announcementButton = createButton("Notices", new Color(153, 102, 255));
        JButton qaButton = createButton("Course Q&A", new Color(255, 102, 102));

        overviewPanel.add(announcementButton);
        overviewPanel.add(qaButton);

        contentPanel.add(overviewPanel, BorderLayout.CENTER);

        add(contentPanel);


        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottomPanel.setPreferredSize(new Dimension(1200, 150));

        JLabel progressTitle = new JLabel("Attendance");
        progressTitle.setFont(new Font("Arial", Font.BOLD, 24));
        bottomPanel.add(progressTitle, BorderLayout.NORTH);


        JPanel attendancePanel = new JPanel();
        attendancePanel.setLayout(new GridLayout(2, 16));
        attendancePanel.setBackground(Color.WHITE);


        for (int i = 1; i <= 16; i++) {
            JLabel weekLabel = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            weekLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            attendancePanel.add(weekLabel);
        }

        String[] statuses = {
                "At", "Ab", "At", "L", "At", "Ab", "At", "At", "Ab", "At", "At", "L", "At", "At", "Ab", "At"
        };

        for (String status : statuses) {
            JLabel statusLabel = new JLabel(status, SwingConstants.CENTER);
            statusLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            statusLabel.setForeground(status.equals("At") ? Color.BLUE : status.equals("Ab") ? Color.RED : status.equals("L") ? Color.GREEN : Color.BLACK);
            attendancePanel.add(statusLabel);
        }

        bottomPanel.add(attendancePanel, BorderLayout.CENTER);

        add(bottomPanel);


        JPanel activityPanel = new JPanel();
        activityPanel.setLayout(new BorderLayout());
        activityPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        activityPanel.setPreferredSize(new Dimension(1200, 150));

        JLabel activityTitle = new JLabel("Weekly Learning Activities");
        activityTitle.setFont(new Font("Arial", Font.BOLD, 24));
        activityPanel.add(activityTitle, BorderLayout.NORTH);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (int i = 1; i <= 16; i++) {
            listModel.addElement(i + " Week");
        }

        JList<String> weekList = new JList<>(listModel);
        weekList.setFont(new Font("Arial", Font.PLAIN, 20));
        JScrollPane scrollPane = new JScrollPane(weekList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        activityPanel.add(scrollPane, BorderLayout.CENTER);

        add(activityPanel);

        setVisible(true);
    }

    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(150, 70));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        return button;
    }

    public static void main(String[] args) {
        new ClassPage("Java Programming", "WookLee");
    }
}
