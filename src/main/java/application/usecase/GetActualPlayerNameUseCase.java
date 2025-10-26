package application.usecase;

import domain.repository.GameRepository;
import domain.repository.PlayerRepository;

public class GetActualPlayerNameUseCase {

    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;

    public GetActualPlayerNameUseCase(GameRepository gameRepository, PlayerRepository playerRepository) {
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
    }

    public String getActualPlayerName() {
        return playerRepository.getBySymbol(gameRepository.get().getActualSymbol()).getName();
    }
}
