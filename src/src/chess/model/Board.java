package chess.model;

import java.util.Map;
import java.util.TreeMap;

public class Board {

    int boardSize;
    Cell[][] cells;

    public Board(int boardSize, Cell[][] cells) {
        this.boardSize = boardSize;
        this.cells = cells;
    }

    Cell getLeftCell(Cell cell){
         return null;
    }
}
