package interfaces.console;

import application.dto.CheckEndGameOutput;

public class EndGameHandler {

    private final WinHandler winHandler;
    private final ShowScoreHandler showScoreHandler;

    public EndGameHandler(WinHandler winHandler, ShowScoreHandler showScoreHandler) {
        this.winHandler = winHandler;
        this.showScoreHandler = showScoreHandler;
    }

    public void run(CheckEndGameOutput endGameOutput) {
        if(endGameOutput.hasWinner()){
            winHandler.run(endGameOutput);
        } else {
            System.out.println("Deu velha!");
        }

        showScoreHandler.run();
    }
}
