import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Lab09_3 {
    public static void main(String[] args) {
        FileReader fin = null;
        int c;
        
        System.out.println("<bart.txt>");
        try {
            fin = new FileReader("c:/test/bart.txt");
            BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
            while ((c=fin.read())!=-1) {
                out.write(c);
            }
            new Scanner(System.in).nextLine();
            out.flush();
            fin.close();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("<fox.txt>");
        try {
            fin = new FileReader("c:/test/fox.txt");
            BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
            while ((c=fin.read())!=-1) {
                out.write(c);
            }
            new Scanner(System.in).nextLine();
            out.flush();
            fin.close();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("<notebook.txt>");
        try {
            fin = new FileReader("c:/test/notebook.txt");
            BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
            while ((c=fin.read())!=-1) {
                out.write(c);
            }
            new Scanner(System.in).nextLine();
            out.flush();
            fin.close();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("<pinkman.txt>");
        try {
            fin = new FileReader("c:/test/pinkman.txt");
            BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
            while ((c=fin.read())!=-1) {
                out.write(c);
            }
            new Scanner(System.in).nextLine();
            out.flush();
            fin.close();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
