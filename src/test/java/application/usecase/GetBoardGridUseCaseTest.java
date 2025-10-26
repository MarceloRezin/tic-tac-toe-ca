package application.usecase;

import domain.entity.*;
import domain.repository.BoardRepository;
import org.junit.Assert;
import org.junit.Test;

public class GetBoardGridUseCaseTest {

    @Test
    public void getBoardGrid_test() {
        var board = new Board();

        board.updateGrid(0, 0, Symbol.X);
        board.updateGrid(0, 1, Symbol.X);
        board.updateGrid(0, 2, Symbol.X);

        var fakeBoardRepository = new FakeBoardRepository(board);

        var getBoardGridUseCase = new GetBoardGridUseCase(fakeBoardRepository);
        var boardGrid = getBoardGridUseCase.getBoardGrid();

        String[][] expectedGrid = {
            {"X", "X", "X"},
            {null, null, null},
            {null, null, null},
        };

        for(int i = 0; i < expectedGrid.length; i++){
            for(int j = 0; j < expectedGrid[i].length; j++){
                Assert.assertEquals(expectedGrid[i][j], boardGrid[i][j]);
            }
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

        }
    }
}
