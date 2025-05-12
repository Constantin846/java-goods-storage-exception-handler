package tk.project.exceptionhandler.goodsstorage.exceptions.product;

public class OperationNotDefinedByStringException extends RuntimeException {
    public OperationNotDefinedByStringException(final String message) {
        super(message);
    }
}
