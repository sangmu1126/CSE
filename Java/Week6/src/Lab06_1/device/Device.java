package Lab06_1.device;

public abstract class Device {
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
