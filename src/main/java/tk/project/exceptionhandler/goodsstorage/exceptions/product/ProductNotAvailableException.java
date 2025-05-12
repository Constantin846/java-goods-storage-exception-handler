package tk.project.exceptionhandler.goodsstorage.exceptions.product;

public class ProductNotAvailableException extends RuntimeException {
    public ProductNotAvailableException(final String message) {
        super(message);
    }
}
