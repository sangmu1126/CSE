import java.io.*;
import java.util.*;

public class Lab09_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileWriter fout = null;

        int c;
        try {
            fout = new FileWriter("c:/test/test2.txt");
            while(true) {
                String line = scanner.nextLine();
                if(line.length()==0) {
                    break;
                }
                fout.write(line, 0, line.length());
                fout.write("\r\n",0,2);
            }
            fout.close();
        }
        catch (IOException e) {
            System.out.println("IO Error");
        }

        FileReader fin = null;
        try {
            fin = new FileReader("c:/test/test2.txt");
            int k;
            while((k=fin.read())!=-1) {
                System.out.print((char)k);
            }
            fin.close();
        }
        catch (IOException e) {
            System.out.println("IO Error");
        }
    }
}