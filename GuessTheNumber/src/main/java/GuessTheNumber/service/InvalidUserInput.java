

package GuessTheNumber.service;

/**
 *
 * @author Shantoria Taylor  ,  Dec 28, 2020  ,  10:54:20 AM

 */
public class InvalidUserInput extends Exception{
    
     public InvalidUserInput(String message, Throwable cause) {
        super(message, cause);
    }
    
    
    public InvalidUserInput(String message) {
        super(message);
    }

}
