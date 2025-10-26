package persistence;

import domain.entity.Board;
import domain.repository.BoardRepository;

public class BoardRepositoryInMemory implements BoardRepository {

    private Board board;

    @Override
    public Board get() {
        return board;
    }

    @Override
    public void save(Board board) {
        this.board = board;
    }
}
