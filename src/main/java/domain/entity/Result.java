package domain.entity;

public class Result {

    private final Symbol winner;
    private final int p1;
    private final int p2;
    private final int p3;

    public Result(Symbol winner, int p1, int p2, int p3) {
        this.winner = winner;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Symbol getWinner() {
        return winner;
    }

    public int getP1() {
        return p1;
    }

    public int getP2() {
        return p2;
    }

    public int getP3() {
        return p3;
    }
}
