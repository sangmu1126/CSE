class Device_2 {
    private String name;
    private int year;

    public Device_2(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getInfor() {
        return name + " " + year;
    }
}

class S22_2 extends Device_2{
    private int price;

    public S22_2(String name, int year) {
        super(name, year);
        this.price = 1400;
    }

    @Override
    public String getInfor() {
        return super.getInfor() + " $" + price;
    }
}

class MP3_2 extends Device_2{
    private int price;

    public MP3_2(String name, int year) {
        super(name, year);
        this.price = 120;
    }

    @Override
    public String getInfor() {
        return super.getInfor() + " $" + price;
    }
}

class TV_2 extends Device_2{
    private int price;

    public TV_2(String name, int year) {
        super(name, year);
        this.price = 5000;
    }

    @Override
    public String getInfor() {
        return super.getInfor() + " $" + price;
    }
}

public class Lab05_2 {
    static void printInfor(Device_2 device2) {
        System.out.println(device2.getInfor());
    }

    public static void main(String[] args) {
        S22_2 s22 = new S22_2("S22", 2022);
        MP3_2 mp3 = new MP3_2("MP3", 2005);
        TV_2 tv = new TV_2("TV", 2017);

        Device_2[] devices = new Device_2[3];

        devices[0] = s22;
        devices[1] = mp3;
        devices[2] = tv;

        for(Device_2 dv : devices) {
            printInfor(dv);
        }
    }
}
