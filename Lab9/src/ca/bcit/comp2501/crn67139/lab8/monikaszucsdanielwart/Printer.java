package ca.bcit.comp2501.crn67139.lab8.monikaszucsdanielwart;

/**
 * Printer.java
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
 * This Printer Class that will create the ArrayList and add the appropriate items to it while displaying the
 * called information from other classes/methods
 *
 */
class Printer extends Electronic {
    private final String  tonerColor;
    private final boolean hasToner;
    private final boolean hasScanner;
    private final double  beltLength;

    private static final int MIN_PRICE_CANADIAN = 0;
    private static final int MIN_BELT_LENGTH    = 10;
    private static final int BELT_TOO_CHEAP     = 100;
    private static final int BELT_TOO_EXPENSIVE = 400;
    private static final int SMALL_PRINTER      = 15;
    private static final int MEDIUM_PRINTER     = 35;

    private static final String YELLOW_TONER    = "yellow";
    private static final String BLACK_TONER     = "black";
    private static final String MAGENTA_TONER   = "magenta";
    private static final String CYAN_TONER      = "cyan";

    /**
     * This is the constructor for the Printer Class
     *
     * @param brand this is to see the brand of the printer
     * @param model this is to see the model of the printer
     * @param tonerColor this is to see what toner color the person will use
     * @param beltLength this is to see what the length of the belt is inside the printer
     * @param priceCnd this is to check the price of the printer
     * @param powerCableAttached this is to see if the printer has an attached power cable or not
     * @param hasToner this is to see if the printer is using toner or ink
     * @param hasScanner this is to see if the printer has a scanner
     *
     * @throws IllegalArgumentException This checks to see if there is an Illegal Argument Exception
     */
    Printer(final String    brand,
            final String    model,
            final String    tonerColor,
            final double    beltLength,
            final double    priceCnd,
            final boolean   powerCableAttached,
            final boolean   hasToner,
            final boolean   hasScanner
    ) {
        super(brand, model, priceCnd, powerCableAttached);

        if(brand == null || brand.isEmpty()) {
            throw new IllegalArgumentException("There must be a brand name");
        }

        if(model == null || model.isEmpty()) {
            throw new IllegalArgumentException("There must be a model type");
        }

        if(priceCnd <= MIN_PRICE_CANADIAN) {
            throw new IllegalArgumentException("That is a incorrect price you have entered.");
        }

        if(     tonerColor.equalsIgnoreCase(BLACK_TONER) ||
                tonerColor.equalsIgnoreCase(MAGENTA_TONER) ||
                tonerColor.equalsIgnoreCase(CYAN_TONER) ||
                tonerColor.equalsIgnoreCase(YELLOW_TONER)
        ) {
            this.tonerColor = tonerColor;
        } else {
            throw new IllegalArgumentException("You can only have the colors: " +
                                                BLACK_TONER + ", " + MAGENTA_TONER + ", " + CYAN_TONER + ", " +
                                                YELLOW_TONER);
        }

        if(beltLength < MIN_BELT_LENGTH) {
            throw new IllegalArgumentException("That belt length is not possible.");
        }

        this.beltLength     = beltLength;
        this.hasToner       = hasToner;
        this. hasScanner    = hasScanner;
    }

    /**
     * Printer method
     *
     *This method is used to let the person know that the printer is printing when it calls this method
     */
    public void print() {
        System.out.println("printing");
    }

    /**
     * The price checker method
     *
     * @param price this is to check the price of the printer to see if it is within budget
     *
     * @throws IllegalArgumentException This checks to see if there is an Illegal Argument Exception
     */
    public void checkPrice(final double price) {
        if(price <= MIN_PRICE_CANADIAN) {
            throw new IllegalArgumentException("That is a incorrect price you have entered.");
        } else if(price <= BELT_TOO_CHEAP) {
            System.out.println("Too cheap");
        } else if(price >= BELT_TOO_EXPENSIVE) {
            System.out.println("Too expensive");
        } else {
            System.out.println("It is a good option");
        }
    }

    /**
     * This is the belt length method
     *
     * This will check if the printer is small, medium or large.
     */
    public void getBeltLength() {

        if(beltLength < SMALL_PRINTER) {
            System.out.println("This printer is too small");
        } else if(beltLength <= MEDIUM_PRINTER) {
            System.out.println("This is a medium printer");
        } else {
            System.out.println("This printer is a large printer");
        }
    }
}
