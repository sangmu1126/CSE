package Lab06_1.device;

import Lab06_1.usb.USBA;

public class MP3 extends Device implements USBA{
    private int price = 120;
    public MP3 (String name, int year){
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
