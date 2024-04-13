package Lab06_1.device;

public class TV extends Device{
    private int price = 5000;
    public TV (String name, int year){
        super(name, year);
    }
    @Override
    public String getInfor() {
        return this.getName() + " " + this.getYear() + " $" + this.price;
    }
}
