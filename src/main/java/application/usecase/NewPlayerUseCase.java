package application.usecase;

import domain.entity.Player;
import domain.entity.Symbol;
import domain.repository.PlayerRepository;

public class NewPlayerUseCase {

    private final PlayerRepository playerRepository;

    public NewPlayerUseCase(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void newPlayer(String name, Symbol symbol) {
        if(playerRepository.existsBySymbol(symbol)) {
            throw new RuntimeException("Já existe um player " + symbol);
        }

        playerRepository.save(new Player(name, symbol));
    }
}
