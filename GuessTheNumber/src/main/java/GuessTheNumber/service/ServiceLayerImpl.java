

package GuessTheNumber.service;

import GuessTheNumber.dao.GameDao;
import GuessTheNumber.dao.RoundDao;
import GuessTheNumber.dao.GameDaoImpl;
import GuessTheNumber.dao.RoundDaoImpl;
import GuessTheNumber.dto.Game;
import GuessTheNumber.dto.Round;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Shantoria Taylor  ,  Dec 26, 2020  ,  1:29:15 AM

 */

public class ServiceLayerImpl implements ServiceLayer {

    
    
   private GameDaoImpl gameDao;
    private RoundDaoImpl roundDao;
    
     public ServiceLayerImpl(GameDaoImpl gameDao, RoundDaoImpl roundDao) {
        this.gameDao = gameDao;
        this.roundDao = roundDao;

    }

    
    @Override
    public Game BeginGame() throws PersistenceException, NoGameException {
        
    Game newGame = new Game(generateFourDigitNumber());
    newGame = gameDao.AddNewGame(newGame);
        if (newGame == null) {
            throw new NoGameException("Failed to create new game.");
        }
   
    return newGame;
    
    }

    
    
    
    
    @Override
    public Round Guess(Round Round) throws NoGameException, InvalidUserInput {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Round> getRoundByTime(int gameId) throws NoGameException, InvalidUserInput {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Game> GetListOfGames() throws NoGameException, InvalidUserInput {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Game GetGameById(int gameId) throws NoGameException, InvalidUserInput {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
 
    public String generateFourDigitNumber() {
        String number = "";
        HashSet<Integer> set = new HashSet<Integer>();
        Random rand = new Random();
        while (set.size() != 4) {
            int num = rand.nextInt(10);
            if (!set.contains(num)) {
                set.add(num);
                number = number + num;
            }
        }
        return number;
    }
    
    public String validateGuess(Round guess){
        
        
        int game;
        game = gameDao.GetGameById(guess.getGameId());
        Round round= roundDao.AddRound(round);
        int exactMatches = 0;
        int partialMatches = 0;
        ArrayList<String> potentialPartialMatches = new ArrayList<>();
        
        //mark game as finished if the guess matches the game answer
        if (round.getGuess().equals(game.getFourDigitNumber())) {
            game.setStatusOfGame(true);
            gameDao.UpdateGame(game);
        }
        
        
        
        //calculate number of exact matches
        for(int i=0; i<game.getAnswer().length(); i++){
            if(game.getAnswer().charAt(i) == guess.getGuess().charAt(i)){
                exactMatches+=1;
            }else{
                //number of non-exact matches from the game answer
                potentialPartialMatches.add(Character.toString(((game.getAnswer().charAt(i)))));
            }
        }
        //calculate number of partial matches
        for(String letter : potentialPartialMatches){
            if(guess.getGuess().contains(letter)){
                partialMatches++;
            }
        }
        String result =  "e:"+exactMatches+":p:"+partialMatches;
       return  result;
    }

  
    
  

    

}
