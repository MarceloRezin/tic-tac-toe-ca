package application.usecase;

import domain.entity.*;
import domain.repository.BoardRepository;
import domain.repository.GameRepository;

public class NewGameUseCase {

    private final GameRepository gameRepository;
    private final BoardRepository boardRepository;

    public NewGameUseCase(GameRepository gameRepository, BoardRepository boardRepository) {
        this.gameRepository = gameRepository;
        this.boardRepository = boardRepository;
    }

    public void newGame() {
        boardRepository.save(new Board());
        gameRepository.save(new Game());
    }
}
