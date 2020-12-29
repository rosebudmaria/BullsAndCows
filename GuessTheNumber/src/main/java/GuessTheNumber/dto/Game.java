

package GuessTheNumber.dto;

import java.util.Objects;

/**
 *
 * @author Shantoria Taylor  ,  Dec 25, 2020  ,  8:37:09 PM

 */
public class Game {   
    
    private int GameId;
    private String FourDigitNumber;
    private Boolean StatusOfGame ; 
    
    
    
    public Game(String FourDigitNumber, Boolean StatusOfGame) {
        this.FourDigitNumber = FourDigitNumber;
        this.StatusOfGame = StatusOfGame;
    }
    

   public Game(int GameId, String FourDigitNumber, Boolean StatusOfGame) {
        this.GameId = GameId;
        this.FourDigitNumber = FourDigitNumber;
        this.StatusOfGame = StatusOfGame;
    }

    public Game(String generateFourDigitNumber){
        this.FourDigitNumber = generateFourDigitNumber;
    }
    
    public Game(int GameId){
        this.GameId= GameId;
    }
    
    public Game(Boolean StatusOfGame){
        this.StatusOfGame= StatusOfGame;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.GameId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.GameId != other.GameId) {
            return false;
        }
        return true;
    }

    public int getGameId() {
        return GameId;
    }

    public void setGameId(int GameId) {
        this.GameId = GameId;
    }

    public String getFourDigitNumber() {
        return FourDigitNumber;
    }

    public void setFourDigitNumber(String FourDigitNumber) {
        this.FourDigitNumber = FourDigitNumber;
    }

    public Boolean getStatusOfGame() {
        return StatusOfGame;
    }

    public void setStatusOfGame(Boolean StatusOfGame) {
        this.StatusOfGame = StatusOfGame;
    }

    public void endGame() {
      
    }

   


  

}
