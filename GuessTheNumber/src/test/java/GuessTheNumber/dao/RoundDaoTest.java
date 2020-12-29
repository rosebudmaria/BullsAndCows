

package GuessTheNumber.dao;

import GuessTheNumber.dto.Game;
import GuessTheNumber.dto.Round;
import java.util.List;
import org.junit.After;
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
 * @author Shantoria Taylor  ,  Dec 27, 2020  ,  8:07:19 PM

 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class RoundDaoTest {
    
     @Autowired 
     private GameDao gameDao;
     
     
    @Autowired 
    private RoundDao roundDao;
    
    
    private Game game;
    private Round round;
    
    @BeforeEach
    public void setUpClass() throws Exception {
        List<Game>  gameList = gameDao.GetListOfGames();
        
        for(Game game : gameList) {
            gameDao.DeleteGameId ();
        }

}
