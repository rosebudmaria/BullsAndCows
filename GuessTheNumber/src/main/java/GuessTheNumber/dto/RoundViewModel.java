package GuessTheNumber.dto;

/**
 *
 * @author rosalindapowell0608
 */
public class RoundViewModel {
    private int RoundIdView;
    private int GameIdView;
    private String GuessView;
    private String TimeStampOfRoundView;
    private String ResultView;
    
    public int getRoundIdView() {
        return RoundIdView;
    }
    
    public void setRoundIdView(int RoundIdView) {
        this.RoundIdView = RoundIdView;
    }
    
    
    public int getGameIdView() {
        return GameIdView;
    }
    
    public void setGameIdView(int GameIdView) {
        this.GameIdView = GameIdView;
    }
    
    
    public String getGuessView() {
        return GuessView;
    }
    
    public void setGuessView(String GuessView) {
        this.GuessView = GuessView;
    }
    
    public String getTimeStampOfRoundView() {
        return TimeStampOfRoundView;
    }
    
    public void setTimeStampOfRoundView(String TimeStampOfRoundView) {
        this.TimeStampOfRoundView = TimeStampOfRoundView;
    }
    public String getResultView() {
        return ResultView;
    }
    
    public void setResult(String ResultView) {
        this.ResultView = ResultView;
    }
    
}
