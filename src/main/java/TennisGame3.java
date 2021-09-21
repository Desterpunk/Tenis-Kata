
public class TennisGame3 implements TennisGame {
    
    private int playerPoints2;
    private int playerPoints1;
    private String playerName1;
    private String playerName2;
    private String score;
    String[] points = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    public TennisGame3(String p1N, String p2N) {
        this.playerName1 = p1N;
        this.playerName2 = p2N;
    }

    public String getScore() {
        if (isPointGame()) {
            return getPointGame();
        } else {
            if (isTie())
                return "Deuce";
            return this.getAdvantageWinner();
            }
    }
    
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.playerPoints1 += 1;
        else
            this.playerPoints2 += 1;
        
    }

    private boolean isPointGame(){
        return this.playerPoints1 < 4 && this.playerPoints2 < 4 && this.playerPoints1 + this.playerPoints2 != 6;
    }

    private String getPointGame(){
        this.score = this.points[playerPoints1];
        return (this.playerPoints1 == this.playerPoints2) ? this.score + "-All" : this.score + "-" + this.points[playerPoints2];
    }

    private boolean isTie(){
        return this.playerPoints1 == this.playerPoints2;
    }

    private String getName(){
        return this.score = this.playerPoints1 > this.playerPoints2 ? this.playerName1 : this.playerName2;
    }

    private String getAdvantageWinner(){
        this.getName();
        return ((this.playerPoints1-this.playerPoints2)*(this.playerPoints1-this.playerPoints2) == 1) ? "Advantage " + this.score : "Win for " + this.score;
    }

}
