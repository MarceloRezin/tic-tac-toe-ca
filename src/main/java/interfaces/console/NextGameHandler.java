package interfaces.console;

import interfaces.console.dto.NextGameType;

import java.util.Scanner;

public class NextGameHandler {

    private final Scanner scanner;

    public NextGameHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public NextGameType run() {
        String option;

        do {
            System.out.print("\nDeseja uma revanche (r|R) ou um novo jogo (n|N)? ");
            option = scanner.nextLine();

            if (option == null || option.trim().isEmpty()) {
                System.out.println("Você deve escolher uma opção.\n");
            } else {
                try {
                    return NextGameType.fromOperation(option);
                } catch(IllegalArgumentException e) {
                    System.out.println("Opção inválida. Apenas r ou n.\n");
                }
            }
        }while(true);
    }
}
