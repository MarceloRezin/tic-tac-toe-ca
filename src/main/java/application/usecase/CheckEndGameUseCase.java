package application.usecase;

import application.dto.*;
import domain.entity.Board;
import domain.entity.Symbol;
import domain.repository.BoardRepository;

public class CheckEndGameUseCase {

    private final BoardRepository boardRepository;
    private Board board;

    public CheckEndGameUseCase(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public CheckEndGameOutput checkEndGame() {
        board = boardRepository.get();

        var output = checkWinnerRow1();

        if(output != null) {
            return output;
        }

        output = checkWinnerRow2();
        if(output != null) {
            return output;
        }

        output = checkWinnerRow3();
        if(output != null) {
            return output;
        }

        output = checkWinnerCol1();
        if(output != null) {
            return output;
        }

        output = checkWinnerCol2();
        if(output != null) {
            return output;
        }

        output = checkWinnerCol3();
        if(output != null) {
            return output;
        }

        output = checkWinnerDia1();
        if(output != null) {
            return output;
        }

        output = checkWinnerDia2();
        if(output != null) {
            return output;
        }

        output = checkDraw();
        if(output != null) {
            return output;
        }

        return new CheckEndGameOutput(GameStatus.PLAYING);
    }

    private CheckEndGameOutput checkWinnerRow1() {
        return checkWinner(
                new PostionDto(0, 0),
                new PostionDto(0, 1),
                new PostionDto(0, 2),
                WinType.ROW
        );
    }

    private CheckEndGameOutput checkWinnerRow2() {
        return checkWinner(
                new PostionDto(1, 0),
                new PostionDto(1, 1),
                new PostionDto(1, 2),
                WinType.ROW
        );
    }

    private CheckEndGameOutput checkWinnerRow3() {
        return checkWinner(
                new PostionDto(2, 0),
                new PostionDto(2, 1),
                new PostionDto(2, 2),
                WinType.ROW
        );
    }

    private CheckEndGameOutput checkWinnerCol1() {
        return checkWinner(
                new PostionDto(0, 0),
                new PostionDto(1, 0),
                new PostionDto(2, 0),
                WinType.COL
        );
    }

    private CheckEndGameOutput checkWinnerCol2() {
        return checkWinner(
                new PostionDto(0, 1),
                new PostionDto(1, 1),
                new PostionDto(2, 1),
                WinType.COL
        );
    }

    private CheckEndGameOutput checkWinnerCol3() {
        return checkWinner(
                new PostionDto(0, 2),
                new PostionDto(1, 2),
                new PostionDto(2, 2),
                WinType.COL
        );
    }

    private CheckEndGameOutput checkWinnerDia1() {
        return checkWinner(
                new PostionDto(0, 0),
                new PostionDto(1, 1),
                new PostionDto(2, 2),
                WinType.DIA_1
        );
    }

    private CheckEndGameOutput checkWinnerDia2() {
        return checkWinner(
                new PostionDto(0, 2),
                new PostionDto(1, 1),
                new PostionDto(2, 0),
                WinType.DIA_2
        );
    }

    private CheckEndGameOutput checkWinner(PostionDto p1, PostionDto p2, PostionDto p3, WinType winType) {
        if (hasWinner(p1, p2, p3)) {
            return new CheckEndGameOutput(p1, p2, p3, board.getFrom(p1.getRow(), p1.getCol()), winType);
        }

        return null;
    }

    private boolean hasWinner(PostionDto p1, PostionDto p2, PostionDto p3) {
        var symbolP1 = board.getFrom(p1.getRow(), p1.getCol());

        if(symbolP1 == null) {
            return false;
        }

        return symbolP1 == board.getFrom(p2.getRow(), p2.getCol())
                &&
                symbolP1 == board.getFrom(p3.getRow(), p3.getCol());
    }

    private CheckEndGameOutput checkDraw() {
        var grid = board.getGrid();

        for(Symbol[] row : grid) {
            for(Symbol symbol : row) {
                if(symbol == null) {
                    return null;
                }
            }
        }

        return new CheckEndGameOutput(GameStatus.DRAW);
    }
}
