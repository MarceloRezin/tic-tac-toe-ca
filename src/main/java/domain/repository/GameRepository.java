package domain.repository;

import domain.entity.Game;

public interface GameRepository {

    Game get();
    void save(Game game);
}
