package interfaces.console;

import application.usecase.RematchUseCase;

public class RematchHandler {

    private final RematchUseCase rematchUseCase;

    public RematchHandler(RematchUseCase rematchUseCase) {
        this.rematchUseCase = rematchUseCase;
    }

    public void run() {
        System.out.print("\nIniciando revanche");

        for(int i = 0; i < 3; i++) {
            System.out.print(" .");
            try{
                Thread.sleep(400);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }

        rematchUseCase.rematch();
    }
}
