package interfaces.console;

import application.usecase.*;
import domain.entity.Symbol;

public class ShowWinnerHandler {

    private final GetWinnerPlayerName getWinnerPlayerName;

    public ShowWinnerHandler(GetWinnerPlayerName getWinnerPlayerName) {
        this.getWinnerPlayerName = getWinnerPlayerName;
    }

    public void run(Symbol winner) {
        var winnerName = getWinnerPlayerName.getWinnerPlayerName(winner);

        System.out.println("\n\nParabéns " + winnerName + ", você venceu!");
    }
}
