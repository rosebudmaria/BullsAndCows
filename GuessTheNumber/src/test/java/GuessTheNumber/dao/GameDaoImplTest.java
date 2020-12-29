

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
public class GameDaoImplTest {
    
    @Autowired
    GameDao gameDao;
    
   // private RoundDao roundDao;
    
    
    private Game game;
    private Round round;
    private Game testGame;
    
    
    @BeforeEach
    public void setUp(){
    List<Game> listOfGames= gameDao.GetListOfGames();
    
    for(Game testgame : listOfGames) {
    gameDao.DeleteGameId(testgame.getGameId());
}
//    public void setUpClass() throws Exception {
//        List<Game>  gameList = gameDao.GetListOfGames();
//        for(Game game : gameList) {
          //  gameDao.DeleteGameById (game.GetGameById());
        
        
        
//  testGame= new Game();
//      testGame.setFourDigitNumber("1007");
//       testGame.setStatusOfGame(true);
   }
    
    
    @Test
    
    public void testAddGame() {
        
        Game testGame = new Game("1234");
        //testGame= gameDao.AddNewGame(testGame);
        Game game = gameDao.GetGameById(testGame.getGameId());
        //assertNotNull(testGame, "The game should not be null.");
        assertEquals(testGame, game);
    }
    
    
    @Test
    public void testGetGameById() {
        
        Game newGame = new Game("1234");
        newGame= gameDao.AddNewGame(newGame);
        Game game = gameDao.GetGameById(newGame.getGameId());
        
        assertEquals(newGame, game);
    }
    
    @Test
    public void getAllGames(){
        
        List<Game> gameList= gameDao.GetListOfGames();
        int list = 0;
        
        assertEquals(list, gameList.size());
    }
    
    @Test
    public void getGameSet(){
        
        Game testGame1= new Game("1007");
        Game testGame2= new Game("2020");
        
        gameDao.AddNewGame(testGame1);
        gameDao.AddNewGame(testGame2);
        
        
        int list= 2;
        
        List<Game> listOfGames= gameDao.GetListOfGames();
        
        assertEquals(list, listOfGames.size());
    }
    
    @Test
    public void updateGameTest() {
        
        Game testGame = new Game("8595");
        testGame = gameDao.AddNewGame(testGame);
        testGame.endGame();
        
        gameDao.UpdateGame(testGame);
        
        testGame= gameDao.GetGameById(testGame.getGameId());
        Game testGame2= new Game(testGame.getGameId(), "8595", false);
        assertEquals(testGame, testGame2);
    }
    }

