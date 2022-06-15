package ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart;

import ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.electronics.*;
import ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.electronics.printer.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * Room.java COMP 2501 - CRN: 67139 Wednesday evenings, Spring/Summer 2022 Lab #9
 *
 * <p>Exploring Inheritance by developing a data class hierarchy.
 *
 * @author Monika Szucs
 * @author Daniel Wart
 *     <p>This Room Class that will create the ArrayList and add the appropriate items to it while
 *     displaying the called information from other classes/methods
 */
public class Room {

    private static final double PRINTER_BUDGET = 25.0;
    private static final double CELLPHONE_BUDGET = 600.0;
    private static final double FAN_BUDGET = 10.0;
    private static final double LAPTOP_BUDGET = 5000.0;
    private static final double MODEM_BUDGET = 30.0;
    private static final double SPEAKER_BUDGET = 300.0;
    private static final char UNDERLINE_CHAR = '=';

    public final List<Electronic> electronics;

    /**
     * Constructor for Room Class
     *
     * <p>This is where the new electronics are added to the ArrayList. It will look through the
     * instance of each class to get the information needed
     */
    Room() {
        electronics = new ArrayList<>();
    }

    public void buyElectronic(Electronic e) {
        this.electronics.add(e);
    }

    public void sellElectronic(int index) {
        this.electronics.remove(index);
    }

    public int numElectronics() {
        return this.electronics.size();
    }

    public void test() {
        for (Electronic e : this.electronics) {
            System.out.println();
            System.out.println(e);
            var underlineString = new StringBuilder();
            for (int i = 0; i < e.toString().length(); i++) {
                underlineString.append(UNDERLINE_CHAR);
            }
            System.out.println(underlineString);
            if (e.checkPrice(getBudget(e))) {
                System.out.printf("%s is in budget!\n", e.getClass().getSimpleName());
            } else {
                System.out.printf("%s is too much money 😢\n", e.getClass().getSimpleName());
            }
            if (e instanceof Printer) {
                Printer printer = (Printer) e;
                printer.print();
                System.out.printf("Printer belt length: %scm\n", printer.getBeltLengthCm());
                System.out.println("How big is the printer?");
                System.out.println(printer.getBeltLength());
            }

            if (e instanceof Laptop) {
                Laptop laptop = (Laptop) e;
                System.out.printf("Laptop display size: %s\"\n", laptop.getDisplaySizeInches());
                System.out.println("How expensive is the laptop?");
                System.out.println(laptop.howExpensive());
                System.out.println("How big is the display?");
                System.out.println(laptop.howBig());
            }

            if (e instanceof Fan) {
                Fan fan = (Fan) e;
                System.out.printf("Fan temperature: %s °C\n", fan.getTemperatureCelsius());
                System.out.println("How hot does it feel?");
                System.out.println(fan.getTemperature());

                System.out.println("Oh no I'm moving my fan but my hands are covered in whale oil from all the illegal whaling I've been doing!");
                fan.drop();
            }

            if (e instanceof Cellphone) {
                Cellphone cell = (Cellphone) e;
                System.out.println("How would you describe the data plan?");
                System.out.println(cell.getDataPlanCategory());
            }

            if (e instanceof Speaker) {
                Speaker speaker = (Speaker) e;
                System.out.println("Where can I take the speaker to?");
                System.out.println(speaker.canTakeSpeakerTo());
                speaker.playSound();
            }
            System.out.println(" ");
        }
        System.out.println("\n");
    }

    private static double getBudget(Electronic e) {
        if (e instanceof Printer) {
            return PRINTER_BUDGET;
        } else if (e instanceof Cellphone) {
            return CELLPHONE_BUDGET;
        } else if (e instanceof Fan) {
            return FAN_BUDGET;
        } else if (e instanceof Laptop) {
            return LAPTOP_BUDGET;
        } else if (e instanceof ModemRouter) {
            return MODEM_BUDGET;
        } else if (e instanceof Speaker) {
            return SPEAKER_BUDGET;
        }
        throw new AssertionError("getBudget is missing a cases");
    }

    @Override
    public String toString() {
        return "Room{" + "electronics=" + electronics + '}';
    }
}
