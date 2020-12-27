

package GuessTheNumber.dto;

/**
 *
 * @author Shantoria Taylor  ,  Dec 27, 2020  ,  4:51:46 PM

 */
public class GameViewModel {
    
    
    private String gameId;
    private String  correctAnswer;
    private String status; 
    
    
    public String getGameId() {
        return gameId;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getStatus() {
        return status;
    }
    
  public GameViewModel(Game newGame) {
      
      if(newGame != null){
          this.gameId = String.valueOf(newGame.getGameId());
          
          if( newGame.getStatusOfGame() == "true") {
              
              this.status = "Game in Progress.";
              
              this.correctAnswer= "Hidden";
              
          }
          
          else {
              this.status= "Game completed.";
              
              this.correctAnswer= newGame.getFourDigitNumber();
          }
      }
  }
 
}
