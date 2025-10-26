package interfaces.console;

import application.usecase.NewPlayerUseCase;
import domain.entity.Symbol;

import java.util.Scanner;

public class NewPlayerHandler {

    private final Scanner scanner;
    private final NewPlayerUseCase newPlayerUseCase;

    public NewPlayerHandler(Scanner scanner, NewPlayerUseCase newPlayerUseCase) {
        this.scanner = scanner;
        this.newPlayerUseCase = newPlayerUseCase;
    }

    public void run(Symbol symbolRequested) {

        boolean invalid;
        String playerName;

        do {
            System.out.print("Qual é o nome do jogador " + symbolRequested.name() + "? ");
            playerName = scanner.nextLine();

            if (playerName == null || playerName.trim().isEmpty()) {
                System.out.println("O nome não pode ser vazio.\n");
                invalid = true;
            } else {
                invalid = false;
            }
        }while(invalid);

        newPlayerUseCase.newPlayer(playerName, symbolRequested);
    }
}
