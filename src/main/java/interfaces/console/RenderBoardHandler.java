package interfaces.console;

import application.dto.*;
import application.usecase.GetBoardGridUseCase;
import domain.entity.Symbol;

import java.util.*;

import static interfaces.console.service.Sprites.*;

public class RenderBoardHandler {

    private CheckEndGameOutput endGameOutput;
    private static final Character X_WINNER = 'x';
    private static final Character O_WINNER = 'o';

    private static final Map<Character, String[]> SPRITES_BY_CHAR = new HashMap<>();
    static {
        SPRITES_BY_CHAR.put('X', X);
        SPRITES_BY_CHAR.put('O', O);
        SPRITES_BY_CHAR.put('1', ONE);
        SPRITES_BY_CHAR.put('2', TWO);
        SPRITES_BY_CHAR.put('3', THREE);
        SPRITES_BY_CHAR.put('4', FOUR);
        SPRITES_BY_CHAR.put('5', FIVE);
        SPRITES_BY_CHAR.put('6', SIX);
        SPRITES_BY_CHAR.put('7', SEVEN);
        SPRITES_BY_CHAR.put('8', EIGHT);
        SPRITES_BY_CHAR.put('9', NINE);
    }

    private final GetBoardGridUseCase getBoardMatrixUseCase;

    public RenderBoardHandler(GetBoardGridUseCase getBoardMatrixUseCase) {
        this.getBoardMatrixUseCase = getBoardMatrixUseCase;
    }

    public void run(CheckEndGameOutput endGameOutput) {
        this.endGameOutput = endGameOutput;

        var p1 = endGameOutput.getP1();
        var p2 = endGameOutput.getP2();
        var p3 = endGameOutput.getP3();

        if(endGameOutput.hasWinner()) {
            addWinnerSpritesFromWinType();

            System.out.println("Fim de jogo!\n\n");
        } else {
            System.out.println("Hora do jogo!\n\n");
        }

        String[][] boardMatrix = getBoardMatrixUseCase.getBoardGrid();
        for (int i = 0, counter = 1; i < boardMatrix.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < boardMatrix[0].length; j++, counter++) {
                var cell = boardMatrix[i][j];

                if (cell == null) {
                    cell = Integer.toString(counter);
                } else if(endGameOutput.hasWinner()) {
                    cell = markPostionIfWinner(i, j, cell, p1, p2, p3);
                }

                builder.append(cell);
            }

            renderRow(builder.toString(), i == boardMatrix.length - 1);
        }
    }

    private void addWinnerSpritesFromWinType() {
        var winner = endGameOutput.getWinner();
        String[] winSprite;

        if(Symbol.X.equals(winner)) {
            switch(endGameOutput.getWinType()) {
                case COL -> winSprite = X_COL_WIN;
                case ROW -> winSprite = X_ROW_WIN;
                case DIA_1 -> winSprite = X_DIA_1_WIN;
                case DIA_2 -> winSprite = X_DIA_2_WIN;
                default -> winSprite = X;
            }

            SPRITES_BY_CHAR.put(X_WINNER, winSprite);
        } else {
            switch(endGameOutput.getWinType()) {
                case COL -> winSprite = O_COL_WIN;
                case ROW -> winSprite = O_ROW_WIN;
                case DIA_1 -> winSprite = O_DIA_1_WIN;
                case DIA_2 -> winSprite = O_DIA_2_WIN;
                default -> winSprite = O;
            }

            SPRITES_BY_CHAR.put(O_WINNER, winSprite);
        }
    }

    private String markPostionIfWinner(int row, int col, String cell, PostionDto p1, PostionDto p2, PostionDto p3) {
        if((p1.getRow() == row && p1.getCol() == col) ||
                (p2.getRow() == row && p2.getCol() == col) ||
                (p3.getRow() == row && p3.getCol() == col)){
            return cell.toLowerCase();
        }

        return cell;
    }

    private void renderRow(String row, boolean lastRow) {
        List<String[]> sprites = new ArrayList<>();

        for (Character character : row.toCharArray()) {
            sprites.add(SPRITES_BY_CHAR.get(character));
        }

        int height = lastRow ? HEIGHT - 1 : HEIGHT;

        for(int i = 0; i < height; i++){

            StringBuilder builder = new StringBuilder();

            for(int j = 0; j< sprites.size(); j++){
                builder.append(removePipeIfLastCol(sprites.get(j)[i], j == sprites.size() - 1));
            }
            System.out.println(PADDING + builder);
        }
    }

    private String removePipeIfLastCol(String spriteLine, boolean isLastCol) {
        if(isLastCol) {
            return spriteLine.substring(0, spriteLine.length() - 1);
        }

        return spriteLine;
    }
}
