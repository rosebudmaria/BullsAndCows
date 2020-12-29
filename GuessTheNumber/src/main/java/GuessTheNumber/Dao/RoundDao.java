/*	package com.mycompany.guessthenumber.data;
 * To change this license header, choose License Headers in Project Properties.	
 * To change this template file, choose Tools | Templates	
 * and open the template in the editor.	
 */	
package GuessTheNumber.Dao;	


import GuessTheNumber.dto.Round;	
import java.util.List;	


/**	
 *	 
 * @author shana	 
 */	 

public interface RoundDao {	
    
    public Round AddRound (Round newRound);
    
    public List<Round> GetRoundByTime (int gameId);
    
    public void DeleteRoundById(int roundId);	

}
