

package GuessTheNumber.service;

/**
 *
 * @author Shantoria Taylor  ,  Dec 26, 2020  ,  1:30:55 AM

 */
public class NoGameException extends Exception {
    
 
    public NoGameException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
    public NoGameException(String message) {
        super(message);
    }
}
