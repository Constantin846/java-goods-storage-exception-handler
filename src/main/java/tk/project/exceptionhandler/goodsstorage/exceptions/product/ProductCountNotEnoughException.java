package tk.project.exceptionhandler.goodsstorage.exceptions.product;

public class ProductCountNotEnoughException extends RuntimeException {
    public ProductCountNotEnoughException(final String message) {
        super(message);
    }
}
