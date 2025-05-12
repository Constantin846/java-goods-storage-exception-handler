package tk.project.exceptionhandler.goodsstorage.exceptions.schedulers;

public class OptimizedProductPriceSchedulingResultWriteFileException extends RuntimeException {
    private final static String MESSAGE =
            "Exception during save to file the result of optimized product price scheduling: ";

    public OptimizedProductPriceSchedulingResultWriteFileException(final String message) {
        super(MESSAGE + message);
    }
}
