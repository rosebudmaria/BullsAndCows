

package com.mycompany.guessthenumber.models;

/**
 *
 * @author rosalindapowell0608
 */
public class Round {
    private int RoundId;
    private int GameId;
    private String Guess;
    private String TimeStampOfRound;
    private String Result;
    
    public int getRoundId() {
        return RoundId;
    }
    
    public void setRoundId(int RoundId) {
        this.RoundId = RoundId;
    }
    
    
    public int getGameId() {
        return GameId;
    }
    
    public void setGameId(int GameId) {
        this.GameId = GameId;
    }
    
    
    public String getGuess() {
        return Guess;
    }
    
    public void setGuess(String Guess) {
        this.Guess = Guess;
    }
    
    public String getTimeStampOfRound() {
        return TimeStampOfRound;
    }
    
    public void setTimeStampOfRound(String TimeStampOfRound) {
        this.TimeStampOfRound = TimeStampOfRound;
    }
    public String getResult() {
        return Result;
    }
    
    public void setResult(String Result) {
        this.Result = Result;
    }
}
