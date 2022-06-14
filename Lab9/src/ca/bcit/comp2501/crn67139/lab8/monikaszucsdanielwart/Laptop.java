package ca.bcit.comp2501.crn67139.lab8.monikaszucsdanielwart;

/**
 * Laptop.java
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
 * This Laptop Class that will create the appropriate constructor and methods
 *
 */
class Laptop extends Electronic {
    private double displaySizeInches;
    private boolean touchPad;
    private boolean wirelessMouse;

    private static final int MIN_PRICE                      = 0;
    private static final int IMPOSSIBLE_SCREEN_SIZE         = 0;
    private static final int CHEAP_LAPTOP                   = 1000;
    private static final int EXPENSIVE_LAPTOP               = 4000;
    private static final int SMALL_TO_MEDIUM_DISPLAY_SIZE   = 10;
    private static final int MEDIUM_TO_LARGE_DISPLAY_SIZE   = 18;

    /**
     * This is the constructor for the Laptop Class
     *
     * @param brand this is the brand of the laptop
     * @param model this is the model of the laptop
     * @param priceCdn this is the price of the laptop
     * @param displaySizeInches this is the display size of the laptop in inches
     * @param powerCableAttached this is to see if the power cable is directly attached or not
     * @param touchPad this is to see if the laptop has a touchpad or not
     * @param wirelessMouse this is to see if the laptop is using a wireless mouse
     *
     * @throws IllegalArgumentException this checks to see if there is an Illegal Argument Exception
     */
    Laptop(final String brand,
           final String model,
           final double priceCdn,
           final double displaySizeInches,
           final boolean powerCableAttached,
           final boolean touchPad,
           final boolean wirelessMouse
    ) {
        super(brand, model, priceCdn, powerCableAttached);

        if(brand == null || brand.isEmpty()) {
            throw new IllegalArgumentException("There must be a brand name");
        }

        if(model == null || model.isEmpty()) {
            throw new IllegalArgumentException("There must be a model type");
        }

        if(priceCdn <= MIN_PRICE) {
            throw new IllegalArgumentException("That is a incorrect price you have entered.");
        }

        if(displaySizeInches <= IMPOSSIBLE_SCREEN_SIZE) {
            throw new IllegalArgumentException("This value is not valid for the display size");
        }

        this.displaySizeInches = displaySizeInches;
        this.touchPad = touchPad;
        this.wirelessMouse = wirelessMouse;
    }

    /**
     * This is the method to check the price of the laptop. It will either be too cheap, too expensive or within budget
     *
     * @param price this is the price of the laptop the person paid for at the time
     */
    public void checkPrice(final double price) {
        if(price <= MIN_PRICE) {
            throw new IllegalArgumentException("That is a incorrect price you have entered.");
        } else if(price <= CHEAP_LAPTOP) {
            System.out.println("Too cheap");
        } else if(price >= EXPENSIVE_LAPTOP) {
            System.out.println("Too expensive");
        } else {
            System.out.println("It is a good option");
        }
    }

    /**
     * This is the method to see what the display size is on the laptop in inches.
     *
     * The display size might either be small, medium or large
     */
    public void getDisplaySize() {
         if(displaySizeInches <= SMALL_TO_MEDIUM_DISPLAY_SIZE ) {
             System.out.println("This is a small display screen");
         } else if(displaySizeInches > SMALL_TO_MEDIUM_DISPLAY_SIZE  &&
                 displaySizeInches<= MEDIUM_TO_LARGE_DISPLAY_SIZE) {
            System.out.println("This is a medium display screen");
         } else if(displaySizeInches > MEDIUM_TO_LARGE_DISPLAY_SIZE) {
             System.out.println("This is a large display screen");
        }
    }
}
