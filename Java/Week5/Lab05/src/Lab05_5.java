abstract class Device {
    private String name;
    private int year;

    Device(String name, int year) {
        this.name = name;
        this.year = year;
    }
    protected String getName() {
        return name;
    }
    protected int getYear() {
        return year;
    }
    public abstract String getInfor();
}

interface USB {
    void readUSB();
    default void writeUSB() {
        System.out.println("Can't write to USB");
    }
}

interface USBA extends USB {
    void connectA();
}

interface USBC extends USB {
    void connectC();
}

class S22 extends Device implements USBC{
    private int price = 1400;
    S22 (String name, int year){
        super(name, year);
    }
    @Override
    public String getInfor() {
        return this.getName() + " " + this.getYear() + " $" + this.price;
    }
    public void readUSB() {
        System.out.println(this.getName() + ": USB read");
    }
    @Override
    public void connectC() {
        System.out.println(this.getName() + ": USB-C connected");
    }
    @Override
    public void writeUSB() {
        System.out.println(this.getName() + ": USB write");
    }
}

class MP3 extends Device implements USBA{
    private int price = 120;
    MP3 (String name, int year){
        super(name, year);
    }
    @Override
    public String getInfor() {
        return this.getName() + " " + this.getYear() + " $" + this.price;
    }
    public void readUSB() {
        System.out.println(this.getName() + ": USB read");
    }
    @Override
    public void connectA() {
        System.out.println(this.getName() + ": USB-A connected");
    }
    @Override
    public void writeUSB() {
        USBA.super.writeUSB();
    }
}

class TV extends Device{
    private int price = 5000;
    TV (String name, int year){
        super(name, year);
    }
    @Override
    public String getInfor() {
        return this.getName() + " " + this.getYear() + " $" + this.price;
    }
}
class USBhub{
    USB[] hub = new USB[4];
    private int port = 0;

    public void addDevice(USB u) {
        if (port > 3) {
            System.out.println("USBhub is fulL!");
            return;
        }

        this.hub[port] = u;
        port++;

        if (u instanceof USBA) {
            ((USBA) u).connectA();
        }
        else if (u instanceof USBC) {
            ((USBC) u).connectC();
        }
    }
    public void readUSBs() {
        for (USB u : this.hub) {
            if (u != null) u.readUSB();
        }
        System.out.println();
    }
    public void writeUSBs() {
        for (USB u : this.hub) {
            if (u != null) u.writeUSB();
        }
    }
}

public class Lab05_5 {
    static void printInfor(Device d) {
        System.out.println(d.getInfor());
    }
    public static void main(String[] args) {
        S22 s22 = new S22("S22", 2022);
        MP3 mp3 = new MP3("MP3", 2005);
        TV tv = new TV("TV", 2017);

        Device[] devices = new Device[] {s22, mp3, tv};
        USBhub hub = new USBhub();

        for (Device d : devices) {
            printInfor(d);
            if (d instanceof USB) {
                hub.addDevice((USB)d);
            }
        }

        System.out.println();
        hub.readUSBs();
        hub.writeUSBs();
    }
}
