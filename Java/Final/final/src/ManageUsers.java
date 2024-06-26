import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageUsers extends JFrame {
    private JTextField usernameField, passwordField;
    private JComboBox<String> roleComboBox;
    private JButton addButton, deleteButton;
    private JList<String> userList;
    private DefaultListModel<String> listModel;
    private static final String FILE_PATH = "Final/final/users.txt";

    public ManageUsers() {
        setTitle("Manage Users");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setupUI();
        loadUsers();
        setVisible(true);
    }

    private void setupUI() {
        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(0, 87, 153));
        headerPanel.setPreferredSize(new Dimension(1000, 70));

        JLabel headerLabel = new JLabel("Manage Users", SwingConstants.CENTER);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        headerPanel.add(headerLabel, BorderLayout.CENTER);

        add(headerPanel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        userList = new JList<>(listModel);
        userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        userList.setBackground(Color.WHITE);
        userList.setFont(new Font("Arial", Font.PLAIN, 16));
        add(new JScrollPane(userList), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 1, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        inputPanel.setBackground(new Color(240, 240, 240));

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        fieldsPanel.setBackground(new Color(240, 240, 240));

        usernameField = new JTextField(10);
        passwordField = new JTextField(10);
        roleComboBox = new JComboBox<>(new String[]{"admin", "student", "professor"});

        fieldsPanel.add(new JLabel("Username:"));
        fieldsPanel.add(usernameField);
        fieldsPanel.add(new JLabel("Password:"));
        fieldsPanel.add(passwordField);
        fieldsPanel.add(new JLabel("Role:"));
        fieldsPanel.add(roleComboBox);

        inputPanel.add(fieldsPanel);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonsPanel.setBackground(new Color(240, 240, 240));

        addButton = createButton("Add User");
        deleteButton = createButton("Delete User");

        buttonsPanel.add(addButton);
        buttonsPanel.add(deleteButton);

        inputPanel.add(buttonsPanel);

        add(inputPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();
            String role = roleComboBox.getSelectedItem().toString();
            addUser(username, password, role);
            listModel.addElement(username + " " + password + " " + role);
        });

        deleteButton.addActionListener(e -> {
            int index = userList.getSelectedIndex();
            if (index != -1) {
                deleteUser(index);
            }
        });
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

    private void loadUsers() {
        listModel.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                listModel.addElement(line);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Failed to load users.");
        }
    }

    private void addUser(String username, String password, String role) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(username + " " + password + " " + role + "\n");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Failed to write to file.");
        }
    }

    private void deleteUser(int index) {
        String toRemove = listModel.get(index);
        listModel.remove(index);
        List<String> out = new ArrayList<>();
        for (int i = 0; i < listModel.getSize(); i++) {
            out.add(listModel.get(i));
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String line : out) {
                bw.write(line + "\n");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Failed to update file.");
        }
    }

    public static void main(String[] args) {
        new ManageUsers();
    }
}
