import javax.swing.*;
import java.awt.*;

public class Program3 extends JFrame {
    private MyPanel panel = new MyPanel();
    public Program3() {
        setTitle("p3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(200, 170);
        setVisible(true);
    }
    public void mo
    public static void main(String[] args) {

    }
    class MyPanel extends JPanel {
        public void paintComponent (Graphics g) {
            super.paintComponent(g);

        }
    }
}