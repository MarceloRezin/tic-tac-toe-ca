package domain.entity;

import org.junit.Assert;
import org.junit.Test;

public class BoardTest {

    @Test(expected = IllegalArgumentException.class)
    public void updateGrid_invalidRow_rowMinus1_test() {
        var board = new Board();

        board.updateGrid(-1, 0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateGrid_invalidRow_row3_test() {
        var board = new Board();

        board.updateGrid(3, 0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateGrid_invalidCol_colMinus1_test() {
        var board = new Board();

        board.updateGrid(0, -1, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateGrid_invalidCol_col3_test() {
        var board = new Board();

        board.updateGrid(0, 3, null);
    }

    @Test
    public void updateGrid_validPositon_test() {
        var board = new Board();

        board.updateGrid(0, 0, Symbol.X);

        Assert.assertEquals(Symbol.X, board.getGrid()[0][0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateGrid_positionUsed_test() {
        var board = new Board();

        board.updateGrid(0, 0, Symbol.X);
        board.updateGrid(0, 0, Symbol.X);
    }
}
