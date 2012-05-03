package Game;

public class BigBoard {
    /** Holds each of the inner boards. */
    private SmallBoard[] BoardArray;
    
    /** Holds the winner of each board. */
    private Mark[] MarkArray;
    
    /** Winning patterns: 012, 345, 678, 048, 246, 036, 147, 258*/
    
    public BigBoard() {
        BoardArray = new SmallBoard[9];
        MarkArray = new Mark[9];
        for (int i = 0; i < 9; i ++) {
            BoardArray[i] = new SmallBoard();
            MarkArray[i] = None;
        }
    }
    
    /** Makes the move specified by m. */
    void makeMove(Mark m, int board, int position) throws BadMoveException {
        MarkArray[board] = BoardArray[board].makeMove(m, position);
        if(isGameFinished(m)) {
            
        }
    }
    
    void makeFirstMove(Mark m, int board, int position) throws BadMoveException {
        if (board != position) {
            throw new BadMoveException("The first move big and small board positions need to align");
        } else {
            makeMove(m, board, position);
        }
    }
    /** Checks to see if the move made my M finished the game.*/
    Boolean isGameFinished(Mark m) {
        boolean done = true;
        for (SmallBoard s : BoardArray) {
            if (!s.isBoardDone()) {
                done = false
            }
        }
        return done && checkForWinner(m);
    }
    
    /**Checks to see if player m won the game. */
    Boolean checkForWinner(Mark m) {
        if (MarkArray[0] == MarkArray[1] == MarkArray[2] == m) {
            return true;
        } else if (MarkArray[3] == MarkArray[4] == MarkArray[5] == m) {
            return true;
        } else if (MarkArray[6] == MarkArray[7] == MarkArray[8] == m) {
            return true;
        } else if (MarkArray[0] == MarkArray[3] == MarkArray[6] == m) {
            return true;
        } else if (MarkArray[1] == MarkArray[4] == MarkArray[7] == m) {
            return true;
        } else if (MarkArray[2] == MarkArray[5] == MarkArray[8] == m) {
            return true;
        } else if (MarkArray[0] == MarkArray[4] == MarkArray[8] == m) {
            return true;
        } else if (MarkArray[2] == MarkArray[4] == MarkArray[6] == m) {
            return true;
        } else {
            return false;
        }
    }
}
