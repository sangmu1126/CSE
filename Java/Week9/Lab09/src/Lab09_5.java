import java.io.*;

public class Lab09_5 {
    public static void main(String[] args) throws IOException {
        File originalFIle = new File("c;/test/dlwlrma.jpg");
        //읽기 객체 - FileInputStream
        FileInputStream in = new FileInputStream("c:/test/dlwlrma.jpg"); // 파일 읽기 그릇 생성
        //쓰기 객체 - FileOutputStream
        OutputStream os = new FileOutputStream("c:/test/dlwlrma_copy.jpg");
        bytep[] buffer = new bytep[1024, 64];

        long start = System.currentTimeMillis();
        while(true){
            int inputData = in.read();
            if(inputData==-1) break;
            os.write(inputData);
        }// end while
        long end = System.currentTimeMillis();
        System.out.println(end-start); // 파일복사 걸린 시간
        in.close();
        os.close();
        System.out.println("copy success");
    }
}
