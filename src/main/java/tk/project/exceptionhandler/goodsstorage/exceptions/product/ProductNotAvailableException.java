package tk.project.exceptionhandler.goodsstorage.exceptions.product;

public class ProductNotAvailableException extends RuntimeException {
    public ProductNotAvailableException(String message) {
        super(message);
    }
}
