package ca.bcit.comp2501.crn67139.lab8.monikaszucsdanielwart;

/**
 * Electronic.java
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
 * This Electronic Class that will create the appropriate constructor and methods
 *
 */
class Electronic {
    private String brand;
    private String model;
    private double priceCdn;
    private boolean powerCableAttached;

    /**
     * This is an Electronics Class
     *
     * @param brand this is the brand of the electronics
     * @param model this is the model of the electronics
     * @param priceCdn this is the price of the electronics in Canadian Dollars
     * @param powerCableAttached this is to check to see if the cable is directly attached or not
     */
    Electronic(final String brand, final String model, final double priceCdn, final boolean powerCableAttached) {
        this.brand = brand;
        this.model = model;
        this.priceCdn = priceCdn;
        this.powerCableAttached = powerCableAttached;
    }

    /**
     * This is the getter for the brand method
     *
     * @return the brand of the product
     */
    public String getBrand() {
        return brand;
    }

    /**
     * This is the getter for the model
     *
     * @return this will return the model of the product
     */
    public String getModel() {
        return model;
    }

    /**
     * This is the getter for the price
     *
     * @return this will return the price of the product
     */
    public double getPrice() {
        return priceCdn;
    }

    /**
     * This is the getter to check if the product has a cable directly attached or not
     *
     * @return the power cable attached of the product
     */
    public boolean hasPowerCableAttached() {
        return powerCableAttached;
    }

    /**
     * This is the toString method
     *
     * @return this will return the detailed information of the different Classes in a String format
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + priceCdn +
                ", powerCableAttached=" + powerCableAttached +
                '}';
    }
}
