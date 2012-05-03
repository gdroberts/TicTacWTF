package Game;

public class SmallBoard {
    
    /**Holds the marks (None, X, and O) */
    private Mark[] BoardArray;
    /**The winner of the board, once set it doesn't change. */
    private Mark winner;
    
    /**Makes a new blank SmallBoard. */
    public SmallBoard() {
        BoardArray = new Mark[9];
        winner = None;
        for (Mark m : BoardArray) {
            m = None;
        }
    }
    
    /**Checks to see if the board is full.*/
    Boolean isBoardDone() {
        boolean value = true;
        for (Mark m : BoardArray) {
            if (m == None) {
                value = false;
            }
        }
        return value;
    }
    
    /**Checks to make sure that the move is valid before making it.
     * Next, it checks to see if that move just won for one player.  */
    Mark makeMove(Mark m, int position) throws BadMoveException {
        if (isBoardDone()) {
            throw new BadMoveException("The board is full");
        } else if (BoardArray[position] != None) {
            throw new BadMoveException("That square is already taken!");
        } else {
            BoardArray[position] = m;
            if (winner != None) {
                return winner;
            } else {
                return boardWinner(m);
            }
        }
    }
    
    /** Winning patterns: 012, 345, 678, 048, 246, 036, 147, 258
     * m made the last move and this checks to see if that move won the board. */
    Mark boardWinner(Mark m) {
        if (BoardArray[0] == BoardArray[1] == BoardArray[2] == m) {
            return m;
        } else if (BoardArray[3] == BoardArray[4] == BoardArray[5] == m) {
            return m;
        } else if (BoardArray[6] == BoardArray[7] == BoardArray[8] == m) {
            return m;
        } else if (BoardArray[0] == BoardArray[3] == BoardArray[6] == m) {
            return m;
        } else if (BoardArray[1] == BoardArray[4] == BoardArray[7] == m) {
            return m;
        } else if (BoardArray[2] == BoardArray[5] == BoardArray[8] == m) {
            return m;
        } else if (BoardArray[0] == BoardArray[4] == BoardArray[8] == m) {
            return m;
        } else if (BoardArray[2] == BoardArray[4] == BoardArray[6] == m) {
            return m;
        } else {
            return None;
        }
    }
}
