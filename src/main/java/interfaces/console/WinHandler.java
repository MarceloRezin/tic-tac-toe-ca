package interfaces.console;

import application.dto.CheckEndGameOutput;
import application.usecase.IncreaseScoreUseCase;

public class WinHandler {

    private final IncreaseScoreUseCase increaseScoreUseCase;
    private final ShowWinnerHandler showWinnerHandler;

    public WinHandler(IncreaseScoreUseCase increaseScoreUseCase, ShowWinnerHandler showWinnerHandler) {
        this.increaseScoreUseCase = increaseScoreUseCase;
        this.showWinnerHandler = showWinnerHandler;
    }

    public void run(CheckEndGameOutput endGameOutput) {
        increaseScoreUseCase.increaseScore(endGameOutput.getWinner());
        showWinnerHandler.run(endGameOutput.getWinner());
    }
}
