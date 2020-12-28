package GuessTheNumber.Controller;

import GuessTheNumber.dto.Round;
import GuessTheNumber.dto.RoundViewModel;
import GuessTheNumber.dto.Game;
import GuessTheNumber.dto.GameViewModel;
import GuessTheNumber.service.Service;
import GuessTheNumber.service.NoGameException;
import GuessTheNumber.service.PersistenceException;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author rosalindapowell0608
 */
@RestController
//@RequestMapping()
public class Controller {

    @Autowired
    Service service;

//"begin" - POST – Starts a game, generates an answer, and sets the correct status. 
//Should return a 201 CREATED message as well as the created gameId.

    /**
     *
     * @return
     * @throws NoSuchGameException
     */
    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public GameViewModel create()throws NoGameException{
        return new GameViewModel(service.startGame());
    }

//"guess" – POST – Makes a guess by passing the guess and gameId in as JSON. 
//The program must calculate the results of the guess and mark the game finished if the guess is correct. 
//It returns the Round object with the results filled in.
    @PostMapping("/guess")
    // @ResponseStatus(HttpStatus.CREATED)
    public RoundViewModel guess(@RequestBody Round round)throws NoGameException, 
            PersistenceException{
        Round thisRound = round;
        Round newround = service.guess(round);
        
        return new RoundViewModel(newround);
    }

//"game" – GET – Returns a list of all games. Be sure in-progress games do not display their answer.
    @GetMapping("/game")
    public List<GameViewModel> getListOfGames()throws NoGameException{
        List<GameViewModel> listOfGameVM = new ArrayList<>();
        List<Game> listOFGames = service.getAllGames();
        for (int i = 0; i < listOFGames.size(); i++) {
            listOfGameVM.add(new GameViewModel(listOFGames.get(i)));
        }
        return listOfGameVM;

    }

//"game/{gameId}" - GET – Returns a specific game based on ID.Be sure in-progress games do not display their answer.
    @GetMapping("/game/{gameID}")
    public GameViewModel getGameByID(@PathVariable int gameID)throws NoGameException{
        return new GameViewModel(service.getGameById(gameID));
    }

//"rounds/{gameId} – GET – Returns a list of rounds for the specified game sorted by time.
    @GetMapping("/rounds/{gameID}")
    public List<Round> getListOfRoundsForGame(@PathVariable int gameID) throws NoGameException{
        return service.getRoundForGameSortedByTime(gameID);
    }

}
