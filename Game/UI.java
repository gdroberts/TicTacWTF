package Game;

interface UI {

    /** Get the next move from M. */
    int getMove(Mark m, int numMoves, int prevBoard);
    
    /**Get the first move from M. */
    int getFirstMove(Mark m);
    
}
