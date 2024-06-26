import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Program1 extends JFrame {
    private Container contentPane;
    public Program1() {
        setTitle("Only numbers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = getContentPane();
        createToolBar();
        setSize(500,200);
        setVisible(true);
    }

    private void createToolBar() {
        JToolBar toolBar = new JToolBar("Only numbers");
        toolBar.setBackground(Color.LIGHT_GRAY);
        toolBar.add(new JLabel("Student ID: "));
        toolBar.addSeparator();
        TextField tf = new TextField("");
        tf.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_ENTER) {
                    String input = tf.getText();
                    if (!isNumeric(input)) {
                        tf.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                input + "is not a number.\nInput only numbers.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        toolBar.add(new JTextField(""));

        contentPane.add(toolBar, BorderLayout.SOUTH);
    }
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String [] args) {
        new Program1();
    }
}

class MyDialog extends JDialog {
    private JTextField tf = new JTextField("is not a number." + "\nInput only numbers.");
    private JButton okButton = new JButton("OK");
    public MyDialog(JFrame frame, String title) {
        super(frame,title);
        setLayout(new FlowLayout());
        add(tf);
        add(okButton);
        setSize(200, 100);
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}