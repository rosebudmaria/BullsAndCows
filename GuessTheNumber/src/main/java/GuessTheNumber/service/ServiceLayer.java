/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessTheNumber.service;

import GuessTheNumber.dto.Game;
import GuessTheNumber.dto.Round;
import java.util.List;

/**
 *
 * @author shana
 */
public interface ServiceLayer {
    
    public Game BeginGame() throws PersistenceException, NoGameException;
    
    public Round Add (Round model) throws NoGameException;
    
    public Round GetGuess (Round Round) throws NoGameException, InvalidUserInput;
    
    public List<Round> getRoundByTime (int gameId) throws NoGameException, InvalidUserInput;
    
    public List<Game> GetListOfGames() throws NoGameException, InvalidUserInput;
    
    public Game GetGameById (int gameId) throws NoGameException, InvalidUserInput;
    
    public void validateGuess(String input) throws InvalidUserInput;
    
    public String generateFourDigitNumber();

   
    }
