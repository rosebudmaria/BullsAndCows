

package GuessTheNumber.Controller;

import java.time.LocalDateTime;

/**
 *
 * @author Shantoria Taylor  ,  Dec 26, 2020  ,  1:22:10 AM

 */
public class Error {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    public String message;
    private LocalDateTime timestamp = LocalDateTime.now();

}
