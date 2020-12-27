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
public interface Service {
    
    public Game BeginGame() throws PersistenceException, NoGameException;
    
    public Round Guess (Round Round) throws NoGameException;
    
    public List<Game> GetListOfGames() throws NoGameException;
    
    public Game GetGameById (int gameId) throws NoGameException;
    
    
    
}
