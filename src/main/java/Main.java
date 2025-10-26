import application.usecase.*;
import domain.repository.*;
import interfaces.console.*;
import persistence.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Repositories
        PlayerRepository playerRepository = new PlayerRepositoryInMemory();
        GameRepository gameRepository = new GameRepositoryInMemory();
        BoardRepository boardRepository = new BoardRepositoryInMemory();

        //Use cases
        NewPlayerUseCase newPlayerUseCase = new NewPlayerUseCase(playerRepository);
        NewGameUseCase newGameUseCase = new NewGameUseCase(gameRepository, boardRepository);
        GetBoardGridUseCase getBoardMatrixUseCase = new GetBoardGridUseCase(boardRepository);
        GetActualPlayerNameUseCase getActualPlayerNameUseCase = new GetActualPlayerNameUseCase(gameRepository, playerRepository);
        MakeMoveUseCase moveUseCase = new MakeMoveUseCase(gameRepository, boardRepository);
        TurnPlayerUseCase turnPlayerUseCase = new TurnPlayerUseCase(gameRepository);
        CheckEndGameUseCase endGameUseCase = new CheckEndGameUseCase(boardRepository);
        GetWinnerPlayerName getWinnerPlayerName = new GetWinnerPlayerName(playerRepository);
        IncreaseScoreUseCase increaseScoreUseCase = new IncreaseScoreUseCase(gameRepository);
        GetScoreUseCase getScoreUseCase = new GetScoreUseCase(gameRepository, playerRepository);
        RematchUseCase rematchUseCase = new RematchUseCase(gameRepository, boardRepository);
        ResetPlayersUseCase resetPlayersUseCase = new ResetPlayersUseCase(playerRepository);

        //Handlers
        NewPlayerHandler newPlayerHandler = new NewPlayerHandler(scanner, newPlayerUseCase);
        NewGameHandler newGameHandler = new NewGameHandler(newPlayerHandler, newGameUseCase, resetPlayersUseCase);
        RenderBoardHandler renderBoardHandler = new RenderBoardHandler(getBoardMatrixUseCase);
        MoveHandler moveHandler = new MoveHandler(scanner, getActualPlayerNameUseCase, moveUseCase, turnPlayerUseCase);
        ShowWinnerHandler showWinnerHandler = new ShowWinnerHandler(getWinnerPlayerName);
        WinHandler winHandler = new WinHandler(increaseScoreUseCase, showWinnerHandler);
        ShowScoreHandler showScoreHandler = new ShowScoreHandler(getScoreUseCase);
        EndGameHandler endGameHandler = new EndGameHandler(winHandler, showScoreHandler);
        NextGameHandler nextGameHandler = new NextGameHandler(scanner);
        RematchHandler rematchHandler = new RematchHandler(rematchUseCase);

        new ConsoleUI(newGameHandler, renderBoardHandler, moveHandler, endGameHandler, nextGameHandler, rematchHandler, endGameUseCase).run();
    }

}