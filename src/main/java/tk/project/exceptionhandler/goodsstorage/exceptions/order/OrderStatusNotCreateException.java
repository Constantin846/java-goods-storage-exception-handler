package tk.project.exceptionhandler.goodsstorage.exceptions.order;

public class OrderStatusNotCreateException extends RuntimeException {
    public OrderStatusNotCreateException(final String message) {
        super(message);
    }
}
