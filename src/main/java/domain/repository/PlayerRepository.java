package domain.repository;

import domain.entity.Player;
import domain.entity.Symbol;

public interface PlayerRepository {

    void save(Player player);
    boolean existsBySymbol(Symbol symbol);
    Player getBySymbol(Symbol symbol);
    void reset();
}
