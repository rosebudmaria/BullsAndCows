

package GuessTheNumber.dto;

import java.util.Objects;

/**
 *
 * @author Shantoria Taylor  ,  Dec 25, 2020  ,  8:37:09 PM

 */
public class Game {   
    
    private int GameId;
    private char FourDigitNumber;
    private String StatusOfGame ; 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.GameId;
        hash = 29 * hash + this.FourDigitNumber;
        hash = 29 * hash + Objects.hashCode(this.StatusOfGame);
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
        if (this.FourDigitNumber != other.FourDigitNumber) {
            return false;
        }
        if (!Objects.equals(this.StatusOfGame, other.StatusOfGame)) {
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

    public char getFourDigitNumber() {
        return FourDigitNumber;
    }

    public void setFourDigitNumber(char FourDigitNumber) {
        this.FourDigitNumber = FourDigitNumber;
    }

    public String getStatusOfGame() {
        return StatusOfGame;
    }

    public void setStatusOfGame(String StatusOfGame) {
        this.StatusOfGame = StatusOfGame;
    }
    


}
