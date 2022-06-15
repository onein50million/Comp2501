package ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart;

import ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.electronics.*;
import ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.electronics.printer.Printer;
import ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.electronics.port.DataPort;

/**
 * @version 2.0
 */
public class Main {
    // Code from https://en.wikipedia.org/wiki/Brainfuck#Hello_World!
    private static final String HELLO_WORLD_PROGRAM =
            "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
    // Code from https://gist.github.com/wxsBSD/31e2e9cf8b41d624403c91e6d7e6da3f
    private static final String FIBONACCI_PROGRAM =
            ",>+>+<<[->>[->+>+<<]<[->>+<<]>>[-<+>]>[-<<<+>>>]<<<<]>>.";

    /**
     * This is the main class where it will create the room object
     *
     * @param args this is the argument for the main
     */
    public static void main(String[] args) {
        Room room = new Room();
        room.buyElectronic(
                new Printer(
                        "Brother",
                        "HL-2280DW",
                        Printer.InkColor.BLACK,
                        36.0,
                        true,
                        true,
                        false,
                        250.0,
                        10.0));
        room.buyElectronic(
                new Laptop(
                        "Microsoft",
                        "Surface Pro 6",
                        2500.0,
                        true,
                        new DataPort[] {
                            new DataPort(DataPort.PortType.ETHERNET),
                            new DataPort(DataPort.PortType.USB_A),
                            new DataPort(DataPort.PortType.USB_A),
                            new DataPort(DataPort.PortType.USB_B),
                            new DataPort(DataPort.PortType.AUX)
                        },
                        14.5,
                        true,
                        true));
        room.buyElectronic(new Fan("Honeywell", "QC03", 60.0, 13.0, true, 3, true));
        room.buyElectronic(
                new Cellphone("Iphone", "XR", 1400.0, true, 80.0, 6.1, true, true, false));
        room.buyElectronic(new Speaker("Ultimate Ears", "Boom 3", 250.0, true, true, false));

        room.test();

        System.out.printf("Number of electronics in the room: %s\n", room.numElectronics());
        room.sellElectronic(0);
        System.out.printf("Number of electronics in the room: %s\n", room.numElectronics());

        Laptop laptop =
                new Laptop(
                        "DanielInc",
                        "DanTop",
                        10.0,
                        true,
                        new DataPort[] {
                            new DataPort(DataPort.PortType.USB_B),
                        },
                        14.5,
                        true,
                        true);
        Printer printer =
                new Printer(
                        "Sister",
                        "WD0822-LH",
                        Printer.InkColor.BLACK,
                        30000.0,
                        true,
                        true,
                        false,
                        250.0,
                        10.0);
        laptop.getAvailablePort(DataPort.PortType.USB_B)
                .connectPort(printer.getAvailablePort(DataPort.PortType.USB_B));
        laptop.programReadOnlyMemory(HELLO_WORLD_PROGRAM);
        laptop.runStoredProgram();
        printer.print();

        laptop.programReadOnlyMemory(FIBONACCI_PROGRAM);
        laptop.setKeyboardBuffer("\u0010"); // 16 in unicode
        laptop.runStoredProgram();
        printer.setMode(Printer.Mode.NUMBER);
        printer.print();
    }
}
