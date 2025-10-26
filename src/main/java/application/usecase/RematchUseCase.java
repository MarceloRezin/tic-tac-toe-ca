package application.usecase;

import domain.entity.*;
import domain.repository.BoardRepository;
import domain.repository.GameRepository;

public class RematchUseCase {

    private final GameRepository gameRepository;
    private final BoardRepository boardRepository;

    public RematchUseCase(GameRepository gameRepository, BoardRepository boardRepository) {
        this.gameRepository = gameRepository;
        this.boardRepository = boardRepository;
    }

    public void rematch() {
        var game = gameRepository.get();
        game.setActualSymbol(Symbol.X);

        gameRepository.save(game);

        boardRepository.save(new Board());
    }
}
