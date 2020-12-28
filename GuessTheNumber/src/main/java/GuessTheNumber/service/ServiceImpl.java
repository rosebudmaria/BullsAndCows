

package GuessTheNumber.service;

import GuessTheNumber.dao.GameDao;
import GuessTheNumber.dao.RoundDao;
import GuessTheNumber.dao.GameDaoImpl;
import GuessTheNumber.dao.RoundDaoImpl;
import GuessTheNumber.dto.Game;
import GuessTheNumber.dto.Round;
import java.lang.annotation.Annotation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Shantoria Taylor  ,  Dec 26, 2020  ,  1:29:15 AM

 */

@Service
public class ServiceImpl implements Service {

    
    @Autowired
    GameDao gameDao;
    
    @Autowired
    RoundDao roundDao;
    
     public ServiceImpl(GameDaoImpl gameDao, RoundDaoImpl roundDao) {
        this.gameDao = gameDao;
        this.roundDao = roundDao;

    }

    
    @Override
    public Game BeginGame() throws PersistenceException, NoGameException {
        
    Game newGame = new Game(getFourDigitNumber());
    newGame= gameDao.AddNewGame(newGame);
    if(newGame== null){
        throw new NoGameException ("Sorry, a new game could not be created.");
    }
    return newGame;
    
    }

    
    
    
    
    @Override
    public Round Guess(Round Round) throws NoGameException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Round> getRoundByTime(int gameId) throws NoGameException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Game> GetListOfGames() throws NoGameException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Game GetGameById(int gameId) throws NoGameException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    

    @Override
    public String value() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
