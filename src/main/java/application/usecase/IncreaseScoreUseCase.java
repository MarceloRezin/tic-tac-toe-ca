package application.usecase;

import domain.entity.Game;
import domain.entity.Symbol;
import domain.repository.GameRepository;

public class IncreaseScoreUseCase {

    private final GameRepository gamerepository;

    public IncreaseScoreUseCase(GameRepository gamerepository) {
        this.gamerepository = gamerepository;
    }

    public void increaseScore(Symbol winner) {
        Game game = gamerepository.get();
        game.increaseScore(winner);

        gamerepository.save(game);
    }
}
