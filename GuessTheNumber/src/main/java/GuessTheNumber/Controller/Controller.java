package GuessTheNumber.Controller;

import GuessTheNumber.dao.GameDao;
import GuessTheNumber.dao.RoundDao;
import GuessTheNumber.dto.Game;
import GuessTheNumber.dto.GameViewModel;
import GuessTheNumber.dto.Round;
import GuessTheNumber.dto.RoundViewModel;
import GuessTheNumber.service.InvalidUserInput;
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
import GuessTheNumber.service.ServiceLayer;

/**
 *
 * @author Rosalinda Powell ,  Dec 26, 2020  ,  1:21:40 AM
 */

@RestController
public class Controller {

    @Autowired
    private GameDao gameDao;

    @Autowired
    private RoundDao roundDao;


     @Autowired
    ServiceLayer service;

//"begin" - POST – Starts a game, generates an answer, and sets the correct status.
//Should return a 201 CREATED message as well as the created gameId.

    /**
     *
     * @return
     * @throws Error
     */
    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public GameViewModel AddNewGame() throws PersistenceException, NoGameException, InvalidUserInput  {
        return new GameViewModel(service.BeginGame());
    }

//"guess" – POST – Makes a guess by passing the guess and gameId in as JSON.
//The program must calculate the results of the guess and mark the game finished if the guess is correct.
//It returns the Round object with the results filled in.
    @PostMapping("/guess")
    // @ResponseStatus(HttpStatus.CREATED)
    public RoundViewModel guess(@RequestBody Round round)throws NoGameException,
            PersistenceException,
            InvalidUserInput{
        Round thisRound = round;
        Round newRound = service.Guess(round);

        return new RoundViewModel();

    }

//"game" – GET – Returns a list of all games. Be sure in-progress games do not display their answer.
    @GetMapping("/game")
    public List<GameViewModel> getListOfGames()  throws PersistenceException, NoGameException, InvalidUserInput {
        List<GameViewModel> listOfGameVM = new ArrayList<>();
        List<Game> listOfGames = service.GetListOfGames();
        for (int i = 0; i < listOfGames.size(); i++) {
            listOfGameVM.add(new GameViewModel(listOfGames.get(i)));
        }
        return listOfGameVM;

    }

//"game/{gameId}" - GET – Returns a specific game based on ID.Be sure in-progress games do not display their answer.
    @GetMapping("/game/{gameId}")
    public GameViewModel getGameById(@PathVariable int gameId)throws NoGameException, InvalidUserInput{
        return new GameViewModel(service.GetGameById(gameId));
    }



//"rounds/{gameId} – GET – Returns a list of rounds for the specified game sorted by time.
    @GetMapping("/rounds/{gameId}")
    public List<Round> getListOfRoundsForGame(@PathVariable int gameId) throws NoGameException, InvalidUserInput{
        return service.getRoundByTime(gameId);
    }

}
