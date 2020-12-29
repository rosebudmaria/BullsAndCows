package GuessTheNumber.dao;

import GuessTheNumber.dto.Game;
import GuessTheNumber.GuessTheNumberApplicationTests;
import GuessTheNumber.dto.Round;
import java.util.List;
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
    
    public RoundDaoImplTest() {
    }
    
    @BeforeEach
    public void setUp() {
       //List<Game> gameList = gameDao.getListOfNames;
        //for(Game game : gameList) {
            //gameDao.deleteGameById (game.getGameId());
        //}
        
        List<Round> roundList = roundDao.getListOfNames;
        for(Round round : roundList) {
            roundDao.deleteRoundById (round.getRoundId());
        }
    }
    

    @Test
    public void testAddRound() {
        Game game = new Game("1994");
        game = gameDao.addNewGame(game);
        Round round = new Round("1964", "e:3:p:0", game.getGameId());
        round = roundDao.addRound(round);
        Round roundTest = new Round(round.getRoundId(), "1964", "e:3:p:0", 
                round.getTimeStampOfRound(), game.getGameId());
        //assert
        assertEquals(roundTest, round);
    }

    /**
     * Test of GetAllRounds method, of class RoundDaoImpl.
     */
    @Test
    public void testGetAllRounds() {
        Game g1= new Game("1017");
        Game g2= new Game("0420");
        
        g1 = gameDao.addNewGame(g1);
        g2 = gameDao.addNewGame(g2);
        
        Round r1g1 = new Round("1010", "e:3:p:0", g1.getGameId());
        r1g1 = roundDao.AddRound(r1g1);
        
        Round r2g1 = new Round("1210", "e:2:p:0", g1.getGameId());
        r2g1 = roundDao.AddRound(r2g1);
        
        Round r3g1 = new Round("1310", "e:2:p:0", g1.getGameId());
        r2g1 = roundDao.AddRound(r3g1);
        
        List<Round> roundList = roundDao.GetAllRounds(g1.getGameId());
        assertEquals(r1g1, roundList.get(0));
        assertEquals(r2g1, roundList.get(1));
        assertEquals(r3g1, roundList.get(2));
    }

  
    @Test
    public void testGetAllRounds2() {
        List<Round> list = roundDao.GetAllRounds(999); 
       
        
    }
    
}
