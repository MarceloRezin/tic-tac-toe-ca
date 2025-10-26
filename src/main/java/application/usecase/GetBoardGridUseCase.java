package application.usecase;

import domain.repository.BoardRepository;

public class GetBoardGridUseCase {

    private final BoardRepository boardRepository;

    public GetBoardGridUseCase(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public String[][] getBoardGrid() {
        var gridDto = new String[3][3];

        var grid = boardRepository.get().getGrid();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                var symbol = grid[i][j];

                gridDto[i][j] = symbol == null ? null : symbol.name();
            }
        }

        return gridDto;
    }
}
