package tk.project.exceptionhandler.goodsstorage.exceptions.order;

public class OrderStatusNotProcessingException extends RuntimeException {
    public OrderStatusNotProcessingException(final String message) {
        super(message);
    }
}
