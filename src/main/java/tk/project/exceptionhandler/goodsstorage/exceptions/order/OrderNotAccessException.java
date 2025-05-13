package tk.project.exceptionhandler.goodsstorage.exceptions.order;

public class OrderNotAccessException extends RuntimeException {
    public OrderNotAccessException(final String message) {
        super(message);
    }
}
