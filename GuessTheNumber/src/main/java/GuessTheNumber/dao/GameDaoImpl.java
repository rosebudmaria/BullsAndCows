package GuessTheNumber.dao;

import GuessTheNumber.dto.Game;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Shantoria Taylor  ,  Dec 26, 2020  ,  1:20:18 AM

 */

@Repository
public class GameDaoImpl implements GameDao{

    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    @Override
    @Transactional
    public Game AddNewGame(Game newGame) {
    final String INSERT_GAME = "INSERT INTO Game(GameId, FourDigitNumber, StatusOfGame) VALUES (?,?,?);";
    jdbcTemplate.update(INSERT_GAME,
            newGame.getGameId(),
            newGame.getFourDigitNumber(),
            newGame.getStatusOfGame());
    
    int newId= jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Integer.class);
    newGame.setGameId(newId);
    
    return newGame;
    }

    @Override
    public Game GetGameById(int gameId) {
        final String SELECT_GAME = "SELECT * FROM GAME WHERE GameId = ? ; ";
        return jdbcTemplate.queryForObject(SELECT_GAME, new GameMapper(), gameId);
        
          
        }
    

    @Override
    public List<Game> GetListOfGames() {
   final String SELECT_ALL_GAMES =  "SELECT * FROM GAME; ";
   
   return jdbcTemplate.query(SELECT_ALL_GAMES, new GameMapper());
    }

    @Override
    public void UpdateGame(Game playingGame) {
        final String EDIT_GAME = "UPDATE GAME SET StatusOfGame = ? WHERE GameId = ? ;" ;
    }

    @Override
    @Transactional
    public void DeleteGameId(int gameId) {
        final String DELETE_GAME_ROUND = "DELETE FROM ROUND WHERE gameId= ? ; " ;
        jdbcTemplate.update(DELETE_GAME_ROUND, gameId);
        
        final String DELETE_GAME = "DELETE FROM GAME WHERE gameId= ? ; ";
        jdbcTemplate.update(DELETE_GAME, gameId);
    }



    
    private static final class GameMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException {
            Game game = new Game(rs.getInt("GameId"), rs.getString("FourDigitNumber"), rs.getBoolean("StatusOfGame"));
            return game;
        }
    }
}