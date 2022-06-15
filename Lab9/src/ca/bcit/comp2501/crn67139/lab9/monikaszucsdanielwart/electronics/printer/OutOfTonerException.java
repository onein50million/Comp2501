package ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.electronics.printer;



/** OutOfTonerException.java COMP 2501 - CRN: 67139 Wednesday evenings, Spring/Summer 2022 Lab #9
 *
 * Exception that happens if the printer is out of toner. This is bad news for your wallet
 * @author Daniel Wart
 * @author Monika Szucs
 */
public class OutOfTonerException extends RuntimeException {
    public OutOfTonerException(String message) {
        super(message);
    }
}
