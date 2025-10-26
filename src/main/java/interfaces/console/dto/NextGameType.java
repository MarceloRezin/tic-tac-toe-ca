package interfaces.console.dto;

public enum NextGameType {

    REMATCH("r"),
    NEW_MATCH("n");

    private final String operation;

    NextGameType(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static NextGameType fromOperation(String operation) {
        for (NextGameType nextGameType : NextGameType.values()) {
            if (nextGameType.getOperation().equalsIgnoreCase(operation)) {
                return nextGameType;
            }
        }

        throw new IllegalArgumentException("Invalid operation");
    }
}
