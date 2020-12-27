

package GuessTheNumber.service;

import GuessTheNumber.Dao.GameDao;
import GuessTheNumber.Dao.RoundDao;
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

@service
public class ServiceImpl implements Service {

    
    @Autowired
    GameDao gameDao;
    
    @Autowired
    RoundDao roundDao;
    
    @Override
    public Game BeginGame() throws PersistenceException, NoGameException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
