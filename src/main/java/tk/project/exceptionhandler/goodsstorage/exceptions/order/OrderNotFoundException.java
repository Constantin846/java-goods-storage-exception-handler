package tk.project.exceptionhandler.goodsstorage.exceptions.order;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);
    }
}
