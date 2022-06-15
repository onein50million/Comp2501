package ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.electronics.port;


/** NoMatchingPortsException.java COMP 2501 - CRN: 67139 Wednesday evenings, Spring/Summer 2022 Lab #9
 *
 * Exception that happens if there are no matching data ports on the device
 * @author Daniel Wart
 * @author Monika Szucs
 */
public class NoMatchingPortsException extends RuntimeException {
    public NoMatchingPortsException(String message) {
        super(message);
    }
}
