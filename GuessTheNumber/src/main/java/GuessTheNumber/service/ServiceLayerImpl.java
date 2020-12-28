

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
    public Round guess(Round round) throws NoGameException, InvalidUserInput {
        validateGuess(round.getGuess());
        Game playingGame = GetGameById(round.getGameById());
//        Game playingGame = gameDao.getGameById(round.getGameID());
//        if (playingGame == null) {
//            throw new NoSuchGameException("No Game found for Game ID :" + round.getGameID());
//        }
        if (playingGame.getStatus() == false) {
            throw new NoSuchGameException("Game ID :" + playingGame.getGameId() + " has finished, please start a new game");
        }
        String[] result = gameLogic(round.getAnswer(), playingGame.getRandomNumber());
        round.setResult(result[0]);
        if (result[1].equals("4")) {
            playingGame.endGame();
            gameDao.updateGame(playingGame);
        }
        round = roundDao.addRound(round);
        return round;
        
    }

    @Override
    public List<Round> getRoundByTime(int gameId) throws NoGameException, InvalidUserInput {
        
   Game game = GetGameById(gameId);
        List<Round> rounds = roundDao.GetRoundByTime (game.getGameId());
        if (rounds.size() == 0) {
            throw new NoGameException("This game has 0 rounds. It was not played yet");
        }
        return rounds;}

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
