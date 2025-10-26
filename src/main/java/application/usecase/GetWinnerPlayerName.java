package application.usecase;

import domain.entity.Symbol;
import domain.repository.PlayerRepository;

public class GetWinnerPlayerName {

    private final PlayerRepository playerRepository;

    public GetWinnerPlayerName(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public String getWinnerPlayerName(Symbol winner) {
        return playerRepository.getBySymbol(winner).getName();
    }
}
