package application.usecase;

import application.dto.*;
import domain.entity.*;
import domain.repository.BoardRepository;
import org.junit.Assert;
import org.junit.Test;

public class EndGameUseCaseTest {

    @Test
    public void Xwin_r1() {

        Board board = new Board();

        board.setGrid(new Symbol[][] {
                {Symbol.X, Symbol.X, Symbol.X},
                {null, null, null},
                {null, null, null},
        });

        var fakeBoardRepository = new FakeBoardRepository(board);

        var checkEndGameUseCase = new CheckEndGameUseCase(fakeBoardRepository);

        var output = checkEndGameUseCase.checkEndGame();

        Assert.assertEquals(GameStatus.HAS_WINNER, output.getGameStatus());
        Assert.assertEquals(Symbol.X, output.getWinner());
        Assert.assertEquals(WinType.ROW, output.getWinType());
    }

    @Test
    public void Owin_r2() {

        Board board = new Board();

        board.setGrid(new Symbol[][] {
                {null, null, null},
                {Symbol.O, Symbol.O, Symbol.O},
                {null, null, null},
        });

        var fakeBoardRepository = new FakeBoardRepository(board);

        var checkEndGameUseCase = new CheckEndGameUseCase(fakeBoardRepository);

        var output = checkEndGameUseCase.checkEndGame();

        Assert.assertEquals(GameStatus.HAS_WINNER, output.getGameStatus());
        Assert.assertEquals(Symbol.O, output.getWinner());
        Assert.assertEquals(WinType.ROW, output.getWinType());
    }

    @Test
    public void Owin_r3() {

        Board board = new Board();

        board.setGrid(new Symbol[][] {
                {Symbol.X, Symbol.X, null},
                {null, Symbol.X, null},
                {Symbol.O, Symbol.O, Symbol.O},
        });

        var fakeBoardRepository = new FakeBoardRepository(board);

        var checkEndGameUseCase = new CheckEndGameUseCase(fakeBoardRepository);

        var output = checkEndGameUseCase.checkEndGame();

        Assert.assertEquals(GameStatus.HAS_WINNER, output.getGameStatus());
        Assert.assertEquals(Symbol.O, output.getWinner());
        Assert.assertEquals(WinType.ROW, output.getWinType());
    }

    @Test
    public void Xwin_c1() {

        Board board = new Board();

        board.setGrid(new Symbol[][] {
                {Symbol.X, null, null},
                {Symbol.X, null, null},
                {Symbol.X, null, null},
        });

        var fakeBoardRepository = new FakeBoardRepository(board);

        var checkEndGameUseCase = new CheckEndGameUseCase(fakeBoardRepository);

        var output = checkEndGameUseCase.checkEndGame();

        Assert.assertEquals(GameStatus.HAS_WINNER, output.getGameStatus());
        Assert.assertEquals(Symbol.X, output.getWinner());
        Assert.assertEquals(WinType.COL, output.getWinType());
    }

    @Test
    public void Xwin_c2() {

        Board board = new Board();

        board.setGrid(new Symbol[][] {
                {null, Symbol.X, null},
                {null, Symbol.X, null},
                {null, Symbol.X, null},
        });

        var fakeBoardRepository = new FakeBoardRepository(board);

        var checkEndGameUseCase = new CheckEndGameUseCase(fakeBoardRepository);

        var output = checkEndGameUseCase.checkEndGame();

        Assert.assertEquals(GameStatus.HAS_WINNER, output.getGameStatus());
        Assert.assertEquals(Symbol.X, output.getWinner());
        Assert.assertEquals(WinType.COL, output.getWinType());
    }

    @Test
    public void Xwin_c3() {

        Board board = new Board();

        board.setGrid(new Symbol[][] {
                {null, null, Symbol.X},
                {null, null, Symbol.X},
                {null, null, Symbol.X},
        });

        var fakeBoardRepository = new FakeBoardRepository(board);

        var checkEndGameUseCase = new CheckEndGameUseCase(fakeBoardRepository);

        var output = checkEndGameUseCase.checkEndGame();

        Assert.assertEquals(GameStatus.HAS_WINNER, output.getGameStatus());
        Assert.assertEquals(Symbol.X, output.getWinner());
        Assert.assertEquals(WinType.COL, output.getWinType());
    }

    @Test
    public void Owin_d1() {

        Board board = new Board();

        board.setGrid(new Symbol[][] {
                {Symbol.O, Symbol.X, Symbol.X},
                {null, Symbol.O, Symbol.X},
                {Symbol.X, null, Symbol.O},
        });

        var fakeBoardRepository = new FakeBoardRepository(board);

        var checkEndGameUseCase = new CheckEndGameUseCase(fakeBoardRepository);

        var output = checkEndGameUseCase.checkEndGame();

        Assert.assertEquals(GameStatus.HAS_WINNER, output.getGameStatus());
        Assert.assertEquals(Symbol.O, output.getWinner());
        Assert.assertEquals(WinType.DIA_1, output.getWinType());
    }

    @Test
    public void Owin_d2() {

        Board board = new Board();

        board.setGrid(new Symbol[][] {
                {Symbol.X, Symbol.X, Symbol.O},
                {null, Symbol.O, Symbol.X},
                {Symbol.O, null, Symbol.X},
        });

        var fakeBoardRepository = new FakeBoardRepository(board);

        var checkEndGameUseCase = new CheckEndGameUseCase(fakeBoardRepository);

        var output = checkEndGameUseCase.checkEndGame();

        Assert.assertEquals(GameStatus.HAS_WINNER, output.getGameStatus());
        Assert.assertEquals(Symbol.O, output.getWinner());
        Assert.assertEquals(WinType.DIA_2, output.getWinType());
    }

    @Test
    public void draw() {

        Board board = new Board();

        board.setGrid(new Symbol[][] {
                {Symbol.X, Symbol.O, Symbol.X},
                {Symbol.O, Symbol.O, Symbol.X},
                {Symbol.X, Symbol.X, Symbol.O},
        });

        var fakeBoardRepository = new FakeBoardRepository(board);

        var checkEndGameUseCase = new CheckEndGameUseCase(fakeBoardRepository);

        var output = checkEndGameUseCase.checkEndGame();

        Assert.assertEquals(GameStatus.DRAW, output.getGameStatus());
    }

    private static class FakeBoardRepository implements BoardRepository {

        private Board board;

        public FakeBoardRepository(Board board) {
            this.board = board;
        }

        @Override
        public Board get() {
            return board;
        }

        @Override
        public void save(Board board) {

        }
    }
}
