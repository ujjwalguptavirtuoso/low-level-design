package cachesystem.exceptions;

public class StorageFullException extends RuntimeException{

    public StorageFullException(final String message) {
        super(message);
    }
}
