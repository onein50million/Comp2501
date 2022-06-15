package ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.electronics.printer;

import ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.electronics.Electronic;
import ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.electronics.port.DataPort;

/**
 * Printer.java COMP 2501 - CRN: 67139 Wednesday evenings, Spring/Summer 2022 Lab #9
 *
 * <p>Exploring Inheritance by developing a data class hierarchy.
 *
 * @author Monika Szucs
 * @author Daniel Wart
 *     <p>This Printer Class that will create the ArrayList and add the appropriate items to it
 *     while displaying the called information from other classes/methods
 */
public class Printer extends Electronic {

    public enum Mode {
        TEXT,
        NUMBER
    }

    public enum InkColor {
        YELLOW,
        BLACK,
        MAGENTA,
        CYAN
    }

    private final InkColor tonerColor;
    private int printsLeft;
    private Mode mode;
    private final boolean scanner;
    private final double beltLengthCm;
    private final double beltPriceCdn;

    private static final double MIN_BELT_LENGTH = 10;
    private static final double BELT_TOO_CHEAP = 1;
    private static final double BELT_TOO_EXPENSIVE = 400;
    private static final double SMALL_PRINTER = 15;
    private static final double MEDIUM_PRINTER = 35;

    private static final int PRINT_CAPACITY = 5;

    /**
     * This is the constructor for the Printer Class
     *
     * @param brand this is to see the brand of the printer
     * @param model this is to see the model of the printer
     * @param tonerColor this is to see what toner color the person will use
     * @param beltLengthCm this is to see what the length of the belt is inside the printer
     * @param beltPriceCdn Price of the belt in Canadian Dollars
     * @param priceCdn this is to check the price of the printer
     * @param powerCableAttached this is to see if the printer has an attached power cable or not
     * @param hasToner this is to see if the printer is using toner or ink
     * @param scanner this is to see if the printer has a scanner
     * @throws IllegalArgumentException This checks to see if there is an Illegal Argument Exception
     */
    public Printer(
            final String brand,
            final String model,
            final InkColor tonerColor,
            final double priceCdn,
            final boolean powerCableAttached,
            final boolean hasToner,
            final boolean scanner,
            final double beltLengthCm,
            final double beltPriceCdn) {
        super(
                brand,
                model,
                priceCdn,
                powerCableAttached,
                new DataPort[] {new DataPort(DataPort.PortType.USB_B)});
        if (beltLengthCm < MIN_BELT_LENGTH) {
            throw new IllegalArgumentException("Belt too short");
        }
        if (beltPriceCdn < BELT_TOO_CHEAP || beltPriceCdn > BELT_TOO_EXPENSIVE) {
            throw new IllegalArgumentException("Belt price is outside of allowed range");
        }

        this.beltLengthCm = beltLengthCm;
        this.beltPriceCdn = beltPriceCdn;

        if (hasToner) {
            this.printsLeft = PRINT_CAPACITY;
        } else {
            this.printsLeft = 0;
        }
        this.scanner = scanner;
        this.tonerColor = tonerColor;
        this.mode = Mode.TEXT;
    }

    /**
     * This is the belt length method
     *
     * <p>This will check if the printer is small, medium or large.
     */
    public String getBeltLength() {

        if (getBeltLengthCm() < SMALL_PRINTER) {
            return "This printer is too small";
        } else if (beltLengthCm <= MEDIUM_PRINTER) {
            return "This is a medium printer";
        } else {
            return "This printer is a large printer";
        }
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public InkColor getTonerColor() {
        return tonerColor;
    }

    public int getPrintsLeft() {
        return printsLeft;
    }

    public void refillToner() {
        this.printsLeft = PRINT_CAPACITY;
    }

    public boolean HasScanner() {
        return scanner;
    }

    public double getBeltLengthCm() {
        return beltLengthCm;
    }

    public double getBeltPriceCdn() {
        return beltPriceCdn;
    }

    /**
     * Printer method
     *
     * <p>This method is used to let the person know that the printer is printing when it calls this
     * method
     */
    public void print() {

        for (var port : this.dataPorts) {
            if (!port.isConnected()) {
                continue;
            }
            if (getPrintsLeft() > 0) {
                printsLeft -= 1;
                var buffer = port.getConnectedPort().getHost().getPrintBuffer();
                var outString = new StringBuilder();
                if (mode == Mode.TEXT) {
                    for (char c : buffer) {
                        outString.append(c);
                    }
                } else if (mode == Mode.NUMBER) {
                    for (char c : buffer) {
                        outString.append((int) c);
                    }
                }
                System.out.println(outString);
                port.getConnectedPort().getHost().clearPrintBuffer();

            } else {
                throw new OutOfTonerException("Printer has run out of prints");
            }
        }
    }
}
