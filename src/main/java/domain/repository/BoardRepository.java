package domain.repository;

import domain.entity.Board;

public interface BoardRepository {

    Board get();
    void save(Board board);
}
