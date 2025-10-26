package application.usecase;

import application.dto.PostionDto;
import domain.entity.*;
import domain.repository.BoardRepository;
import domain.repository.GameRepository;

public class MakeMoveUseCase {

    private final GameRepository gameRepository;
    private final BoardRepository boardRepository;

    public MakeMoveUseCase(GameRepository gameRepository, BoardRepository boardRepository) {
        this.gameRepository = gameRepository;
        this.boardRepository = boardRepository;
    }

    public void makeMove(PostionDto postionDto) throws IllegalArgumentException {
        Game game = gameRepository.get();

        var actualSymbol = game.getActualSymbol();

        Board actualBoard = boardRepository.get();
        actualBoard.updateGrid(postionDto.getRow(), postionDto.getCol(), actualSymbol);

        boardRepository.save(actualBoard);
        gameRepository.save(game);
    }
}
