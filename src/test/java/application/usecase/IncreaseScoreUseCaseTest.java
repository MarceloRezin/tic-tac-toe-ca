package application.usecase;

import domain.entity.*;
import domain.repository.GameRepository;
import org.junit.Assert;
import org.junit.Test;

public class IncreaseScoreUseCaseTest {

    @Test
    public void x0_o0_xWon() {
        Game game = new Game();

        IncreaseScoreUseCase useCase = new IncreaseScoreUseCase(new FakeGameRepository(game));
        useCase.increaseScore(Symbol.X);

        Assert.assertEquals(1, game.getScoreX());
    }

    @Test
    public void x0_o0_oWon() {
        Game game = new Game();

        IncreaseScoreUseCase useCase = new IncreaseScoreUseCase(new FakeGameRepository(game));
        useCase.increaseScore(Symbol.O);

        Assert.assertEquals(1, game.getScoreO());
    }

    private static class FakeGameRepository implements GameRepository {

        private final Game game;

        public FakeGameRepository(Game game) {
            this.game = game;
        }

        @Override
        public Game get() {
            return game;
        }

        @Override
        public void save(Game game) {

        }
    }
}
