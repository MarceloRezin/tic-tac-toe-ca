package interfaces.console;

import application.usecase.CheckEndGameUseCase;
import interfaces.console.dto.NextGameType;

public class ConsoleUI {

    private final NewGameHandler newGameHandler;
    private final RenderBoardHandler renderBoardHandler;
    private final MoveHandler moveHandler;
    private final EndGameHandler endGameHandler;
    private final NextGameHandler nextGameHandler;
    private final RematchHandler rematchHandler;

    private final CheckEndGameUseCase checkEndGameUseCase;

    public ConsoleUI(NewGameHandler newGameHandler, RenderBoardHandler renderBoardHandler, MoveHandler moveHandler, EndGameHandler endGameHandler, NextGameHandler nextGameHandler, RematchHandler rematchHandler, CheckEndGameUseCase checkEndGameUseCase) {
        this.newGameHandler = newGameHandler;
        this.renderBoardHandler = renderBoardHandler;
        this.moveHandler = moveHandler;
        this.endGameHandler = endGameHandler;
        this.nextGameHandler = nextGameHandler;
        this.rematchHandler = rematchHandler;
        this.checkEndGameUseCase = checkEndGameUseCase;
    }

    public void run() {
        clearAll();
        printIntro();

        while(true){
            newGameHandler.run();

            while(true){
                clearAll();

                var endGameOutput = checkEndGameUseCase.checkEndGame();

                renderBoardHandler.run(endGameOutput);
                if(endGameOutput.isEnd()){
                    endGameHandler.run(endGameOutput);

                    NextGameType nextGameType = nextGameHandler.run();
                    if(NextGameType.REMATCH.equals(nextGameType)){
                        rematchHandler.run();
                    }else{
                        clearAll();
                        break;
                    }

                }else{
                    moveHandler.run();
                }
            }
        }
    }

    private void clearAll() {
        System.out.print("\033\143");
    }

    private void printIntro() {
        System.out.println(
            """
            ████████╗██╗ ██████╗    ████████╗ █████╗  ██████╗    ████████╗ ██████╗ ███████╗
            ╚══██╔══╝██║██╔════╝    ╚══██╔══╝██╔══██╗██╔════╝    ╚══██╔══╝██╔═══██╗██╔════╝
               ██║   ██║██║            ██║   ███████║██║            ██║   ██║   ██║█████╗
               ██║   ██║██║            ██║   ██╔══██║██║            ██║   ██║   ██║██╔══╝
               ██║   ██║╚██████╗       ██║   ██║  ██║╚██████╗       ██║   ╚██████╔╝███████╗
               ╚═╝   ╚═╝ ╚═════╝       ╚═╝   ╚═╝  ╚═╝ ╚═════╝       ╚═╝    ╚═════╝ ╚══════╝
            """
        );

        System.out.println("Bem vindo! Use CTRL+C a qualquer momento para sair.\n\n");
    }
}
