package tk.project.exceptionhandler.goodsstorage.exceptions.order;

public class OrderStatusNotCreatedException extends RuntimeException {
    public OrderStatusNotCreatedException(final String message) {
        super(message);
    }
}
