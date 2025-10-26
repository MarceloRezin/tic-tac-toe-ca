package application.usecase;

import domain.entity.*;
import domain.repository.BoardRepository;
import domain.repository.GameRepository;
import org.junit.Assert;
import org.junit.Test;

public class RematchUseCaseTest {

    @Test
    public void rematch_actualO_test() {
        Game game = new Game();
        game.setActualSymbol(Symbol.O);

        var fakeGameRepository = new FakeGameRepository(game);

        var board = new Board();
        board.updateGrid(0, 0, Symbol.X);
        board.updateGrid(0, 1, Symbol.X);
        board.updateGrid(0, 2, Symbol.X);

        var fakeBoardRepository = new FakeBoardRepository(board);

        var rematchUseCase = new RematchUseCase(fakeGameRepository, fakeBoardRepository);
        rematchUseCase.rematch();

        Assert.assertEquals(Symbol.X, game.getActualSymbol());
        assertEmptyBoard(fakeBoardRepository.get());
    }

    private void assertEmptyBoard(Board actualBoard){
        Symbol[][] grid = actualBoard.getGrid();

        for(Symbol[] row : grid){
            for(Symbol symbol : row){
                Assert.assertNull(symbol);
            }
        }
    }

    private static class FakeGameRepository implements GameRepository {

        private final Game game;

        public FakeGameRepository(Game game) {
            this.game = game;
        }

        @Override
        public Game get() {
            return game;
        }

        @Override
        public void save(Game game) {

        }
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
            this.board = board;
        }
    }
}
