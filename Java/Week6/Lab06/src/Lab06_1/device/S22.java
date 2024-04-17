package Lab06_1.device;

import Lab06_1.usb.USBC;

public class S22 extends Device implements USBC{
    private int price = 1400;
    public S22 (String name, int year){
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
