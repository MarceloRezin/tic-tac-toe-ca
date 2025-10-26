package application.dto;

public class ScoreDto {

    private final int scoreX;
    private final String playerNameX;

    private final int scoreO;
    private final String playerNameO;

    public ScoreDto(int scoreX, String playerNameX, int scoreO, String playerNameO) {
        this.scoreX = scoreX;
        this.playerNameX = playerNameX;
        this.scoreO = scoreO;
        this.playerNameO = playerNameO;
    }

    public int getScoreX() {
        return scoreX;
    }

    public String getPlayerNameX() {
        return playerNameX;
    }

    public int getScoreO() {
        return scoreO;
    }

    public String getPlayerNameO() {
        return playerNameO;
    }
}
