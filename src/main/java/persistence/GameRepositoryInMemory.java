package persistence;

import domain.entity.Game;
import domain.repository.GameRepository;

public class GameRepositoryInMemory implements GameRepository {

    private Game game;

    @Override
    public Game get() {
        return game;
    }

    @Override
    public void save(Game game) {
        this.game = game;
    }
}
