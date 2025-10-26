package application.usecase;

import domain.repository.PlayerRepository;

public class ResetPlayersUseCase {

    private final PlayerRepository playerRepository;

    public ResetPlayersUseCase(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void resetPlayers() {
        playerRepository.reset();
    }
}
