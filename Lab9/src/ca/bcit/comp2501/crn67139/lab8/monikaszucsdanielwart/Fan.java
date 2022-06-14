package ca.bcit.comp2501.crn67139.lab8.monikaszucsdanielwart;

/**
 * Fan.java
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
 * This Fan Class that will create the appropriate constructor and methods
 *
 */
class Fan extends Electronic {
    private final double  temperatureCelsius;
    private final boolean blades;
    private final boolean rotating;
    private final boolean fallDetectionOn;

    private static final int MIN_TEMPERATURE_CELSIUS = 0;
    private static final int MAX_TEMPERATURE_CELSIUS = 25;
    private static final int COOL_WARM_BREAKING_POINT = 9;
    private static final int WARM_HOT_BREAKING_POINT = 18;

    private static final int MIN_PRICE = 0;

    /**
     * This is the Fan Constructor
     *
     * @param brand this is the brand of the fan
     * @param model this is the model of the fan
     * @param priceCdn this is the price of the fan in Canadian Dollars
     * @param temperatureCelsius this is the temperature in Celsius
     * @param powerCableAttached this is to check to see if the cable directly attached or not
     * @param blades this is to check to see if the fan uses blades or not
     * @param rotating this is to check to see if the fan can rotate
     * @param fallDetectionOn this is to check to see if the fan can detect if it falls to turn off as a safety feature
     *
     * @throws IllegalArgumentException This is to check to see if there is an Illegal Argument Exception
     */
    Fan(final String    brand,
        final String    model,
        final double    priceCdn,
        final double    temperatureCelsius,
        final boolean   powerCableAttached,
        final boolean   blades,
        final boolean   rotating,
        final boolean   fallDetectionOn
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

        this.temperatureCelsius = temperatureCelsius;
        this.blades = blades;
        this.rotating = rotating;
        this.fallDetectionOn = fallDetectionOn;
    }

    /**
     * This is method that checks the temperature in Celsius
     *
     * @throws IllegalArgumentException this is to check if there is an Illegal Argument Exception
     */
    public void getTemperature() {
        if(temperatureCelsius < MIN_TEMPERATURE_CELSIUS) {
            throw new IllegalArgumentException("The temperature (Celsius) you entered is too low");
        } else if(temperatureCelsius > MAX_TEMPERATURE_CELSIUS) {
            throw new IllegalArgumentException("The temperature (Celsius) you entered is too high");
        } else if(temperatureCelsius <= COOL_WARM_BREAKING_POINT) {
            System.out.println("The air is cool");
        } else if(temperatureCelsius <= WARM_HOT_BREAKING_POINT) {
            System.out.println("The air is warm");
        } else {
            System.out.println("The air is hot");
        }
    }

    /**
     * This is the method to check if the fan is kid proof or not. It depends on if it has fall detection or not.
     */
    public void kidProof(){
        if(fallDetectionOn) {
            System.out.println("This is a kid proof fan");
        } else {
            System.out.println("This is not a kid proof fan");
        }
    }
}
