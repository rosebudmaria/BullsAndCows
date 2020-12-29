package GuessTheNumber.Dao;


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
 * @author rosalindapowell0608
 */

@Repository
public class RoundDaoImpl implements RoundDao {
    
    
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private RoundDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Round add(Round round) {
        
        final String sql = "INSERT INTO Round(Guess, Result, TimeStampOfRound, GameId) " 
                + "VALUES(?, ?, ?, ?);";
        
        try {
            jdbcTemplate.update(sql, round.getGuess(), round.getResult(), 
                    round.getTimeStampOfRound(), round.getGameId());
        } catch(Exception ex) {
            return null;
        }
        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        round.setRoundId(newId);
        
        return round;
    }

    @Override
    public List<Round> getAll(int GameId) {
        List<Round> ListOfRounds = null;
        final String sql = "SELECT * FROM Round " 
                + " WHERE GameId = ? "
                + " ORDER BY TimeStampOfRound ;";
        try {
            ListOfRounds = jdbcTemplate.query(sql, new RoundMapper(), GameId);
             
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return ListOfRounds;
    }

    @Override
    public void deleteRoundId(int RoundId) {
        final String sql = "DELETE * " 
                + "FROM Round "
                + "WHERE RoundId = ?;";
        jdbcTemplate.update(sql, RoundId);
    }


    @Override
    public String getGuess() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Round getRoundById(int roundId) {
        try {
            final String SELECT_ROUND = "SELECT * FROM ROUND WHERE RoundId = ? ;";
            return jdbcTemplate.queryForObject(SELECT_ROUND, new RowMapper() {}, RoundId);
        } catch(Exception ex) {
    return null;
        }
    }

   

    public static final class RoundMapper implements RowMapper<Round> {
        
        @Override
        public Round mapRow(ResultSet rs, int i) throws SQLException {
            Round round = new Round(rs.getInt("RoundId"), rs.getString("Guess"), 
            rs.getString("Result"), 
            rs.getTimestamp("TimeStampOfRound").toLocalDateTime(), 
            rs.getInt("GameId"));
            return round;
        }

    }
}
