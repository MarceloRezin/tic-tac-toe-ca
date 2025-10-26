package application.dto;

public class PostionDto {

    private final int row;
    private final int col;

    public PostionDto(int row, int col) {

        if (row < 0 || row > 2) {
            throw new IllegalArgumentException("A linha deve ser entre 0 e 2");
        }

        if (col < 0 || col > 2) {
            throw new IllegalArgumentException("A coluna deve ser entre 0 e 2");
        }

        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
