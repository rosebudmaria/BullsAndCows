package GuessTheNumber.dao;
import GuessTheNumber.dto.Game;
import GuessTheNumber.dto.Round;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.runner.RunWith;
/**
 *
 * @author Rosalinda Powell
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoundDaoImplTest {
    
    @Autowired 
     private GameDao gameDao;
    
    @Autowired 
    private RoundDao roundDao;
    
    private Game game;
    private Round round;
    private Round testRound;
    @BeforeEach
    public void setUpClass() throws Exception {
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
}
