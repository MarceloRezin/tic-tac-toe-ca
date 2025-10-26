package application.usecase;

import domain.entity.Player;
import domain.entity.Symbol;
import domain.repository.PlayerRepository;
import org.junit.Assert;
import org.junit.Test;

public class NewPlayerUseCaseTest {

    @Test(expected = RuntimeException.class)
    public void symbolExists_test() {
        NewPlayerUseCase newPlayerUseCase = new NewPlayerUseCase(new FakePlayerRepository(true));

        newPlayerUseCase.newPlayer("", Symbol.X);
    }

    @Test
    public void validPlayer_test() {
        FakePlayerRepository fakePlayerRepository = new FakePlayerRepository(false);

        NewPlayerUseCase newPlayerUseCase = new NewPlayerUseCase(fakePlayerRepository);
        newPlayerUseCase.newPlayer("Test", Symbol.X);

        Player playerSaved = fakePlayerRepository.getPlayer();
        Assert.assertNotNull(playerSaved);
        Assert.assertEquals(Symbol.X, playerSaved.getSymbol());
        Assert.assertEquals("Test", playerSaved.getName());
    }

    private static class FakePlayerRepository implements PlayerRepository {

        private final boolean existsBySymbol;
        private Player player;

        public FakePlayerRepository(boolean existsBySymbol) {
            this.existsBySymbol = existsBySymbol;
        }

        public Player getPlayer() {
            return player;
        }

        @Override
        public void save(Player player) {
            this.player = player;
        }

        @Override
        public boolean existsBySymbol(Symbol symbol) {
            return existsBySymbol;
        }

        @Override
        public Player getBySymbol(Symbol symbol) {
            return null;
        }

        @Override
        public void reset() {

        }
    }

}