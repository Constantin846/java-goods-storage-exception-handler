package tk.project.exceptionhandler.goodsstorage.exceptions.order;

public class OrderStatusAlreadyRejectedException extends RuntimeException {
    public OrderStatusAlreadyRejectedException(String message) {
        super(message);
    }
}
