package GuessTheNumber.service;

import GuessTheNumber.Dao.RoundDao;
import GuessTheNumber.Dao.GameDao;
import GuessTheNumber.dto.Game;
import GuessTheNumber.dto.Round;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author rosalindapowell0608
 */

@Component
public class ServiceImpl implements Service {
    
    @Autowired
    GameDao gameDao;
    
    @Autowired
    RoundDao roundDao;

    @Override
    public Game BeginGame() throws NoGameException, InvalidUserInput, PersistenceException {
        Game newGame = new Game(generateFourDigitNumber());
        newGame = gameDao.AddNewGame(newGame);
        if (newGame == null) {
            throw new NoGameException("Sorry, new game could not be created.");
        }
        return newGame;
    }

    @Override
    public Round Add(Round model) throws NoGameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Round Guess(Round round) throws NoGameException, InvalidUserInput {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Game> GetAllGames() throws NoGameException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Game GetGameById(int gameID) throws NoGameException, InvalidUserInput {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Round> GetRoundByTime(int GameID) throws NoGameException, InvalidUserInput {
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

   

    @Override
    public void validateGuess(String input) throws InvalidUserInput {
        Game game = gameDao.GetGameById(game.getGameId());
        Round round = roundDao.add(newRound);
        //Round round = roundDao.addRound(guess);
        int exactMatches = 0;
        int partialMatches = 0; 
        ArrayList<String> potentialPartialMatches = new ArrayList<>();
        
        //mark game as finished if the guess matches the game answer
        if (round.getGuess().equals(game.getFourDigitNumber())) {
            game.setStatusOfGame(true); 
            gameDao.UpdateGame(game); 
        }
        
        //calculate number of exact matches
        for(int i=0; i<round.getGuess().length(); i++){
            if(round.getGuess().charAt(i) == round.getGuess().charAt(i)){
                exactMatches+=1;
            }else{
                //number of non-exact matches from the game answer
                potentialPartialMatches.add(Character.toString(((round.getGuess().charAt(i)))));
            }
        }
        //calculate number of partial matches
        for(String letter : potentialPartialMatches){
            if(round.getGuess().contains(letter)){
                partialMatches++;
            }
        }
        String result =  "e:"+exactMatches+":p:"+partialMatches;
    
    }

    
}
