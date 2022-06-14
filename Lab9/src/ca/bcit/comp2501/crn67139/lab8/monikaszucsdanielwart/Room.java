package ca.bcit.comp2501.crn67139.lab8.monikaszucsdanielwart;

import java.util.ArrayList;
import java.util.List;

/**
 * Room.java
 * COMP 2501 - CRN: 67139
 * Wednesday evenings, Spring/Summer 2022
 * Lab #9
 *
 * Exploring Inheritance by developing a data class hierarchy.
 *
 * @author Monika Szucs
 * @author Daniel Wart
 *
 * @version 1.2
 *
 * This Room Class that will create the ArrayList and add the appropriate items to it while displaying the
 * called information from other classes/methods
 *
 */
public class Room {
    private List<Electronic> eletronics;

    /**
     * Constructor for Room Class
     *
     * This is where the new electronics are added to the ArrayList. It will look through the instance of each class to
     * get the information needed
     */
    Room() {
        eletronics = new ArrayList<>();

        eletronics.add(new Printer("Brother", "HL-2280DW", "black", 36.0, 250.0, false, true, true));
        eletronics.add(new Laptop("Microsoft", "Surface Pro 6", 2500, 14.5, false, true, true));
        eletronics.add(new Fan("Honeywell", "QC03", 60, 13, true, true, true, true));
        eletronics.add(new Cellphone("Iphone", "XR", 1400, 80, 6.1, true, true, true, false));
        eletronics.add(new Speaker("Ultimate Ears", "Boom 3", 250, true, true, false));


        for(Electronic e: eletronics) {
            System.out.println(e);

            if (e instanceof Printer) {
                Printer printer = (Printer) e;
                printer.print();
                printer.checkPrice(e.getPrice());
                printer.getBeltLength();
            };

            if(e instanceof Laptop) {
                Laptop laptop = (Laptop) e;
                laptop.getDisplaySize();
                laptop.checkPrice(e.getPrice());
            }

            if(e instanceof Fan) {
                Fan fan = (Fan) e;
                fan.getTemperature();
                fan.getPrice();
                fan.kidProof();
            }

            if(e instanceof  Cellphone) {
                Cellphone cell = (Cellphone) e;
                cell.dataPlanTypes();
            }

            if(e instanceof Speaker) {
                Speaker speaker = (Speaker) e;
                speaker.canTakeSpeakerTo();
            }
            System.out.println(" ");
        }
    }

    /**
     * This is the main class where it will create the room object
     *
     * @param args this is the argument for the main
     */
    public static void main(final String[] args) {
        Room room;
        room = new Room();
    }

}
