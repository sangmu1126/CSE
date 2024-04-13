package Lab06_1.hub;

import Lab06_1.device.*;
import Lab06_1.usb.*;
import Lab06_1.hub.*;

public class Lab06_1 {
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
