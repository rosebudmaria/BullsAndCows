package GuessTheNumber.Dao;

import GuessTheNumber.dto.Round;
import java.util.List;

/**
 *
 * @author rosalindapowell0608
 */
public interface RoundDao {
   public Round add(Round round);
   //creates guess b passing guess and gameid in as JSON
   //program must calculate results & mark finished if correct
   //returns Round object with results included
   
   public List<Round> getAll(int GameId);
   //returns list of rounds for specific game sorted by time
   
   public void deleteRoundId(int RoundId);
   
   public void getRoundById(int RoundId);
   
   public String getGuess();
}

