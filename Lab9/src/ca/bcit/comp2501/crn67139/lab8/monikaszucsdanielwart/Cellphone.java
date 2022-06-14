package ca.bcit.comp2501.crn67139.lab8.monikaszucsdanielwart;

/**
 * Cellphone.java
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
 * This Cellphone Class that will create the appropriate constructor and methods
 *
 */
class Cellphone extends Electronic {
    private final boolean   hasSms;
    private final boolean   dataOn;
    private final double    dataPlanCost;
    private final double    displaySizeInches;
    private boolean         canDownloadApps;

    private static final int MIN_PRICE_CDN                  = 0;
    private static final int LOW_DATA_PLAN_COST_CDN         = 10;
    private static final int AFFORDABLE_DATA_PLAN_COST_CDN  = 40;
    private static final int EXPENSIVE_DATA_PLAN_COST_CDN   = 40;

    /**
     * This is the constructor for the Cellphone Class
     *
     * @param brand this is the brand of the cellphone
     * @param model this is the model of the cellphone
     * @param priceCdn this is the price of the cellphone
     * @param dataPlanCost this is to see what the data plan the person is paying for that cellphone
     * @param displaySizeInches this is to see what size the cellphone is
     * @param canDownloadApps this is to see if the cellphone can download apps
     * @param dataOn this is to see if the cellphone has the data turned on
     * @param hasSms this is to see if the cellphone can receive messages
     * @param powerCableAttached this is to see if the cellphone has a cable connected directly to it at all times
     */
    Cellphone(final String      brand,
              final String      model,
              final double      priceCdn,
              final double      dataPlanCost,
              final double      displaySizeInches,
              final boolean     canDownloadApps,
              final boolean     dataOn,
              final boolean     hasSms,
              final boolean     powerCableAttached
    ) {
        super(brand, model, priceCdn, powerCableAttached);

        if(brand == null || brand.isEmpty()) {
            throw new IllegalArgumentException("There must be a brand name");
        }

        if(model == null || model.isEmpty()) {
            throw new IllegalArgumentException("There must be a model type");
        }

        if(priceCdn <= MIN_PRICE_CDN) {
            throw new IllegalArgumentException("That is a incorrect price you have entered.");
        }

        this.dataOn = dataOn;
        this.dataPlanCost = dataPlanCost;
        this.displaySizeInches = displaySizeInches;
        this.canDownloadApps = canDownloadApps;
        this.hasSms = hasSms;

    }

    /**
     * This is the method that checks the data plan types
     *
     * This will check to see if the plan the person is paying is reasonable, slightly too much or very expensive
     */
    public void dataPlanTypes() {
        if(dataPlanCost < LOW_DATA_PLAN_COST_CDN ) {
            throw new IllegalArgumentException("This is too low of a price is does not exist");
        }

        if(dataPlanCost >= LOW_DATA_PLAN_COST_CDN && dataPlanCost <= AFFORDABLE_DATA_PLAN_COST_CDN) {
            System.out.println("This is reasonable");
        } else if(dataPlanCost <= EXPENSIVE_DATA_PLAN_COST_CDN) {
            System.out.println("There better be some good reception and data on this plan");
        } else if(dataPlanCost > EXPENSIVE_DATA_PLAN_COST_CDN) {
            System.out.println("This is too expensive");
        } else {
            System.out.println("Please make sure you entered in a number that is reasonable");
        }
    }
}
