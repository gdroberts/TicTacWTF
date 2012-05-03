package Game;

public class Main {
    //Initialize the game
    //Allow for players to alternately interact with the boards
    //and the game in general through these methods
    
    //This might not stay in this class, maybe to something like Game
    void play() {
        boolean continueGame = true;
        int turnCount = 1;
        int prev
        while (continueGame) {
            if (turnCount == 1) {
                /* Get the first move, this will be a little different for the ui */
                uiX.getFirstMove();
            } else if (turnCount % 2 == 1) {
                /* Allow X to make move. */
                uiX.getMove();
            } else {
                /* Allow O to make move. */
                uiO.getMove();
            }
        }
    }
}
