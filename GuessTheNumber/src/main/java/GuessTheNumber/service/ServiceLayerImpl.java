

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
            throw new NoGameException("Sorry, a new game could not be created.");
        }
   
    return newGame;
    
    }

    
    
    
    @Override
    public Round GetGuess(Round round) throws NoGameException, InvalidUserInput {
        validateInputNumber(round.getGuess());
        Game playingGame;
       playingGame = gameDao.GetGameById(round.getRoundId());

        if (playingGame.getStatusOfGame() == false) {
            throw new NoGameException("Game Id :" + playingGame.getGameId() + " has finished, please start a new game");
        }
        String[] result = gameLogic(round.getGuess(), playingGame.getFourDigitNumber());
        round.setResult(result[0]);
        if (result[1].equals("4")) {
             playingGame.setStatusOfGame(false);
            gameDao.UpdateGame(playingGame);
        }
        round = roundDao.AddRound(round);
        return round;
        
    }

//    @Override
//    public List<Round> getRoundByTime(int gameId) throws NoGameException, InvalidUserInput {
//        
//   Game game = GetGameById(gameId);
//        List<Round> rounds = roundDao.GetRoundByTime (game.getGameId());
//        if (rounds.size() == 0) {
//            throw new NoGameException("This game has 0 rounds. It was not played yet");
//        }
//        return rounds;}

    @Override
    public List<Game> GetListOfGames() throws NoGameException, InvalidUserInput {
       List<Game> games = gameDao.GetListOfGames();
        if (games.size() == 0) {
            throw new NoGameException("No games have been created.");
        }
        return games; }

    @Override
    public Game GetGameById(int gameId) throws NoGameException, InvalidUserInput {
        
       Game getGame = gameDao.GetGameById(gameId);
        if (getGame == null) {
            throw new NoGameException("No Game found for Game Id : " + gameId+ "could be found. Please try again.");
        }
        return getGame; }
    
   
 
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
    
    
     public boolean validateInputNumber(String number) throws InvalidUserInput {
        if (number.length() != 4) {
            throw new InvalidUserInput("Please enter a 4 digit number");
        }
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < number.length(); i++) {
            char temp = number.charAt(i);
            if (!Character.isDigit(temp)) {
                throw new InvalidUserInput("Please enter a 4 digit number, " + temp + " is not a number");
            } else if (set.contains(temp)) {
                throw new InvalidUserInput("Please enter a 4 digit non-repeating number, " + temp + " is repeating");
            } else {
                set.add(temp);
            }
        }
        if (set.size() == 4) {
            return true;
        } else {
            throw new InvalidUserInput("Invalid number input for" + number);
        }
    }
     
     
    private String[] gameLogic(String guess, String randomNumber) {
        HashSet<Character> set = new HashSet<Character>();
        int exactMatch = 0, partialMatch = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == randomNumber.charAt(i)) {
                exactMatch++;
            } else {
                set.add(randomNumber.charAt(i));
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (set.contains(guess.charAt(i))) {
                partialMatch++;
            }
        }
        String[] arr = new String[2];
        arr[0] = "e:" + exactMatch + ":p:" + partialMatch;
        arr[1] = exactMatch + "";
        return arr;
    }

    

}
