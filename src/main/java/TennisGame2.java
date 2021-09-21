
public class TennisGame2 implements TennisGame
{
    public int playerPoints1;
    public int playerPoints2;
    private String player1Name;
    private String player2Name;
    private final String[] scores = {"Love","Fifteen","Thirty","Forty"};

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        if(isTie()) return gameTie();
        if(isAdvanceGame()) return gameAdvantage();
        return currentScore();
    }

    public void wonPoint(String player) {
        if (player == "player1")
            playerPoints1++;
        else
            playerPoints2++;
    }

    public boolean isTie(){
        return playerPoints1 == playerPoints2;
    }

    public String gameTie(){
        return (playerPoints1 < 3) ? scores[playerPoints1] + "-All" : "Deuce";
    }

    public String currentScore(){
        return scores[playerPoints1] + "-" + scores[playerPoints2];
    }

    public int differenceResult(){
        return playerPoints1 - playerPoints2;
    }

    public boolean isAdvanceGame(){
        return playerPoints1 >= 4 || playerPoints2 >= 4;
    }

    public String gameAdvantage(){
        if (differenceResult() == 1) return  "Advantage player1";
        if (differenceResult() == -1) return  "Advantage player2";
        return winner();
    }

    public String winner(){
        return (differenceResult()>=2) ? "Win for player1" : "Win for player2";
    }
}