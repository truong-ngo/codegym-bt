package clean_code.tennis_game;

public class TennisGame {

    public static String getScore(String player1Name,
                                  String player2Name,
                                  int player1Score,
                                  int player2Score) {
        boolean isDraw = player1Score == player2Score;
        boolean isEnd = player1Score >= 4 || player2Score >=4;
        String gameScore;
        if (isDraw) return getGameDrawCalledScore(player1Score);
        if (isEnd) return getEndGameCallScore(player1Score,player2Score);
        gameScore = getPlayerCallScore(player1Score) + " - " + getPlayerCallScore(player2Score);
        return gameScore;
    }
    public static String getGameDrawCalledScore(int drawScore) {
        switch (drawScore) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }
    public static String getEndGameCallScore(int player1Score, int player2Score) {
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) return "Advance Player 1";
        if (minusResult == -1) return "Advance Player 2";
        if (minusResult >= 2) return "Player 1 win";
        return "Player 2 win";
    }

    public static String getPlayerCallScore(int playerScore) {
        switch (playerScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }
}
