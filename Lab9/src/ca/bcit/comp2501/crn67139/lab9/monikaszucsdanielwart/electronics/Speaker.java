package ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.electronics;

import ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.port.DataPort;

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
public class Speaker extends Electronic {
    private final boolean waterProof;
    private final boolean floats;

    /**
     * Constructor for the Speaker Class
     *
     * @param brand this is the brand of the speaker
     * @param model this is for the model of the speaker
     * @param priceCdn this is for the price of the speaker in Canadian Dollars
     * @param waterProof this is to see if the speaker is waterproof or not
     * @param floats this is to see if the speaker floats in water or not
     * @param powerCableAttached this is to see if the cord is directly attached or not to the speaker
     *
     * @throws IllegalArgumentException this checks to see if there is an Illegal Argument Exception
     */
    public Speaker(    final String      brand,
                final String      model,
                final double      priceCdn,
                final boolean     waterProof,
                final boolean     floats,
                final boolean     powerCableAttached
        ) {
        super(brand, model, priceCdn, powerCableAttached, new DataPort[]{new DataPort(DataPort.PortType.AUX)});

        this.waterProof = waterProof;
        this.floats = floats;
    }
    public boolean isWaterProof() {
        return waterProof;
    }
    public boolean doesFloat() {
        return floats;
    }

    public void playSound(){
        if(hasPower()){
            System.out.print("You hear a some great tunes playing");
        }
        System.out.print("You really wish there was some music playing");

    }

    /**
     * This method will return if a string saying where you can take the speaker to.
     */
    public String canTakeSpeakerTo() {
        if(isWaterProof() && doesFloat()) {
            return "Take to the beach and/or pool while you swim with it";
        } else if(isWaterProof()) {
            return "Can take outside when it is raining";
        } else {
            return "Only keep the speaker indoors";
        }
    }

}
