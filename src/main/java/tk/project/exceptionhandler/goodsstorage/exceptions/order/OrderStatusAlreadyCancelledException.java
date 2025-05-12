package tk.project.exceptionhandler.goodsstorage.exceptions.order;

public class OrderStatusAlreadyCancelledException extends RuntimeException {
    public OrderStatusAlreadyCancelledException(final String message) {
        super(message);
    }
}
