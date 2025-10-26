package domain.entity;

public class Game {

    private int scoreX = 0;
    private int scoreO = 0;
    private Symbol actualSymbol = Symbol.X;

    public int getScoreX() {
        return scoreX;
    }

    public void setScoreX(int scoreX) {
        this.scoreX = scoreX;
    }

    public int getScoreO() {
        return scoreO;
    }

    public void setScoreO(int scoreO) {
        this.scoreO = scoreO;
    }

    public Symbol getActualSymbol() {
        return actualSymbol;
    }

    public void setActualSymbol(Symbol actualSymbol) {
        this.actualSymbol = actualSymbol;
    }

    public void increaseScore(Symbol symbol) {
        if(Symbol.X == symbol) {
            scoreX++;
        } else {
            scoreO++;
        }
    }
}
