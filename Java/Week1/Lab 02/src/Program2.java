public class Program2 {
    public static void main(String[] args) {
        byte b1 = 60;
        byte b2 = 70;
        char c1 = 'A';
        char c2 = 1;

        int bSum = b1 + b2;
        int cSum = c1 + c2;

        System.out.println("bSum (value) : " + bSum);
        System.out.println("cSum (value) : " + cSum);
        System.out.println("cSum (letter) : " + (char)cSum);
    }
}
