package interfaces.console;

import application.dto.PostionDto;
import application.usecase.*;

import java.util.*;

public class MoveHandler {

    private final Scanner scanner;
    private final GetActualPlayerNameUseCase getActualPlayerNameUseCase;
    private final MakeMoveUseCase moveUseCase;
    private final TurnPlayerUseCase turnPlayerUseCase;
    private static final Map<Integer, PostionDto> PLAYER_POSITION_TO_BOARD = new HashMap<>();

    static {
        for(int i = 0, postion = 1; i < 3; i++) {
            for(int j = 0; j < 3; j++, postion++) {
                PLAYER_POSITION_TO_BOARD.put(postion, new PostionDto(i, j));
            }
        }
    }

    public MoveHandler(Scanner scanner, GetActualPlayerNameUseCase getActualPlayerNameUseCase, MakeMoveUseCase moveUseCase, TurnPlayerUseCase turnPlayerUseCase) {
        this.scanner = scanner;
        this.getActualPlayerNameUseCase = getActualPlayerNameUseCase;
        this.moveUseCase = moveUseCase;
        this.turnPlayerUseCase = turnPlayerUseCase;
    }

    public void run() {

        boolean invalid;

        do{
            System.out.print("\n\n" + getActualPlayerNameUseCase.getActualPlayerName() + " diga a posição da sua jogada: ");
            var positionStr = scanner.nextLine();

            try{
                var position = Integer.parseInt(positionStr);

                if(position < 1 || position > 9) {
                    System.out.println("A posição deve ser de 0 à 9.\n");
                    invalid = true;
                    continue;
                }

                PostionDto postionDto = PLAYER_POSITION_TO_BOARD.get(position);
                if(postionDto == null) {
                    throw new RuntimeException("Não foi possível recuperar a posição");
                }

                moveUseCase.makeMove(postionDto);
                turnPlayerUseCase.turnPlayer();
                invalid = false;
            } catch(NumberFormatException e){
                System.out.println("Você precisa informar um número.\n");
                invalid = true;
            } catch(IllegalArgumentException e){
                System.out.println("Essa posição já foi usada. Tente novamente.\n");
                invalid = true;
            }
        }while(invalid);
    }
}
