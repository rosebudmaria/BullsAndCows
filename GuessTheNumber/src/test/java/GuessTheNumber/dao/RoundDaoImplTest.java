package GuessTheNumber.dao;

import GuessTheNumber.dto.Game;
import GuessTheNumber.GuessTheNumberApplicationTests;
import GuessTheNumber.dto.Round;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author rosalindapowell0608
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GuessTheNumberApplicationTests.class)
public class RoundDaoImplTest {
    
    @Autowired 
     private GameDao gameDao;
    
    @Autowired 
    private RoundDao roundDao;
    
    private Game game;
    private Round round;
    private Round testRound;
    
    @BeforeEach
    public void setUp() throws Exception {
        List<Game>  gameList = gameDao.getListOfGames();
        for(Game game : gameList) {
            gameDao.deleteGameById (game.getGameId());
        }
        testRound = new Round();
        testRound.setResult("1007");
        testRound.setTimeStampOfRound(LocalDateTime.MIN);
    }
    @Test
    public void testBeginRound() {
        testRound= roundDao.addNewGame(testRound);
        Round round = roundDao.getGameById(testRound.getRoundId());
        assertNotNull(testRound, "The game should not be null.");
        assertEquals(testRound, round);
    }
    
    
   @Test
    public void testUpdate() {
        Round round = new Round();
        round.setRoundId(2);
        round.setGuess("1234");
        round = roundDao.addRound(round);
        
        Round roundDao = roundDao.getRoundById(round.getRoundId());
        
    }

    private void assertNotNull(Round testRound, String the_game_should_not_be_null) {
        throw new UnsupportedOperationException("The game should not be null."); //To change body of generated methods, choose Tools | Templates.
    }
}
