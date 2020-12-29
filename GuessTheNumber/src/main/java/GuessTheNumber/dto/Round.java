

package com.mycompany.guessthenumber.models;

/**
 *
 * @author rosalindapowell0608
 */
public class Round {



  private int RoundId;
  public Game GameId;
  private String Guess;
  private LocalDateTime TimeStampOfRound;
  private String Result;



    public Round(int RoundId, String Guess, String Result) {
        this.RoundId = RoundId;
        this.Guess = Guess;
        this.Result = Result;
    }


  

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



    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.RoundId;
        hash = 71 * hash + Objects.hashCode(this.GameId);
        hash = 71 * hash + Objects.hashCode(this.Guess);
        hash = 71 * hash + Objects.hashCode(this.TimeStampOfRound);
        hash = 71 * hash + Objects.hashCode(this.Result);
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
        final Round other = (Round) obj;
        if (this.RoundId != other.RoundId) {
            return false;
        }
        if (this.Guess != other.Guess) {
            return false;
        }
        if (!Objects.equals(this.Result, other.Result)) {
            return false;
        }
        if (!Objects.equals(this.GameId, other.GameId)) {
            return false;
        }
        if (!Objects.equals(this.TimeStampOfRound, other.TimeStampOfRound)) {
            return false;
        }
        return true;
    }

}
