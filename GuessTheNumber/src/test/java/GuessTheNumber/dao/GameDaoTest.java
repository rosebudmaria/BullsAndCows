

package GuessTheNumber.dao;


import GuessTheNumber.TestApplicationConfiguration;
import GuessTheNumber.dto.Game;
import GuessTheNumber.dto.Round;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 *
 * @author Shantoria Taylor  ,  Dec 27, 2020  ,  8:06:58 PM

 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes= TestApplicationConfiguration.class)
public class GameDaoTest {
    
    
    private GameDao gameDao;
    private RoundDao roundDao;
    
    
    private Game game;
    private Round round;
    private Game testGame;
    
    
    @BeforeEach
    public void setUp(){
    List<Game> listOfGames= gameDao.GetListOfGames();
    
    for(Game game : listOfGames) {
    gameDao.DeleteGameId(game.getGameId());
}
//    public void setUpClass() throws Exception {
//        List<Game>  gameList = gameDao.GetListOfGames();
//        for(Game game : gameList) {
          //  gameDao.DeleteGameById (game.GetGameById());
        
        
        
     testGame= new Game();
      testGame.setFourDigitNumber("1007");
       testGame.setStatusOfGame("Game in Progress");
   }
    
    
    @Test
    
    public void testAddGame() {
        
    
        testGame= gameDao.AddNewGame(testGame);
        Game game = gameDao.GetGameById(testGame.getGameId());
        //assertNotNull(testGame, "The game should not be null.");
        assertEquals(testGame, game);
    }
    }

