package application.dto;

import domain.entity.Symbol;

public class CheckEndGameOutput {
    private PostionDto p1;
    private PostionDto p2;
    private PostionDto p3;
    private final GameStatus gameStatus;
    private Symbol winner;
    private WinType winType;

    public CheckEndGameOutput(PostionDto p1, PostionDto p2, PostionDto p3, Symbol winner, WinType winType) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.winner = winner;
        this.winType = winType;
        this.gameStatus = GameStatus.HAS_WINNER;
    }

    public CheckEndGameOutput(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public PostionDto getP1() {
        return p1;
    }

    public PostionDto getP2() {
        return p2;
    }

    public PostionDto getP3() {
        return p3;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Symbol getWinner() {
        return winner;
    }

    public WinType getWinType() {
        return winType;
    }

    public boolean isEnd() {
        return gameStatus != GameStatus.PLAYING;
    }

    public boolean hasWinner() {
        return gameStatus == GameStatus.HAS_WINNER;
    }
}
