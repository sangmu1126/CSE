interface USB_4 {
    void readUSB();
    default void writeUSB() {
        System.out.println("Can't write to USB");
    }
    // overiding에 대한 피로도를 줄임
    // overiding 시 접근 권한을 줄일 수 없음
}

interface USBA_4 extends USB_4 {
    void connectA();
}

interface USBC_4 extends USB_4 {
    void connectC();
}

class S22_4 implements USBC_4{
    private String name;
    @Override
    public void readUSB() {
        System.out.println(this.name + ": USB read");
    }
    @Override
    public void connectC() {
        System.out.println(this.name + ": USB-C connected");
    }

    @Override
    public void writeUSB() {
        System.out.println(this.name + ": USB write");
    }

    S22_4(String name) {
        this.name = name;
    }
}

class MP3_4 implements USBA_4{
    private String name;
    @Override
    public void readUSB() {
        System.out.println(this.name + ": USB read");
    }
    @Override
    public void connectA() {
        System.out.println(this.name + ": USB-A connected");
    }

    @Override
    public void writeUSB() {
        USBA_4.super.writeUSB();
    }
    MP3_4(String name) {
        this.name = name;
    }
}

public class Lab05_4 {
    static void connect(USB_4 u) {
        if (u instanceof USBA_4) {
            ((USBA_4) u).connectA();
        }
        else if (u instanceof USBC_4){
            ((USBC_4)u).connectC();
        }
    }
    static void readUSB(USB_4 u) {
        u.readUSB();
    }

    static void writeUSB(USB_4 u) {
        u.writeUSB();
    }

    public static void main(String[] args) {
        S22_4 s22 = new S22_4("S22");
        MP3_4 mp3 = new MP3_4("MP3");

        USB_4[] hub = new USB_4[] {s22, mp3};
        for (USB_4 u : hub) {
            connect(u);
            readUSB(u);
            writeUSB(u);
        }

    }
}
