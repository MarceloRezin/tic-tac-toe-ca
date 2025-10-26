package application.usecase;

import domain.entity.*;
import domain.repository.GameRepository;

public class TurnPlayerUseCase {

    private final GameRepository gameRepository;

    public TurnPlayerUseCase(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public void turnPlayer() {
        Game game = gameRepository.get();

        var actualSymbol = game.getActualSymbol();
        if(Symbol.X == actualSymbol) {
            actualSymbol = Symbol.O;
        } else {
            actualSymbol = Symbol.X;
        }

        game.setActualSymbol(actualSymbol);

        gameRepository.save(game);
    }
}
