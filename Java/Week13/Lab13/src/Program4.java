import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.filechooser.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Program4 extends JFrame {
    private JLabel imageLabel = new JLabel();
    public Program4() {
        setTitle("Change to gray");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.add(imageLabel);
        createMenu(); // 메뉴 생성, 프레임에 삽입
        setSize(250,200);
        setVisible(true);
    }
    private void createMenu() {
        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem openItem = new JMenuItem("Load");
        openItem.addActionListener(new OpenActionListener());
        menu.add(openItem);

        JMenuItem grayItem = new JMenuItem("Gray");
        grayItem.addActionListener(new GrayActionListener());
        menu.add(grayItem);

        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(new SaveActionListener());
        menu.add(saveItem);


        menu.add(new JMenuItem("Exit"));
        mb.add(menu);
        setJMenuBar(mb);
    }
    private BufferedImage modifyImageColor(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);

                // Get individual color components
                int alpha = (rgb >> 24) & 0xff;
                int red = (rgb >> 16) & 0xff;
                int green = (rgb >> 8) & 0xff;
                int blue = rgb & 0xff;

                // Convert to grayscale
                int gray = (red + green + blue) / 3;

                // Set the new pixel value
                int newRgb = (alpha << 24) | (gray << 16) | (gray << 8) | gray;
                result.setRGB(x, y, newRgb);
            }
        }

        return result;
    }

    class GrayActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (originalImage == null) {
                JOptionPane.showMessageDialog(null, "먼저 이미지를 로드하세요", "경고", JOptionPane.WARNING_MESSAGE);
                return;
            }
            grayImage = modifyImageColor(originalImage);
            imageLabel.setIcon(new ImageIcon(grayImage));
            pack();
        }
    }

    class OpenActionListener implements ActionListener {
        private JFileChooser chooser;
        public OpenActionListener() {
            chooser = new JFileChooser();
        }
        public void actionPerformed(ActionEvent e) {
            FileNameExtensionFilter filter =
                    new FileNameExtensionFilter("JPG & GIF Images",
                            "jpg", "gif");
            chooser.setFileFilter(filter);
            int ret = chooser.showOpenDialog(null);
            if(ret != JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(null,
                        "파일을 선택하지 않았습니 다", "경고",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            String filePath = chooser.getSelectedFile().getPath();
            imageLabel.setIcon(new ImageIcon(filePath));
            pack(); // 이미지의 크기에 맞추어 프레임 크기 조절
        }
    }

    class SaveActionListener implements ActionListener {
        private JFileChooser chooser;

        public SaveActionListener() {
            chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg", "jpeg");
            chooser.setFileFilter(filter);
        }

        public void actionPerformed(ActionEvent e) {
            if (grayImage == null) {
                JOptionPane.showMessageDialog(null, "먼저 이미지를 변환하세요", "경고", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int ret = chooser.showSaveDialog(null);
            if (ret != JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(null, "파일을 저장하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
                return;
            }

            File file = chooser.getSelectedFile();
            try {

                ImageIO.write(grayImage, "jpg", file);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    public static void main(String [] args) {
        new Program4();
    }
}
