package com.mycompany.guessthenumber.data;

import com.mycompany.guessthenumber.models.Round;
import java.util.List;

/**
 *
 * @author rosalindapowell0608
 */
public interface RoundDao {
   public Round add(Round newRound);

   
   public List<Round> getAll(int GameId);

   
   public void deleteRoundId(int RoundId);
   
   
    
}
