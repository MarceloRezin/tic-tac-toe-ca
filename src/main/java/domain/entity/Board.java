package domain.entity;

public class Board {

    private Symbol[][] grid = new Symbol[3][3];

    public Symbol[][] getGrid() {
        return grid;
    }

    public void setGrid(Symbol[][] grid) {
        this.grid = grid;
    }

    public void updateGrid(int row, int col, Symbol symbol) throws IllegalArgumentException {
        checkValidPosition(row, col);

        if(this.grid[row][col] != null) {
            throw  new IllegalArgumentException();
        }

        this.grid[row][col] = symbol;
    }

    public Symbol getFrom(int row, int col) {
        checkValidPosition(row, col);

        return this.grid[row][col];
    }

    private void checkValidPosition(int row, int col) {
        if (row < 0 || col < 0 || row > 2 || col > 2) {
            throw new IllegalArgumentException();
        }
    }
}
