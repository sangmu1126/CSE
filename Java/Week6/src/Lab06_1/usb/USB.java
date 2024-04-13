package Lab06_1.usb;

public interface USB {
    void readUSB();
    default void writeUSB() {
        System.out.println("Can't write to USB");
    }
}
