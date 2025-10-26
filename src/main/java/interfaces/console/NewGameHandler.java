package interfaces.console;

import application.usecase.NewGameUseCase;
import application.usecase.ResetPlayersUseCase;
import domain.entity.Symbol;

public class NewGameHandler {

    private final NewPlayerHandler newPlayerHandler;
    private final NewGameUseCase newGameUseCase;
    private final ResetPlayersUseCase resetPlayersUseCase;

    public NewGameHandler(NewPlayerHandler newPlayerHandler, NewGameUseCase newGameUseCase, ResetPlayersUseCase resetPlayersUseCase) {
        this.newPlayerHandler = newPlayerHandler;
        this.newGameUseCase = newGameUseCase;
        this.resetPlayersUseCase = resetPlayersUseCase;
    }

    public void run() {
        System.out.println("Iniciando novo jogo...\n");

        resetPlayersUseCase.resetPlayers();

        newPlayerHandler.run(Symbol.X);
        newPlayerHandler.run(Symbol.O);

        newGameUseCase.newGame();
    }
}
