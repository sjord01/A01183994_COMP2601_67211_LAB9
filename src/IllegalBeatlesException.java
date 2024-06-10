/**
 * Exception thrown when an invalid parameter is provided for creating a BeatleAlbum object.
 * 
 * @author Samson James Ordonez
 * @version 1.0
 */

public class IllegalBeatlesException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new IllegalBeatlesException with the specified detail message.
     *
     * @param message the detail message
     */
	public IllegalBeatlesException(final String message) {
        super(message);
    }
}
