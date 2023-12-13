package projects.simulation.exceptions;

public class OutOfMapException extends RuntimeException {
    public OutOfMapException(String message) {
        super(message);
    }

    public OutOfMapException() {
    }
}
