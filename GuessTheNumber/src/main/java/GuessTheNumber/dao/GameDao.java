
package GuessTheNumber.dao;

import GuessTheNumber.dto.Game;
import java.util.List;

/**
 *
 * @author shana
 */
public interface GameDao {
    
    public Game AddNewGame (Game newGame);
    
    public Game GetGameById(int gameId);
    
    public List<Game> GetListOfGames();
    
    public void UpdateGame(Game game);
    
    public void DeleteGameId(int gameId);
    
    
    

}
