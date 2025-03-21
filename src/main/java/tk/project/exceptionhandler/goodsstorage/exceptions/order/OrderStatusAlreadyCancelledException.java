package tk.project.exceptionhandler.goodsstorage.exceptions.order;

public class OrderStatusAlreadyCancelledException extends RuntimeException {
    public OrderStatusAlreadyCancelledException(String message) {
        super(message);
    }
}
