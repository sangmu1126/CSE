import java.io.*;
import java.util.*;

public class Lab09_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OutputStreamWriter out = null;
        FileOutputStream fout = null;
        int c;
        try {
            fout = new FileOutputStream("c:/test/test3.txt");
            out = new OutputStreamWriter(fout, "UTF-8");
            while(true) {
                String line = scanner.nextLine();
                if(line.length()==0) {
                    break;
                }
                char[] buf = new char[10];
                
                out.write("\r\n",0,2);
            }
            out.close();
            fout.close();
        }
        catch (IOException e) {
            System.out.println("IO Error");
        }
        InputStreamReader in = null;
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("c:/test/test3.txt");
            in = new InputStreamReader(fin, "UTF-8");
            int k;
            char[] cbuf = new char[10];
            while((k=in.read(cbuf))!=-1) {
                System.out.print((char)k);
            }
            in.close();
            fin.close();
        }
        catch (IOException e) {
            System.out.println("IO Error");
        }
    }
}