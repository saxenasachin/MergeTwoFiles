package exception;

public class InvalidFileContentException extends Exception {
    public InvalidFileContentException() {
    }

    public InvalidFileContentException(String message) {
        super(message);
    }

    public InvalidFileContentException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidFileContentException(Throwable cause) {
        super(cause);
    }

    public InvalidFileContentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
