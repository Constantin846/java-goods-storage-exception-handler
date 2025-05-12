package tk.project.exceptionhandler.goodsstorage.exceptions.schedulers;

public class OptimizedProductPriceSchedulingSQLException extends RuntimeException {
    private final static String MESSAGE =
            "Exception during database query from optimized product price scheduler: ";

    public OptimizedProductPriceSchedulingSQLException(final String message) {
        super(MESSAGE + message);
    }
}
