package tk.project.exceptionhandler.goodsstorage.exceptions.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
public class RequestFindAccountNumberException extends RuntimeException {
    private final Throwable reasonException;

    public RequestFindAccountNumberException(final String message, final Throwable e) {
        super(message);
        reasonException = e;
    }

    public RequestFindAccountNumberException(final String message) {
        super(message);
        this.reasonException = new RuntimeException("Reason exception was not specified");
    }
}
