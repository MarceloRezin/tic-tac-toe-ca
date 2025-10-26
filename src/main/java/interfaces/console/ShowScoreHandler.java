package interfaces.console;

import application.usecase.GetScoreUseCase;

public class ShowScoreHandler {

    private final GetScoreUseCase getScoreUseCase;

    public ShowScoreHandler(GetScoreUseCase getScoreUseCase) {
        this.getScoreUseCase = getScoreUseCase;
    }

    public void run() {
        var score = getScoreUseCase.getScore();

        System.out.println("\nPlacar atual: ");
        System.out.println(score.getPlayerNameX() + ": " + score.getScoreX());
        System.out.println(score.getPlayerNameO() + ": " + score.getScoreO());
    }
}
