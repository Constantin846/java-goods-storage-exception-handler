package tk.project.exceptionhandler.goodsstorage.exceptions.order;

public class OrderNotAccessException extends RuntimeException {
    public OrderNotAccessException(String message) {
        super(message);
    }
}
