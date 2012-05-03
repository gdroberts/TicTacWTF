package Game;

public class BadMoveException extends Throwable {
    /** The UID of the exception. */
    private static final long serialVersionUID = 1L;
    /** The message from where the Exception is thrown. */
    private String msg;
    /** Creates a new Exception with its MESSAGE. */
    public BadMoveException(String message) {
        msg = message;
    }
    /**Returns the message if prompted. */
    public String getMessage() {
        return msg;
    }
}
