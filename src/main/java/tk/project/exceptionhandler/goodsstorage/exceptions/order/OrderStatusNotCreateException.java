package tk.project.exceptionhandler.goodsstorage.exceptions.order;

public class OrderStatusNotCreateException extends RuntimeException {
    public OrderStatusNotCreateException(String message) {
        super(message);
    }
}
