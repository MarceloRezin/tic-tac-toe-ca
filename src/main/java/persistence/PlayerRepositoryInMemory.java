package persistence;

import domain.entity.Player;
import domain.entity.Symbol;
import domain.repository.PlayerRepository;

import java.util.*;

public class PlayerRepositoryInMemory implements PlayerRepository {

    private final Map<Symbol, Player> players = new HashMap<>();

    @Override
    public void save(Player player) {
        players.put(player.getSymbol(), player);
    }

    @Override
    public boolean existsBySymbol(Symbol symbol) {
        return players.containsKey(symbol);
    }

    @Override
    public Player getBySymbol(Symbol symbol) {
        return players.get(symbol);
    }

    @Override
    public void reset() {
        players.clear();
    }
}
