package tk.project.exceptionhandler.goodsstorage.exceptions.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
public class RequestFindInnException extends RuntimeException {
    private final Throwable reasonException;

    public RequestFindInnException(final String message, final Throwable e) {
        super(message);
        reasonException = e;
    }

    public RequestFindInnException(final String message) {
        super(message);
        this.reasonException = new RuntimeException("Reason exception was not specified");
    }
}
