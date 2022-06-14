package ca.bcit.comp2501.crn67139.lab8.monikaszucsdanielwart;

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
 * This Speaker Class that will check the properties of the speaker and seeing if it is waterproof/floats
 *
 */
class Speaker extends Electronic{
    private final boolean waterProof;
    private final boolean floats;

    private static final int MIN_PRICE_CANADIAN = 0;

    /**
     * Constructor for the Speaker Class
     *
     * @param brand this is the brand of the speaker
     * @param model this is for the model of the speaker
     * @param priceCnd this is for the price of the speaker in Canadian Dollars
     * @param waterProof this is to see if the speaker is waterproof or not
     * @param floats this is to see if the speaker floats in water or not
     * @param powerCableAttached this is to see if the cord is directly attached or not to the speaker
     *
     * @throws IllegalArgumentException this checks to see if there is an Illegal Argument Exception
     */
    Speaker(    final String      brand,
                final String      model,
                final double      priceCnd,
                final boolean     waterProof,
                final boolean     floats,
                final boolean     powerCableAttached
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

        this.waterProof = waterProof;
        this.floats = floats;
    }

    /**
     * This method will check to see if the speaker is waterproof, floats or not to see where it can be taken.
     */
    public void canTakeSpeakerTo() {
        if(waterProof && floats) {
            System.out.println("Take to the beach and/or pool while you swim with it");
        } else if(waterProof) {
            System.out.println("Can take outside when it is raining");
        } else {
            System.out.println("Only keep the speaker indoors");
        }
    }
}
