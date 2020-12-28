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
    public Round add(Round newRound) {
        
        final String sql = "INSERT INTO Round(Guess, Result, TimeStampOfRound, GameId) " 
                + "VALUES(?, ?, ?, ?);";
        
        try {
            jdbcTemplate.update(sql, newRound.getGuess(), newRound.getResult(), 
                    newRound.getTimeStampOfRound(), newRound.getGameId());
        } catch(Exception ex) {
            return null;
        }
        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        newRound.setRoundId(newId);
        
        return newRound;
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
