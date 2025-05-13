package tk.project.exceptionhandler.goodsstorage.exceptions.currency;

import lombok.Getter;
import lombok.Setter;

@Getter
public class RequestGetCurrenciesException extends RuntimeException {
    private final Throwable reasonException;

    public RequestGetCurrenciesException(final String message, final Throwable e) {
        super(message);
        this.reasonException = e;
    }

    public RequestGetCurrenciesException(final String message) {
        super(message);
        this.reasonException = new RuntimeException("Reason exception was not specified");
    }
}
