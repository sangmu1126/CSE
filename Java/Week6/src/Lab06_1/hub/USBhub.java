package Lab06_1.hub;

import Lab06_1.usb.*;

public class USBhub{
    USB[] hub = new USB[4];
    private int port = 0;

    public void addDevice(USB u) {
        if (port > 3) {
            System.out.println("USBhub is full!");
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
