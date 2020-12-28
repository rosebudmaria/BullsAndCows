package GuessTheNumber.service;


import GuessTheNumber.dto.Game;
import GuessTheNumber.dto.Round;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*

package GuessTheNumber.service;

import GuessTheNumber.dto.Game;
import GuessTheNumber.dto.Round;
import java.util.List;

/**
 *
 * @author shana
 */
public interface Service {
    
    public Game BeginGame()throws NoGameException;
    //"begin" - POST – Starts a game, generates an answer, and sets the correct status. 
    //Should return a 201 CREATED message as well as the created gameId.
    
    public Round Add (Round model) throws NoGameException;
    //"add" - adding addtional round to the game
    
    public Round Guess(Round round)throws NoGameException,PersistenceException;
    //"guess" – POST – Makes a guess by passing the guess and gameId in as JSON.
    //The program must calculate the results of the guess and mark the game finished if the guess is correct. 
    //It returns the Round object with the results filled in.

    public List<Game> GetAllGames() throws NoGameException;
    //"game" – GET – Returns a list of all games. Be sure in-progress games do not display their answer.
    
    
    public Game GetGameById(int gameID) throws NoGameException; 
    //"game/{gameId}" - GET – Returns a specific game based on ID. Be sure in-progress games 
    //do not display their answer.
    
    public List<Round> GetRoundByTime(int GameID) throws NoGameException; 
    //"rounds/{gameId} – GET – Returns a list of rounds for the specified game sorted by time.s


   
    }
