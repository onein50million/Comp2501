package ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.electronics;

import ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.electronics.port.DataPort;
import ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.electronics.port.FullPortsException;
import ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.electronics.port.NoMatchingPortsException;

import java.util.ArrayList;
import java.util.List;

/**
 * Electronic.java COMP 2501 - CRN: 67139 Wednesday evenings, Spring/Summer 2022 Lab #9
 *
 * <p>Exploring Inheritance by developing a data class hierarchy.
 *
 * @author Monika Szucs
 * @author Daniel Wart
 *     <p>This Electronic Class that will create the appropriate constructor and methods
 */
public class Electronic {

    private final String brand;
    private final String model;
    private final double priceCdn;
    private boolean powerCableAttached;
    protected final DataPort[] dataPorts;
    protected final List<Character> printBuffer;

    private static final int MIN_PRICE_CDN = 0;

    /**
     * This is an Electronics Class
     *
     * @param brand this is the brand of the electronics
     * @param model this is the model of the electronics
     * @param priceCdn this is the price of the electronics in Canadian Dollars
     * @param powerCableAttached this is to check to see if the cable is directly attached or not
     * @param dataPorts An array of DataPorts representing what type of Electronics can be plugged
     *     into the device
     */
    protected Electronic(
            final String brand,
            final String model,
            final double priceCdn,
            final boolean powerCableAttached,
            final DataPort[] dataPorts) {
        if (brand == null || brand.isEmpty()) {
            throw new IllegalArgumentException("There must be a brand name");
        }

        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("There must be a model type");
        }

        if (priceCdn <= MIN_PRICE_CDN) {
            throw new IllegalArgumentException("Price must be larger than " + MIN_PRICE_CDN);
        }
        if (dataPorts == null) {
            throw new IllegalArgumentException("Must at least have an empty array for data ports");
        }

        this.brand = brand;
        this.model = model;
        this.priceCdn = priceCdn;
        this.powerCableAttached = powerCableAttached;
        this.dataPorts = dataPorts;
        for (var port : dataPorts) {
            port.setHost(this);
        }
        this.printBuffer = new ArrayList<>();
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

    public double getPriceCdn() {
        return priceCdn;
    }

    public boolean hasPower() {
        return powerCableAttached;
    }

    public void attachPowerCable() {
        this.powerCableAttached = true;
    }

    public void detachPowerCable() {
        this.powerCableAttached = false;
    }

    /**
     * This is the getter to check if the product has a cable directly attached or not
     *
     * @return the power cable attached of the product
     */
    public boolean isPowerCableAttached() {
        return powerCableAttached;
    }

    public List<Character> getPrintBuffer() {
        return printBuffer;
    }

    public DataPort getAvailablePort(DataPort.PortType portType) {
        var hasMatchingPort = false;
        for (var port : this.dataPorts) {
            if (portType == port.getPortType()) {
                hasMatchingPort = true;
                if (port.getConnectedPort() == null) {
                    return port;
                }
            }
        }
        if (hasMatchingPort) {
            throw new FullPortsException("All ports are full");
        } else {
            throw new NoMatchingPortsException("No matching ports on device");
        }
    }

    public boolean checkPrice(double budgetCdn) {
        return getPriceCdn() <= budgetCdn;
    }

    /**
     * This is the toString method
     *
     * @return this will return the detailed information of the different Classes in a String format
     */
    @Override
    public String toString() {
        return getClass().getSimpleName()
                + "{"
                + "brand='"
                + brand
                + '\''
                + ", model='"
                + model
                + '\''
                + ", price="
                + priceCdn
                + ", powerCableAttached="
                + powerCableAttached
                + '}';
    }

    public void clearPrintBuffer() {
        this.printBuffer.clear();
    }
}
