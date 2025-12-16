/* Ashton Chavez
 * Project 4
 * March 5, 2024
 * 
 * The InvalidTime class represents a custom checked exception for
 * invalid time inputs.
 */

public class InvalidTime extends Exception {

    // Constructor for creating an InvalidTime object with a custom message
    public InvalidTime(String message) {

        // Call the constructor of the superclass (Exception) with the provided message
        super(message);
    }
}