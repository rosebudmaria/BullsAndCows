

package GuessTheNumber.dao;

import GuessTheNumber.dto.Game;
import GuessTheNumber.dto.Round;
import java.util.List;

/**
 *
 * @author shana
 */
public interface RoundDao {
    
    public Round AddRound (Round newRound);
    
    public List<Round> GetRoundByTime (int gameId);
    
    public void DeleteRoundById(int roundId);
    
    public Game GetGameById(int gameId);
    
    public String GetGuess();
    
}