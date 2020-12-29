
package GuessTheNumber.dao;

import GuessTheNumber.dto.Game;
import GuessTheNumber.dto.Round;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Shantoria Taylor  ,  Dec 26, 2020  ,  1:20:51 AM

 */

@Repository
public class RoundDaoImpl implements RoundDao{

    @Autowired
    private final JdbcTemplate jdbcTemplate;

//    @Autowired
    private RoundDaoImpl(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
   }

    @Override
    @Transactional
    public Round AddRound(Round newRound) {
        
        final String INSERT_ROUND = "INSERT INTO Round(Guess, Result, TimeStampOfRound, GameId) " 
                + "VALUES(?, ?, ?, ?);";
        
        try {
            jdbcTemplate.update(INSERT_ROUND, newRound.getGuess(), newRound.getResult(), 
                    newRound.getTimeStampOfRound(), newRound.getGameId());
        } 
        catch(Exception ex) {
            return null;
        }
        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        newRound.setRoundId(newId);
        
        return newRound;
    }

    
    
    @Override
    public List<Round> GetAllRounds() {
        final String  SELECT_ALL_ROUNDS = "SELECT * FROM Round " 
                + " WHERE GameId = ? "
                + " ORDER BY TimeStampOfRound ;";
       
        return jdbcTemplate.query(SELECT_ALL_ROUNDS, new RoundMapper());
    }

    @Override
    public void DeleteRoundById(int RoundId) {
        final String sql = "DELETE * " 
                + "FROM Round "
                + "WHERE RoundId = ?;";
        jdbcTemplate.update(sql, RoundId);
    }

//    @Override
//    public List<Round> GetRoundByTime(int gameId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public String GetGuess() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public boolean update(Round round) {
  final String UPDATE_ROUND = "UPDATE Round SET GameId = ?, TimeStampOfRound = ?, Guess = ?, Result = ?,  WHERE RoundId = ?; " ;
        return jdbcTemplate.update(UPDATE_ROUND, round.getGameId(), round.getGuess(), round.getResult(),
                round.getTimeStampOfRound(), round.getRoundId()) > 0;
     }

    
    public static final class RoundMapper implements RowMapper<Round> {
        
        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
             Round round = new Round(rs.getInt("RoundId"), rs.getString("Guess"), rs.getString("Result"));
            return round;
        }

    }
}