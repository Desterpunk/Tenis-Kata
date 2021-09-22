
public class TennisGame1 implements TennisGame {

    private int playerScore1 = 0;
    private int playerScore2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            playerScore1 += 1;
        else
            playerScore2 += 1;
    }

    public String getScore() {
        if (isEqual())
        {
            return getScoreAll(playerScore1);
        }
        if (isAdvantage())
        {
           return getAdvantageOrWin(playerScore1,playerScore2);
        }
        return Score.nameFromPoints(playerScore1) + "-" + Score.nameFromPoints(playerScore2);
    }

    private boolean isAdvantage() {
        return playerScore1 >=4 || playerScore2 >=4;
    }

    private boolean isEqual() {
        return playerScore1 == playerScore2;
    }

    private String getScoreAll(int playerScore) {
        switch (playerScore) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    private String getAdvantageOrWin (int playerScore1, int playerScore2){
        int minusResult = playerScore1 - playerScore2;
        if (minusResult==1) return "Advantage player1";
        if (minusResult ==-1) return "Advantage player2";
        if (minusResult>=2) return "Win for player1";
        return "Win for player2";
    }

    enum Score {
        Love, Fifteen, Thirty, Forty;

        public static String nameFromPoints(int points) {
            return values()[points].name();
        }
    }
}
