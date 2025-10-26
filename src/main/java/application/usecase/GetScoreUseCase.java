package application.usecase;

import application.dto.ScoreDto;
import domain.entity.Symbol;
import domain.repository.GameRepository;
import domain.repository.PlayerRepository;

public class GetScoreUseCase {

    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;

    public GetScoreUseCase(GameRepository gameRepository, PlayerRepository playerRepository) {
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
    }

    public ScoreDto getScore() {
        var game = gameRepository.get();

        return new ScoreDto(game.getScoreX(), playerRepository.getBySymbol(Symbol.X).getName(), game.getScoreO(), playerRepository.getBySymbol(Symbol.O).getName());
    }
}
