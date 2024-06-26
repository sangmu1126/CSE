import java.io.*;
import java.util.Scanner;

public class Lab09_4 {
    public static void main(String[] args) {
        double time1 = System.currentTimeMillis();
        File src = new File("c:/test/dlwlrma.jpg");
        File dest = new File("c:/test/new.jpg");
        int c;
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            fi = new FileInputStream(src);
            fo = new FileOutputStream(dest);
            while((c = fi.read()) != -1) {
                fo.write((byte)c);
            }
            fi.close();
            fo.close();

        } catch (IOException e) {
            System.out.println("파일 복사 오류");
        }
        double time2 = System.currentTimeMillis();
        System.out.println("FileInputStream: " + (time2 - time1));


        long start = System.currentTimeMillis();
        try {
            BufferedInputStream bfi = new BufferedInputStream(fi);
            BufferedOutputStream bfo = new BufferedOutputStream(fo);
            new Scanner(System.in).nextLine();
            bfo.flush();
            bfi.close();
            bfo.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("BufferedInputStream: " + (end-start));
    }
}
